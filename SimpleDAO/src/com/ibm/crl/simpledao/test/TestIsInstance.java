package com.ibm.crl.simpledao.test;

import junit.framework.Assert;

import org.junit.Test;

public class TestIsInstance {
	private static final int times = 2000000;
	
	@Test
	public void test(){
		final Class<?> type = Number.class;
		
		TestTimer.countTime(new TestTimer.TimedMethod() {
			@Override
			public void doSomething() {
				Assert.assertTrue(type.isInstance(new Integer(0)));
			}
		}, times);
		
		TestTimer.countTime(new TestTimer.TimedMethod() {
			@Override
			public void doSomething() {
				Assert.assertTrue((new Integer(0)) instanceof Number);
			}
		}, times);
	}
}
