package ee.ut.smarttool.DB;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImpactTest {

	ImpactDBService impactDBService;
	
	@Before
	public void setUp(){
		impactDBService=new ImpactDBService();
	}

	@Test
	public void testInsertImpact() throws Exception {
		int res=impactDBService.insertImpact("Loss of integrity","The messages has been changes","1","Loss of confidentiality");
		assertEquals(1, res);	
	}
	
	@Test
	public void testUpdateImpact() throws Exception {
		int res=impactDBService.updateImpact(1,"Loss of Confidentiality","The messages revealled","2","Loss of confidentiality");
		assertEquals(1, res);	
	}

}
