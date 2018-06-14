package sample;

import Model.CourseManager;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by eyal8_000 on 13/06/2018.
 */
public class CourseManager2Controller {
  static int counter = 0;
  private CourseManagerController cm = new CourseManagerController();
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
    //TODO
  }
}
