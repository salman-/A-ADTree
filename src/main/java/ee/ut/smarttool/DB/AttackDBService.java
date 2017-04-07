package ee.ut.smarttool.DB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class AttackDBService extends GeneralCRUDs {

    
    public int insertAttack( String name,String description,String probaility,
                            String costOfDamage,String costOfAttack,
                            String assetId) throws Exception{

    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	Date today = Calendar.getInstance().getTime();      
    	String reportDate = df.format(today);
    	
	String query="insert into  attack ( name,description,date, probability,costOfDamage,costOfAttack, asset_id,isAtomic) values('?','?','?','?','?','?',?,1)";
        query=QueryMaker.queryFitter(query, QueryMaker.createArgList( name,description,reportDate,probaility,costOfDamage,costOfAttack, assetId));
		return DB.executeQuery(query);
    }
    
    public int insertAttack(String id, String name,String description,String probaility,
                            String costOfDamage,String costOfAttack,
                            String assetId) throws Exception{

    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	Date today = Calendar.getInstance().getTime();      
    	String reportDate = df.format(today);
    	
	String query="insert into  attack (id, name,description,date, probability,costOfDamage,costOfAttack, asset_id,isAtomic) values('?','?','?','?','?','?','?',?,1)";
        query=QueryMaker.queryFitter(query, QueryMaker.createArgList(id, name,description,reportDate,probaility,costOfDamage,costOfAttack, assetId));
		return DB.executeQuery(query);
    }
    
        public int insertAttack(String id,String name,String description,String isAtomic) throws Exception{

	String query="insert into  attack (id, name,description,isAtomic) values(?,'?','?',?)";
        query=QueryMaker.queryFitter(query, QueryMaker.createArgList(id, name,description,isAtomic));
        return DB.executeQuery(query);
    }
                      
    public int updateAttack(String id,String name,String description,String threatAgent_id,String asset_id
    		,String success,String times,String probability,String countermeasure_id,String operation
            ,String cost_of_damage, String cost_of_attack,String impact_id) throws Exception{

    	String query= "update attack set name='?',description='?',threatAgent_id=?,asset_id=?,success='?',times='?',probability='?',countermeasure_id=?,operation='?',cost_of_damage='?',cost_of_attack='?',impact_id=? where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList( name,description,threatAgent_id,asset_id,
                success,times,probability,countermeasure_id,
                operation,cost_of_damage,cost_of_attack,impact_id,id));
    	return DB.executeQuery(query);
    }
    
    
    public int updateAttack(String id,String name,String description) throws Exception{

    	String query= "update attack set name='?',description='?' where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList( name,description,id));
    	return DB.executeQuery(query);
    }
    
    
    public Map<String, ArrayList<String>> selectAllAttack() throws Exception{

        
        
        /*
    	String query= "SELECT  attack.id,attack.name as Attack,attack.description,costOfAttack,costOfDamage,\n" +
                      "asset.name as Asset,impact.name as Impact,attack.probability,vulnerability .name as vulnerability \n" +
                      "FROM    attack    inner join  asset on attack.asset_id=asset.id\n" +
                      "inner join  impact on attack.impact_id=impact.id\n" +
                      "inner join  vulnerability on attack.vulnerability_id=vulnerability.id";  */
    	
        
    	String query= "SELECT  attack.id,attack.name as Attack,attack.description,costOfAttack,costOfDamage,\n" +
                      "asset.name as Asset\n" +
                      "FROM    attack    inner join  asset on attack.asset_id=asset.id";
                     
    	return DB.selectQuery(query);
    }
    
}


