package sample;

import Model.Secretary;
import Model.SemesterType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Mivhanet");
        primaryStage.setScene(new Scene(root, 600, 200));
        primaryStage.getScene().getStylesheets().add(getClass().getResource("procss.css").toExternalForm());
        primaryStage.show();
    }


    public static void main(String[] args) {
      //Secretary s = new Secretary();
     // s.AddLecturersToCourse(new ArrayList<String>(), SemesterType.Spring,"1232","1998");
      launch(args);
    }
}
