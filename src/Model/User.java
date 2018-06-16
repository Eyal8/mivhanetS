package Model;

/**
 * Created by eyal8_000 on 14/04/2018.
 */
public abstract class User {
  protected String userName;
  protected String firstName;
  protected String lastName;
  protected String ID;
  protected String address;
  protected String phoneNumber;
  protected String email;

  public User(String firstName, String lastName, String ID) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.ID = ID;
  }

  public User(){};

    public String getID() {
        return ID;
    }
}
