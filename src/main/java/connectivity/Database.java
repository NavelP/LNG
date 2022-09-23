package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public Connection connection;

    String databaseName = "LibManagement";
    String userName = "root";
    String password = "";

    public Database(String databaseName, String userName, String password) {
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
    }

    public Database(){}

    public Connection connectDB(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + this.databaseName , this.userName , this.password);
        }catch(Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
