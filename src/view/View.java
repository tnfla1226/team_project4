package view;

import controller.StudentController;
import student.Student;

import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);
    private StudentController sc = new StudentController();
    int menuNo = -1;
    int sCount = 0;
    public String semester2;
    double Score = 0;

    public void mainMenu() {

        //메인화면
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
        }
    }

    //성적 입력 메서드
    public void insert() {

        double total = 0;
        double avg = 0;
        double score = 0;
        String changeScore;
        String semester;
        double tScore = 0;
        int creditCount = 0;
        String resultScore = null;

        // 학기를 선택할 수 있는 메서드
        seasonMenu();

        while (true) {
            String subject = null;
            System.out.println(" =========== 과목 목록 ===========");
            System.out.println("1. 자바프로그래밍 - 홍길동 교수님");
            System.out.println("2. 소프트웨어공학 - 뽀로로 교수님");
            System.out.println("3. 데이터베이스 - 김영희 교수님");
            System.out.println(" ");

            //과목 입력
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

            //점수 입력
            modifyScore: while(true) {
            System.out.print("점수 입력: ");
            score = scanner.nextDouble();
            sCount++;
            total += score;

                if (score > 4.5) {
                    System.out.println("최대 4.5점을 초과할 수 없습니다.");
                    continue modifyScore;

                } else {
                    resultScore = sc.changeScore(score);
                    break modifyScore;
                }
            }

            //이수학점 임력
            System.out.print("이수학점 입력: ");
            int credit = scanner.nextInt();
            creditCount += creditCount;


            // 평균학점 구하는 식: (과목1 점수 * 과목1 이수학점) + (과목2 점수 * 과목2 이수학점)... / 총 이수학점
            tScore = score * credit;
            total += tScore;
            avg = total / creditCount;

            sc.insert(semester2, subject, credit, score, resultScore);

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

    //학기 선택 메서드
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

        while (true) {
            System.out.print("학기를 선택하세요>> ");
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
                    System.out.println("");
                    continue;
            }
            break;
        }
        semester2 = semester;
        return semester;
    }

    //전체 출력 메서드
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

    //성적 수정 메서드
    public void modifyMenu() {
        String subject = null;
        String targetSemester = null;
        while (true) {
            System.out.println("\n=========== 과목 목록 ===========");
            System.out.println("자바프로그래밍 - 홍길동 교수님");
            System.out.println("소프트웨어공학 - 뽀로로 교수님");
            System.out.println("데이터베이스 - 김영희 교수님");
            System.out.print("\n수정하실 과목을 입력하세요: ");
            System.out.print(">> ");
            subject = scanner.next();
            System.out.println("");
            System.out.println("=============== 입력된 성적 정보 ===============");
            System.out.println("");
            System.out.println("|   학기   |   과목명   |  이수학점  |   성적   |   학점   |");
            sc.modifySubject(subject);

            System.out.println("수정하실 학기를 입력해주세요. ex) 4학년 2학기");
            System.out.print(">> ");
            scanner.nextLine();
            targetSemester = scanner.nextLine();
            System.out.println("");
            sc.modifySemesterScore(targetSemester);
            break;

        }
    }
}


