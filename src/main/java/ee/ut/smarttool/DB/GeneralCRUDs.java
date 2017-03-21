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
	public Map<String, ArrayList<String>> select(String table,int id) throws Exception {
		String query="select * from '?' where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table,Integer.toString(id)));
		return DB.selectQuery(query);
	}

	@Override
	public int delete(String table,String id) throws Exception {
		String query="delete  from ? where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table,id));
		return DB.executeQuery(query);
	}

	@Override
	public int deleteAll(String table) throws Exception {
		String query="delete  from ?";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table));
		return DB.executeQuery(query);
	}

}
