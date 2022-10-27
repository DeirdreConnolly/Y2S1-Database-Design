

//import java.sql.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



public class Driver {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            // 1. Get a connection to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightbookingsystem?user=root&password=password&useSSL=false&allowPublicKeyRetrieval=true" );

            // 2. Create a statement
            Statement s = con.createStatement();

            // 3. Execute SQL queries
            ResultSet myRs = s.executeQuery("SELECT * from passenger");

            // INSERT
            String sql_i =  "insert into booking" +
                            "(bookingNo, flightNo, departDateTime, seatNo, passportNo, price)" +
                            "values ('AK206', 'EI2008', '2019-01-14 12:05:00', 'H06', 'PIE31415', '120')";
            s.executeUpdate(sql_i);

            // UPDATE
            String sql_u =  "update flight" +
                            "set gate = 'G12'" +
                            "where flightNo='AE6302'";
            s.executeUpdate(sql_u);


            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("sName") + ", " + myRs.getString("fName"));
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
