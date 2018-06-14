package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public abstract class TeachingEmployee extends User {
  protected ArrayList<Course> courses;

  public ArrayList<Course> GetCurrentSemesterCourses (String year, SemesterType season){ return new ArrayList<Course>();}
  public ArrayList<Student> GetStudentsOfCourse(String courseID, SemesterType season, String year){return new ArrayList<Student>();}
  public void CalculateStudentsScore(String courseID, Date date, ArrayList<String> ids, SemesterType season){}
  public void WriteComment(String CourseID, String year, SemesterType season, String question, String comment){}
  public void SetDurationOfQuestion(String CourseID, String year, SemesterType season, String question, double duration){}
  public void SetDifficultyLevel(String CourseID, String year, SemesterType season, String question, Difficulty d){}
  public boolean CreateQuestion (SemesterType season, String courseID, String year , String content){return true;}
  public boolean CreateChoice(SemesterType season, String courseID, String year, String questionContent , String choiceContent, boolean isTrue){return true;}

}
