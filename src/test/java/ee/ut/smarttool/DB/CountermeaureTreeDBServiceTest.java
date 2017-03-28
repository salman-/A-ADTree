package ee.ut.smarttool.DB;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountermeaureTreeDBServiceTest {
	
	CountermeaureTreeDBService countermeaureTreeDBService;
	@Before
	public void setUp(){
		countermeaureTreeDBService=new CountermeaureTreeDBService();
	}
	
	@Test
	public void testInsertAttackTree() throws Exception {
	/*	int res=countermeaureTreeDBService.insertCountermeaureTree(2, 3);
		assertEquals(1, res); */
	}

	@Test
	public void testUpdateAttackTree() throws Exception {
		int res=countermeaureTreeDBService.updateCountermeaureTree(6, 8,1);
		assertEquals(1, res);
	}
}
