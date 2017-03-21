package ee.ut.smarttool.DB;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QueryMakerTest {


	
	@Test
	public void QueryFitterTest() {
		
		ArrayList<String> args=new ArrayList<String>(); 
		
		args.add("Bad code");
		args.add("The code is buggy");
		
		String res = QueryMaker.queryFitter("insert into  vulnerability (name,descirption) values(?,?)",args);
		String correctQuery="insert into  vulnerability (name,descirption) values(Bad code,The code is buggy)";
		assertEquals(correctQuery, res);
		
	}

}
