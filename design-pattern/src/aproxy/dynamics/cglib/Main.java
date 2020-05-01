package aproxy.dynamics.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Main {

	public static void main(String[] args) {
//		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\repository\\java-learning");
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(SleepService.class);
        enhancer.setCallback(new SpendTimeMethodInterceptor());
        
        //这里的create方法就是正式创建代理类
        SleepService proxy = (SleepService)enhancer.create();
        //调用代理类的eat方法
        proxy.handle(2000);       
        System.out.println("返回值：" + proxy.handleAndReturn(2000));
	}
}
