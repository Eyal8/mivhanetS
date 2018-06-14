package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class CourseManager extends Lecturer {
  public ArrayList<Exam> GetAllExamsOfCourse(String courseID, String year, SemesterType season){return new ArrayList<Exam>();}
  public boolean UpdateGrade (SemesterType season, String courseID, Date date, ArrayList<String> studentsID, float percentFactor){return true;}
  public void SetSylabusToCourse(SemesterType season, String courseID, String year, String sylabus){}

}
