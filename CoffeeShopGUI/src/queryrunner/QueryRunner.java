/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queryrunner;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * QueryRunner takes a list of Queries that are initialized in it's constructor
 * and provides functions that will call the various functions in the QueryJDBC
 * class which will enable MYSQL queries to be executed. It also has functions
 * to provide the returned data from the Queries. Currently the eventHandlers in
 * QueryFrame call these functions in order to run the Queries.
 * 
 * @author Michael McKee, Zachary Bax, Emily Desmond, Stephanie Peters, Yvonne Rogell
 */
public class QueryRunner {

	public QueryRunner() {
		this.m_jdbcData = new QueryJDBC();
		m_updateAmount = 0;
		m_queryArray = new ArrayList<>();
		m_error = "";
		
		String helloDesc = "Welcome to the No Dozin' Database!\n\nPlease " +
            "log in.\n " +
            "  .-~~-.\n" +
            ",|`-__- '|\n" +
            "||           |\n" +
            "`|          |\n" +
            "  `-__- '";
      String helloQuery = "SELECT * FROM STORE";

		String vendorListDesc = "List of vendors ordered by oldest to newest, "
				+ "incl. column with years as vendor.";
		String vendorListQuery = "SELECT VENDOR_COMPANY_NAME, YEAR(SYSDATE()) "
				+ "- YEAR(VENDOR_SINCE_DATE) AS Num_Years_As_Vendor, VENDOR_SINCE_DATE "
				+ "FROM VENDOR_LIST ORDER BY VENDOR_SINCE_DATE";

		String equipServiceDesc = "Next service due date by piece of equipment";
		String equipServiceQuery = "SELECT T.EQUIP_TYPE_DESC, E.STORE_ID, \r\n"
				+ "E.EQUIP_PURCHASE_DATE, E.EQUIP_LAST_SERVICED, "
				+ "E.EQUIP_SERVICE_FREQUENCY_DAYS, DATE_ADD(EQUIP_LAST_SERVICED, "
				+ "INTERVAL EQUIP_SERVICE_FREQUENCY_DAYS DAY) AS NEXT_SERVICE_DATE"
				+ " FROM EQUIPMENT E JOIN EQUIPMENT_TYPE T ON E.EQUIP_TYPE_ID = "
				+ "T.EQUIP_TYPE_ID ORDER BY NEXT_SERVICE_DATE";

		String storeContactQueryDesc = "Number of employees per store with "
				+ "store/manager contact information";
		String storeContactQuery = "SELECT E.STORE_ID, CONCAT(S.STORE_ADDRESS_ST_NUMBER, \" \", "
				+ "S.STORE_ADDRESS_STREET_NAME) AS LOCATION, COUNT(*) as NUMBER_OF_EMPS,"
				+ "CONCAT(E.EMP_FNAME, \" \", E.EMP_LNAME) AS MANAGER, S.STORE_PHONE, "
				+ "E.EMP_PHONE FROM EMPLOYEE E INNER JOIN STORE S on "
				+ "E.STORE_ID = S.STORE_ID GROUP BY S.STORE_ID;";

		String recipeQueryDesc = "Recipe for each menu item";
		String recipeQuery = "SELECT MENU_ITEM_DESC, COMP_PROD_DESC, COMP_PROD_QTY_PER_1_MENU_ITEM,"
				+ "COMP_PROD_UNIT_MEASUREMENT FROM MENU_ITEM M INNER JOIN "
				+ "MENU_ITEM_contains_COMPONENT_PRODUCT MC ON M.MENU_ITEM_ID = MC.MENU_ITEM_ID INNER JOIN "
				+ "COMPONENT_PRODUCT C ON MC.COMP_PROD_ID = C.COMP_PROD_ID";

		String profitabilityDesc = "Menu item profitability";
		String profitabilityQuery = "SELECT MENU_ITEM_DESC, MENU_ITEM_RETAIL_PRICE, "
				+ "ROUND(SUM(COMP_PROD_QTY_PER_1_MENU_ITEM * COMP_PROD_UNIT_COST),2) AS COGS, "
				+ "ROUND((MENU_ITEM_RETAIL_PRICE - SUM(COMP_PROD_QTY_PER_1_MENU_ITEM * COMP_PROD_UNIT_COST)) "
				+ "/ MENU_ITEM_RETAIL_PRICE * 100,2) AS MARKUP_PERCENTAGE FROM MENU_ITEM M INNER JOIN "
				+ "MENU_ITEM_contains_COMPONENT_PRODUCT MC ON M.MENU_ITEM_ID = MC.MENU_ITEM_ID INNER JOIN "
				+ "COMPONENT_PRODUCT C ON MC.COMP_PROD_ID = C.COMP_PROD_ID GROUP BY MENU_ITEM_DESC "
				+ "ORDER BY MARKUP_PERCENTAGE DESC";

		String farmerCertDesc = "All farmers and their certifications.";
		String farmerCertQuery = "SELECT v.VENDOR_COMPANY_NAME, cf.FARMER_CERT_DATE, c.CERT_DESC"
				+ " FROM COFFEE_FARMER_has_CERTIFICATION cf, VENDOR_LIST v, CERTIFICATION c "
				+ "WHERE v.vendor_id = cf.vendor_id AND cf.cert_id = c.cert_id "
				+ "ORDER BY v.vendor_company_name";

		String farmerProdDesc = "Calculating each farmer's productivity (yield/acre)";
		String farmerProdQuery = "SELECT COFFEE_FARMER.VENDOR_ID, "
				+ "VENDOR_LIST.VENDOR_COMPANY_NAME, VENDOR_LIST.VENDOR_ADDRESS_COUNTRY, "
				+ "ROUND(COFFEE_FARMER.COFFEE_FARMER_ANNUAL_YIELD / COFFEE_FARMER.COFFEE_FARMER_ACREAGE, 2) "
				+ "AS YIELD_PER_ACRE FROM COFFEE_FARMER JOIN VENDOR_LIST ON "
				+ "COFFEE_FARMER.VENDOR_ID = VENDOR_LIST.VENDOR_ID ORDER BY "
				+ "YIELD_PER_ACRE DESC";

		String totalSalesDesc = "Total sales by menu item\n\nEnter dates in the following format: yyyy-mm-dd";
		String totalSalesQuery = "SELECT MENU_ITEM_DESC,ROUND(SUM(TRANS_LINE_ITEM_UNIT_QTY * "
				+ "MENU_ITEM_RETAIL_PRICE),2) AS TOTAL_SALES, SUM(TRANS_LINE_ITEM_UNIT_QTY) AS TOTAL_UNITS"
				+ " FROM CUSTOMER_TRANSACTION C INNER JOIN CUSTOMER_TRANSACTION_LINE_ITEM T "
				+ "ON C.CUST_TRANS_ID = T.CUST_TRANS_ID INNER JOIN MENU_ITEM M ON T.MENU_ITEM_ID = "
				+ "M.MENU_ITEM_ID WHERE C.CUST_TRANS_DATE_TIME BETWEEN ? AND ? GROUP BY"
				+ " MENU_ITEM_DESC WITH ROLLUP";

		String addStoreDesc = "Open a new store and promote an existing employee from another store to manager of the new store";
		String addStore = "INSERT INTO STORE " + "	(STORE_PHONE, "
				+ "    STORE_ADDRESS_ST_NUMBER, "
				+ "    STORE_ADDRESS_STREET_NAME, " + "    STORE_ADDRESS_CITY, "
				+ "    STORE_ADDRESS_STATE, " + "    STORE_ADDRESS_ZIP, "
				+ "    STORE_OPEN_DATE) "
				+ "VALUES(?, ?, ?, ?, ?, ?, curdate()); " +

				"UPDATE EMPLOYEE E "
				+ "SET E.JOB_TITLE_ID = 1, E.EMP_HOURLY_PAY_RATE = ?, E.STORE_ID = (SELECT LAST_INSERT_ID()) "
				+ "WHERE E.EMPLOYEE_ID = ?; " + "COMMIT;";

		this.m_projectTeamApplication = "No Dozin' Coffee Roasters";

		// Each row that is added to m_queryArray is a separate query. It does
		// not work on Stored procedure calls.
		// The 'new' Java keyword is a way of initializing the data that will be
		// added to QueryArray. Please do not change
		// Format for each row of m_queryArray is: (QueryText,
		// ParamaterLabelArray[], LikeParameterArray[], IsItActionQuery,
		// IsItParameterQuery)

		// QueryText is a String that represents your query. It can be anything
		// but Stored Procedure
		// Parameter Label Array (e.g. Put in null if there is no Parameters in
		// your query, otherwise put in the Parameter Names)
		// LikeParameter Array is an array I regret having to add, but it is
		// necessary to tell QueryRunner which parameter has a LIKE Clause. If
		// you have no parameters, put in null. Otherwise put in false for
		// parameters that don't use 'like' and true for ones that do.
		// IsItActionQuery (e.g. Mark it true if it is, otherwise false)
		// IsItParameterQuery (e.g.Mark it true if it is, otherwise false)

		String helloButton = "0 Choose query";
		String vendorButton = "1 Vendor";
		String equipmentButton = "2 Equipment";
		String recipeButton = "3 Recipe";
		String profitButton = "4 Profit";
		String storeButton = "5 Store";
		String farmerCertButton = "6 Farmer Cert";
		String farmerProdButton = "7 Productivity";
		String salesButton = "8 Sales";
		String addStoreButton = "9 Add store"; 
		
		m_queryArray.add(new QueryData(helloButton, helloDesc, helloQuery, null,
            null, false, false));
		m_queryArray.add(new QueryData(vendorButton, vendorListDesc,
				vendorListQuery, null, null, false, false));
		m_queryArray.add(new QueryData(equipmentButton, equipServiceDesc,
				equipServiceQuery, null, null, false, false)); // APPLICATION
		m_queryArray.add(new QueryData(recipeButton, recipeQueryDesc,
				recipeQuery, null, null, false, false));
		m_queryArray.add(new QueryData(profitButton, profitabilityDesc,
				profitabilityQuery, null, null, false, false));
		m_queryArray.add(new QueryData(storeButton, storeContactQueryDesc,
				storeContactQuery, null, null, false, false));
		m_queryArray.add(new QueryData(farmerCertButton, farmerCertDesc,
				farmerCertQuery, null, null, false, false));
		m_queryArray.add(new QueryData(farmerProdButton, farmerProdDesc,
				farmerProdQuery, null, null, false, false));
		m_queryArray.add(new QueryData(salesButton, totalSalesDesc,
				totalSalesQuery, new String[] { "START_DATE", "END_DATE" },
				new boolean[] { false, false }, false, true));
		m_queryArray.add(new QueryData(addStoreButton, addStoreDesc, addStore,
				new String[] { "PHONE", "STREET_NUM", "STREET_NAME", "CITY",
						"STATE", "ZIP", "MANAGER_PAY", "EMP_ID" },
				new boolean[] { false, false, false, false, false, false, false,
						false },
				true, true));
	}

	public int GetTotalQueries() {
		return m_queryArray.size();
	}

	// Added function to retrieve query button text for drop-down menu
	public String getQueryButtonText(int queryChoice) {
		QueryData e = m_queryArray.get(queryChoice);
		return e.getQueryButtonText();
	}

	public int GetParameterAmtForQuery(int queryChoice) {
		QueryData e = m_queryArray.get(queryChoice);
		return e.GetParmAmount();
	}

	public String GetParamText(int queryChoice, int parmnum) {
		QueryData e = m_queryArray.get(queryChoice);
		return e.GetParamText(parmnum);
	}

	public String GetQueryText(int queryChoice) {
		QueryData e = m_queryArray.get(queryChoice);
		return e.GetQueryString();
	}

	// Added function to get description of query. 
	public String getQueryDesc(int queryChoice) {
		QueryData e = m_queryArray.get(queryChoice);
		return e.getQueryDesc();
	}

	/**
	 * Function will return how many rows were updated as a result of the update
	 * query
	 * 
	 * @return Returns how many rows were updated
	 */
	public int GetUpdateAmount() {
		return m_updateAmount;
	}

	/**
	 * Function will return ALL of the Column Headers from the query
	 * 
	 * @return Returns array of column headers
	 */
	public String[] GetQueryHeaders() {
		return m_jdbcData.GetHeaders();
	}

	/**
	 * After the query has been run, all of the data has been captured into a
	 * multi-dimensional string array which contains all the row's. For each row
	 * it also has all the column data. It is in string format
	 * 
	 * @return multi-dimensional array of String data based on the result set
	 *         from the query
	 */
	public String[][] GetQueryData() {
		return m_jdbcData.GetData();
	}

	public String GetProjectTeamApplication() {
		return m_projectTeamApplication;
	}

	public boolean isActionQuery(int queryChoice) {
		QueryData e = m_queryArray.get(queryChoice);
		return e.IsQueryAction();
	}

	public boolean isParameterQuery(int queryChoice) {
		QueryData e = m_queryArray.get(queryChoice);
		return e.IsQueryParm();
	}

	public boolean ExecuteQuery(int queryChoice, String[] parms) {
		boolean bOK = true;
		QueryData e = m_queryArray.get(queryChoice);
		bOK = m_jdbcData.ExecuteQuery(e.GetQueryString(), parms,
				e.GetAllLikeParams());
		return bOK;
	}

	public boolean ExecuteUpdate(int queryChoice, String[] parms) {
		boolean bOK = true;
		QueryData e = m_queryArray.get(queryChoice);
		bOK = m_jdbcData.ExecuteUpdate(e.GetQueryString(), parms);
		m_updateAmount = m_jdbcData.GetUpdateCount();
		return bOK;
	}

	public boolean Connect(String szHost, String szUser, String szPass,
			String szDatabase) {

		boolean bConnect = m_jdbcData.ConnectToDatabase(szHost, szUser, szPass,
				szDatabase);
		if (bConnect == false)
			m_error = m_jdbcData.GetError();
		return bConnect;
	}

	public boolean Disconnect() {
		// Disconnect the JDBCData Object
		boolean bConnect = m_jdbcData.CloseDatabase();
		if (bConnect == false)
			m_error = m_jdbcData.GetError();
		return true;
	}

	public String GetError() {
		return m_error;
	}

	private QueryJDBC m_jdbcData;
	private String m_error;
	private String m_projectTeamApplication;
	private ArrayList<QueryData> m_queryArray;
	private int m_updateAmount;

	/**
	 * @param args the command line arguments
	 */

	// Console App will Connect to Database
	// It will run a single select query without Parameters
	// It will display the results
	// It will close the database session
	public static void main(String[] args) {
		final QueryRunner queryrunner = new QueryRunner();
		if (args.length == 0) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new QueryFrame(queryrunner).setVisible(true);
				}
			});
		} else {
			if (args[0].equals("-console")) {
				boolean repeat;
				Scanner keyboard = new Scanner(System.in);
				do {
					repeat = false;
					// Get database login credentials from the user
					String hostname, username, password, database;
					System.out.print("Enter Hostname: ");
					hostname = keyboard.nextLine();
					System.out.print("Enter Username: ");
					username = keyboard.nextLine();
					System.out.print("Enter Password: ");
					password = keyboard.nextLine();
					System.out.print("Enter Database: ");
					database = keyboard.nextLine();
					// Use login credentials to connect to the database
					boolean connected = queryrunner.Connect(hostname, username,
							password, database);
					// Print a message to indicate whether login was successful
					if (connected) {
						System.out.println("Connected to the database.");
						System.out.println();
					}
					// If login fails, allow user to try again
					else {
						System.out.println(
								"Login failed. Not connected to the database. "
										+ "Would you like to try again? (y/n) ");
						if (keyboard.nextLine().toLowerCase().charAt(0) == 'y')
							repeat = true;
					}
				} while (repeat);

				// Get the number of queries
				int numQueries = queryrunner.GetTotalQueries();
				// Cycle through each query and execute it
				for (int i = 0; i < numQueries; i++) {
					// Determine if the query has parameters
					int numParams = queryrunner.m_queryArray.get(i)
							.GetParmAmount();
					String[] parameters = new String[numParams];
					// Get the parameters from the user
					// Recommended dates for most interesting results:
					// START_DATE: 2018-11-01
					// END_DATE: 2018-11-15
					if (numParams > 0) {
						for (int j = 0; j < parameters.length; j++) {
							String paramLabel = queryrunner.GetParamText(i, j);
							System.out.print(paramLabel + ": ");
							String input = keyboard.nextLine();
							parameters[j] = input;
						}
					}
					// Determine if the query is an action query and run it
					if (queryrunner.isActionQuery(i)) {
						queryrunner.ExecuteUpdate(i, parameters);
						int numUpdated = queryrunner.GetUpdateAmount();
						System.out.println(numUpdated + "rows were affected.");
					}
					// If query isn't an action query, run it
					else {
						queryrunner.ExecuteQuery(i, parameters);
						// Get the headers for each query and print to console
						String[] headers = queryrunner.GetQueryHeaders();
						for (int k = 0; k < headers.length; k++) {
							System.out.printf("%-40s ", headers[k]);
						}
						System.out.println();
						// Get the data for each query and print to console
						String[][] data = queryrunner.GetQueryData();
						for (int m = 0; m < data.length; m++) {
							for (int n = 0; n < data[m].length; n++) {
								System.out.printf("%-40s ", data[m][n]);
							}
							System.out.println();
						}
						System.out.println();
					}
				}
				// Disconnect from the database
				boolean disconnected = queryrunner.Disconnect();
				if (disconnected)
					System.out.println("Disconnected from the database.");
				else
					System.out.println("ERROR: Failed to disconnect from the "
							+ "database.");
			} else {
				System.out.println(
						"usage: you must use -console as your argument "
								+ "to get non-gui functionality. If you leave it out it will"
								+ " be GUI");
			}
		}
	}
}
