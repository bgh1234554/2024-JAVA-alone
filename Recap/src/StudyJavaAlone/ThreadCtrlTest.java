package StudyJavaAlone;

class StopTest extends Thread{
    private boolean stop = false;

    public void setStop(boolean stop) {
        this.stop = stop;
    }
    @Override
    public void run(){
        while(!stop){
            System.out.println("Running");
//            try {
//                this.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } 없어도 됨. 보기 편하라고 넣어 놓은 것.
        }
        //thread가 사용한 자원 정리
        System.out.println("Collecting Resources");
        System.out.println("End Thread");
    }
}

class StopTest2 extends Thread{
    @Override
    public void run(){
        try{
            System.out.println("Running");
            this.sleep(1); //sleep이 있어야됨
        }catch(InterruptedException e){}
        //thread가 사용한 자원 정리
        System.out.println("Collecting Resources");
        System.out.println("End Thread");
    }
}

class StopTest3 extends Thread{
    @Override
    public void run(){
        while(true){
            System.out.println("Running");
            if(this.isInterrupted()) break;
        }
        System.out.println("Collecting Resources");
        System.out.println("End Thread");
    }
}

class JoinTest extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("JoinTest is Running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class WaitTest extends Thread{
    int total;
    @Override
    //Wait와 Notify는 동기화된 블록 안에서 사용해야 한다.
    public void run(){
        synchronized (this){
            for(int i=0;i<5;i++){
                System.out.println("Adding "+(i+1));
                total+=i+1;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notify(); //Synchronized 블럭 안에 있어야함.
        }
        //쓰레드를 깨운다.
        //notifyAll();
    }
}

public class ThreadCtrlTest {
    public static void main(String[] args) {
        //start()한다고 바로 시작하는게 아니라 시작 대기 상태임.
        //OS가 선택해서 실행시키는 것.
        //Runnable 상태와 Running 상태가 된다고 말함.
        //일시정지가 되면, 다시 실행 대기 상태가 되었다가 실행됨.
        //sleep 상태에서 주어진 시간이 되기 전에 interrupted 메소드가 호출되면 sleep의 catch 구문으로 들어가서 처리를 하고 종료된다.
        //wait() 메서드 - 다른 스레드에서 notify() 메서드를 호출하지 않는 이상은 계속 sleep 상태와 동일한 Blocked 상태 유지.
        //yield (다른 메서드에 자원을 양보)
        //스레드 종료 방법
        //1. stop 플래그 사용. - run 메소드 안에 stop이란 boolean 멤버를 만들어서 사용할 수 있음.
        StopTest stopTest = new StopTest();
        stopTest.setName("stopTest");
        stopTest.start(); //스레드 시작
        System.out.println("Main started "+stopTest.getName());
        try {
            stopTest.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopTest.setStop(true);
        //2. interrupt 메소드 사용 - 호출 시 InterruptedException을 발생시킴.
        //Thread A가 Thread B의 interrupt()를 호출 시킬 경우, B가 sleep 상태일때 예외가 발생되어 catch 구문으로 이동한다.
        //일시 정지 상태가 되지 않으면 interrupt()의 의미가 없기 때문에 짧게라도 sleep 상태가 존재해야 한다.
        StopTest2 stopTest2 = new StopTest2();
        stopTest2.setName("stopTest2");
        stopTest2.start();
        System.out.println("Main started "+stopTest2.getName());
        stopTest2.interrupt(); //훨씬 빠르게 stop된다.
        //3. .isInterrupted()메서드 사용. interrupt()가 호출되었는지 알려주는 boolean 메소드.
        StopTest3 stopTest3 = new StopTest3();
        stopTest3.setName("stopTest3");
        stopTest3.start();
        System.out.println("Main started "+stopTest3.getName());
        stopTest3.interrupt();
        //2, 3 두 개가 좋은 듯 하다.

        //join 메서드 - try-catch 구문 안에서 실행되어야함.
        JoinTest jt = new JoinTest();
        jt.start();

        System.out.println("Main Start!");
        try {
            jt.join(); //JoinTest Thread가 종료될때까지 기다렸다가 Main End가 출력된다.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main End!");

        //
        WaitTest wt = new WaitTest();
        wt.start();
        synchronized (wt){
            try{
                System.out.println("Waiting until Thread wt finishes");
                wt.wait(); //wt가 Main쓰레드에게 wait을 보낸거라 Main 쓰레드가 정지됨.
                //해당 쓰레드가 notify를 호출해야함.
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(wt.total);
        }
    }
}
