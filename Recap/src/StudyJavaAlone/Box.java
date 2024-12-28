package StudyJavaAlone;

//기존 Object 클래스 방식
//형변환 하기 귀찮음.
//재너릭이 나옴.
public class Box<E> {
    private E obj;

    public E getObj() {
        return obj;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }
}
