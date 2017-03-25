package ee.ut.smarttool.DB;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttackDBServiceTest {

	AttackDBService attack;
	
	@Before
	public void setUp(){
		attack=new AttackDBService();
	}
	
	@Test
	public void testInsertAttack() throws Exception {
	//	int res=attack.insertAttack("DDOS", "So many connection", 3, 3, "3", "3", "0.6", 2, "Or", "10000", "5000", 1);
	//	assertEquals(1, res);
	}

	@Test
	public void testUpdateAttack() throws Exception {
		int res=attack.updateAttack(1,"SQL Injection", "Injecting sql", 3, 3, "3", "3", "0.6", 2, "Or", "10000", "5000", 1);
		assertEquals(1, res);
	}

}
