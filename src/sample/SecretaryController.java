package sample;

import Model.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by eyal8_000 on 13/06/2018.
 */
public class SecretaryController {

  public javafx.scene.control.TextField courseID;
  public javafx.scene.control.TextField courseName;
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
  public javafx.scene.control.ComboBox student;

  private String course_id;
  private SemesterType semester;
  private String year;
  private Semester s;
  public void close(){
    Stage s = (Stage)courseID.getScene().getWindow();
    s.close();
  }

  public void registerCourse(){
    course_id = courseID.getText().trim();
    semester = SemesterType.valueOf(semesterType.getValue().toString());
    String course_name = courseName.getText().trim();
    CourseDetails cd = new CourseDetails(course_id, course_name);

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
    String student_name = student.getValue().toString();
  }
}
