package com.atguigu.proxy;
/**
 * ѧ�������࣬Ҳʵ����Person�ӿڣ�����һ��ѧ��ʵ�壬�����ȿ��Դ���ѧ��������Ϊ
 * @author Gonjan
 *
 */
public class StudentsProxy implements Person{
    //�������ѧ��
    Student stu;
    
    public StudentsProxy(Person stu) {
        // ֻ����ѧ������
        if(stu.getClass() == Student.class) {
            this.stu = (Student)stu;
        }
    }
    
    //�����Ͻ���ѣ����ñ�����ѧ�����Ͻ������Ϊ
    public void giveMoney() {
        stu.giveMoney();
    }
}