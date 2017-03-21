package ee.ut.smartadtool.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ee.ut.smarttool.DB.AssetDBSerivice;

public class DataPopulatorTest {

	AssetDBSerivice asset;
	Map<String, ArrayList<String>> res;
	
	@Before
	public void setUp() throws Exception {
		 asset=new AssetDBSerivice();
		 res=asset.selectAll("asset");
	}

	@Test
	public void testDataPopulator() throws Exception {
		 res = asset.selectAll("asset");
		
	}
	
	@Test
	public void testColumnCounter() throws Exception {
		
		assertEquals(5, DataPopulator.columnCounter(res));
	}
	
	@Test
	public void testGetCell() throws Exception {
		
		assertEquals("asset1", DataPopulator.getCell( 1,0,res  ));
	}
	
	@Test
	public void testRowCounter() throws Exception {
		
		assertEquals(1, DataPopulator.rowCounter(res));	
	}
	
	@Test
	public void testPrintRow() throws Exception {
		DataPopulator.DataPreprocessor(res);
	//	DataPopulator.printRow(DataPopulator.DataPreprocessor(res),0,5);
	//	assertEquals(1, DataPopulator.rowCounter(res));	
	}

}
