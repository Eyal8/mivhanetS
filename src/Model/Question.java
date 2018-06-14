package Model;

import java.util.ArrayList;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class Question {
  protected String body;
  private double score;
  protected Difficulty difficultyLevel;
  protected double estimatedTime;
  protected ArrayList<Comment> comments;
  protected ArrayList<Choice> choices;
  protected TeachingEmployee te;

  public Question(String body, double score, Difficulty difficultyLevel, double estimatedTime){
    this.body=body;
    this.score=score;
    this.difficultyLevel=difficultyLevel;
    this.estimatedTime=estimatedTime;
  }
  public Question(String body){
    this.body=body;
  }
  public double getScore(){return this.score;}
  public double getEstimatedTime(){return this.estimatedTime;}
  public void addTimeToDuration(double time){};
  public void writeComment(String comment){};
  public void setDuration(double duration){};
  public void setDifficulty(double d){};
  public void addChoice(Choice ch){}
}
