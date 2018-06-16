package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class Exam {
  private String courseID;
  private Date date;
  private SemesterType semester;
  private Moed moed;
  private float duration;
  private ArrayList<Question> questions;
  private Course course;
  private ArrayList<Student> students;
  private HashMap<Student,ArrayList<QuestionInExam>> questionsOfStudents;
  private HashMap<Student, Grade> gradesOfStudents;

  public Exam(String courseID, Moed m, Date d, SemesterType s){
    this.courseID = courseID;
    this.moed = m;
    this.date = d;
    this.semester = s;
  }
  public boolean addQuestion(Question q){return true;}
  public QuestionInExam getQuestionInExam(Student s){return new QuestionInExam("",0,Difficulty.ZERO,0,true);}
  public ArrayList<Question> getQuestions(Student student){return new ArrayList<Question>();}

    public Date getDate() {
        return date;
    }

  public Moed getMoed() {
    return moed;
  }

  public float getDuration() {
    return duration;
  }
}
