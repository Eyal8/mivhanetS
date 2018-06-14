package Model;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class Semester {
  private String year;
  private SemesterType season;

  public Semester(String year, SemesterType st){
    this.year = year;
    this.season = st;
  }
}
