package ee.ut.smarttool.DB;

import java.util.ArrayList;
import java.util.Map;

public class GeneralCRUDs implements CRUD {

	@Override
	public Map<String, ArrayList<String>> selectAll(String table) throws Exception {
		String query="select * from '?'";
                query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table));
		return DB.selectQuery(query);
	}

	@Override
	public Map<String, ArrayList<String>> select(String table,String id) throws Exception {
		String query="select * from '?' where id=?";
                query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table,id));
		return DB.selectQuery(query);
	}
        
        
	public Map<String, ArrayList<String>> selectbyName(String table,String name) throws Exception {
		String query="select * from '?' where name='?'";
                query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table,name));
		return DB.selectQuery(query);
	}
        
        
	public String selectIdFromField(String table, String fieldName, String fieldValue ) throws Exception {
		String query="select * from '?' where ?='?'";
                query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table,fieldName,fieldValue));
		Map<String, ArrayList<String>>res= DB.selectQuery(query);
                String id=res.get("id").toArray()[0].toString();
                System.out.println("Table:"+table+" "+"ID is: "+id);
                return id;
	}
        

	@Override
	public int delete(String table,String id) throws Exception {
		String query="delete  from ? where id=?";
                query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table,id));
		return DB.executeQuery(query);
	}

        	
	public int deleteByName(String table,String name) throws Exception {
		String query="delete  from ? where name='?'";
                query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table,name));
		return DB.executeQuery(query);
	}

        
	@Override
	public int deleteAll(String table) throws Exception {
		String query="delete  from ?";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table));
		return DB.executeQuery(query);
	}

}
