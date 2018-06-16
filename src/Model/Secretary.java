package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class Secretary extends User {
 // Database db = new Database();
  public void AddLecturersToCourse(ArrayList<String> lecturersIDS, SemesterType season, String courseID, String year){
    //ResultSet rs2 = db.executeSqlQuery("INSERT INTO Comment (questionBody, commentBody) VALUES('what are you?','lovely question!!(!');SELECT * FROM Comment;");
   /* ResultSet rs = db.executeSqlQuery("SELECT questionBody FROM Comment;");
    try {
      if (!rs.isBeforeFirst() ) {
        System.out.println("no data");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }*/
  }
  public boolean AddTutorsToCourse(ArrayList<String> tutorsIDS,SemesterType season, String year, String courseID){ return true;}
  public boolean CreateExamsToCourse(String courseID , HashMap<Moed,Date> exams, SemesterType season, String year){ return true;}

}
