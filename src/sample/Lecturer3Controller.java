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
public class Lecturer3Controller {
  private String chosenQuestion;
  Lecturer2Controller lc2 = new Lecturer2Controller();
  public javafx.scene.control.ComboBox chooseChoice;
  private Database db;
  @FXML
  public void initialize() throws SQLException {
    chosenQuestion = lc2.getQuestion();


    db = new Database();
    Map<Statement, ResultSet> result = db.executeSqlQuery("SELECT content FROM Choice WHERE body = 'what are you?';");
    Map.Entry<Statement,ResultSet> entry = result.entrySet().iterator().next();
    Statement key = entry.getKey();
    ResultSet value = entry.getValue();
    final ObservableList options = FXCollections.observableArrayList();
    while(value.next()){
      String content = (value.getString("content"));
      options.add(content);
    }
    chooseChoice.getItems().addAll(options);
    key.close();
  }


}
