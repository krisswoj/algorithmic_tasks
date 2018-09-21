package com.krisswoj;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(100002, 7));
    }

    public static int solution(int A, int B) {
        if (A < 0 || B < 0) throw new IllegalArgumentException("only postive numbers");
        if (A > 100000000 || B > 100000000) throw new IllegalArgumentException("provided numbers are too large");
        int c = A * B;
        return Integer.bitCount(c);
    }
}
