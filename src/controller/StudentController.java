package controller;

import student.Student;

public class StudentController {

    private Student[] s = new Student[SIZE];
    public static final int SIZE = 8;

    public StudentController() {
        s[0] = new Student("4학년 1학기", "자바프로그래밍", 3, 4.0, "A");
        s[1] = new Student("4학년 1학기", "소프트웨어공학", 2, 3.5, "B+");
        s[2] = new Student("4학년 2학기", "데이터베이스", 2, 4.5, "A+");
    }

    //실제 저장된 과목의 숫자를 반환
    public int existNum() {
        int count = 0; // 숫자를 세는 변수
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null) {
                break;
            }
            count++;
        }
        return count;
    }


    public void insert(String semester, String subject, int credit, double score, String changeScore) {
        //charAt(index) : 문자열에서 해당 위치의 글자 하나를 추출
        int count = existNum();
        s[count] = new Student(semester, subject, credit, score, changeScore);
    }

    public Student[] printAll() {
        return s;
    }

    public void login(int StudentNum) {
        for (int i = 0; i < existNum(); i++) {

        }

    }


}
