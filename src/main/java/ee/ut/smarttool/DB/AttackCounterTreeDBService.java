/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.smarttool.DB;

/**
 *
 * @author Salman
 */
public class AttackCounterTreeDBService extends GeneralCRUDs{
    

    public int insertAttackCountermeaureTree(String attackParentId,String counterChildId) throws Exception{
	String query="insert into  'attack-counterTree' (parent_id,child_id) values(?,?)";
	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(attackParentId,counterChildId));
	return DB.executeQuery(query);
    }

    public int  updateCountermeaureTree(String attackParentId,String counterChildId,String id) throws Exception{
    	String query="update 'attack-counterTree' set parent_id=?, child_id=? where id=?";
	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(attackParentId,counterChildId,id));
	return DB.executeQuery(query);
    }
}
