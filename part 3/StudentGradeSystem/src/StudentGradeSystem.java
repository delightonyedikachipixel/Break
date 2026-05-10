import java.util.Scanner;
public class StudentGradeSystem{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to The Student Grade System");
        System.out.println("Enter the number of students you have:");
        int numberOfStudents = input.nextInt();
        System.out.println("Enter the number of subjects entered offered for each students:");
    int numberOfSubjects = input.nextInt();

        Classroom classroom = new Classroom(numberOfStudents, numberOfSubjects);

        for (int count = 0; count < numberOfStudents; count++) {
            for (int counter = 0; counter < numberOfSubjects; counter++) {
                int score = -1;
                while (score < 0 || score > 100) {
                    System.out.println("Entering score for student " + (count+1));
                    System.out.print("Enter score for subject " + (counter+1) + ": ");
                    score = input.nextInt();
                    if (score < 0 || score > 100) {
                        System.out.println("Score must be between 0 and 100!");
                    }
                }
                System.out.println("Saving >>>>>>>>>>>>>>>>>>>>");
                classroom.getStudent(count).setScore(counter, score);
                System.out.println("Saved successfully");
            }
        }

        classroom.processResults();
        classroom.printClassTable();
        classroom.printSubjectSummary();
        classroom.printClassSummary();

    }
}

