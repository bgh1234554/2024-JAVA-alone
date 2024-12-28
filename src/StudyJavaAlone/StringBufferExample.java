package StudyJavaAlone;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append(123);
        sb.append(" hello");
        String str = sb.toString();
        System.out.println(str);

        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = sb2.append("Hello");
        //이러면 sb2==sb3가 참임. append가 this라는 주소를 반환하기 때문.
        sb2.indexOf("H");
        sb2.charAt(3);
        sb2.length();
        sb2.delete(2,4);
        sb2.lastIndexOf("l");
        sb2.insert(3,"x");
        //메소드 체이닝
        String strr = new StringBuffer().append("Hello").append(" World").toString();

        //String 클래스의 문제점
        String str1 = "Hello World";
        String str2 = str1.substring(5);
        System.out.println(str1);
        System.out.println(str2);

        String str3 = str1+str2;
        System.out.println(str3);
        //내부적으로 JAVA에서는 String에 대한 연산자를 호출 시 StringBuffer 클래스를 이용하기 때문에
        //성능이 하락하는 문제가 있다.
        String str4 = new StringBuffer().append(str1).append(str2).toString();
        System.out.println(str4);
        long timeprev = System.nanoTime();
        StringBuffer sb4 = new StringBuffer();
        for(int i=0;i<1000;i++){
            sb4.append("*");
        }
        System.out.println(sb4);
        long timenow = System.nanoTime();
        System.out.println(timenow-timeprev);
        timeprev = System.nanoTime();
        str4="";
        for(int i=0;i<1000;i++){
            str4+="*";
        }
        System.out.println(str4);
        timenow = System.nanoTime();
        System.out.println(timenow-timeprev);
    }
}
