package com.zq.util;

import com.zq.entity.Fraction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataProcessing {
    public static Fraction process(String s) throws Exception {
        int test = rightNum(s);
        if(test == 0) {
            throw new Exception();
        }
        if(test == 1) {
            return new Fraction(Integer.valueOf(s), 1);
        } else if(test == 2) {
            String strList[] = s.split("\\.");
            if(strList.length >= 3) {
                throw new Exception();
            } else{
                return FloatDispose.doubleToFrac(Integer.valueOf(strList[0]), Integer.valueOf(strList[1]));
            }
        } else if(test == 3) {
            String fraList[] = s.split("/");
            if (fraList.length >= 3) {
                throw new Exception();
            } else {
                return new Fraction(Integer.valueOf(fraList[0]), Integer.valueOf(fraList[1]));
            }
        } else {
            throw new Exception();
        }
    }

    public static int rightNum(String s) {
        String PATTERN0 = ".*-+.*";
        String PATTERN1 = ".*[^0-9]+.*";
        String PATTERN2 = ".*[^.]+.*";
        String PATTERN3 = ".*[^/]+.*";
        if(s == null) {
            return 0;
        }
        if(Pattern.matches(PATTERN0, s)) {
            Pattern x = Pattern.compile("-");
            Matcher y = x.matcher(s);
            s = y.replaceAll("");
        }
        if (! Pattern.matches(PATTERN1, s)) {
            return 1;
        } else{
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(s);
                s = m.replaceAll("");
                if (! Pattern.matches(PATTERN2, s)) {
                    return 2;
            } else{
                    Pattern a = Pattern.compile("\\.");
                    Matcher b = a.matcher(s);
                    s = b.replaceAll("");
                    if(! Pattern.matches(PATTERN3, s)) {
                        return 3;
                    } else {
                        return 4;
                    }
                }
        }
    }
}
