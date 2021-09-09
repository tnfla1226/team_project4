package student;

public class Student {

    // 필드 선언
    // 학생
    private String name;
    //학번
    private int studentNum;


    //이수학점
    private int credit;
    //학기
    private String semester;
    // 과목
    private String subject;
    // 과목당 점수를 숫자로 환산 ( 4.5 이런식이기 때문에 double 사용 )
    private double score;
    // 과목당 점수(A~F)
    private String changeScore;
    // 숫자로 환산받은 점수를 모두 더함 ( 나중에 나눠서 (A~F)로 변환 예정 )
    private double total;
    private double avg;
    private String grade;

    public Student(String semester, String subject, int credit, double score, String changeScore) {

        this.semester = semester;
        this.subject = subject;
        this.score = score;
        this.changeScore = changeScore;
        this.credit = credit;
    }

    public String showScore() {
        return this.semester + "  |  " + this.subject + "  |  " + this.credit + "  |  " + this.score + "  |  " + this.changeScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public Student(int credit) {
        this.credit = credit;
    }


    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChangeScore() {
        return changeScore;
    }

    public void setChangeScore(String changeScore) {
        this.changeScore = changeScore;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
