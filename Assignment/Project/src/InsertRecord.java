package javamysql;

import java.sql.*;

/**
 *
 * @author Deirdre
 */
public class InsertRecord {

    public InsertRecord() {
    }

    public  void insert(Connection con) {
        try {
            // 1. Insert record into database
            Statement insertS = con.createStatement();
            String insertSQL = " Insert into flight values ('AE6302', 'Emirates', 'UAE', 'IAH', '2019-01-12 13:40:00', '2019-01-13 20:00:00', '14:00:00', 'G06', '350'. '10')";

            int res = insertS.executeUpdate(insertSQL);
            System.out.println("Number of records inserted: " + res);
            // You May need to uncomment if Autocommit is not set
            con.commit();
            insertS.close();

        }
        catch (Exception io) {
            System.out.println("ERROR: " + io);
        }

    }//insert
}
