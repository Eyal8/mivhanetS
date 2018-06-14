package Model;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class Grade {
  private double value;
  private Student student;
  private Exam exam;

  public Grade(Student s, Exam e, double val){
    this.student=s;
    this.exam=e;
    this.value=val;
  }
  public void addScoreToGrade(double score){value+=score;}
  public void setGrade(double percentFactor){}
  public double getGrade(){return this.value;}
}
