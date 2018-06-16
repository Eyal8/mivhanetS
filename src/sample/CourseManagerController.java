package sample;

import Model.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Created by eyal8_000 on 13/06/2018.
 */
public class CourseManagerController {

  private String courseID;
  public javafx.scene.control.ComboBox chooseCourse;
  public javafx.scene.control.ComboBox semesterType;
  public javafx.scene.control.ComboBox year;

  //public String course = chooseCourse.getValue().toString();
  public Stage CM2page;
  private Database db;
  private String syllabus;
  private String selectedSeason;
  //semesterType.getValue().toString()

  @FXML
  public void initialize() throws SQLException {
    semesterType.getItems().addAll("Winter", "Spring", "Summer");
    db = new Database();
    Map<Statement, ResultSet> result = db.executeSqlQuery("SELECT DISTINCT CourseDetails.courseID, CourseDetails.name FROM CourseDetails JOIN Course ON CourseDetails.courseID = Course.courseID WHERE courseMenagerID = '123124';");
    Map.Entry<Statement,ResultSet> entry = result.entrySet().iterator().next();
    Statement key = entry.getKey();
    ResultSet value = entry.getValue();
    final ObservableList options = FXCollections.observableArrayList();
    while(value.next()){
      String course_id = (value.getString("courseID"));
      String course_name = value.getString("name");
      options.add(course_name + " "+course_id);
    }
    chooseCourse.getItems().addAll(options);
    key.close();

  }

  public String getCourse(){
    if(chooseCourse != null) {
      return chooseCourse.getValue().toString();
    }
    else return "";
  }

  public void chooseFile(){
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    File file = fileChooser.showOpenDialog(new Stage());
    FileInputStream fis = null;
    String str = "";
    try {
      fis = new FileInputStream(file);
      byte[] data = new byte[(int) file.length()];
      fis.read(data);
      fis.close();
      str = new String(data, "UTF-8");

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    syllabus = str;
    //TODO
  }

  public void setCourseID()
  {
    String[] details = chooseCourse.getValue().toString().split(" ");
    courseID = details[details.length-1];
  }

  public void setSemester() throws SQLException {
    selectedSeason = semesterType.getValue().toString();
    Map<Statement, ResultSet> result2 = db.executeSqlQuery("SELECT DISTINCT yearr FROM Course WHERE courseID='"+courseID+"' AND season = '"+selectedSeason+"'");
    Map.Entry<Statement,ResultSet> entry2 = result2.entrySet().iterator().next();
    Statement key2 = entry2.getKey();
    ResultSet value2 = entry2.getValue();
    final ObservableList options2 = FXCollections.observableArrayList();
    while(value2.next()){
      String yearr = (value2.getString("yearr"));
      options2.add(yearr);
    }
    year.getItems().addAll(options2);
    key2.close();
  }

  public void getSyllabusScreen()
  {
    String chosenYear = year.getValue().toString();
    db.executeUpdateQuery("UPDATE Course SET syllabus='"+syllabus+"' WHERE courseID='"+courseID+"' AND yearr='"+chosenYear+"' AND season = '"+selectedSeason+"';");
  }
}
