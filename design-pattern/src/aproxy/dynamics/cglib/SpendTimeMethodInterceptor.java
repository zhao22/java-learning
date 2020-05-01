package aproxy.dynamics.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class SpendTimeMethodInterceptor implements MethodInterceptor{

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println(method.getName() + "方法开始执行");
		Object result = proxy.invokeSuper(object, args);
		System.out.println(method.getName() + "方法执行完成,耗时" + ((System.currentTimeMillis() - start) / 1000) + "秒");
		return result;
	}

}
