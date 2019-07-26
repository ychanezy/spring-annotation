package com.atguigu.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {
   //invocationHandler���еı��������
    T target;
    
    public StuInvocationHandler(T target) {
       this.target = target;
    }
    
    /**
     * proxy:����̬�������
     * method����������ִ�еķ���
     * args���������Ŀ�귽��ʱ�����ʵ��
     * 
     * JDK ��̬����
		��̬����ĺ�����ʵ���Ǵ����������ɣ��� Proxy.newProxyInstance(classLoader, proxyInterface, handler)��
		
		�����ǽ���newProxyInstance������Ħ�£����Ĵ�����ʵ�����С�
		
		���������Ҫ����������
		
		ClassLoader�����ڼ��ش������ Loader �࣬ͨ����� Loader �ͱ����������ͬһ�� Loader �ࡣ
		Interfaces����Ҫ���������Щ��Щ�ӿڡ�
		InvocationHandler����������ִ�г��˱�����ӿ��з���֮����û��Զ���Ĳ�������Ҳ���û���Ҫ���������Ŀ�ġ��û�����Ŀ�귽���������� InvocationHandler ���ж����Ψһ���� invoke �С�
		
		//��ȡ������  
		Class cl = getProxyClass(loader, interfaces);  
		//��ȡ����InvocationHandler�����Ĺ��췽��  
		Constructor cons = cl.getConstructor(constructorParams);  
		//��handler���빹�췽������ʵ��  
		return (Object) cons.newInstance(new Object[] { h });
     * 
     * 
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("����ִ��" +method.getName() + "����");
       
        //��������в����ⷽ��,����÷�����ʱ
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}