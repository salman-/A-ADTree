package ee.ut.smarttool.DB;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DBTest {

	Map<String, ArrayList<String>> res;
	String[] array={"id","name","value","times","description"};
	@Before
	public void setUp() {
		  res=new LinkedHashMap <String, ArrayList<String>>();
	}
	
	@Test
	public void testOpenConnection() {
		for (int i = 0; i <= array.length; i++){
		   System.out.println(" |*>"+array[i]);
    	   res.put(array[i], new ArrayList<String>());
    	}
	}

	@Test
	public void testExecuteQuery() {
		
		
		int columns = res.keySet().size();
		System.out.println("|| "+columns);
		for(int i=0;i<columns;i++)
			System.out.println("| "+res.keySet().toArray()[i]);
	}

	@Test
	public void testSelectQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintRows() {
		fail("Not yet implemented");
	}

	@Test
	public void testCloseConnection() {
		fail("Not yet implemented");
	}

}
