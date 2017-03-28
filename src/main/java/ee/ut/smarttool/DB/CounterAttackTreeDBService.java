/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.smarttool.DB;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salman
 */
public class CounterAttackTreeDBService  extends GeneralCRUDs{
    
     public int insertCountermeaureAttackTree(String attackParentId,String counterChildId) {
	String query="insert into  'counter-attackTree' (parent_id,child_id) values(?,?)";
	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(attackParentId,counterChildId));
         try {
            int res = DB.executeQuery(query);
            return res;
         } catch (Exception ex) {
             Logger.getLogger(CounterAttackTreeDBService.class.getName()).log(Level.SEVERE, null, ex);
             return -1;
         }
        
    }

    public int  updateCountermeaureAttackTree(String attackParentId,String counterChildId,String id) throws Exception{
    	String query="update 'counter-attackTree' set parent_id=?, child_id=? where id=?";
	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(attackParentId,counterChildId,id));
	return DB.executeQuery(query);
    }
}
