package world;


public class Example {
    public static void testDriver2(){
        C obj1= new C();
        D obj2= new D();
        obj1.start();
        obj2.start();
    }
    public static void testDriver1(){ //Implementing thread using Runnable interface
        A obj1= new A();
        B obj2= new B();
        Thread t1= new Thread(obj1);
        Thread t2= new Thread(obj2);
        t1.start();
        t2.start();
    }
}
class C extends Thread{
    public void run(){
        f1();
    }
    public void f1(){
        for(int i=1;i<=10;i++)
            System.out.println("i="+i);
    }
}
class D extends Thread{
    public void run(){
        f2();
    }
    public void f2(){
        for(int j=1;j<=10;j++)
            System.out.println("j="+j);
    }
}
class A implements Runnable{
    public void run(){
        f1();
    }
    public void f1(){
        for(int i=1;i<=10;i++)
            System.out.println("i="+i);
    }
}
class B implements Runnable{
    public void run(){
        f2();
    }
    public void f2(){
        for(int j=1;j<=10;j++)
            System.out.println("j="+j);
    }
}
