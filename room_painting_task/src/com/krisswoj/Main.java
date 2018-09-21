package com.krisswoj;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};

        System.out.println(solution(array));
    }

    public static int solution(int[] A) {
        if (A.length > 100000) throw new IllegalArgumentException("array is so long");
        if (Arrays.stream(A).max().getAsInt() > 100000000)
            throw new IllegalArgumentException("Element of the array exceeds the permissible norm");

        int amountStrokes = 0;
        for (int i = 0; i <= A.length - 1; i++) {

            if ((i + 1) == A.length - 1) {
                if (A[i] < A[i + 1]) {
                    amountStrokes += A[i + 1];
                    break;
                }
                if (A[i] > A[i + 1] || A[i] == A[i + 1]) {
                    amountStrokes += A[i];
                    break;
                }
            }

            if (A[i] > A[i + 1]) {
                amountStrokes += (A[i] - A[i + 1]);
            }
        }
        return amountStrokes;
    }
}
