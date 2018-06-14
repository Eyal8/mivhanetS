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
public class LecturerController {
  public javafx.scene.control.ComboBox chooseCourse;
  //public String course = chooseCourse.getValue().toString();
  public Stage L2page;
  @FXML
  public void initialize() {
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
