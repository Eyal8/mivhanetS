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
public class Lecturer3Controller {
  private String chosenQuestion;
  Lecturer2Controller lc2 = new Lecturer2Controller();
  public javafx.scene.control.ComboBox chooseChoice;

  @FXML
  public void initialize() {
    chosenQuestion = lc2.getQuestion();
  }


}
