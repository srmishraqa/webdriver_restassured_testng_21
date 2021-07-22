package basicCommands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            Connection con = DriverManager.getConnection("sample string");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("sample SQL Query");
            //resultSet.getArray(0);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
