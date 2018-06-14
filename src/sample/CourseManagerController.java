package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by eyal8_000 on 13/06/2018.
 */
public class CourseManagerController {

  public javafx.scene.control.ComboBox chooseCourse;
  //public String course = chooseCourse.getValue().toString();
  public Stage CM2page;
  @FXML
  public void initialize() {
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
