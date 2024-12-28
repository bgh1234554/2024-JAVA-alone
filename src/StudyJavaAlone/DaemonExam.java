package StudyJavaAlone;

class AutoSaveThread extends Thread{
    public void save(){
        System.out.println("Saved File");
    }

    @Override
    public void run() {
        while(true){
            try {
                this.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            save();
        }
    }
}
public class DaemonExam {
    //데몬 - 백그라운드로 처리하는 프로세스
    //데몬 스레드 - 보조 스레드이며 주 스레드가 종료될 때 같이 종료됨.
    //워드프로세서의 자동 저장, 동영상/음악 재생, JVM의 junk collector에 주로 사용됨.
    //예제 - 1초 간격으로 저장하는 쓰레드 실행 후, 3초 후에 메인 스레드가 종료되면 그때 같이 종료되는 예제.
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true); //daemon thread로 설정.
        autoSaveThread.start();
        System.out.println("AutoSaveThread has started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread has ended.");
    }
}
