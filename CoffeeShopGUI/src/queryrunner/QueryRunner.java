/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queryrunner;
// Steph test again
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * QueryRunner takes a list of Queries that are initialized in it's constructor
 * and provides functions that will call the various functions in the QueryJDBC
 * class which will enable MYSQL queries to be executed. It also has functions
 * to provide the returned data from the Queries. Currently the eventHandlers
 * in QueryFrame call these functions in order to run the Queries.
 */
public class QueryRunner
{
	
	/**
	 * HELLOOO CCHHHANNNGING FROM EM
	 */

   public QueryRunner()
   {
      //
      this.m_jdbcData = new QueryJDBC();
      m_updateAmount = 0;
      m_queryArray = new ArrayList<>();
      m_error = "";

      // TODO - You will need to change the queries below to match your
      // queries.

      String vendorListQuery = "SELECT VENDOR_COMPANY_NAME, YEAR(SYSDATE()) " +
            "- YEAR(VENDOR_SINCE_DATE) AS Num_Years_As_Vendor, VENDOR_SINCE_DATE " +
            "FROM VENDOR_LIST ORDER BY VENDOR_SINCE_DATE";
      String vendorListDesc = "List of vendors ordered by oldest to newest, " +
            "incl. column with years as vendor.";
      
      String equipServiceQuery = "SELECT T.EQUIP_TYPE_DESC, E.STORE_ID, \r\n" + 
            "E.EQUIP_PURCHASE_DATE, E.EQUIP_LAST_SERVICED, " +
            "E.EQUIP_SERVICE_FREQUENCY_DAYS, DATE_ADD(EQUIP_LAST_SERVICED, " +
            "INTERVAL EQUIP_SERVICE_FREQUENCY_DAYS DAY) AS NEXT_SERVICE_DATE" +
            " FROM EQUIPMENT E JOIN EQUIPMENT_TYPE T ON E.EQUIP_TYPE_ID = " +
            "T.EQUIP_TYPE_ID ORDER BY NEXT_SERVICE_DATE";
            
      String equipServiceDesc = "Next service due date by piece of equipment";
      
      String storeContactQueryDesc = "Number of employees per store with "
      		+ "store/manager contact information";
      
      String storeContactQuery = "SELECT\r\n" + 
      		"E.STORE_ID,\r\n" + 
      		"CONCAT(S.STORE_ADDRESS_ST_NUMBER, \" \", S.STORE_ADDRESS_STREET_NAME) AS LOCATION,\r\n" + 
      		"COUNT(*) as NUMBER_OF_EMPS,\r\n" + 
      		"CONCAT(E.EMP_FNAME, \" \", E.EMP_LNAME) AS MANAGER, \r\n" + 
      		"S.STORE_PHONE, \r\n" + 
      		"E.EMP_PHONE    \r\n" + 
      		"FROM \r\n" + 
      		"EMPLOYEE E\r\n" + 
      		"INNER JOIN \r\n" + 
      		"STORE S on E.STORE_ID = S.STORE_ID \r\n" + 
      		"GROUP BY \r\n" + 
      		"S.STORE_ID; \r\n" ;
      
      
      // You will need to put your Project Application in the below variable

      this.m_projectTeamApplication = "No Dozin' Coffee Roasters"; // THIS
                                                                   // NEEDS TO
                                                                   // CHANGE
                                                                   // FOR YOUR
                                                                   // APPLICATION

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

      m_queryArray.add(new QueryData(vendorListDesc, vendorListQuery, null,
            null, false, false)); // THIS NEEDS TO CHANGE FOR YOUR APPLICATION
      m_queryArray.add(new QueryData(equipServiceDesc, equipServiceQuery, null,
            null, false, false)); // THIS NEEDS TO CHANGE FOR YOUR APPLICATION
      m_queryArray.add(new QueryData(storeContactQueryDesc, storeContactQuery, 
    		  null, null, false, false));
     
      // m_queryArray.add(new QueryData("Select * from contact where
      // contact_id=?", new String [] {"CONTACT_ID"}, new boolean [] {false},
      // false, true)); // THIS NEEDS TO CHANGE FOR YOUR APPLICATION
      // m_queryArray.add(new QueryData("Select * from contact where
      // contact_name like ?", new String [] {"CONTACT_NAME"}, new boolean []
      // {true}, false, true)); // THIS NEEDS TO CHANGE FOR YOUR APPLICATION
      // m_queryArray.add(new QueryData("insert into contact (contact_id,
      // contact_name, contact_salary) values (?,?,?)",new String []
      // {"CONTACT_ID", "CONTACT_NAME", "CONTACT_SALARY"}, new boolean []
      // {false, false, false}, true, true));// THIS NEEDS TO CHANGE FOR YOUR
      // APPLICATION

   }

   public int GetTotalQueries()
   {
      return m_queryArray.size();
   }

   public int GetParameterAmtForQuery(int queryChoice)
   {
      QueryData e = m_queryArray.get(queryChoice);
      return e.GetParmAmount();
   }

   public String GetParamText(int queryChoice, int parmnum)
   {
      QueryData e = m_queryArray.get(queryChoice);
      return e.GetParamText(parmnum);
   }

   public String GetQueryText(int queryChoice)
   {
      QueryData e = m_queryArray.get(queryChoice);
      return e.GetQueryString();
   }

   public String getQueryDesc(int queryChoice)
   {
      QueryData e = m_queryArray.get(queryChoice);
      return e.getQueryDesc();
   }

   /**
    * Function will return how many rows were updated as a result of the update
    * query
    * 
    * @return Returns how many rows were updated
    */

   public int GetUpdateAmount()
   {
      return m_updateAmount;
   }

   /**
    * Function will return ALL of the Column Headers from the query
    * 
    * @return Returns array of column headers
    */
   public String[] GetQueryHeaders()
   {
      return m_jdbcData.GetHeaders();
   }

   /**
    * After the query has been run, all of the data has been captured into a
    * multi-dimensional string array which contains all the row's. For each row
    * it also has all the column data. It is in string format
    * 
    * @return multi-dimensional array of String data based on the resultset
    *         from the query
    */
   public String[][] GetQueryData()
   {
      return m_jdbcData.GetData();
   }

   public String GetProjectTeamApplication()
   {
      return m_projectTeamApplication;
   }

   public boolean isActionQuery(int queryChoice)
   {
      QueryData e = m_queryArray.get(queryChoice);
      return e.IsQueryAction();
   }

   public boolean isParameterQuery(int queryChoice)
   {
      QueryData e = m_queryArray.get(queryChoice);
      return e.IsQueryParm();
   }

   public boolean ExecuteQuery(int queryChoice, String[] parms)
   {
      boolean bOK = true;
      QueryData e = m_queryArray.get(queryChoice);
      bOK = m_jdbcData.ExecuteQuery(e.GetQueryString(), parms, e
            .GetAllLikeParams());
      return bOK;
   }

   public boolean ExecuteUpdate(int queryChoice, String[] parms)
   {
      boolean bOK = true;
      QueryData e = m_queryArray.get(queryChoice);
      bOK = m_jdbcData.ExecuteUpdate(e.GetQueryString(), parms);
      m_updateAmount = m_jdbcData.GetUpdateCount();
      return bOK;
   }

   public boolean Connect(String szHost, String szUser, String szPass,
         String szDatabase)
   {

      boolean bConnect = m_jdbcData.ConnectToDatabase(szHost, szUser, szPass,
            szDatabase);
      if (bConnect == false)
         m_error = m_jdbcData.GetError();
      return bConnect;
   }

   public boolean Disconnect()
   {
      // Disconnect the JDBCData Object
      boolean bConnect = m_jdbcData.CloseDatabase();
      if (bConnect == false)
         m_error = m_jdbcData.GetError();
      return true;
   }

   public String GetError()
   {
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

   public static void main(String[] args)
   {
      
     
      // TODO code application logic here

      final QueryRunner queryrunner = new QueryRunner();

      if (args.length == 0)
      {
         java.awt.EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               new QueryFrame(queryrunner).setVisible(true);

            }
         });
      }
      else
      {
         if (args[0] == "-console")
         {
            // TODO
            // You should code the following functionality:

            // You need to determine if it is a parameter query. If it is, then
            // you will need to ask the user to put in the values for the
            // Parameters in your query
            // you will then call ExecuteQuery or ExecuteUpdate (depending on
            // whether it is an action query or regular query)
            // if it is a regular query, you should then get the data by
            // calling GetQueryData. You should then display this
            // output.
            // If it is an action query, you will tell how many row's were
            // affected by it.
            //
            // This is Psuedo Code for the task:
            // Connect()
            // n = GetTotalQueries()
            // for (i=0;i < n; i++)
            // {
            // Is it a query that Has Parameters
            // Then
            // amt = find out how many parameters it has
            // Create a paramter array of strings for that amount
            // for (j=0; j< amt; j++)
            // Get The Paramater Label for Query and print it to console. Ask
            // the user to enter a value
            // Take the value you got and put it into your parameter array
            // If it is an Action Query then
            // call ExecuteUpdate to run the Query
            // call GetUpdateAmount to find out how many rows were affected,
            // and print that value
            // else
            // call ExecuteQuery
            // call GetQueryData to get the results back
            // print out all the results
            // end if
            // }
            // Disconnect()

            // NOTE - IF THERE ARE ANY ERRORS, please print the Error output
            // NOTE - The QueryRunner functions call the various JDBC Functions
            // that are in QueryJDBC. If you would rather code JDBC
            // functions directly, you can choose to do that. It will be
            // harder, but that is your option.
            // NOTE - You can look at the QueryRunner API calls that are in
            // QueryFrame.java for assistance. You should not have to
            // alter any code in QueryJDBC, QueryData, or QueryFrame to make
            // this work.
            System.out.println("Please write the non-gui functionality");
         }
         else
         {
            System.out.println(
                  "usage: you must use -console as your argument to get non-gui functionality. If you leave it out it will be GUI");
         }
      }

   }
}
