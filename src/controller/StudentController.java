package controller;

import student.Student;

import java.util.Scanner;

public class StudentController {
    private Scanner scanner = new Scanner(System.in);
    private Student[] s = new Student[SIZE];
    public static final int SIZE = 8;
    public String semester2;

    public StudentController() {
        s[0] = new Student("4학년 1학기", "자바프로그래밍", 3, 4.0, "A");
        s[1] = new Student("4학년 1학기", "소프트웨어공학", 2, 3.5, "B+");
        s[2] = new Student("4학년 2학기", "데이터베이스", 2, 4.5, "A+");
        s[3] = new Student("4학년 2학기", "데이터베이스", 2, 4.5, "A+");
        s[4] = new Student("4학년 2학기", "데이터베이스", 2, 4.5, "A+");
        s[5] = new Student("4학년 2학기", "데이터베이스", 2, 4.5, "A+");
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


    public void seasonMenu() {

        String semester = null;
        System.out.println("====================================");
        System.out.println("[1]1학년 1학기");
        System.out.println("[2]1학년 2학기");
        System.out.println("[3]2학년 1학기");
        System.out.println("[4]2학년 2학기");
        System.out.println("[5]3학년 1학기");
        System.out.println("[6]3학년 2학기");
        System.out.println("[7]4학년 1학기");
        System.out.println("[8]4학년 2학기");
        System.out.println("====================================");
        System.out.print("학기를 선택하세요: ");
        int menuNo = scanner.nextInt();

        switch (menuNo) {
            case 1:
                semester = "1학년 1학기";
                break;
            case 2:
                semester = "1학년 2학기";
                break;
            case 3:
                semester = "2학년 1학기";
                break;
            case 4:
                semester = "2학년 2학기";
                break;
            case 5:
                semester = "3학년 1학기";
                break;
            case 6:
                semester = "3학년 2학기";
                break;
            case 7:
                semester = "4학년 1학기";
                break;
            case 8:
                semester = "4학년 2학기";
                break;
            default:
                System.out.println("잘못된 입력입니다.");

        }
        semester2 = semester;
    }

    // 성적 수정
    public void modifymenu() {
        String subject = null;
        int count = 0;
        while (true) {
            System.out.println(" ============== 과목 목록 ==============");
            System.out.println("자바프로그래밍 - 홍길동 교수님");
            System.out.println("소프트웨어공학 - 뽀로로 교수님");
            System.out.println("데이터베이스 - 김영희 교수님");
            System.out.println(" ");
            System.out.print("수정하실 과목을 입력하세요: ");
            subject = scanner.next();
            System.out.println("");
            for (int i = 0; i < existNum(); i++) {
                if (subject.equals(s[i].getSubject())) {
                    System.out.println(i + 1 + ". " + s[i].showScore());
                    System.out.println("");
                }
            }
            System.out.println("수정하실 학기의 번호를 선택해주세요.");
            count = scanner.nextInt();
            System.out.println(s[count - 1].getSemester());


        }


    }
}