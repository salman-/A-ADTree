package ee.ut.smarttool.DB;

import ee.ut.smarttool.DB.GeneralCRUDs;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ImpactDBService  extends GeneralCRUDs{

	public int insertImpact(String name, String description,String level,String type)  {
            try {
                String query="insert into  impact (name,description,type,level) values('?','?','?','?')";
                query=QueryMaker.queryFitter(query, QueryMaker.createArgList(name, description,type,level));
                int res = DB.executeQuery(query);
                JOptionPane.showMessageDialog(null, "The record inserted successfully", "Success",JOptionPane.INFORMATION_MESSAGE );
                return res;
            } catch (Exception ex) {
                Logger.getLogger(ImpactDBService.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Operation failed. Try again", "Failure",JOptionPane.ERROR_MESSAGE );
                return -1;
            }
		
	}

    public int  updateImpact(String id,String name, String description,String level,String type) throws Exception{
      //     System.out.println("Name "+name+" description: "+description+" level:"+level+" type:"+type);
     
    	String query="update impact set name='?', description='?',level='?',type='?' where id=?";
    	query=QueryMaker.queryFitter(query, QueryMaker.createArgList(name, description,level,type,id));
//	System.out.println("Query is:"+query);
	return DB.executeQuery(query);
    }


}
