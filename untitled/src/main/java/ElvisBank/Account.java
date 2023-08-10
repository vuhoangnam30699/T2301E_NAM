package ElvisBank;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private String customerName;
    private String accountNumber;
    private Double balance;

    public Account(String customerName, String accountNumber, Double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    Locale locale = new Locale("vi", "VN");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

    @Override
    public String toString() {
        return "Tên khách hàng: " + customerName + ", Số tài khoản: " + accountNumber + ", Số dư khả dụng: " + numberFormat.format(balance);
    }
}

