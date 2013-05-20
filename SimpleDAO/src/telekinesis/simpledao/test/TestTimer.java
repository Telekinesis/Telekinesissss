package telekinesis.simpledao.test;

public class TestTimer {
	private TestTimer(){}
	
	public static interface TimedMethod {
		public void doSomething() throws Exception;
	}
	
	public static void countTime(TimedMethod method, int times) {
		long time = System.currentTimeMillis();
		try{
			for(int i = 0; i < times; i++)
				method.doSomething();
		}catch(Exception e){
			throw new RuntimeException();
		}
		long elapsed = System.currentTimeMillis() - time;
		System.out.println(elapsed);
	}
}
