package Model;

import java.util.ArrayList;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class CourseDetails {
  private String courseID;
  private String name;
  private ArrayList<Question> questions;

  public CourseDetails(String courseID, String name){
    this.courseID = courseID;
    this.name = name;
  }

  public CourseDetails getCourseDetails(){
    return this;
  }
  public void addQuestion(Question q){}
}
