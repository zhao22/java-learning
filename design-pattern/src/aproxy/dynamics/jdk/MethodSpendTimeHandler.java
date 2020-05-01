package aproxy.dynamics.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodSpendTimeHandler<T> implements InvocationHandler{

	private T countObject;
	
	public MethodSpendTimeHandler(T countObject) {
		this.countObject = countObject;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println(method.getName() + "方法开始执行");
		Object result = method.invoke(countObject, args);
		System.out.println(method.getName() + "方法执行完成,耗时" + ((System.currentTimeMillis() - start) / 1000) + "秒");
		return result;
	}

}
