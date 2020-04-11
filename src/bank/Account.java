package bank;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Account {
    private String name;        //Account name - like checking
    private double balance;        //Balance in the account
    private String uuid;        //ID of the account
    private Users holer;        //User of the account
    private ArrayList<Transaction> transactions;    //List of transactions in the account

    public Account(String name, Users holder, Bank theBank){
        this.name = name;
        this.holer = holder;

        //Crate UUID for the account
        this.uuid= theBank.getNewAccountUUID();

        //Initialize transactions in an empty list
        this.transactions = new ArrayList<Transaction>();

    }

    public String getUUID() {
        return this.uuid;
    }
}

