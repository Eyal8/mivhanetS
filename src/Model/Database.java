package Model;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Database {
    static Connection c;
    public Database()
    {
        c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String currentPath= System.getProperty("user.dir");
            c = DriverManager.getConnection("jdbc:sqlite:"+currentPath+"\\src\\Model\\mivhanet_db.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void executeUpdateQuery(String Query)
    {
        try {
            Statement stmt = c.createStatement();
            stmt.executeUpdate(Query);
            stmt.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static Map<Statement, ResultSet> executeSqlQuery(String Query)
    {
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(Query);
            //stmt.close();
            Map<Statement, ResultSet> result = new HashMap<>();
            result.put(stmt,rs);
            return result;
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return null;
    }

}