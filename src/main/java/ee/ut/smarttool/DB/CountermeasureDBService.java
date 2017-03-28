package ee.ut.smarttool.DB;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CountermeasureDBService extends GeneralCRUDs{
	
	
    
    public int insertCountermeasure(String id,String name,String description,String cost,String operation,String probability) throws Exception{
    	String query="insert into  countermeasure (id, name,description,cost,probability) values(?,'?','?','?','?')";
	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(id, name,description,cost,probability));
	return DB.executeQuery(query);
    }
    
    public int insertCountermeasure(String id,String name,String description,String isAtomic) {
        try {
            String query="insert into  countermeasure (id, name,description,isAtomic) values(?,'?','?',?)";
            query=QueryMaker.queryFitter(query, QueryMaker.createArgList(id, name,description,isAtomic));
            int res = DB.executeQuery(query); 
            return res;
        } catch (Exception ex) {
            Logger.getLogger(CountermeasureDBService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;    
        }
    }
    
    
    public int updateCountermeasure(int id,String name,String description
            ,String cost,String operation,String probability
            ,int attackId,String failure_times) throws Exception{
    		
        String query= "update countermeasure set name='?', description='?',cost='?',operation='?',probability='?',attack_id='?',failure_times='?' where id='?'";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(name,description
    								, cost,operation,probability
    								,Integer.toString(attackId),failure_times,Integer.toString(id))); 
    	return DB.executeQuery(query);
    }

        public int updateCountermeasure(String id,String name,String description) throws Exception{
    		
        String query= "update countermeasure set name='?', description='?' where id='?'";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(name,description,id)); 
    	return DB.executeQuery(query);
    }
    
}


