package bank;

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Users {

    private String firstName;               //First name of the user
    private String lastName;                //Last name of the user
    private String uuid;                    //Unique universal ID of the user
    private byte pinHash[];                 //MD5 hash of the user pin
    private ArrayList<Account> accounts;   //List of accounts of the user

    //Constructor
    public Users(String firstName, String lastName, String pin, Bank theBank){
        this.firstName = firstName;
        this.lastName = lastName;

        //Hashing using MD5 algorithm
        this.pinHash = getPinHash(pin);

        //Create the UUID
        this.uuid = theBank.getNewUserUUID();

        //Create empty list of account
        this.accounts = new ArrayList<Account>();

        //print log message
        System.out.printf("New user %s, %s with ID %s has been created.", lastName, firstName, this.uuid);

    }

    //Creating the hash value of the pin
    public byte[] getPinHash(String pin){

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md.digest(pin.getBytes());
    }

    public void addAccount(Account account) {
        this.accounts.add(account);

    }

    public String getUUID(){
        return this.uuid;
    }

    public boolean validatePin(String pin) {

        byte[] enteredPin = getPinHash(pin);
        boolean isValid = MessageDigest.isEqual(enteredPin, this.pinHash);

        return isValid;
    }
}
