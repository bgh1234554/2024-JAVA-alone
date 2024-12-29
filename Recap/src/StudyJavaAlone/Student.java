package StudyJavaAlone;

import java.util.Objects;

public class Student extends People{
    private int StudentNo;
    private int BirthYear;
    public Student(String name, String ssn, int StudentNo){
        super(name,ssn);
        this.setStudentNo(StudentNo);
    }

    public Student(String name, String ssn) {
        super(name, ssn);
    }

    public int getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(int studentNo) {
        StudentNo = studentNo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return StudentNo == student.StudentNo && BirthYear == student.BirthYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(StudentNo, BirthYear);
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentNo=" + StudentNo +
                ", BirthYear=" + BirthYear +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
    //Alt+Insert 단축키로 자동 메서드 오버라이드 가능.
    //super 메소드로 재정의되기 전 부모클래스의 메소드를 불러올 수 있으며, final 메소드는 자식 클래스에서 재정의할 수 없음. public final 같은 방식으로 가능.
}