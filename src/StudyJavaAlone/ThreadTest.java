package StudyJavaAlone;

import java.awt.*;

//다중상속이 금지된 자바이기 때문에 이미 상속받은 것이 있는 자식 클래스인 경우, Runnable을 implement해야함.
class BeepTask implements Runnable{
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0;i<5;i++){
            toolkit.beep(); //소리 내게 하는 클래스 구현
            try{Thread.sleep(500);} catch(Exception e){}
            //작동 중지할 때 Thread.sleep 사용
        }
    }
}
class WorkerThread extends Thread{
    @Override
    public void run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0;i<3;i++){
            toolkit.beep(); //소리 내게 하는 클래스 구현
            try{Thread.sleep(500);} catch(Exception e){}
            //작동 중지할 때 Thread.sleep 사용
        }
    }
}
class MyThread extends Thread{
    private String str;
    MyThread(String str){
        this.str=str;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(str);
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //Thread 클래스로 작업 스레드 객체 생성하기
        //Runnable 객체를 변수로 넘겨줘야하고, run()메소드를 구현해줘야함.
        //출력과 동시에 '삐'소리 나게 하기
        Runnable beepTask = new BeepTask();
        Thread thread = new Thread(beepTask);
        thread.start(); //start 하면 작업 스레드가 시작됨.
        for(int i=0;i<5;i++){
            System.out.println("BEEP"); //소리 내게 하는 클래스 구현
            try{Thread.sleep(750);} catch(Exception e){}
            //작동 중지할 때 Thread.sleep 사용
        }
        //이러면 동시에 두 코드가 실행된다.
        // Runnable 없이 Thread 클래스를 상속하는 방법으로도 구현이 가능하다.
        System.out.println("Round 2");
        try {
            Thread.sleep(1000); //sleep 구현할때 try-catch 구문 사용해야함.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WorkerThread wthread = new WorkerThread();
        wthread.setName("Thread No. 2");
        String wname = wthread.getName();
        wthread.start();
        for(int i=0;i<3;i++){
            System.out.println("BEEP"); //소리 내게 하는 클래스 구현
            try{Thread.sleep(250);} catch(Exception e){}
            //작동 중지할 때 Thread.sleep 사용
        }
        //당연히 익명 자식 클래스나, 익명 구현 객체로 매개변수를 넘겨줄 수도 있음.
        //new Thread(new Runnable(){@override....});
        //Thread thread = new Thread(){@override public void run(){...}};
        
        //현재 쓰레드 객체의 참조를 얻으려면
        Thread thread2 = Thread.currentThread(); //가능
        System.out.println(thread2.getName());
    }

}
