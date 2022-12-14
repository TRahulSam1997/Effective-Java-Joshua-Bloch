package chapter3.item10.regexapi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println(runRegExAgainstStr("^(.+)@(.+)$", "user@domain.com"));
        System.out.println(runRegExAgainstStr("^(.+)@(.+)$", "foo"));
        System.out.println(runRegExAgainstStr("^(.+)@(.+)$", "123"));
    }

    public static boolean runRegExAgainstStr(String regex, String text) {
        /** Pattern is a compiled regex that returns a Pattern object. */
        Matcher matcher = Pattern.compile(regex).matcher(text);
        /** Matcher interprets the pattern **/
        return matcher.find();
    }
}

