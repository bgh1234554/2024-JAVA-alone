package StudyJavaAlone;

import java.util.*;
class Member{
    public String name;
    public int age;
    public Member(String name, int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Member member)) return false;
        return age == member.age && Objects.equals(name, member.name);
        //이름과 나이가 같으면 동일한 사람으로 간주하게 바꾸기.
    }

    @Override
    public int hashCode() {
        return name.hashCode()+age; //String의 hashcode 이용. 같은 내용의 문자열이면 동일하니까.
    }
}
public class SetExam {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("Kang");
        set1.add("Kim");
        set1.add("Kang");
        set1.size();

        Iterator<String> iter = set1.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        //HashSet은 동일한 객체는 중복저장하지 않는데, 같은 객체인지 판단할때 HashCode()를 사용함.
        Set<Member> setm = new HashSet<>();
        setm.add(new Member("baek",25));
        setm.add(new Member("baek",25));
        System.out.println(setm.size());
        System.out.println("---");
        setm.contains(new Member("baek",25));
        List<Integer> arint = new ArrayList<>();
        //ArrayList<Integer>
        arint.add(32);
        System.out.println(arint.get(0)); //찾아내는 것.
        System.out.println(arint.indexOf(32)); //0
        arint.remove(Integer.valueOf(32)); //ArrayList가 Integer일때, 값을 지정해서 빼고 싶을땐 valueOf 사용.
        System.out.println(arint.size()); //그냥 remove(3)이런식으로 하면 3번째 index가 없어짐
    }
}
