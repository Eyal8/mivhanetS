package Model;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * Created by eyal8_000 on 16/04/2018.
 */
public class Course {
  private CourseDetails courseDetails;
  private Semester semester;
  private ArrayList<Tutor> tutors;
  private ArrayList<Lecturer> lecturers;
  private CourseManager manager;
  private ArrayList<Student> students;
  private Secretary s;
  private ArrayList<Exam> exams;
  private ArrayList<Action> actions;
  private ArrayList<Error> errors;

  public Course(CourseDetails cd, Semester s, ArrayList<Tutor> t, ArrayList<Lecturer> l, CourseManager cm, ArrayList<Student> students, ArrayList<Exam> exams){
    this.courseDetails = cd;
    this.semester = s;
    this.tutors = t;
    this.lecturers = l;
    this.manager = cm;
    this.students = students;
    this.exams = exams;
  }
  public void addLecturer(Lecturer lct){}
  public void addTutor(Tutor ttr){}
  public void addCourseManager(CourseManager cm){};
  public void addExam(Exam e){}
  public ArrayList<Student> getStudents(){return this.students;}
  public ArrayList<Exam> getExams(){return this.exams;}
  public void setSyllabus(String syllabus){}

}
