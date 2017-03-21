package ee.ut.smarttool.DB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AttackDBService {
	    
    
    public int insertAttack(String name,String description,int threatAgent_id,int asset_id
    		,String success,String times,String probability,int countermeasure_id,String operation
            ,String cost_of_damage, String cost_of_attack,int impact_id) throws Exception{

    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	Date today = Calendar.getInstance().getTime();      
    	String reportDate = df.format(today);
    	
    	String query="insert into  attack ( name,description,threatAgent_id,asset_id,date,success,times,probability,countermeasure_id,operation,cost_of_damage,cost_of_attack,impact_id) values('?','?','?','?','?','?','?','?','?','?','?','?','?')";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList( name,description,Integer.toString(threatAgent_id),Integer.toString(asset_id),
				                                                      reportDate,success,times,probability,Integer.toString(countermeasure_id),
				                                                      operation,cost_of_damage,cost_of_attack,Integer.toString(impact_id)));
		return DB.executeQuery(query);
    }

    public int updateAttack(int id,String name,String description,int threatAgent_id,int asset_id
    		,String success,String times,String probability,int countermeasure_id,String operation
            ,String cost_of_damage, String cost_of_attack,int impact_id) throws Exception{

    	String query= "update attack set name='?',description='?',threatAgent_id=?,asset_id=?,success='?',times='?',probability='?',countermeasure_id=?,operation='?',cost_of_damage='?',cost_of_attack='?',impact_id='?' where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList( name,description,Integer.toString(threatAgent_id),Integer.toString(asset_id),
                success,times,probability,Integer.toString(countermeasure_id),
                operation,cost_of_damage,cost_of_attack,Integer.toString(impact_id),Integer.toString(id)));
    	return DB.executeQuery(query);
    }
    
    
    
    
    
}


