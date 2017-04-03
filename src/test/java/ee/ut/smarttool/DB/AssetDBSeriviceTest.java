package ee.ut.smarttool.DB;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AssetDBSeriviceTest {

	
	AssetDBSerivice assetDBSerivice;
	
	@Before
	public void init() throws Exception{
		assetDBSerivice=new AssetDBSerivice();
	}
	
	@Test
	public void testInsertAsset() throws Exception {
		//assertEquals(1, assetDBSerivice.insert("Router1","it is expensive" ,"10000", "6"));
	}

	@Test
	public void testUpdateAsset() throws Exception {
		assertEquals(1, assetDBSerivice.updateAsset("Special Router***","it is expensive" ,"10000", "6", "11"));
	}

}
