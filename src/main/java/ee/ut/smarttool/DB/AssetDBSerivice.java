package ee.ut.smarttool.DB;

import java.util.ArrayList;
import java.util.Map;


public class AssetDBSerivice extends GeneralCRUDs {
	
    public int  updateAsset(String name,String value,String times,String description, String id) throws Exception{
    	String query="update asset set name='?', value='?',times='?',description='?' where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(name, value,times,description,id));
		return DB.executeQuery(query);
    }

	public int insert(String name,String description, String value,String times,String vulnerabilityId) throws Exception {
		String query="insert into  asset (name,value,times,description,vulnerability_id) values('?','?',?,'?',?)";
                ArrayList<String> par = QueryMaker.createArgList(name, value,times,description,vulnerabilityId);
                query=QueryMaker.queryFitter(query,par );
		return DB.executeQuery(query);
		
	}

    public Map<String, ArrayList<String>> selectAllAssets() throws Exception {
       String query= "select  asset.id as id,asset.name as name, asset.description as description,vulnerability.name as vulnerabilityVame ,asset.value as value,asset.times as attackedCounter"
               + " from vulnerability join asset on vulnerability.id=asset.vulnerability_id";
   
        return DB.selectQuery(query);
    }
    

}
