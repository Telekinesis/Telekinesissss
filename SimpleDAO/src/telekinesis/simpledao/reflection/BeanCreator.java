package telekinesis.simpledao.reflection;


public class BeanCreator {
	private BeanCreator(){}
	
	public static <T> T createBean(Class<T> targetType){
		T emptyBean;
		try {
			emptyBean = targetType.newInstance();
		} catch (IllegalAccessException e) {
			throw new BeanCreationException(e);
		} catch (InstantiationException e) {
			throw new BeanCreationException(e);
		}
		return emptyBean;
	}
}
