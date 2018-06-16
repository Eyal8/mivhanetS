package sample;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eyal8_000 on 13/06/2018.
 */
public class SecretaryController {

  public javafx.scene.control.DatePicker exam1;
  public javafx.scene.control.DatePicker exam2;
  public javafx.scene.control.DatePicker exam3;
  public javafx.scene.control.ComboBox cm;
  public javafx.scene.control.ComboBox lec1;
  public javafx.scene.control.ComboBox lec2;
  public javafx.scene.control.ComboBox lec3;
  public javafx.scene.control.ComboBox lec4;
  public javafx.scene.control.ComboBox lec5;
  public javafx.scene.control.ComboBox tut1;
  public javafx.scene.control.ComboBox tut2;
  public javafx.scene.control.ComboBox tut3;
  public javafx.scene.control.ComboBox semesterType;
  public javafx.scene.control.ComboBox stu;
  public javafx.scene.control.ComboBox courseDetails;
  private String course_id;
  private SemesterType semester;
  private String year;
  private Semester s;
  private ArrayList<Tutor> tutors;
  private ArrayList<Lecturer> lecturers;
  private ArrayList<Student> students;
  private ArrayList<Exam> exams;
  private Database db;
  private String courseID;

  @FXML
  public void initialize() throws SQLException {

    semesterType.getItems().addAll("Winter", "Spring", "Summer");

    db = new Database();

    Map<Statement, ResultSet> result = db.executeSqlQuery("SELECT * FROM CourseDetails");
    Map.Entry<Statement,ResultSet> entry = result.entrySet().iterator().next();
    Statement key = entry.getKey();
    ResultSet value = entry.getValue();
    final ObservableList options = FXCollections.observableArrayList();
    while(value.next()){
      String course_id = (value.getString("courseID"));
      String course_name = value.getString("name");
      options.add(course_name + " "+course_id);
    }
    courseDetails.getItems().addAll(options);
    key.close();

    Map<Statement, ResultSet> result2 = db.executeSqlQuery("SELECT ID, firstName, lastName FROM CourseManager");
    Map.Entry<Statement,ResultSet> entry2 = result2.entrySet().iterator().next();
    Statement key2 = entry2.getKey();
    ResultSet value2 = entry2.getValue();
    final ObservableList options2 = FXCollections.observableArrayList();
    while(value2.next()){
      String id = (value2.getString("ID"));
      String fn = value2.getString("firstName");
      String ln = value2.getString("lastName");
      options2.add(fn + " "+ ln + " " + id);
    }
    cm.getItems().addAll(options2);
    key2.close();

    Map<Statement, ResultSet> result3 = db.executeSqlQuery("SELECT ID, firstName, lastName FROM Lecturer");
    Map.Entry<Statement,ResultSet> entry3 = result3.entrySet().iterator().next();
    Statement key3 = entry3.getKey();
    ResultSet value3 = entry3.getValue();
    final ObservableList options3 = FXCollections.observableArrayList();
    while(value3.next()){
      String id = (value3.getString("ID"));
      String fn = value3.getString("firstName");
      String ln = value3.getString("lastName");
      options3.add(fn + " "+ ln + " " + id);
    }
    lec1.getItems().addAll(options3);
    lec2.getItems().addAll(options3);
    lec3.getItems().addAll(options3);
    lec4.getItems().addAll(options3);
    lec5.getItems().addAll(options3);

    key3.close();


    Map<Statement, ResultSet> result4 = db.executeSqlQuery("SELECT ID, firstName, lastName FROM Tutor");
    Map.Entry<Statement,ResultSet> entry4 = result4.entrySet().iterator().next();
    Statement key4 = entry4.getKey();
    ResultSet value4 = entry4.getValue();
    final ObservableList options4 = FXCollections.observableArrayList();
    while(value4.next()){
      String id = (value4.getString("ID"));
      String fn = value4.getString("firstName");
      String ln = value4.getString("lastName");
      options4.add(fn + " "+ ln + " " + id);
    }
    tut1.getItems().addAll(options4);
    tut2.getItems().addAll(options4);
    tut3.getItems().addAll(options4);
    key4.close();

    Map<Statement, ResultSet> result5 = db.executeSqlQuery("SELECT ID, firstName, lastName FROM Student");
    Map.Entry<Statement,ResultSet> entry5 = result5.entrySet().iterator().next();
    Statement key5 = entry5.getKey();
    ResultSet value5 = entry5.getValue();
    final ObservableList options5 = FXCollections.observableArrayList();
    while(value5.next()){
      String id = (value5.getString("ID"));
      String fn = value5.getString("firstName");
      String ln = value5.getString("lastName");
      options5.add(fn + " "+ ln + " " + id);
    }
    stu.getItems().addAll(options5);
    key5.close();

  }

  public void registerCourse(){

    semester = SemesterType.valueOf(semesterType.getValue().toString());
    String[] details = courseDetails.getValue().toString().split(" ");
    courseID = details[details.length-1];
  }
  public void createExams(){
    LocalDate e1 = exam1.getValue();
    LocalDate e2 = exam2.getValue();
    LocalDate e3 = exam3.getValue();
    year = String.valueOf(e1.getYear());
    s = new Semester(year, semester);
    ArrayList<Exam> exams = new ArrayList<>(3);
    Exam newExam1 = new Exam(course_id, Moed.A, Date.from(e1.atStartOfDay(ZoneId.systemDefault()).toInstant()), semester);
    Exam newExam2 = new Exam(course_id, Moed.B, Date.from(e2.atStartOfDay(ZoneId.systemDefault()).toInstant()), semester);
    Exam newExam3 = new Exam(course_id, Moed.C, Date.from(e3.atStartOfDay(ZoneId.systemDefault()).toInstant()), semester);
    exams.add(newExam1);
    exams.add(newExam2);
    exams.add(newExam3);
}
  public void getTeachingEmployees(){
    String cm_name = cm.getValue().toString();
    String lec1_name = lec1.getValue().toString();
    String lec2_name = lec2.getValue().toString();
    String lec3_name = lec3.getValue().toString();
    String lec4_name = lec4.getValue().toString();
    String lec5_name = lec5.getValue().toString();
    String tut1_name = tut1.getValue().toString();
    String tut2_name = tut2.getValue().toString();
    String tut3_name = tut3.getValue().toString();
  }
  public void selectStudent(){
    String student_name = stu.getValue().toString();
  }


}
