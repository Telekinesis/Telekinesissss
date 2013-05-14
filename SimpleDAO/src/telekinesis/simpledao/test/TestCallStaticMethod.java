package telekinesis.simpledao.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestCallStaticMethod {
	public static void method(int par1, int par2){
		System.out.println(par1);
		System.out.println(par2);
	}
	
	@Test
	public void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method[] methods = TestCallStaticMethod.class.getMethods();
		for(Method m : methods){
			int modifiers = m.getModifiers();
			if(Modifier.isStatic(modifiers)){
				m.invoke(null, 1, 2);
			}
		}
	}
}
