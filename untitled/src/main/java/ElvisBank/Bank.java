package ElvisBank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankId;
    private String bankName;
    private String branch;
    private List<Account> accounts = new ArrayList<>();

    public void displayAccountDetails(Account account) {
        System.out.println(this);
        System.out.println(account);
    }

    public void displayAccountDetails(String accountNumber) {
        Account account = findAccount(accountNumber);
        displayAccountDetails(account);
    }

    public void createAccount(String customerName, String accountNumber, Double balance) {
        accounts.add(new Account(customerName, accountNumber, balance));
    }

    public void withdraw(String accountNumber, Double amount) {
        Account account = findAccount(accountNumber);
        if (account.getBalance() < amount) {
            throw new RuntimeException("Số dư không đủ!");
        }
        account.setBalance(account.getBalance() - amount);
    }

    public void deposit(String accountNumber, Double amount) {
        Account account = findAccount(accountNumber);
        account.setBalance(account.getBalance() + amount);
    }

    private Account findAccount(String accountNumber) throws RuntimeException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException();
    }


    @Override
    public String toString() {
        return "Id: " + bankId + ", Tên ngân hàng: " + bankName + ", Chi nhánh: " + branch;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Bank(String bankId, String bankName, String branch) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.branch = branch;
    }
}
