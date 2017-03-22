package ee.ut.smartadtool.service;

import java.util.ArrayList;
import java.util.Map;

public class DataPopulator {
	
	static int rows;
	static int columns;
	static Object[][] data;
	
	public static Object [][] DataPreprocessor(Map<String, ArrayList<String>> res){
		columnCounter(res);
		rowCounter(res);
		arrayInitiator();
		return populator(res);
	}
	
	public static int columnCounter(Map<String, ArrayList<String>> res){
		columns= res.keySet().size();
	//	for(int i=0;i<columns;i++)
		//	System.out.println("| "+res.keySet().toArray()[i]);
		return columns;
	}
	public static int rowCounter(Map<String, ArrayList<String>> res){
		rows=res.get( res.keySet().toArray()[0] ).toArray().length;
		return rows;
	}
	
	public static Object[][] arrayInitiator(){
		data=new Object[rows][columns];
		return data;
	}
	
	public static Object getCell(int column, int row,Map<String, ArrayList<String>> res){
		return res.get( res.keySet().toArray()[column] ).toArray()[row];
	}
	
	public static Object getRow(int column,Map<String, ArrayList<String>> res){
		return res.get( res.keySet().toArray()[column] ).toArray();
	}
	
	public static Object[][] populator(Map<String, ArrayList<String>> res){
	//	System.out.println("Row: "+rows+" Columns: "+columns);
		for(int i=0;i<columns;i++)
			for(int j=0;j<rows;j++){
				data[j][i]=getCell(i,j,res);
				System.out.println("Row: "+j+" Column: "+i+" Feature: "+res.keySet().toArray()[i] +" "+data[j][i]);
			}
		return data;
	}

	public static String[] getColumn(Map<String, ArrayList<String>> res) {
		String[] columnsName= new String[res.keySet().toArray().length];
		for(int i=0;i<res.keySet().toArray().length;i++)
			columnsName[i]=res.keySet().toArray()[i].toString();
		return columnsName;
	} 
	
}
