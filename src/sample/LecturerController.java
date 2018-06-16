package sample;

import Model.Database;
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
  public javafx.scene.control.ComboBox chooseCourse;
  private Database db;
  public Stage L2page;
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
    chooseCourse.getItems().addAll(options);
    key.close();


    L2page = new Stage();
    L2page.setAlwaysOnTop(true);
    L2page.setResizable(false);
    L2page.setTitle("Lecturer");

    Parent root = null;

    try {
      //change MyView.fxml to help.fxml after designed
      root = FXMLLoader.load(getClass().getResource("Lecturer2.fxml"));
    } catch (IOException e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("Exception!");
      alert.show();
    }
    L2page.setTitle("Lecturer");
    Scene scene = new Scene(root, 600, 400);
    scene.getStylesheets().add(getClass().getResource("procss.css").toExternalForm());
    L2page.setScene(scene);
    L2page.initModality(Modality.APPLICATION_MODAL);
  }

  public String getChosenCourse()
  {
    if(chooseCourse != null)
      return chooseCourse.getValue().toString();
    return "";
  }
  public void getQuestions(){

    L2page.show();
  }
  public String getCourse(){
    if(chooseCourse != null) {
      return chooseCourse.getValue().toString();
    }
    else return "";
  }
}
