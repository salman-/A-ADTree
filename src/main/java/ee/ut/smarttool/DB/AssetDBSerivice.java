package ee.ut.smarttool.DB;


public class AssetDBSerivice extends GeneralCRUDs {
	
    public int  updateAsset(String name,String value,String times,String description, String id) throws Exception{
    	String query="update asset set name='?', value='?',times='?',description='?' where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(name, value,times,description,id));
		return DB.executeQuery(query);
    }

	public int insert(String name,String description, String value,String times) throws Exception {
		String query="insert into  asset (name,value,times,description) values('?','?',?,'?')";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(name, value,times,description));
		return DB.executeQuery(query);
		
	}
    

}
