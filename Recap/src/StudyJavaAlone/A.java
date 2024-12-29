package StudyJavaAlone;

public class A{
    public int value;
    class B{
        B(){}
        int field1;
        void method1(){
            A.this.value=10;
        }
    }
    void MethodA(){
        B b = new B();
        b.field1=3;
        b.method1(); //이런 식으로 사용 가능.
    }
    static interface InterfaceA{
        void OnMethod();
    }
    //B가 정적 클래스면 A 선언할 필요 없이 바로 쓸 수 있음.
    //메소드 내에 클래스를 선언하면 로컬 클래스 -> 메소드 내부에서만 사용할 수 있다.
    //정적 클래스 안에서는 바깥 클래스의 정적 필드와 메소드에만 접근할 수 있고 인스턴스 필드와 메소드에는 접근할 수 없음.
}
//클래스 내부에 있는 특정 메서드를 구현해야만 실행되고 싶게 하고 싶다. -> 클래스 안에 중첩 인터페이스를 만들 수 있다.

class Clicklistener implements A.InterfaceA{
    @Override
    public void OnMethod() {
        System.out.println("Yay");
    }
}