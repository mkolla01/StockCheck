package com.abab.stocks.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class StocksTest {
	Stocks stk = new Stocks();
	@Test
public void testSymbol(){
	stk.setSymbol("AAA");
	assertEquals("Vaule is not matching", "AAA", stk.getSymbol());
	
}
}
