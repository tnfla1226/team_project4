package controller;

import student.Student;

import java.util.Scanner;

public class StudentController {
    private Scanner scanner = new Scanner(System.in);
    private Student[] s = new Student[SIZE];
    public static final int SIZE = 50;
    double Score = 0;
    String avg;


    // 객체 입력
    public StudentController() {
        s[0] = new Student("1학년 1학기", "자바프로그래밍", 3, 4.0, "A");
        s[1] = new Student("1학년 1학기", "소프트웨어공학", 2, 3.5, "B+");
        s[2] = new Student("1학년 2학기", "데이터베이스", 3, 3.5, "B+");
//        s[3] = new Student("1학년 2학기", "통신개론", 3, 0.0, "F");
//        s[4] = new Student("2학년 1학기", "프로그래밍언어론", 3, 4.5, "A+");
//        s[5] = new Student("2학년 1학기", "컴퓨터활용", 3, 4.5, "A+");
//        s[6] = new Student("2학년 2학기", "컴퓨터구조", 3, 2.0, "C");
//        s[7] = new Student("2학년 2학기", "현대인과영양", 3, 3.5, "B+");
//        s[8] = new Student("3학년 1학기", "데이터구조", 3, 3.0, "B");
//        s[9] = new Student("3학년 1학기", "웹서버설계및구축", 3, 3.5, "B+");
//        s[10] = new Student("3학년 2학기", "운영체제", 3, 4.0, "A");
//        s[11] = new Student("3학년 2학기", "유비쿼터스컴퓨팅", 3, 4.5, "A+");
//        s[12] = new Student("4학년 1학기", "그리스신화속의사랑", 3, 2.5, "C+");
//        s[13] = new Student("4학년 1학기", "데이터통신", 3, 3.5, "B+");
//        s[14] = new Student("4학년 2학기", "디지털콘텐츠", 3, 4.0, "A");
//        s[15] = new Student("4학년 2학기", "중국어기초", 2, 2.5, "C+");


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


    //입력 메서드
    public void insert(String semester, String subject, int credit, double score, String changeScore) {
        int count = existNum();
        s[count] = new Student(semester, subject, credit, score, changeScore);
    }

    //과목 수정 메서드
    public void modifySubject(String targetSubject) {
        for (int i = 0; i < existNum(); i++) {
            if (targetSubject.equals(s[i].getSubject())) {
                System.out.println();
                System.out.println(s[i].showScore());
                System.out.println();
            }
        }
    }

    //학기와 성적 수정 메서드
    public void modifySemesterScore(String targetSemester) {
        System.out.println("\n=============== 수정하실 학기의 입력 정보 =================");
        System.out.println("\n|   학기   |   과목명   |  이수학점  |   성적   |   학점   |");
        for (int i = 0; i < existNum(); i++) {
            // 이 if문으로 인해 입력 한 학기에 일치하는 해당 배열만 수정 됨.
            if (targetSemester.equals(s[i].getSemester())) {
                System.out.println(s[i].showScore());
            }
        }
        for (int i = 0; i < existNum(); i++) {
            while (true) {
                // 과목 입력
                System.out.print("\n수정할 점수의 과목명을 입력하세요>> ");
                String subject = scanner.next();
                modifySubject(subject);

                //성적 입력
                System.out.print("수정할 성적을 입력하세요>> ");
                Score = scanner.nextDouble();
                if (Score > 4.5) {
                    System.out.println("최대 4.5점을 초과할 수 없습니다.");
                    continue;
                } else {
                    System.out.println();
                    // 입력받은 성적으로 수정
                    s[i].setScore(Score);
                    // 입력받은 성적은 changeScore 메서드로 변경
                    s[i].setChangeScore(changeScore(Score));
                    System.out.println("\n==================== 수정 완료 성적 ====================\n");
                    System.out.println("|   학기   |   과목명   |  이수학점  |   성적   |   학점   |");
                    System.out.println();
                    System.out.println(s[i].showScore());
                    System.out.println();
                    break;
                }
            }
            break;
        }
        return;
    }

    //성적 삭제 메서드
    public boolean delete(String semaester, String subject) {
        int count = existNum();
        //삭제할 데이터 인덱스 구하기
        int delIdx = -1;
        for (int i = 0; i < count; i++) {
            if (semaester.equals(s[i].getSemester())) {
                if (subject.equals(s[i].getSubject())) {
                    delIdx = i;
                    break;
                }
            }
        }

        //삭제 알고리즘
        if (delIdx != -1) {
            for (int i = delIdx; i < count - 1; i++) {
                s[i] = s[i + 1];
            }
            s[count - 1] = null; //마지막 데이터 null로 변경
            return true;
        }
        return false;
    }


    //입력받은 점수를 학점으로 변환하는 메서드
    public String changeScore(double score) {
        String changeScore = null;
        if (score == 4.5) {
            changeScore = "A+";
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


    // 평균학점 구하는 식: (과목1 점수 * 과목1 이수학점) + (과목2 점수 * 과목2 이수학점)... / 총 이수학점
    //총 이수학점 구하는 메서드
    public int getTotalCredit() {

        int totalCredit = 0;
        for (int i = 0; i < existNum(); i++) {
            totalCredit += s[i].getCredit();
        }
        return totalCredit;
    }

    //점수*이수학점 구하는 메서드
    public double getTscore() {

        double tScore = 0;
        for (int i = 0; i < existNum(); i++) {
            tScore += s[i].getScore() * s[i].getCredit();
        }
        return tScore;
    }

    //학기별 성적 출력하는 메서드
    public void printSemester(String semester) {

        System.out.printf("\n==================== %s 성적 ====================\n", semester);
        System.out.println("|   학기   |   과목명   |  이수학점  |   성적   |   학점   |");
        for (int i = 0; i < existNum(); i++) {
            if (semester.equals(s[i].getSemester())) {
                System.out.println(s[i].showScore());
            }
        }
        calculateOneAvg(semester);
        System.out.println("");
    }

    //학기별 평균 학점 구해서 출력하는 메서드
    public void calculateOneAvg(String semester) {
        String semesterAvg;
        double sTotalScore = 0;
        int sTotalCredit = 0;
        for (int i = 0; i < existNum(); i++) {
            if (semester.equals(s[i].getSemester())) {
                sTotalScore += s[i].getScore() * s[i].getCredit();
                sTotalCredit += s[i].getCredit();
            }
        }
        double tempAvg = 0.0;
        if (sTotalCredit <= 0) {
            semesterAvg = "0";
        } else {
            tempAvg = sTotalScore / sTotalCredit;
            semesterAvg = String.format("%.2f", tempAvg);
        }
        System.out.printf("총 이수학점 : %d   /   평균 학점 : %s\n", sTotalCredit, semesterAvg);
    }

    // 총 평균 학점 구해서 출력하는 메서드
    public void calculateAvg(double totalScore, int totalCredit) {

        double tempAvg = getTscore() / getTotalCredit();
        avg = String.format("%.2f", tempAvg);

        System.out.printf("총 이수학점 : %d   /   평균 학점 : %S\n", getTotalCredit(), avg);
    }

    //전체 출력 메서드
    public Student[] printAll() {
        return s;
    }
}