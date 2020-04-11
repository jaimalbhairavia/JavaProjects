package bank;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;        //Name of the bank
    private ArrayList<Users> customers; //Customer of the bank
    private ArrayList<Account> accounts; //Accoutns in bank

    //Constructor
    public Bank(String name){
        this.name = name;
        this.customers = new ArrayList<Users>();
        this.accounts = new ArrayList<Account>();

        }


    public String getNewUserUUID(){
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean isUnique = false;

        do {
            //Generate the number
            uuid="";
            for(int i =0;i<len; i++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            //Check if unique
            for(Users u : this.customers ){
                if(uuid.compareTo(u.getUUID()) == 0){
                    isUnique = true;
                    break;
                }
            }
        }
        while (isUnique);

        return uuid;
}

    public String getNewAccountUUID(){
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean isUnique = false;

        do {
            //Generate the number
            uuid="";
            for(int i =0;i<len; i++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            //Check if unique
            for(Account a : this.accounts ){
                if(uuid.compareTo(a.getUUID()) == 0){
                    isUnique = true;
                    break;
                }
            }
        }
        while (isUnique);
        return uuid;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Users createNewUser(String firstName, String lastName, String pin){

        //create a new user and add it to the customer list
        Users newUser = new Users(firstName, lastName, pin, this);
        this.customers.add(newUser);

        //create a savings account for this user
        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }

    public Users userLogin(String userID, String pin){
        for(Users u : this.customers){
            if(u.getUUID().compareTo(userID) == 0 && u.validatePin(pin) == true){
                return u;
            }
        }
        return null;
    }
}

