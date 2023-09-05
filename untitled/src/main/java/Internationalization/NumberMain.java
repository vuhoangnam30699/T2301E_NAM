package Internationalization;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {
    public static void main(String[] args) {
        Locale vn = new Locale("vi", "VN");
        Locale us = Locale.US;
        Locale fr = Locale.FRANCE;
        Locale.setDefault(vn);

        double number = 1234000.567;

//        NumberFormat vnd = NumberFormat.getInstance(vn);
//        NumberFormat usd = NumberFormat.getInstance(us);
//        NumberFormat franc = NumberFormat.getInstance(fr);
        NumberFormat numberFormat = NumberFormat.getInstance();


//        System.out.println(vnd.format(number));
//        System.out.println(usd.format(number));
//        System.out.println(franc.format(number));

        System.out.println(numberFormat.format(number));
    }
}
