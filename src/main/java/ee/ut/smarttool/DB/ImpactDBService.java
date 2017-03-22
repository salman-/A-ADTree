package ee.ut.smarttool.DB;

import ee.ut.smarttool.DB.GeneralCRUDs;



public class ImpactDBService  extends GeneralCRUDs{


	
	public int insertImpact(String impact, String description,String level,String type) throws Exception {
		String query="insert into  impact (impact,description,level,type) values('?','?','?','?')";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(impact, description,level,type));
		return DB.executeQuery(query);
		
	}

    public int  updateImpact(String id,String impact, String description,String level,String type) throws Exception{
    	String query="update impact set impact='?', description='?',level=?,type='?' where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(impact, description,level,type,id));
		return DB.executeQuery(query);
    }


}
