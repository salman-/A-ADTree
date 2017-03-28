package ee.ut.smarttool.DB;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CountermeaureTreeDBService extends GeneralCRUDs{

	public int insertCountermeaureTree(String parentId,String childId) {
		String query="insert into  countermeaureTree (parent_id,child_id) values(?,?)";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(parentId,childId));
            try {
                    int res = DB.executeQuery(query);
                    return res; 
            } catch (Exception ex) {
                Logger.getLogger(CountermeaureTreeDBService.class.getName()).log(Level.SEVERE, null, ex);
                return -1;
            }
	}

    public int  updateCountermeaureTree(int parentId,int childId,int id) throws Exception{
    	String query="update 'countermeaureTree' set parent_id=?, child_id=? where id=?";
		query=QueryMaker.queryFitter(query, QueryMaker.createArgList(Integer.toString(parentId),Integer.toString(childId),Integer.toString(id)));
		return DB.executeQuery(query);
    }
}
