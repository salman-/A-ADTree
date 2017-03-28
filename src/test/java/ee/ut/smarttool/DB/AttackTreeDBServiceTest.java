package ee.ut.smarttool.DB;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttackTreeDBServiceTest {

	AttackTreeDBService attackTreeDBService;
	
	@Before
	public void setUp(){
		attackTreeDBService=new AttackTreeDBService();
	}
	
	@Test
	public void testInsertAttackTree() throws Exception {
		int res=attackTreeDBService.insertAttackTree("10", "30");
		assertEquals(1, res);
	}

	@Test
	public void testUpdateAttackTree() throws Exception {
		int res=attackTreeDBService.updateAttackTree(2, 3,1);
		assertEquals(0, res);
	}
}
