package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args)  {
        // Ask how many new users we want to add

        System.out.print("Enter number of new students to enroll: ");
        Scanner input = new Scanner(System.in);
        int numOfStudents = input.nextInt();
        Student[] students = new Student[numOfStudents];
        

        // Create a number of students to add
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
        }

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
    }
}
