package sample;

import Model.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tooltip;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;


import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Controller {

  public javafx.scene.control.Button secretaryB;
  public Stage Spage;
  public Stage Lpage;
  public Stage CMpage;
  private Database db;
  @FXML
  public void initialize() throws SQLException {
    Spage = new Stage();
    Spage.setAlwaysOnTop(true);
    Spage.setResizable(false);
    Spage.setTitle("Secretery Window");

    Parent root=null;

    try
    {
      //change MyView.fxml to help.fxml after designed
      root = FXMLLoader.load(getClass().getResource("Secretary.fxml"));
    }
    catch(IOException e)
    {
      Alert alert=new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("Exception!");
      alert.show();
    }
    Spage.setTitle("Secretery");
    Scene scene = new Scene(root,900,700);
    scene.getStylesheets().add(getClass().getResource("procss.css").toExternalForm());
    Spage.setScene(scene);
    Spage.initModality(Modality.APPLICATION_MODAL);







    ////////////////////////////////////////////////////////////////////////////////////
    Lpage = new Stage();
    Lpage.setAlwaysOnTop(true);
    Lpage.setResizable(false);
    Lpage.setTitle("Lecturer Window");

    Parent root2=null;

    try
    {
      //change MyView.fxml to help.fxml after designed
      root2 = FXMLLoader.load(getClass().getResource("Lecturer.fxml"));
    }
    catch(IOException e)
    {
      Alert alert=new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("Exception!");
      alert.show();
    }
    Lpage.setTitle("Lecturer");
    Scene scene2 = new Scene(root2,800,530);
    scene2.getStylesheets().add(getClass().getResource("procss.css").toExternalForm());
    Lpage.setScene(scene2);
    Lpage.initModality(Modality.APPLICATION_MODAL);


    ////////////////////////////////////////////////////////////////////////////////////
    CMpage = new Stage();
    CMpage.setAlwaysOnTop(true);
    CMpage.setResizable(false);
    CMpage.setTitle("Course manager Window");

    Parent root3=null;

    try
    {
      //change MyView.fxml to help.fxml after designed
      root3 = FXMLLoader.load(getClass().getResource("CourseManager.fxml"));
    }
    catch(IOException e)
    {
      Alert alert=new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("Exception!");
      alert.show();
    }
    CMpage.setTitle("Course Manager");
    Scene scene3 = new Scene(root3,600,400);
    scene3.getStylesheets().add(getClass().getResource("procss.css").toExternalForm());
    CMpage.setScene(scene3);
    CMpage.initModality(Modality.APPLICATION_MODAL);

  }
  public void cm(){
    CMpage.show();
  }
  public void lec(){
    Lpage.show();
  }

  public void sec(){
    Spage.show();
  }
}
