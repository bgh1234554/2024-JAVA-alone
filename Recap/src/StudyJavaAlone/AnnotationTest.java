package StudyJavaAlone;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface AnnoTest{
}

class MyHello{
    @AnnoTest
    public void hello(){
        System.out.println("Hello");
    }
}
public class AnnotationTest {
    //Annotation - @기호를 이용하여 소스 코드에 추가적인 정보를 주는 것.
    public static void main(String[] args) {
        //Custom Annotation 예제
        MyHello hello = new MyHello();
        try {
            //클래스의 정보를 리턴해서 그 정보를 얻어 Hello라는 메서드에 대한 정보를 알아내라.
            Method method = hello.getClass().getDeclaredMethod("hello");
            //특정 Annotation이 적용되어있다면...
            if(method.isAnnotationPresent(AnnoTest.class)){
                for(int i=0;i<100;i++){
                    hello.hello();
                }
            }else{
                hello.hello();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
