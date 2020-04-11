package bank;

import java.util.Date;

public class Transaction {

    private String uuid;    //ID of each trnsaction
    private double transacAmount;      //Amount used in the transaction
    private Account account;        //Account used
    private Date timeStamp;     //Timestamp of te transaction
    private String memo;        //Details of the transaction

    //Constructor
    public Transaction(double amount, Account account){
        this.transacAmount = amount;
        this.account = account;
        this.timeStamp = new Date();
        this.memo="";

    }

    //overloading constructor
    public Transaction(double amount, String memo, Account account){

        //call the 2 arg constructor first
        this(amount, account);

        this.memo = memo;
    }
}
