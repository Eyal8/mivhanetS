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
public class Lecturer2Controller{
  private String chosenCourse;
 // public javafx.scene.control.ComboBox chosenCourse;
  private LecturerController lc = new LecturerController();
  public javafx.scene.control.ComboBox chooseQuestion;
  private Database db;
  public Stage L3page;
  @FXML
  public void initialize() throws SQLException {
      String courseID="1124";
    /*  if(lc.getChosenCourse() != null) {
          courseID = lc.getChosenCourse();
      }*/
    db = new Database();
    Map<Statement, ResultSet> result = db.executeSqlQuery("SELECT body FROM Question WHERE courseID = '"+courseID+"';");
    Map.Entry<Statement,ResultSet> entry = result.entrySet().iterator().next();
    Statement key = entry.getKey();
    ResultSet value = entry.getValue();
    final ObservableList options = FXCollections.observableArrayList();
    while(value.next()){
      String body = (value.getString("body"));
      options.add(body);
    }
    chooseQuestion.getItems().addAll(options);
    key.close();


    L3page = new Stage();
    L3page.setAlwaysOnTop(true);
    L3page.setResizable(false);
    L3page.setTitle("Lecturer");
    chosenCourse = lc.getCourse();
    Parent root = null;

    try {
      //change MyView.fxml to help.fxml after designed
      root = FXMLLoader.load(getClass().getResource("Lecturer3.fxml"));
    } catch (IOException e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("Exception!");
      alert.show();
    }
    L3page.setTitle("Lecturer");
    Scene scene = new Scene(root, 600, 400);
    scene.getStylesheets().add(getClass().getResource("procss.css").toExternalForm());
    L3page.setScene(scene);
    L3page.initModality(Modality.APPLICATION_MODAL);
  }
  public String getQuestion(){
    if(chooseQuestion != null)
      return chooseQuestion.getValue().toString();
    else return "";
  }
  public void getChoices(){
    L3page.show();
  }

}
