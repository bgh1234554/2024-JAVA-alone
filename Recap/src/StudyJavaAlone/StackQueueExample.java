package StudyJavaAlone;
import java.util.*;

public class StackQueueExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 3; i++) {
            stack.push(i);
        }
        stack.pop(); //맨위 원소 반환 후 제거
        stack.peek(); //맨위 원소 반환
        stack.add(2,12);
        stack.indexOf(2);

        //FIFO원리를 구현할때 이게 더 나음. Stack은 Vector을 상속받아서 구현한거라 add메소드도 되고 index 검색도 됨.
        //FIFO원칙에 안맞을뿐만 아니라, Thread Safe를 위해 만들어진 Vector을 사용한거라 속도도 느림.
        //List나 Set처럼 Deque는 인터페이스라서, new 하고나서 ArrayDeque 등등으로 써야한다.
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        adq.addFirst(32); //push .addLast
        adq.getFirst(); //peek .getLast
        //add는 예외를 발생시키고, offer은 false를 리턴한다.

        //adq.removeFirst();//pop .removeLast
        adq.removeFirstOccurrence(32); //특정값을 지정해서 제거할수 있음.
        //adq.removeLastOccurrence(32);
        //deque는 Stack이랑 Queue를 합친 형태임.
        //remove는 예외를 발생시키고, poll은 null을 반환한다.

        //기본적인 remove(), add()는 FIFO 구조임.
        //add하면 맨 뒤에 추가되고, remove()는 맨 앞에것이 사라짐.
        //getFirst = peekFirst = peek
        //getLast=  peekLast
        //특정 내용 존재 여부 contain, 크기 size
        //iterator도 존재함.
        Iterator<Integer> iter = adq.iterator(); //앞에서 뒤로
        Iterator<Integer> iter2=adq.descendingIterator(); //거꾸로 순회

        //Queue는 LinkedList로 구현됨. //offer, peek, poll로 사용함.
        Queue<String> q = new LinkedList<>();
        q.offer("Kang");
        String s = q.peek();
        q.poll();
    }
}
