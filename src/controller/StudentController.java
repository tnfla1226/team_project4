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


    public String seasonMenu() {

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
        return semester;
    }

    double Score = 0;

    // 성적 수정
    public void modifymenu() {
        String subject = null;
        String targetSemester = null;
        while (true) {
            System.out.println("\n ============== 과목 목록 ==============");
            System.out.println("자바프로그래밍 - 홍길동 교수님");
            System.out.println("소프트웨어공학 - 뽀로로 교수님");
            System.out.println("데이터베이스 - 김영희 교수님");
            System.out.println(" ");
            System.out.print("수정하실 과목을 입력하세요: ");
            subject = scanner.next();
            System.out.println("");
            System.out.println("=============== 입력된 성적 정보 ===============");
            System.out.println("");
            System.out.println("|   학기   |   과목명   |  이수학점  |   성적   |   학점   |");
            for (int i = 0; i < existNum(); i++) {
                if (subject.equals(s[i].getSubject())) {
                    System.out.println();
                    System.out.println(s[i].showScore());
                    System.out.println("");
                }
            }
            System.out.println("수정하실 학기를 입력해주세요. ex) 4학년 2학기");
            scanner.nextLine();
            targetSemester = scanner.nextLine();
            System.out.println(" ");
            for (int i = 0; i < existNum(); i++) {
                // 이 if문으로 인해 입력 한 학기에 일치하는 해당 배열만 수정 됨.
                if (targetSemester.equals(s[i].getSemester())) {
                    System.out.println("=============== 수정하실 과목의 입력 정보 ===============");
                    System.out.println(" ");
                    System.out.println("|   학기   |   과목명   |  이수학점  |   성적   |   학점   |");
                    System.out.println("");
                    System.out.println(s[i].showScore());

                    System.out.print("\n수정 할 성적을 입력 해주세요: ");
                    Score = scanner.nextDouble();
                    System.out.println("");
                    // 입력받은 성적으로 수정
                    s[i].setScore(Score);
                    // 입력받은 성적은 changeScore 메서드로 변경
                    s[i].setChangeScore(changeScore(Score));
                    System.out.println("");
                    System.out.println("=============== 수정 완료 성적 ===============");
                    System.out.println("");
                    System.out.println("|   학기   |   과목명   |  이수학점  |   성적   |   학점   |");
                    System.out.println("");
                    System.out.println(s[i].showScore());
                    System.out.println("");
                    break;
                }

            }
            break;
        }

    }

    public String changeScore(double score) {
        String changeScore = null;
        if (score == 4.5) {
            changeScore = "A+";
        } else if (score > 4.5) {
            System.out.println("최대 4.5점을 초과할 수 없습니다.");
            System.out.println("과목부터 재 입력 부탁드립니다.");
        } else if (score < 4.5 && score >= 4.0) {
            changeScore = "A";
        } else if (score < 4.0 && score >= 3.5) {
            changeScore = "B+";
        } else if (score < 3.5 && score >= 3.0) {
            changeScore = "B";
        } else if (score < 3.0 && score >= 2.5) {
            changeScore = "C+";
        } else if (score < 2.5 && score >= 2.0) {
            changeScore = "C";
        } else if (score < 2.0 && score >= 1.5) {
            changeScore = "D+";
        } else if (score < 1.5 && score >= 1.0) {
            changeScore = "D";
        } else {
            changeScore = "F";
        }
        return changeScore;
    }
}



