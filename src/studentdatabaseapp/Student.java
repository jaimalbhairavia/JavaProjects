package studentdatabaseapp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private static int id = 1000;
    private String courses;
    private int tuitionBalance;
    private static int courseFees = 600;
    private String studentId;

    //Constructor: prompt user to enter name and year
    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student firstname: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student lastname: ");
        this.lastName = in.nextLine();

        System.out.println("1 for Freshman\n2 for sophomore\n3 for junior\n4 for senior\nEnter student grade year:");
        this.gradeYear = in.nextInt();

        setID();

        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentId);

    }
    //generate the unique ID
    private void setID(){
        id++;
        this.studentId =  (gradeYear + "" + id);
    }

    //enroll in courses
    public void enroll(){

    }

    //View balance and pay tuition

    //Show status of student

}
