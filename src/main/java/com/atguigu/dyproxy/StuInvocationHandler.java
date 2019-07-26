package com.atguigu.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {
   //invocationHandler持有的被代理对象
    T target;
    
    public StuInvocationHandler(T target) {
       this.target = target;
    }
    
    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     * 
     * JDK 动态代理
		动态代理的核心其实就是代理对象的生成，即 Proxy.newProxyInstance(classLoader, proxyInterface, handler)。
		
		让我们进入newProxyInstance方法观摩下，核心代码其实就三行。
		
		这个方法需要三个参数：
		
		ClassLoader，用于加载代理类的 Loader 类，通常这个 Loader 和被代理的类是同一个 Loader 类。
		Interfaces，是要被代理的那些那些接口。
		InvocationHandler，就是用于执行除了被代理接口中方法之外的用户自定义的操作，他也是用户需要代理的最终目的。用户调用目标方法都被代理到 InvocationHandler 类中定义的唯一方法 invoke 中。
		
		//获取代理类  
		Class cl = getProxyClass(loader, interfaces);  
		//获取带有InvocationHandler参数的构造方法  
		Constructor cons = cl.getConstructor(constructorParams);  
		//把handler传入构造方法生成实例  
		return (Object) cons.newInstance(new Object[] { h });
     * 
     * 
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" +method.getName() + "方法");
       
        //代理过程中插入监测方法,计算该方法耗时
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}