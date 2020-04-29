package proxy.dynamics.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		
		BaseService sleepService = new SleepService();
		
		InvocationHandler handler = new MethodSpendTimeHandler<>(sleepService);
		
		BaseService sleepProxy = (BaseService)Proxy.newProxyInstance(sleepService.getClass().getClassLoader(), 
				sleepService.getClass().getInterfaces(), handler);
		sleepProxy.handle(2000);
		System.out.println("返回值：" + sleepProxy.handleAndReturn(2000));
		
	}
}
