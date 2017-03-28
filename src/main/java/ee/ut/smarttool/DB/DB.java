package ee.ut.smarttool.DB;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DB
{
	static Connection connection;
	static Statement statement;
	public static void openConnection() throws Exception{
		try {
			Class.forName("org.sqlite.JDBC");
		    File file = new File(DB.class.getClassLoader().getResource("db/AlignedADTree.sqlite").getFile());
		//    File file = new File("C://DB/alignedADTree.sqlite");
		    String DBPath=file.getAbsolutePath();
		 //   System.out.println(DBPath);
		    connection = DriverManager.getConnection("jdbc:sqlite:"+DBPath);
		    connection.setAutoCommit(true);
		    statement = connection.createStatement();
		    statement.execute("PRAGMA foreign_keys = ON"); 		
		} catch (Exception e) {
			System.out.println("DB file not found: "+e);	
		}
	}
  
	public static  int executeQuery(String sql) throws Exception{
		     openConnection();
		     System.out.println(sql);
	    	int res=   statement.executeUpdate(sql);
	      	closeConnection();
	      	return res;
  }
  
    public static Map<String, ArrayList<String>> selectQuery(String query) throws Exception{
	  
      openConnection();
	  
      ResultSet rs = statement.executeQuery(query);
      Map<String, ArrayList<String>> table = printRows(rs);
      
      closeConnection();
      return table;
  }

    public static Map<String, ArrayList<String>> printRows(ResultSet res ) throws Exception{
    	Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    	map= getColumns(res);
    	while(res.next())
    		map= makeRow(res,map);
    	return map;
    }
    
    private static Map<String, ArrayList<String>> makeRow(ResultSet res, Map<String, ArrayList<String>> map) throws Exception {
    	ResultSetMetaData rsmd=res.getMetaData();	
		for(int i=1;i<=rsmd.getColumnCount();i++){
		//	System.out.println(res.getString(i)+" ");
			map.get(rsmd.getColumnLabel(i)).add(res.getString(i));
		}
		return map;
	}

	private static Map<String, ArrayList<String>> getColumns(ResultSet res) throws Exception {
    	Map<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
    	ResultSetMetaData metaData = res.getMetaData();
    	int count = metaData.getColumnCount(); //number of column

    	for (int i = 1; i <= count; i++){
    	//	System.out.println(" |*>"+metaData.getColumnLabel(i));
    	   map.put(metaData.getColumnLabel(i), new ArrayList<String>());
    	}
    	return map;
		
	}


	public static void closeConnection(){
	  
      try{
        if(connection != null)
          connection.close();
      }
      catch(SQLException e){
        System.err.println(e);
      } 
  }

    

  
}
