package com.ibm.crl.simpledao.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

public class TestInvokeByReflection {
	private static final int count = 2500000;
	
	@Test
	public void test() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		final Sample s = new Sample();
		s.setValue(1);
		TestTimer.countTime(new TestTimer.TimedMethod() {
			@Override
			public void doSomething() throws Exception {
				int value = s.getValue();
				Assert.assertEquals(1, value);
			}
		}, count);
		
		TestTimer.countTime(new TestTimer.TimedMethod() {
			@Override
			public void doSomething() throws Exception {
				s.setValue(1);
				Assert.assertEquals(1, s.getValue());
			}
		}, count);
		
		final Method getMethod = s.getClass().getMethod("getValue");
		TestTimer.countTime(new TestTimer.TimedMethod() {
			@Override
			public void doSomething() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
				int value = (Integer)getMethod.invoke(s);
				Assert.assertEquals(1, value);
			}
		}, count);
		
		final Method setMethod = s.getClass().getMethod("setValue", int.class);
		TestTimer.countTime(new TestTimer.TimedMethod() {
			@Override
			public void doSomething() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
				setMethod.invoke(s, 2);
				Assert.assertEquals(2, s.getValue());
			}
		}, count);
		
		final Method setLong = s.getClass().getMethod("setLongValue", long.class);
		final Method setDouble = s.getClass().getMethod("setDoubleValue", double.class);
		int input = 1;
		Integer objectInput = 2;
		setLong.invoke(s, input);
		Assert.assertEquals(1, s.getLongValue());
		setLong.invoke(s, objectInput);
		Assert.assertEquals(2, s.getLongValue());
		setDouble.invoke(s, input);
		setDouble.invoke(s, objectInput);
	}
	
	private static class Sample{
		private int value;
		private long longValue;
		private double doubleValue;

		public long getLongValue() {
			return longValue;
		}

		@SuppressWarnings("unused")
		public void setLongValue(long longValue) {
			this.longValue = longValue;
		}

		@SuppressWarnings("unused")
		public double getDoubleValue() {
			return doubleValue;
		}

		@SuppressWarnings("unused")
		public void setDoubleValue(double doubleValue) {
			this.doubleValue = doubleValue;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Sample [value=" + value + "]";
		}
		
	}
}
