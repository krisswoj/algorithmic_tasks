package com.krisswoj;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        System.out.println(Solution("Forget CVs..Save time . x x"));

        Solution("We test coders. Give                        us a try?");
//        Solution("Forget CVs..Save time . x x");
    }

    public static int Solution(String S) {
        if (!S.matches("^[a-zA-Z,.!? ]*$")) throw new IllegalArgumentException("illegal character");
        if (S.length() > 100) throw new IllegalArgumentException("string is so long");

        String[] dividedSentence = S.split("[!.?]", -1);

        int[] amount = new int[dividedSentence.length];
        int i = 0;
        for (String element : dividedSentence) {

            Pattern compiledPattern = Pattern.compile("\\w+");
            Matcher matcher = compiledPattern.matcher(element);

            int count = 0;
            while (matcher.find()){
                count++;
            }

            amount[i] = count;
            i++;

        }
        return Arrays.stream(amount).max().getAsInt();
    }

}


