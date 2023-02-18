package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
  
    private String studentID;
    

    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 500;
    private static int id = 1000;

    // Constructor : prompt user to enter student's name and year

    public Student() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = input.nextLine();
        
        System.out.print("Enter student last name: ");
        this.lastName = input.nextLine();
        
        System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4- Senior\nEnter student class level: ");
        this.gradeYear = input.nextInt();
       
        setStudentID();
        System.out.println(firstName+" "+lastName+" "+gradeYear+ " " + studentID);
        

    }

    // Generate an ID
    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll(){
        // A loop to select courses

        do{
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner input = new Scanner(System.in);
            String course = input.nextLine();
            if(!(course.equals("Q"))){
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }else {break;}
        }while(true);
        
        System.out.println("ENROLLED IN: "+courses);
        String tuitionBalanceString = String.format("$%,d", tuitionBalance);
        System.out.println("TUITION BALANCE: "+tuitionBalanceString);
      
    }

    // View balance

    public void viewBalance(){
        String tuitionBalanceString = String.format("$%,d", tuitionBalance);
        System.out.println("Your balance is " + tuitionBalanceString);
    }

    // Pay tuition

    public void payTuition(){
        
        boolean flag =true;
            
        while(flag){
            System.out.print("Enter your payment: $ ");
            Scanner input = new Scanner(System.in);
            int payment = input.nextInt();
            if (payment<0 || payment >tuitionBalance){
               System.out.println("Input is incorrect, Please try it Again.");
            }else {
                tuitionBalance = tuitionBalance - payment; 
                flag=false;
                String paymentString = String.format("$%,d", payment);
                System.out.println("Thank you for your pay is " + paymentString);
                viewBalance();
            }
        }      
        
    }
    // Show status
    public String toString(){
        String tuitionBalanceString = String.format("$%,d", tuitionBalance);
        return "Name: " + firstName + " " + lastName + 
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID + 
                "\nCourses Enrolled: " + courses +
                "\nBalance: " + tuitionBalanceString;
    }
}
