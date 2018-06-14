package Model;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class QuestionInExam extends Question {
  private boolean answeredRight;
  private Exam exam;
  private Student student;

  public QuestionInExam(String body, double score, Difficulty difficultyLevel, double estimatedTime, boolean answeredRight){
    super(body, score, difficultyLevel, estimatedTime);
    this.answeredRight= answeredRight;
  }
  public void setAnsweredRight(boolean right){this.answeredRight=right;}
  public boolean getAnsweredRight(){return this.answeredRight;}
}
