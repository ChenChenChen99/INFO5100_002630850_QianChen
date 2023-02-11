import java.util.Arrays;
import java.util.Random;

class Student{
    public String name;
    public int[] quizScores;

    public Student(String name){
        this.name = name;
        this.quizScores = new int[15];
    }
}

class PartTimeStudent extends Student{
    public PartTimeStudent(String name){
        super(name);
    }
}

class FullTimeStudent extends Student{
    public int[] examScores;

    public FullTimeStudent(String name){
        super(name);
        this.examScores = new int[2];
    }
}

class Session{
    public Student[] students;

    public Session(){
        this.students = new Student[20];
    }

    public void averageScorePerStudent(){
        for (Student student: this.students){
            double perStudentSum = 0.0;
            for (Integer score: student.quizScores){
                perStudentSum += score;
            }
            System.out.println(student.name + ": " + Math.round(perStudentSum / student.quizScores.length));
        }
    }

    public void printQuizScoreInAscendingOrder(){
        for (Student student: this.students){
            Arrays.sort(student.quizScores);
            System.out.println(student.name + ": " + Arrays.toString(student.quizScores));
        }
    }

    public void printPartTimeStudentName(){
        for (Student student: this.students){
            if (student instanceof PartTimeStudent){
                System.out.println(student.name);
            }
        }
    }

    public void printFullTimeStudentScores(){
        for (Student student: this.students){
            if (student instanceof FullTimeStudent){
                System.out.println(student.name + ": " + Arrays.toString(((FullTimeStudent) student).examScores));
            }
        }
    }

}

public class Main{
    public static void main(String[] args){
        Session session = new Session();
        Random random = new Random();

        for (int i = 0; i < 20; i++){
            String name = "Student" + (i + 1);
            boolean isFullStudent = random.nextBoolean();

            if (isFullStudent){
                session.students[i] = new FullTimeStudent(name);
                for (int j = 0; j < 2; j++){
                    int examScore = random.nextInt(100);
                    ((FullTimeStudent) session.students[i]).examScores[j] = examScore;
                }
            }else{
                session.students[i] = new PartTimeStudent(name);
            }

            for (int k = 0; k < 15; k++){
                int quizScore = random.nextInt(100);
                session.students[i].quizScores[k] = quizScore;
            }
        }

        System.out.println("Per student average score: ");
        session.averageScorePerStudent();
        System.out.println("The list of quiz scores in ascending order: ");
        session.printQuizScoreInAscendingOrder();
        System.out.println("Part time student name:");
        session.printPartTimeStudentName();
        System.out.println("Full time student exam scores:");
        session.printFullTimeStudentScores();
    }
}
