package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import com.github.javafaker.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Util class to import csv file
 */
public class BudgetPlannerImporter {

    private String _filename;
    private HashMap<Account, List<Payment>> accounts = new HashMap<>();

    public static void main(String[] args) {
        BudgetPlannerImporter budgetPlannerImporter = new BudgetPlannerImporter("account_payment.csv");
    }

    public BudgetPlannerImporter(String fileName) {
        this._filename = fileName;
        ReadFile(_filename);
    }

    public List<Account> ReadFile(String fileName) {

        Path path = Paths.get(fileName);
        ArrayList<Account> accounts = new ArrayList<>();

        try {
            BufferedReader reader = Files.newBufferedReader(path);
            String line;
            while (reader.readLine() != null) {
                line = reader.readLine();
                Account account = SplitLine(line);

                accounts.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    private Account SplitLine(String line) {
        // Account name,Account IBAN,Counteraccount IBAN,Transaction date,Amount,Currency,Detail

        String[] accountDetails = line.split(",");
        Account account = new Account();

        account.setIBAN(accountDetails[1]);
        account.setName(accountDetails[0]);

        //Payment payment = new Payment(LocalDate.parse());

        CheckAccount(account);

        return null;
    }

    private void CheckAccount(Account account) {
        accounts.get(account);
    }
}
