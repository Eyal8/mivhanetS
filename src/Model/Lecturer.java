package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class Lecturer extends TeachingEmployee {

  public ArrayList<Question> GetListOfQuestions(String year, String courseID, SemesterType season){return new ArrayList<Question>();}
  public void ChooseQuestionsByLecturer(String courseID, Date date, HashMap<String, Double> questionsToAdd, SemesterType season) {}
  public void SetDuraionOfExam(String courseID,  SemesterType season, Date date){}
  public void EditChoice(String courseID, SemesterType season, String year, String question, String oldContent, String newContent, boolean isTrue){}
}
