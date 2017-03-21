package ee.ut.smarttool.DB;

public class ThreatAgent extends GeneralCRUDs{
	
	String motive;
	String capabilities;
	String opportunities;
	String means;
	
	public int insertThreatAgent(String motivation, String capabilities,String opportunities,String means) throws Exception{
		String query="insert into  threatAgent (motivation,capabilities,opportunities,means) values('?','?','?','?')";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(motivation, capabilities,opportunities,means));
		return DB.executeQuery(query);
	}
	
	public int updateThreatAgent(int id,String motive, String capabilities,String opportunities,String means) throws Exception{
    	String query="update threatAgent set motive='?', capabilities='?' ,opportunities='?',means='?' where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(motive,capabilities,opportunities,means,Integer.toString(id)));    
        return DB.executeQuery(query); 
    }

}
