package ee.ut.smarttool.DB;

public class ImpactDBService  extends GeneralCRUDs{


	
	public int insertImpact(String impact, String description,String level) throws Exception {
		String query="insert into  impact (impact,description,level) values('?','?','?')";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(impact, description,level));
		return DB.executeQuery(query);
		
	}

    public int  updateImpact(int id,String impact, String description,String level) throws Exception{
    	String query="update impact set impact='?', description='?',level=? where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(impact, description,level,Integer.toString(id)));
		return DB.executeQuery(query);
    }


}
