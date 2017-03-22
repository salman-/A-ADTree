package ee.ut.smarttool.DB;


public class CountermeaureTreeDBService {

	public int insertCountermeaureTree(int parentId,int childId) throws Exception{
		String query="insert into  countermeaureTree (parent_id,child_id) values(?,?)";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(Integer.toString(parentId),Integer.toString(childId)));
		return DB.executeQuery(query);
	}

    public int  updateCountermeaureTree(int parentId,int childId,int id) throws Exception{
    	String query="update countermeaureTree set parent_id=?, child_id=? where id=?";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(Integer.toString(parentId),Integer.toString(childId),Integer.toString(id)));
		return DB.executeQuery(query);
    }
}
