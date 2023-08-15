package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String strContent = "Toi noi la\"moi nguoi phai di hoc day du\"xong moi nguoi tra loi\"khong thich";
        String strPattern = "\"([^\"]*)\"";

        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(strContent);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
