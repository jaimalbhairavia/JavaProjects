package emailapp;

public class EmailApp {

   public static void main(String[] args){

       Email emp1 = new Email("Jaimal", "Bhairavia");

       emp1.setAlternateEmail("jb@gmail.com");
       System.out.println("Your alternate email is: " + emp1.getAlternateEmail());
       System.out.println(emp1.getName());

   }
}
