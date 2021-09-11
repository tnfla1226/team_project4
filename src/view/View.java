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
                    modifyMenu();
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
        String semester;
        double tScore = 0;
        int creditCount = 0;

        // 학기를 선택할 수 있는 메서드
        sc.seasonMenu();

        while (true) {
            String subject = null;
            System.out.println(" ========== 과목 목록 ==========");
            System.out.println("1. 자바프로그래밍 - 홍길동 교수님");
            System.out.println("2. 소프트웨어공학 - 뽀로로 교수님");
            System.out.println("3. 데이터베이스 - 김영희 교수님");
            System.out.println(" ");
            System.out.print("과목을 입력하세요: ");
            subject = scanner.next();
            if (!subject.equals("자바프로그래밍") && !subject.equals("소프트웨어공학") && !subject.equals("데이터베이스")
                    && !subject.equals("1") && !subject.equals("2") && !subject.equals("3")) {
                System.out.println("다시 입력하세요.");
                continue;
            } else if (subject.equals("1")) subject = "자바프로그래밍";
            else if (subject.equals("2")) {
                subject = "소프트웨어공학";
            } else if (subject.equals("3")) {
                subject = "데이터베이스";
            }



            System.out.print("점수 입력: ");
            double score = scanner.nextDouble();
            sCount++;
            total += score;

            if (score == 4.5) {
                changeScore = "A+";
            } else if (score > 4.5) {
                System.out.println("최대 4.5점을 초과할 수 없습니다.");
                System.out.println("과목부터 재 입력 부탁드립니다.");
                // 이 부분은 재 입력 받는 부분을 못하겠어서 추후 수정 하겠습니다!!
                continue;
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
            System.out.print("이수학점 입력: ");
            int credit = scanner.nextInt();
            creditCount += creditCount;


            // 평균학점 구하는 식: (과목1 점수 * 과목1 이수학점) + (과목2 점수 * 과목2 이수학점)... / 총 이수학점
            tScore = score * credit;
            total += tScore;
            avg = total / creditCount;

            sc.insert(sc.semester2, subject, credit, score, changeScore);

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
            System.out.println("|   학기   |   과목명   |  이수학점  |   성적   |   학점   |");
            for (int i = 0; i < count; i++) {
                System.out.println(students[i].showScore());
            }
        }
    }

    public void modifyMenu() {
        sc.modifymenu();
    }


}


