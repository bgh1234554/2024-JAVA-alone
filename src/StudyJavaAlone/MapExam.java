package StudyJavaAlone;

import java.util.*;
public class MapExam {
    public static void main(String[] args) {
        //Map - Python의 Dict 같은 것.
        //Map<Key,Value>
        Map<String, String> map = new HashMap<>();
        //Key와 value를 둘다 저장
        map.put("001","Kim");
        map.put("002","Lee");
        map.put("003","Choi");
        map.put("001","Kang"); //저장 안됨. 같은 Key의 값으로 올 수 없음.
        map.remove("002");
        //이러면 기존에 있던 값을 덮어씌운다.
        System.out.println(map.size());
        System.out.println(map.get("003")); //Key값으로 값을 알아낼 수 있다.
        //모든 Key 값을 꺼내기
        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()){
            String value = map.get(iter.next());
            System.out.println(iter.next());
        }
        //map은 저장된 정보를 Entry라는 객체에 담는다.
        Set<Map.Entry<String,String>> entryset = map.entrySet();
        Iterator<Map.Entry<String,String>> iterstr = entryset.iterator();
        while(iterstr.hasNext()){
            String key=iterstr.next().getKey();
            String value=iterstr.next().getValue();
        }
        //Map의 Key값을 객체로 할때, 객체의 멤버들의 값이 모두 같으면 같은 키로 간주하게
        //hashCode()와 equals() 메소드를 재정의할 수 있다.
        Map<Student,Integer> studentIntegerMap=new HashMap<Student,Integer>();

        //Hashtable은 Hashmap과 같은 구조지만 쓰레드에서 사용할때 Hashtable을 사용한다.
        //ArrayList와 Vector의 관계와 동일하다.
        map.containsKey("001");
        map.containsValue("Kim"); //이런식으로 contain을 사용할 수 있음.
    }
}
