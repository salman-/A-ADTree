package ee.ut.smarttool.DB;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;



public class QueryMaker {

	public static ArrayList<String> createArgList(String... args) {
	
		ArrayList<String> list=new ArrayList<String>();
	//	list.add(table);
		for (String arg : args) 
	        list.add(arg);
	    
	    return list;
	}
	
	public static String queryFitter(String query, ArrayList<String> args){
	
		 for(int i=0;i<args.size();i++){
		      query = query.replaceFirst("\\?",args.get(i));
		   } 
	    return query;	
	}
}
