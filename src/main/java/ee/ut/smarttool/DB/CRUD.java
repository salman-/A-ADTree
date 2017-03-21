package ee.ut.smarttool.DB;

import java.util.ArrayList;
import java.util.Map;

public interface CRUD {

//	public int insert(String table,String... args) throws Exception;
	
//	public int update(String... args) throws Exception;
	
	public Map<String, ArrayList<String>> selectAll(String table) throws Exception;
	
	public Map<String, ArrayList<String>> select(String table,int id) throws Exception;
	
	public int delete(String table,String id) throws Exception;
    
	public int deleteAll(String table) throws Exception;
}
