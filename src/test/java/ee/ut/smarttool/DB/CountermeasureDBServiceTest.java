package ee.ut.smarttool.DB;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountermeasureDBServiceTest {

	CountermeasureDBService counter;
	
	@Before
	public void setUp() {
		counter=new CountermeasureDBService();
	}
	
	@Test
	public void testUpdateCountermeasure() throws Exception {
		int res = counter.insertCountermeasure( "Countermeasure","It should stop the attack", "10000", "And", "0.94", 1, "12");
		assertEquals(1, res);
	}

	@Test
	public void testInsertAsset() throws Exception {
		int res = counter.updateCountermeasure(2, "Countermeasure","It should stop the attack", "10000", "And", "0.94", 1, "12");
		assertEquals(1, res);
		
	}

}
