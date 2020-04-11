package bank;

import java.util.Scanner;

public class ATM {

    public  static void main(String args[]){

        Scanner in = new Scanner(System.in);

        //create bank
        Bank newBank = new Bank("Bank of Austin");

        //add a user
        Users aUser = new Users("Jaimal", "Bhairavia", "852149", newBank);

        //add accounts to the bamk
        Account acnt = new Account("Checking", aUser, newBank);
        aUser.addAccount(acnt);
        newBank.addAccount(acnt);

        Users currentUser;


    }
}
