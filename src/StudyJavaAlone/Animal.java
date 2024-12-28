package StudyJavaAlone;

public abstract class Animal {
    public String kind;
    public void breathe(){
        System.out.println("Breathe");
    }
    public abstract void sound(); //추상 메소드
}

//인터페이스 - 생성자 x, 다중상속 가능, 핃드로는 상수만 가질 수 있음.