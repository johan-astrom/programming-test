package com.johanastrom;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringUtilities {

    public boolean isAnagram(String s1, String s2){

        if (s1.length()!=s2.length()){
            return false;
        }

        char[] chars1 = s1.toLowerCase().toCharArray();
        Arrays.sort(chars1);

        char[]chars2 = s2.toLowerCase().toCharArray();
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

}
