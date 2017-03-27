package ee.ut.smarttool.DB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class AttackDBService extends GeneralCRUDs {
	    
    
    public int insertAttack(String name,String description,String probaility,
                            String costOfDamage,String costOfAttack,
                            String assetId,String impactId,String vulnerabilityId) throws Exception{

    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	Date today = Calendar.getInstance().getTime();      
    	String reportDate = df.format(today);
    	
	String query="insert into  attack ( name,description,date, probability,costOfDamage,costOfAttack, asset_id,impact_id,vulnerability_id) values('?','?','?','?','?','?','?','?','?')";
        query=QueryMaker.queryFitter(query, QueryMaker.createArgList( name,description,reportDate,probaility,costOfDamage,costOfAttack, assetId,impactId,vulnerabilityId));
		return DB.executeQuery(query);
    }
    
        public int insertAttack(String name,String description) throws Exception{

	String query="insert into  attack ( name,description) values('?','?')";
        query=QueryMaker.queryFitter(query, QueryMaker.createArgList( name,description));
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
    
    
    public Map<String, ArrayList<String>> selectAllAttack() throws Exception{

    	String query= "SELECT  attack.id,attack.name as Attack,attack.description,costOfAttack,costOfDamage,\n" +
                      "asset.name as Asset,impact.name as Impact,attack.probability,vulnerability .name as vulnerability \n" +
                      "FROM    attack    inner join  asset on attack.asset_id=asset.id\n" +
                      "inner join  impact on attack.impact_id=impact.id\n" +
                      "inner join  vulnerability on attack.vulnerability_id=vulnerability.id";
    	
    	return DB.selectQuery(query);
    }
    
    
    
    
}


