package ee.ut.smarttool.DB;

import ee.ut.smarttool.DB.GeneralCRUDs;



public class ImpactDBService  extends GeneralCRUDs{


	
	public int insertImpact(String impact, String description,String level,String type) throws Exception {
		String query="insert into  impact (name,description,level,type) values('?','?','?','?')";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(impact, description,level,type));
		return DB.executeQuery(query);
		
	}

    public int  updateImpact(String id,String name, String description,String level,String type) throws Exception{
      //     System.out.println("Name "+name+" description: "+description+" level:"+level+" type:"+type);
     
    	String query="update impact set name='?', description='?',level='?',type='?' where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(name, description,level,type,id));
//	System.out.println("Query is:"+query);
	return DB.executeQuery(query);
    }


}
