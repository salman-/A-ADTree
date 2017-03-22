package ee.ut.smarttool.DB;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class GeneralCRUDsTest {
	
	GeneralCRUDs g;
	
	@Before
	public void setUp(){
		g=new GeneralCRUDs();
	}

	@Test
	public void testSelectAll() throws Exception {
		Map<String, ArrayList<String>> res = g.selectAll("vulnerability");
	//	assertEquals(3,res.size() );                                           //Number of columns
		assertEquals(1,res.get("name").size() );
	}

	@Test
	public void testSelect() throws Exception {
		Map<String, ArrayList<String>> res = g.select("vulnerability","2");
		//	assertEquals(3,res.size() );                                           //Number of columns
			assertEquals(1,res.get("name").size() );
	}

	@Test
	public void testDelete() throws Exception {
		assertEquals(0, g.delete("vulnerability","1"));   
	}

	@Test
	public void testDeleteAll() throws Exception {
		assertEquals(0, g.deleteAll("vulnerability"));   
	}

}
