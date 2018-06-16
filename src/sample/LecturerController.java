package sample;

import Model.Choice;
import Model.Database;
import Model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Created by eyal8_000 on 13/06/2018.
 */


public class LecturerController {
  public javafx.scene.control.ComboBox chosenCourse;
  public javafx.scene.control.ComboBox chosenQuestion;
  public javafx.scene.control.ComboBox chosenChoice;
  public javafx.scene.control.TextArea changedChoiceText;
  public javafx.scene.control.TextArea newChoiceText;
  public javafx.scene.control.RadioButton choiceChangeRadioButton;
  public javafx.scene.control.RadioButton newChoiceRadioButton;
  private Database db;
  private String courseID;
  private String question;
  private String choice;
  @FXML
  public void initialize() throws SQLException {

    db = new Database();

    Map<Statement, ResultSet> result = db.executeSqlQuery("SELECT CourseDetails.courseID, CourseDetails.name FROM CourseDetails JOIN LecturerCourses ON CourseDetails.courseID = LecturerCourses.courseID WHERE lecturerID = '12346'");
    Map.Entry<Statement,ResultSet> entry = result.entrySet().iterator().next();
    Statement key = entry.getKey();
    ResultSet value = entry.getValue();
    final ObservableList options = FXCollections.observableArrayList();
    while(value.next()){
      String course_id = (value.getString("courseID"));
      String course_name = value.getString("name");
      options.add(course_name + " "+course_id);
    }
    chosenCourse.getItems().addAll(options);
    key.close();

    chosenQuestion.setDisable(true);
    chosenChoice.setDisable(true);
    changedChoiceText.setDisable(true);
    newChoiceText.setDisable(true);
  }

  /*public String getChosenCourse()
  {
    if(chooseCourse != null)
      return chooseCourse.getValue().toString();
    return "";
  }*/
  public void getQuestions() throws SQLException {
    String[] course_full_name = (chosenCourse.getValue().toString()).split(" ");
    courseID = course_full_name[course_full_name.length-1];
    Map<Statement, ResultSet> result = db.executeSqlQuery("SELECT body FROM Question WHERE courseID = '"+courseID+"';");
    Map.Entry<Statement,ResultSet> entry = result.entrySet().iterator().next();
    Statement key = entry.getKey();
    ResultSet value = entry.getValue();
    final ObservableList options = FXCollections.observableArrayList();
    while(value.next()){
      String body = (value.getString("body"));
      options.add(body);
    }
    chosenQuestion.getItems().addAll(options);
    key.close();

    chosenQuestion.setDisable(false);

  }
  public void getChoices() throws SQLException {
    question = chosenQuestion.getValue().toString();
    Map<Statement, ResultSet> result2 = db.executeSqlQuery("SELECT content FROM Choice WHERE body = '"+question+"';");
    Map.Entry<Statement,ResultSet> entry2 = result2.entrySet().iterator().next();
    Statement key2 = entry2.getKey();
    ResultSet value2 = entry2.getValue();
    final ObservableList options2 = FXCollections.observableArrayList();
    while(value2.next()){
      String content = (value2.getString("content"));
      options2.add(content);
    }
    chosenChoice.getItems().addAll(options2);
    key2.close();
    chosenChoice.setDisable(false);
    changedChoiceText.setDisable(false);
    newChoiceText.setDisable(false);
  }
  public void saveQuestionEdit() throws SQLException {
    db = new Database();
    boolean isTrue = choiceChangeRadioButton.isSelected();
    String choiceBody = chosenChoice.getValue().toString().trim();
    String changedChoice = changedChoiceText.getText().trim();
    db.executeUpdateQuery("UPDATE Choice SET content='"+changedChoice+"',isTrue='"+isTrue+"' WHERE content='"+choiceBody+"';");
    chosenChoice.getItems().clear();
    Map<Statement, ResultSet> result2 = db.executeSqlQuery("SELECT content FROM Choice WHERE body = '"+question+"';");
    Map.Entry<Statement,ResultSet> entry2 = result2.entrySet().iterator().next();
    Statement key2 = entry2.getKey();
    ResultSet value2 = entry2.getValue();
    final ObservableList options2 = FXCollections.observableArrayList();
    while(value2.next()){
      String content = (value2.getString("content"));
      options2.add(content);
    }
    chosenChoice.getItems().addAll(options2);
    key2.close();
  }
  public void createNewChoice() throws SQLException {
    db = new Database();
    String newChoice = newChoiceText.getText().trim();
    boolean isTrue = newChoiceRadioButton.isSelected();
    db.executeUpdateQuery("INSERT INTO Choice (body,content, isTrue) VALUES ('" + question + "','" + newChoice + "','" + isTrue + "');");
    chosenChoice.getItems().clear();
    Map<Statement, ResultSet> result2 = db.executeSqlQuery("SELECT content FROM Choice WHERE body = '" + question + "';");
    Map.Entry<Statement, ResultSet> entry2 = result2.entrySet().iterator().next();
    Statement key2 = entry2.getKey();
    ResultSet value2 = entry2.getValue();
    final ObservableList options2 = FXCollections.observableArrayList();
    while (value2.next()) {
      String content = (value2.getString("content"));
      options2.add(content);
    }
    chosenChoice.getItems().addAll(options2);
    key2.close();
    Question q = new Question(question);
    Choice c = new Choice(q, choice, isTrue);
  }
}
