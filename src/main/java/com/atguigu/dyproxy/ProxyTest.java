package com.atguigu.dyproxy;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        
        //����һ��ʵ��������������Ǳ�����Ķ���
        Person zhangsan = new Student("����");
        
        //����һ�����������������InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);
        
        //����һ���������stuProxy������zhangsan����������ÿ��ִ�з��������滻ִ��Invocation�е�invoke����
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

       //����ִ���Ͻ���ѵķ���
        stuProxy.giveMoney();
        
        
//        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
//        String path = "G:/javacode/javase/Test/bin/proxy/StuProxy.class";
//        try(FileOutputStream fos = new FileOutputStream(path)) {
//            fos.write(classFile);
//            fos.flush();
//            System.out.println("������class�ļ�д��ɹ�");
//        } catch (Exception e) {
//           System.out.println("д�ļ�����");
//        }
    }
}