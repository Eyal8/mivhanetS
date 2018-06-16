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
public class CourseManagerController {

  public javafx.scene.control.ComboBox chooseCourse;
  //public String course = chooseCourse.getValue().toString();
  public Stage CM2page;
  private Database db;
  @FXML
  public void initialize() throws SQLException {

    db = new Database();

    Map<Statement, ResultSet> result = db.executeSqlQuery("SELECT CourseDetails.courseID, CourseDetails.name FROM CourseDetails JOIN Course ON CourseDetails.courseID = Course.courseID WHERE courseMenagerID = '123124';");
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


    CM2page = new Stage();
    CM2page.setAlwaysOnTop(true);
    CM2page.setResizable(false);

    Parent root = null;

    try {
      //change MyView.fxml to help.fxml after designed
      root = FXMLLoader.load(getClass().getResource("CourseManager2.fxml"));
    } catch (IOException e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("Exception!");
      alert.show();
    }
    CM2page.setTitle("Course Manager");
    Scene scene = new Scene(root, 600, 400);
    scene.getStylesheets().add(getClass().getResource("procss.css").toExternalForm());
    CM2page.setScene(scene);
    CM2page.initModality(Modality.APPLICATION_MODAL);
  }
  public void getSyllabusScreen(){

    CM2page.show();
  }
  public String getCourse(){
    if(chooseCourse != null) {
      return chooseCourse.getValue().toString();
    }
    else return "";
  }
}
