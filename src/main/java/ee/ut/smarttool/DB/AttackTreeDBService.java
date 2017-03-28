package ee.ut.smarttool.DB;

public class AttackTreeDBService extends GeneralCRUDs {
	
	public int insertAttackTree(String parentId,String childId) throws Exception{
		String query="insert into  attackTree (parent_id,child_id) values(?,?)";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(parentId,childId));
		return DB.executeQuery(query);
	}

    public int  updateAttackTree(int parentId,int childId,int id) throws Exception{
    	String query="update attackTree set parent_id=?, child_id=? where id=?";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(Integer.toString(parentId),Integer.toString(childId),Integer.toString(id)));
		return DB.executeQuery(query);
    }

}
