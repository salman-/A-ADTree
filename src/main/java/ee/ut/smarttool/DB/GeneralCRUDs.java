package ee.ut.smarttool.DB;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            try{
                String id=null;
                String query="select * from ? where ?=?";
                query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table,fieldName,fieldValue));
		Map<String, ArrayList<String>>res= DB.selectQuery(query);
                if(res.get("id").size()>0)
                  id=res.get("id").toArray()[0].toString();
            //    System.out.println("Table:"+table+" "+"ID is: "+id);
                return id;
            }catch(Exception e){
                 Logger.getLogger(GeneralCRUDs.class.getName()).log(Level.SEVERE, null, e);
                return null;}
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
        
     
	public int deleteParentId(String table,String parent_id) throws Exception {
		String query="delete  from ? where parent_id=?";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(table,parent_id));
		return DB.executeQuery(query);
	}

        public void deleteAllRecords() throws Exception{
        String[] query={
           "delete from attackTree;",
            "delete from countermeaureTree;",            
            "delete  from 'attack-counterTree';" ,
            "delete from 'counter-attackTree';",
            "delete from attack;" ,
            "delete from countermeasure;",
                           
                      };
            for(int i=0;i<query.length;i++){
                
            int res = DB.executeQuery(query[i]);
                System.out.println(query[i]+ " Result was:"+res);
            }
        
        }
}
