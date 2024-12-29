package StudyJavaAlone;

import java.io.*;
import java.util.*;

class Book implements Serializable{
    private String title;
    int price;
    private String writer;

    public Book(String title, int price, String writer) {
        this.title = title;
        this.price = price;
        this.writer = writer;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
}

public class StreamEx2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //보조 스트림 - 일반 스트림에 연결되는 플러그인 같은 것. 다양한 기능을 제공해준다.
        //Decorator Pattern - 객체의 추가적인 요건을 동적으로 첨가하는 방식.
        //서브 클래스를 만드는 것을 통해 기능을 유연하게 할 수 있음.
        InputStream is = System.in; //기본 스트림 //키보드로 입력 받음.
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr); //이런 식으로 연결 가능.
        String ln = null;
        try{
            ln = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ln);
        //-> 자세한건 ConsoleExam.java 참조.

        //1. 문자 변환 보조 스트림
        //바이트로 된 내용을 텍스트로 바꿔준다.
        //OutputStreamWriter - OutputStream에서 Writer로 변환시켜줌.
        FileOutputStream fos = new FileOutputStream("fosfistest.txt");
        Writer writer = new OutputStreamWriter(fos);

        writer.write("Char Convert Stream");
        writer.flush();
        writer.close();

        //InputStreamReader - InputStream을 Reader로 바꿔줌.
        FileInputStream fis = new FileInputStream("fosfistest.txt");
        Reader reader = new InputStreamReader(fis);

        char[] buffer = new char[100];
        int readCharNum = reader.read(buffer);
        reader.close();
        String data = new String(buffer,0,readCharNum); //0부터 읽은 바이트 수 만큼 문자열로 전환
        System.out.println(data);

        //2. 성능 향상 보조 스트림
        //프로그램의 실행 성능은 입출력이 가장 늦은 장치를 따라가는데, 이때문에 CPU와 메모리가 아무리 좋아도
        //하드의 입출력이 늦어서 프로그램이 늦어질 수가 있음.
        //이를 해결하기 위해 Buffer를 사용함. 버퍼에 데이터를 보냈다가 일정량 이상이 차면 한번에 하드디스크에 입출력을 한다.
        //Buffered+기본스트림의 이름을 가지고 있음.

        //BufferedOutputStream, BufferedWriter - 프로그램에서 쓴 내용을 Buffer에 저장 후 파일에 보냄.
        //BufferedInputStream, BufferedReader - 파일에서 읽은 내용을 Buffer에 저장 후 출력.
        //예제 - BufferedStream을 이용한 txt파일 복사하기.
        FileReader fis1 = new FileReader("copytest.txt");
        FileWriter fos1 = new FileWriter("copytest2.txt");
        BufferedReader br1 = new BufferedReader(fis1);
        BufferedWriter bw1 = new BufferedWriter(fos1);
        long start = System.nanoTime();
        while(true){
            int dt = br1.read();
            if(dt==-1)break;
            bw1.write(dt);
        }
        bw1.flush(); //버퍼에 남은 거 flush
        //Writer랑 OutputStream은 flush 메서드 호출해줘야함.
        long end = System.nanoTime();
        br1.close();
        bw1.close();
        System.out.println(end-start);
        //BufferedReader 클래스의 메서드인 ReadLine 메서드로 한줄씩 읽을 수 있다.
        //ReadLine 메서드는 String을 반환한다. 없으면 null을 반환한다.
        FileReader fr = new FileReader("copytest2.txt");
        BufferedReader br2 = new BufferedReader(fr);
        while(true){
            String line = br2.readLine();
            if(line==null) break;
            System.out.println(line);
        }
        br2.close();

        //3. 기본 타입 입출력 보조 스트림
        //DataInputStream, DataOutputStream을 통해서 byte타입 파일에 기본 타입들을 입출력할 수 있다.
        //입출력시 read타입 write타입 이렇게 하면 됨. String만 readUTF, writeUTF로 예외.
        FileOutputStream foss = new FileOutputStream("doftest.db");
        DataOutputStream dos = new DataOutputStream(foss);
        dos.writeUTF("baek");
        dos.writeInt(25);
        dos.writeDouble(95.7);

        FileInputStream fiss = new FileInputStream("doftest.db");
        DataInputStream dis = new DataInputStream(fiss);
        //다시 읽어올 때는 쓴 순서대로 다시 읽어와야한다.
        String name = dis.readUTF();
        int age = dis.readInt();
        double grade = dis.readDouble();
        System.out.println(name+"-"+age+"-"+grade);

        //try-with-resources - close 안해도 알아서 닫음.
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));){
            out.writeInt(1000); out.writeUTF("try-with-resources test"); out.writeDouble(3.145192);
        }
        try(DataInputStream in = new DataInputStream(new FileInputStream("data.txt"))){
            System.out.println(in.readInt());
            System.out.println(in.readUTF());
            System.out.println(in.readDouble());
        }

        //4. 프린트 보조 스트림 - PrintStream, PrintWriter
        //print(), println() 메서드를 가지고 있는 게 이 객체임. System.out도 여기 소속임.
        //마치 우리가 print하는 것처럼 파일에 출력을 할 수 있어서 좋음.
        FileOutputStream fos3 = new FileOutputStream("PrintWriterTest.txt");
        PrintStream ps = new PrintStream(fos3);
        PrintWriter pw = new PrintWriter(fos3);
        ps.println("PrintTest");
        pw.println("PrintTest Again");
        ps.flush();
        pw.flush();
        ps.close();
        pw.close();
        //둘다 된다.

        //5. 객체 입출력 보조 스트림 - ObjectOutputStream, ObjectInputStream
        //객체를 입출력할 수 있게 도와주는 보조 스트림.
        //OOS는 객체를 직렬화 시키고, OIS는 직렬회된 객체를 다시 역직렬화시킨다.
        //직렬화 - 객체를 바이트 형식으로 만드는 것.
        //모든 객체한테 해당되는 것은 아니고, 그 객체가 Serializable이라는 Interface를 구현하고 있어야 한다.
        //Book 객체 참조.
        //그리고 OIS를 통해 파일에서 불러온 객체는 다시 형변환을 통해 객체로 바꿔줘야 한다.
        //또한 ArrayList나 Vector를 파일에 저장하고 네트워크로 보낼 때에,
        //거기에 담겨있는 객체도 Serializable Interface를 구현하고 있어야 한다.
        //예제 - Book 객체를 db파일에 입력하고 출력하는 메서드.
        List<Book> lb = new ArrayList<>(); //ArrayList에 담아서 한번에 입출력하기.
        lb.add(new Book("메밀꽃 필 무렵",15000,"이효석"));
        lb.add(new Book("자전거도둑",10000,"박완서"));
        lb.add(new Book("혼공자",28000,"신용석"));
        FileOutputStream foso = new FileOutputStream("ObjectTest.db");
        ObjectOutputStream oos = new ObjectOutputStream(foso);
        oos.writeObject(lb); //Object 말고 다른 것도 다 됨. DataOutputStream처럼.
        oos.flush();
        oos.close();
        FileInputStream fiso = new FileInputStream("ObjectTest.db");
        ObjectInputStream ois = new ObjectInputStream(fiso);
        List<Book> books = (List<Book>) ois.readObject(); //직접 형변환을 해줘야한다. Object 클래스를 반환해서.
        for(Book book : books){
            System.out.println("Title - "+book.getTitle()+" Price - "+book.getPrice()+" Writer - "+book.getWriter());
        }
    }
}
