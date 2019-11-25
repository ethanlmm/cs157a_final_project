import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class DBConnector {
	
	//change this when you test
	public static String USERNAME = new String("TestUser");
	public static String PASSWORD = new String("eevee");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/mydb");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");


	public static DefaultTableModel execSelect() throws ClassNotFoundException, SQLException {
		// Load the Driver
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName(JDBC_DRIVER);
		

		// Get a connection from the connection factory
		Connection con = DriverManager.getConnection(DB_URL,
				// "jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
				USERNAME, PASSWORD);

		// Show some database/driver metadata
		SQLUtil.printDriverInfo(con);

		// Create a Statement object so we can submit SQL statements to the driver
		Statement stmt = con.createStatement();

		// Submit the statement
		String query = "SELECT * FROM patient;";
		ResultSet results = stmt.executeQuery(query);
		
		//Convert the results to a DefaultTableModel
		ResultSetMetaData resultsMetaData = results.getMetaData();
		int cols = resultsMetaData.getColumnCount();
		String[] colNames = new String[cols];
		for (int i = 1; i <= cols; i++)
		{
			colNames[i - 1] = resultsMetaData.getColumnName(i);
		}
		
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		while (results.next())
		{
			Object[] row = new Object[cols];
			for (int i = 1; i <= cols; i++)
			{
				row[i - 1] = results.getObject(i);
			}
			model.addRow(row);
		}
		////////////////////
//		model.addRow(new String[] { "Johnny", "Stfondi" });
//		model.addRow(new String[] { "Lili", "Rochefort" });
//		model.addRow(new String[] { "Ragna", "the Hedgehog" });
//		model.addRow(new String[] { "Sonshoukou", "Shaoren" });
//		model.addRow(new String[] { "Sousou", "Moutoku" });
//		model.addRow(new String[] { "Nanase", "UNI" });
//		model.addRow(new String[] { "Vatista", "UNI" });
		//////////////////////////////

		// Close the statement
		stmt.close();

		// Close the connection
		con.close();

		return model;
	}
	
//	private String[][] resultSetToArray(ResultSet rs)
//	{
//		String[][] results;
//		try {
//			ResultSetMetaData rsmd = rs.getMetaData();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//		return results;
//	}

}
