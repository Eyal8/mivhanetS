package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class Student {
  private String ID;
  private String firstName;
  private String lastName;
  private ArrayList<Course> courses;
  private ArrayList<Exam> exams;
  private HashMap<Exam,ArrayList<QuestionInExam>> questionsOfExams;
  private HashMap<Exam, Grade> examsOfStudents;

  public double getGrade(Exam e){return examsOfStudents.get(e).getGrade();}
}
