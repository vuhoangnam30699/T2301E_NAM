package Internationalization;

import java.util.Currency;
import java.util.Locale;

public class CurrencyMain {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("vi", "VN"));
//        Locale.setDefault(Locale.US);

        Currency currency = Currency.getInstance(Locale.getDefault());

        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getDisplayName());
        System.out.println(currency.getSymbol());
        System.out.println(currency.getNumericCode());

        double money = 1000000.000;
        System.out.println("Số tiền phải trả là " + money + " " + currency.getCurrencyCode());
    }
}
