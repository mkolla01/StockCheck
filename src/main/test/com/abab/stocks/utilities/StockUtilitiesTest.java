package com.abab.stocks.utilities;
import static org.junit.Assert.*;
import java.util.Properties;

import org.junit.Test;

public class StockUtilitiesTest {
	
	StockUtilities stockUtilities = new StockUtilities();
	@Test
	public void testReadProperties() {
		Properties prop = stockUtilities.readProperties("database");
		
		assertEquals("Invalid User", "cassandra", prop.get("db.user.name"));
	}
}
