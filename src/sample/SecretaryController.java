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

  private SemesterType semester;
  private String year;
  private Semester s;
  private ArrayList<Tutor> tutors = new ArrayList<>();
  private ArrayList<Lecturer> lecturers = new ArrayList<>();
  private ArrayList<Student> students = new ArrayList<>();
  private ArrayList<Exam> exams = new ArrayList<>();
  private Database db;
  private String courseID;
  private String courseName = "";
  private CourseManager courseManager;

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
    for(int i = 0; i < details.length - 1; i++)
    {
      courseName += details[i] + " ";
    }
    courseName = courseName.substring(0, courseName.length()-1);
  }
  public void createExams(){
    LocalDate e1 = exam1.getValue();
    LocalDate e2 = exam2.getValue();
    LocalDate e3 = exam3.getValue();
    year = String.valueOf(e1.getYear());
    s = new Semester(year, semester);
    Exam newExam1 = new Exam(courseID, Moed.A, Date.from(e1.atStartOfDay(ZoneId.systemDefault()).toInstant()), semester);
    Exam newExam2 = new Exam(courseID, Moed.B, Date.from(e2.atStartOfDay(ZoneId.systemDefault()).toInstant()), semester);
    Exam newExam3 = new Exam(courseID, Moed.C, Date.from(e3.atStartOfDay(ZoneId.systemDefault()).toInstant()), semester);
    exams.add(newExam1);
    exams.add(newExam2);
    exams.add(newExam3);
}
  public void getTeachingEmployees(){

    String[] cm_details = cm.getValue().toString().split(" ");
    String cm_fn = cm_details[0];
    String cm_ln = cm_details[1];
    String cm_ID = cm_details[2];
    courseManager = new CourseManager(cm_fn, cm_ln,cm_ID);

    String[] lec1_details = lec1.getValue().toString().split(" ");
    String lec1_fn = lec1_details[0];
    String lec1_ln = lec1_details[1];
    String lec1_ID = lec1_details[2];
    lecturers.add(new Lecturer(lec1_fn, lec1_ln, lec1_ID));

    if(lec2.getValue() != null) {
      String[] lec2_details = lec2.getValue().toString().split(" ");
      String lec2_fn = lec2_details[0];
      String lec2_ln = lec2_details[1];
      String lec2_ID = lec2_details[2];
      lecturers.add(new Lecturer(lec2_fn, lec2_ln, lec2_ID));
    }

    if(lec3.getValue() != null) {
      String[] lec3_details = lec3.getValue().toString().split(" ");
      String lec3_fn = lec3_details[0];
      String lec3_ln = lec3_details[1];
      String lec3_ID = lec3_details[2];
      lecturers.add(new Lecturer(lec3_fn, lec3_ln, lec3_ID));
    }

    if(lec4.getValue() != null) {
      String[] lec4_details = lec4.getValue().toString().split(" ");
      String lec4_fn = lec4_details[0];
      String lec4_ln = lec4_details[1];
      String lec4_ID = lec4_details[2];
      lecturers.add(new Lecturer(lec4_fn, lec4_ln, lec4_ID));
    }

    if(lec5.getValue() != null) {
      String[] lec5_details = lec5.getValue().toString().split(" ");
      String lec5_fn = lec5_details[0];
      String lec5_ln = lec5_details[1];
      String lec5_ID = lec5_details[2];
      lecturers.add(new Lecturer(lec5_fn, lec5_ln, lec5_ID));
    }

      String[] tut1_details = tut1.getValue().toString().split(" ");
      String tut1_fn = tut1_details[0];
      String tut1_ln = tut1_details[1];
      String tut1_ID = tut1_details[2];
      tutors.add(new Tutor(tut1_fn, tut1_ln, tut1_ID));

    if(tut2.getValue() != null) {
      String[] tut2_details = tut2.getValue().toString().split(" ");
      String tut2_fn = tut2_details[0];
      String tut2_ln = tut2_details[1];
      String tut2_ID = tut2_details[2];
      tutors.add(new Tutor(tut2_fn, tut2_ln, tut2_ID));
    }

    if(tut3.getValue() != null) {
      String[] tut3_details = tut3.getValue().toString().split(" ");
      String tut3_fn = tut3_details[0];
      String tut3_ln = tut3_details[1];
      String tut3_ID = tut3_details[2];
      tutors.add(new Tutor(tut3_fn, tut3_ln, tut3_ID));
    }
  }
  public void selectStudent(){
    String[] details = stu.getValue().toString().split(" ");
    String fn = details[0];
    String ln = details[1];
    String ID = details[2];
    students.add(new Student(ID, fn, ln));
  }
  public void submit()
  {
    Course c = new Course(new CourseDetails(courseID, courseName), s, tutors, lecturers, courseManager, students, exams);
    for(int i = 0; i < tutors.size(); i++)
    {
      db.executeUpdateQuery("INSERT INTO tutor_course (courseID, Yearr, season, tutorID) VALUES ('" + courseID + "','" + year + "', '" + semester + "', '" + tutors.get(i).getID() + "');");
    }

    for(int i = 0; i < lecturers.size(); i++)
    {
      db.executeUpdateQuery("INSERT INTO LecturerCourses (courseID, yearr, semester, lecturerID) VALUES ('" + courseID + "','" + year + "', '" + semester + "', '" + lecturers.get(i).getID() + "');");
    }

    for(int i = 0; i < students.size(); i++)
    {
      db.executeUpdateQuery("INSERT INTO StudentsInCourses (studentID, courseID, yearr, season) VALUES ('" + students.get(i).getID() + "', '"+courseID+"','" + year + "', '" + semester + "');");
    }
    for(int i = 0; i < exams.size(); i++)
    {
      db.executeUpdateQuery("INSERT INTO Exam (courseID, datee, semester, moed, duration) VALUES ('"+courseID+"','" + exams.get(i).getDate() + "', '" + semester + "', '"+exams.get(i).getMoed()+"', '"+exams.get(i).getDuration()+"');");
    }

    db.executeUpdateQuery("INSERT INTO Course (courseID, yearr, season, courseMenagerID) VALUES ('"+courseID+"','" + year + "', '" + semester + "', '"+courseManager.getID()+"');");
    }


}
