package StudyJavaAlone;

import java.io.*;
import java.util.*;

public class StreamEx {
    public static void main(String[] args) throws Exception {
        //바이트 기반 스트림 - InputStream, OutputStream
        //문자 기반 스트림 - Reader, Writer
        //OutputStream - FileOutputStream, PrintStream, BufferedOutputStream, DataOutputStream
        //파일로 출력함.
        OutputStream os = new FileOutputStream("test.db");
        byte[] array = {10,20,30,40,50};
        os.write(array,2,3); //범위도 지정 가능함. off번째 index부터 len개.
        os.flush(); //버퍼에 잔류하는 모든 바이트 출력
        os.close(); //파일 닫기

        //파일로 입력받는 InputStream
        //FileInputStream, BufferedInputStream, DataInputStream
        InputStream is = new FileInputStream("test.db");
        OutputStream os2 = new FileOutputStream("testCopy.db");
        byte[] buffer = new byte[100]; //100바이트씩 읽게 된다.
        //원래 기본으로 512바이트씩 읽고, 그보다 적게 읽도록 시키면 남는 부분은 버리기 때문에
        //되도록이면 buffer를 정할떄 512의 배수로 정하면 성능 향상에 도움이 된다.
        while(true){
            //int data=is.read(); //데이터를 읽는다. 읽은 바이트 수를 리턴한다.
            //마지막 1바이트에 데이터를 저장한다.
            int data=is.read(buffer); //buffer의 길이 만큼 읽기
            if(data==-1) break;
            //System.out.println(data);
            os2.write(buffer,0,data); //바이트 수만큼 파일에 쓸 수 있다.
            for(int i=0;i<data;i++){
                System.out.println(buffer[i]);
            }
        }
        is.close();

        //프로그래머스 강의 보충
        //java 파일도 읽을 수 있다. 기본 경로가 프로젝트 폴더 바로 밑이다.
        FileInputStream fis = new FileInputStream("src/StudyJavaAlone/Week.java");
        FileOutputStream fos = new FileOutputStream("byteTest.txt");
        int readData=-1;
        //이렇게 쓰면 1바이트씩 읽어들인다.
        while((readData = fis.read())!=-1){
            fos.write(readData);
        }
        fos.flush();
        fis.close(); fos.close();

        //문자 기반으로 파일로 출력 - Writer
        Writer writer = new FileWriter("testing.txt"); //직접 경로를 지정해줄 수도 있음.
        String str = "Hello Java Programming";
        writer.write(str);
        writer.flush();
        writer.close();

        //문자 기반으로 파일로 입력받기 - Reader
        //메서드는 Outputstream과 똑같음.
        Reader reader = new FileReader("testing.txt");
        char[] cbuf = new char[100];
        while(true){
            int readCharNum=reader.read(cbuf);
            if(readCharNum==-1) break;
            for(int i=0;i<readCharNum;i++){ //그냥 문자열 길이로 출력하면 의미없는 문자가 나중에 출력될 수 있다.
                System.out.print(cbuf[i]);
            }
            System.out.println();
        }


    }
}
