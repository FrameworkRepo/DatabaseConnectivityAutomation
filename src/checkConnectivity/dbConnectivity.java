package checkConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnectivity {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String host = "BH17261";
		
		String password = "Nav@3108";
		
		ResultSet rs;

		String partnerOrderId = "584153477079";

		String res_Nbr = null;

		Connection con = DriverManager.getConnection("jdbc:db2://C301:3560/ADG0", host, password);

		Statement s = con.createStatement();

		rs = s.executeQuery("SELECT * FROM S2B.FIL_STG_RES WHERE XREF_DOC IN ('" + partnerOrderId + "')");

		while (rs.next()) {

			res_Nbr = rs.getString("RES_NBR");
			System.out.println("Reservation Number : " + rs.getString("RES_NBR"));
			System.out.println("STAT : " + rs.getString("STAT"));
		}
		rs = s.executeQuery("SELECT * FROM S2B.FIL_STG_RESLN where RES_NBR = '" + res_Nbr + "'");

		while (rs.next()) {

			System.out.println("LN_NBR : " + rs.getString("LN_NBR"));
			System.out.println("HOW_EXP : " + rs.getString("HOW_EXP"));

		}
	}

}
