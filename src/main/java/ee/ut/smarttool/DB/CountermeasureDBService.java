package ee.ut.smarttool.DB;

public class CountermeasureDBService extends GeneralCRUDs{
	
	
    
    public int insertCountermeasure(String name,String description
    		                         ,String cost,String operation,String probability) throws Exception{
    	String query="insert into  countermeasure ( name,description,cost,probability) values('?','?','?','?')";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList( name,description,cost,probability));
		return DB.executeQuery(query);
    }
    
        public int insertCountermeasure(String name,String description) throws Exception{
            String query="insert into  countermeasure ( name,description) values('?','?')";
            query=QueryMaker.queryFitter(query, QueryMaker.createArgList( name,description));
            return DB.executeQuery(query);
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
	
}


