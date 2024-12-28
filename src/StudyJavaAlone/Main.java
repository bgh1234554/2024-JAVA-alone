package StudyJavaAlone;

import java.util.*;
import java.text.*;

import static java.lang.Math.random;

class Car{ //default 클래스는 다른 패키지에서는 사용할 수 없음. 그래서 분리하라고 메시지가 나오는 거임.
    public String company = "현대자동차";
    private String model = "IONIC";
    private String color = "NEON";
    private int maxspeed =200;
    //캡슐화 메뉴로 자동 생성 가능.
    Car() {}

    Car(String model, String color, int maxSpeed){
        this.setModel(model);
        this.setColor(color);
        this.setMaxspeed(maxSpeed);
    }
    String getCompany()
    {return this.company;}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }
}
//클래스에 정적 멤버 쓰면 클래스 이름으로 StudyJavaAlone.Car.xx 이런 식으로 접근하는게 좋음. (사실상 전역변수

class Person{
    void wake(){System.out.println("Woke up at 7");}
}

class Anonymous{
    Person field = new Person(){
        int age; //메서드 내에 선언 시, 메서드 내부에서만 사용 가능.
        void work(){System.out.println("I go to work");}
        @Override
        void wake() {
            System.out.println("Woke up at y");
            work();
        }
    }; //익명의 자식 개체. 상속 버전 람다함수.
}
//인터페이스 버전 람다함수
//인터페이스 이름 = new 인퍼페이스(){@override 추상메소드 구현};

public class Main {
    static final double PI = 3.14; //상수 선언
    static int sum(int...values){
        int sum=0;
        for (int i=0;i<values.length;i++){
            sum+=values[i];
        }
        return sum;
    }
//    static int[] numbers = {0,1,2,5,6,7,8,9};
//    public static int solution(int[] numbers) {
//        int[] sample = {0,1,2,3,4,5,6,7,8,9};
//        OptionalInt max = Arrays.stream(sample).max();
//        int answer = 0;
//        for(int i=0;i<10;i++){
//            if(Arrays.asList(sample)){
//                answer+=sample[i];
//            }
//        }
//        return answer;
//    }
    //매개변수의 개수를 모를 경우...
    //그냥 함수 선언할때도 main 클래스 안에 있어야함.
    public static void main(String[] args) {
//solution(numbers);
        System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);
        //int inputdata = Integer.parseInt(scanner.nextLine());
        //System.out.println(inputdata);
        //string을 다른 타입으로 변경할 때, Integer.pareInt(string) 이런식으로 적으면 됨.
        String[] names = null;
        names = new String[] {"baek","kim","hwang"};
        int len = names.length;
        String string = "adfbalsdfoqmwvoadsf";
        char c = string.charAt(2);
        int len2 = string.length();
        //배열의 길이는 length, 문자열의 길이는 .length()
        //string 비교할때는 .equals 메소드 사용
        //벙뮈 기반 for문
        for(String name : names){
            System.out.println(name);
        }
        WEEK today = WEEK.FRIDAY; //열거형
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        System.out.println(year);
        Car car = new Car();
        System.out.println(car.company);
        int s = sum(1,2,3,4,5);
        System.out.println(s);
        //싱글톤 - 단 하나의 객체만 만들도록 보장하는 것. 클래스 외부에서 new 연산자로 생성자를 호출할 수 없도록 해야함.
        //클래스 형 확인할때 instanceof 사용 가능.
        try{
            Class clazz = Class.forName("java.lang.String2");
            int b=0;
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("No Class Found");
            //당연히 C++처럼 catch 구문도 여러개임.
            //다중 catch문을 작성할때 상위 클래스가 하위 클래스보다 밑에 있어야 하위 클래스 예외가 작동함.
        } finally{
            System.out.println("Please try again");
        }

        //JAVA 버전 Strtok -> 몇개인지 모를때 유용하다.
        String student = "student\n22|100";
        StringTokenizer t = new StringTokenizer(student,"|\n");
        String part = t.nextToken().trim();
        System.out.println(part);
        part=t.nextToken().trim();
        System.out.println(part);
        part=t.nextToken().trim();
        System.out.println(part);
        student.indexOf("2");
        System.out.println("Method 2");

        //방법 2 구분자가 몇개인지 알 경우
        student = "student|22|100";
        String first = student.substring(0,student.indexOf("|"));
        System.out.println(first);
        student = student.substring(first.length()+1);
        System.out.println(student);
        first = student.substring(0,student.indexOf("|"));
        System.out.println(first);
        student = student.substring(first.length()+1);
        System.out.println(student);

        //방법 3 split 메서드 이용. 문자열의 배열을 반환한다는 것에 유의해야함.
        student = "student|22|100";
        String[] list = student.split("\\|");
        System.out.println(Arrays.toString(list));
        String str = "Apple,Amazone,Google,Microsoft";
        list = str.split(",");
        System.out.println(Arrays.toString(list));
        str="Apple/Amazone/Google/Microsoft";
        list = str.split("/");
        System.out.println(Arrays.toString(list));
        String ss = ""+123;

        int x = Integer.valueOf("123");
        //String.valueOf(10)이러면 integer가 문자열로 바뀜.
        String st = String.valueOf(123412);
        int val1 = Integer.parseInt("123");
        switch(ss){
            case "123":
                System.out.println("Hello!");
        }

        //throws 키워드를 사용한 메소드는 나중에 try-catch문으로 예외처리를 사용자쪽에서 해줘야함.

        int random1 = (int) (Math.random()*3+1);
        System.out.println(random1);
        int random2 = new Random().nextInt(2,6);
        int[] arrint = {1,2,3,4,5};
        System.out.println(random2);

        Class clazz = Car.class;
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getName());
        //clazz.getResource("상대경로").getPath(); 클래스가 있는 파일 기준으로 파일의 절대 경로를 알 수 있다.
    }
}