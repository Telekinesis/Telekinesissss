package com.ibm.crl.simpledao.typecast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestAutoCasting {
	private static final Class<?>[] primitiveTypes = {
		byte.class, short.class, int.class, long.class, float.class, double.class
	};
	
	private static final Class<?>[] boxedTypes = {
		Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class
	};
	
	private static final Number[] sampleValue = {
		new Byte((byte) 1), new Short((short)1), new Integer(1), new Long(1L), new Float(1F), new Double(1D)
	};
	
	@Test
	public void testParameterCompatibilityByReflection(){
		testTypePair(primitiveTypes, primitiveTypes);
		testTypePair(primitiveTypes, boxedTypes);
		testTypePair(boxedTypes, primitiveTypes);
		testTypePair(boxedTypes, boxedTypes);
		Sample s = new Sample();
		s.setDoubleValue(1D);
	}
	
	private void testTypePair(Class<?>[] inputTypes, Class<?>[] parameterTypes){
		for (int inputIndex = 0; inputIndex < inputTypes.length; inputIndex++) {
			Class<?> inputType = inputTypes[inputIndex];
			for (Class<?> parameterType : parameterTypes){
				if(inputType == parameterType)
					continue;
				try {
					Sample s = new Sample();
					Method setMethod = Sample.class.getMethod("setValue", parameterType);
					Object input = sampleValue[inputIndex];
					try {
						setMethod.invoke(s, input);
						System.out.println(inputType + " to " + parameterType + " is ok");
					} catch (IllegalArgumentException e) {
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class Sample {
		@SuppressWarnings("unused") private byte byteValue;
		@SuppressWarnings("unused") private short shortValue;
		@SuppressWarnings("unused") private int intValue;
		@SuppressWarnings("unused") private long longValue;
		@SuppressWarnings("unused") private float floatValue;
		@SuppressWarnings("unused") private double doubleValue;

		public void setDoubleValue(Double value){
			
		}
		
		@SuppressWarnings("unused") 
		public void setValue(byte value){
			this.byteValue = value;
		}

		@SuppressWarnings("unused") 
		public void setValue(short shortValue) {
			this.shortValue = shortValue;
		}

		@SuppressWarnings("unused") 
		public void setValue(int intValue) {
			this.intValue = intValue;
		}

		@SuppressWarnings("unused") 
		public void setValue(long longValue) {
			this.longValue = longValue;
		}

		@SuppressWarnings("unused") 
		public void setValue(float floatValue) {
			this.floatValue = floatValue;
		}

		@SuppressWarnings("unused") 
		public void setValue(double doubleValue) {
			this.doubleValue = doubleValue;
		}

		@SuppressWarnings("unused") 
		public void setValue(Byte value){
			
		}

		@SuppressWarnings("unused") 
		public void setValue(Short value){
			
		}

		@SuppressWarnings("unused") 
		public void setValue(Integer value){
			
		}

		@SuppressWarnings("unused") 
		public void setValue(Long value){
			
		}

		@SuppressWarnings("unused") 
		public void setValue(Float value){
			
		}

		@SuppressWarnings("unused") 
		public void setValue(Double value){
			
		}
	}
}
