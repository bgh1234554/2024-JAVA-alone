package StudyJavaAlone;

interface Compare{
    public int compareTo(int val1, int val2);
}

class CopmareExam implements Compare{

    @Override
    public int compareTo(int val1, int val2) {
        return 0;
    }
}
public class LambdaExample {
    static void exec(Compare compare){
        int k=10;
        int l=20;
        int val = compare.compareTo(k,l);
        System.out.println(val);
    }
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println("Lambda Test");
            }
        });
        thread.start();
        //람다식 -> 익명 메서드. 람다식을 Runnable로 자동으로 만들어서 인식함.
        //문법: (매개변수 목록)->{실행문}

        exec((i,j)->{return i-j;});
        //안의 함수를 보고, JVM은 람다식을 Compare의 CompareTo를 구현하는 익명 인터페이스로 간주함.
    }
}
