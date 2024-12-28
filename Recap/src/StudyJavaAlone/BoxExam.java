package StudyJavaAlone;

public class BoxExam {
    public static void main(String[] args) {
//        Box box = new Box();
//        box.setObj(new Object());
//        Object obj = box.getObj();
//
//        box.setObj("Hello"); //당연히 가능함.
//        String str = (String)box.getObj();
//
//        box.setObj(1);
//        int i = (int)box.getObj();
        Box<String> box = new Box<>();
        box.setObj("String");
        String str = box.getObj();
        Box<Integer> box2 = new Box<>();
    }
}
