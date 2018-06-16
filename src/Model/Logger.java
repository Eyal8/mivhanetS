package Model;

import java.util.ArrayList;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public class Logger {
  private static Logger instance;

  private Logger(){
  }
  public Logger getInstance(){
    if(instance == null){
      instance = new Logger();
    }
    return instance;
  }
   private  ArrayList<Action> actions;
   private ArrayList<Error> errors;
}
