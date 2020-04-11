package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String company = "jb";
    private String password;
    int mailboxCapacity = 100;
    private String alternateEmail;
    private String department;
    private int defaultPasswordLength = 8;
    private String email;

    //Constructor will take firstname and lastname
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created for: " + this.firstName + " " + this.lastName);

        //Call a method asking for the department of the employee
        this.department = setDeptartment();
        System.out.println("The department is:" + this.department);


        //Call a method to generate password
        this.password = randomPassword(defaultPasswordLength);


        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"."+ company + ".com";
        System.out.println("Your email address is: "+ email);
        System.out.println("Your password is: "+ this.password);



    }
    //Ask for department
    public String setDeptartment(){
        System.out.println("Choose a department for the employee. Choose one of the following:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n\nEnter your choice:");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        switch (deptChoice){
            case 1:
                department = "sales";
                break;
            case 2:
                department = "dev";
                break;
            case 3:
                department = "accounts";
                break;
            case 4:
                department = "none";
                break;
        }
        return department;

    }

    //Generate a random password
    public String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/$#&";
        char[] password = new char[length];
        for (int i=0;i<length;i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }

    //Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){return mailboxCapacity;}

    public String getAlternateEmail(){return alternateEmail;}

    public String getPassword(){return password;}

    public String getName(){
        return new String(firstName +" "+ lastName);
    }
}
