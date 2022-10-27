
package javamysql;

import java.sql.*;

/**
 *
 * @author Deirdre
 */
public class UpdateRecord {

    /** Creates a new instance of UpdateRecord */
    public UpdateRecord() {
    }


    public  void update(Connection con) {
        try {
            // 1. Update record in database
            Statement updateS = con.createStatement();
            String updateSQL = "Update flight set gate = 'B14' where flightNo = 'EI2008'";

            int res = updateS.executeUpdate(updateSQL);
            System.out.println("Number of records updated: " + res);
            // You May need to uncomment if Autocommit is not set
            con.commit();
            updateS.close();
        }
        catch (Exception io) {
            System.out.println("ERROR: " + io);
        }

    }//update

}
