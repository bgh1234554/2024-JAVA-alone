package StudyJavaAlone;

import java.io.*;

public class ConsoleExam {
    public static void main(String[] args) throws IOException {
        //System.in -> 콘솔에서 입력받을때, System.out -> 콘솔에서 출력할때
        //System.err -> 에러를 출력할때
        InputStream is = System.in;
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
        //코딩테스트 시에는 BufferedReader을 Scanner보다 많이 쓴다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            System.out.print("Type: ");
            String inputstr = br.readLine();
            if(inputstr.equals("quit")) break;
            System.out.println(inputstr);
        }
        br.close();
        //Scanner.nextLine()을 가장 많이 쓰지만, nextInt nextDouble도 있다.
        //그냥 next는 한 글자 읽는 것.

        //File 객체 - 파일 및 폴더 디렉토리에 관한 정보를 전해주는 메소드.
        File file = new File("copytest.txt");
        if(file.exists()) System.out.println("It does exists");
        else file.mkdir(); //새로운 파일이나 폴더 생성
        //file.delete() 삭제 file.getName(), file.getParent(), getPath(), isDirectory(), isFile(), lastModified() 등등의 메서드가 있다.
    }
}
