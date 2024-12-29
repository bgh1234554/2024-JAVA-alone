package StudyJavaAlone;
import java.util.*;

class Calculator{
    private int memory;

    public int getMemory() {
        return memory;
    }
//synchronized = 동기화 메모리 키워드
    //객체의 메서드 하나가 모두 실행될때까지, 다른 스레드는 기다려야한다.
    //메모리에 값 설정후 출력.
    //synchronized를 메소드에 붙혀서 사용 할 경우, 메소드의 코드가 길어지면,
// 마지막에 대기하는 쓰레드가 너무 오래 기다리는것을 막기위해서 메소드에 synchronized를 붙이지 않고, 문제가 있을것 같은 부분만 synchronized블록을 사용한다.
    //synchroinzed(this){...}와 같은 구문을 사용할 수 있다.
    public void setMemory(int memory) {
        //임계영역 - 단 하나의 코드만 실행할 수 있는 영역.
        synchronized(this){
            this.memory = memory;
            long time = System.currentTimeMillis();
            System.out.println(time);
            try {
                Thread.sleep(1500);
            } catch (Exception e) {
            }
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }
}

class User1 extends Thread{
    private Calculator calc;
    public void SetCalculator(Calculator calc){
        this.setName("User1");
        this.calc=calc;
    }

    public Calculator getCalc() {
        return calc;
    }
    @Override
    public void run(){
        calc.setMemory(20+60);
    }
}

class User2 extends Thread{
    private Calculator calc;
    public void SetCalculator(Calculator calc){
        this.setName("User2");
        this.calc=calc;
    }

    public Calculator getCalc() {
        return calc;
    }
    @Override
    public void run(){
        calc.setMemory(20*60);
    }
}

public class SyncExam {
    //여러 쓰레드가 한 함수를 동시에 사용할 경우 메모리가 뒤죽박죽이 되어서 원하지 않는 결과를 얻을 수 있다.
    //메소드에 synchronized 키워드를 사용하면 한 스레드가 작업을 끝낸 뒤 다음 스레드가 메서드를 사용할 수 있다.
    public static void main(String[] args) {
        User1 user1 = new User1();
        User2 user2 = new User2();
        Calculator calc = new Calculator();
        user1.SetCalculator(calc);
        user2.SetCalculator(calc);
        user1.start();
        user2.start();
        //Synchronized를 안쓰면 동시에 실행되서 덮어씌워진다.
    }
}
