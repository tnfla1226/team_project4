package view;

import controller.StudentController;
import student.Student;

import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);
    private StudentController sc = new StudentController();
    int menuNo = -1;
    int sCount = 0;

    public void mainMenu() {


        while (menuNo != 5) {

            System.out.println("========== 학점 관리 프로그램 ==========");
            System.out.println("[1]성적 입력");
            System.out.println("[2]성적 수정");
            System.out.println("[3]학기별 성적 조회");
            System.out.println("[4]전체 성적 조회");
            System.out.println("[5]종료");
            System.out.println("====================================");
            System.out.print("이용하실 메뉴 번호를 입력하세요>> ");

            menuNo = scanner.nextInt();

            switch (menuNo) {
                case 1:
                    insert();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    printAll();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0); //프로그램 종료
                    break;
                default:
                    System.out.println("메뉴를 잘못 입력했습니다.");
            }

                    /*avg = (pScore + rScore + sScore) / 3;

                    if (avg > 90)
                        grade = "A";
                    else if (avg > 80)
                        grade = "B";
                    else if (avg > 70)
                        grade = "C";
                    else if (avg > 60)
                        grade = "D";
                    else
                        grade = "F";

                    std = new Student(name, no, pScore, rScore, sScore, avg);
                    std.setGrade(grade);

                    stdList.add(std);*/
        }
    }

    public void insert() {

        double total = 0;
        double avg = 0;
        String changeScore;
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
                System.out.println("잘못된 입렵입니다.");
        }

        while (true) {
            System.out.print("과목을 입력하세요: ");
            String subject = scanner.next();

            System.out.print("점수 입력: ");
            double score = scanner.nextDouble();
            sCount++;
            total += score;
            avg = total / sCount;

            if (score == 4.5) {
                changeScore = "A+";
            } else if (score < 4.5 && score >= 4.0) {
                changeScore = "A0";
            } else if (score < 4.0 && score >= 3.5) {
                changeScore = "B+";
            } else if (score < 3.5 && score >= 3.0) {
                changeScore = "B0";
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

            sc.insert(semester, subject, score, changeScore);

            System.out.println("\n[추가 입력하기 : 1 / 메인메뉴로 돌아가기: 0]");
            System.out.print(">> ");
            menuNo = scanner.nextInt();
            if (menuNo == 1) {
                continue;
            } else {
                return;
            }
        }
    }

    public void printAll() {
        Student[] students = sc.printAll();
        int count = sc.existNum();

        if (count == 0) {
            System.out.println("\n# 저장된 성적이 없습니다.");
        } else {
            System.out.println("\n=========== 전체 성적 조회 ===========");
            System.out.println("|   학기   |   과목명   |   성적   |   학점   |");
            for (int i = 0; i < count; i++) {
                System.out.println(students[i].showScore());
            }
        }
    }
}

