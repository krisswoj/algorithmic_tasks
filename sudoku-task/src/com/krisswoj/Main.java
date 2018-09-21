package com.krisswoj;

public class Main {

    public static String myPrint(Sudoku sudoku) {

        int[][] sudokuBoard = sudoku.getSudoku();

        String sentenceToPrint = "";

        int row = 0;
        int column = 0;


        for (int pos1 = 0; pos1 < 9; pos1++) {
            for (int pos2 = 0; pos2 < 9; pos2++) {


                if (column > 8) {
                    column = 0;
                    row++;
                    sentenceToPrint += "\n";
                }


                if ((row == 3 || row == 6) && column == 0) {
                    sentenceToPrint += "---+---+---\n";
                }


                if ((column == 3 || column == 6)) {
                    sentenceToPrint += "|";
                }


                if (sudokuBoard[pos1][pos2] == 0) {
                    sentenceToPrint = sentenceToPrint + " ";
                } else {
                    sentenceToPrint = sentenceToPrint + sudokuBoard[pos1][pos2];
                }
                column++;
            }
        }
        return sentenceToPrint;
    }


    public static Boolean checkNumber(int x, int y, int number, Sudoku sudoku) {
        x -= 1;
        y -= 1;
        int[][] sudokuBoard = sudoku.getSudoku();

        for (int rowW = 0; rowW < 8; rowW += 3) {
            for (int colL = 0; colL < 8; colL += 3) {
                for (int pos = 0; pos <= 8; pos++) {
                    for (int pos2 = 0; pos2 <= 8; pos2++) {
                        //Checking number in row and column
                        if (sudokuBoard[x][pos2] == number || sudokuBoard[pos][y] == number)
                            return false;
                        //Checking number in 3/3 matrix
                        if (pos / 3 == (x / 3) && pos2 / 3 == (y / 3)) {
                            if (sudokuBoard[pos][pos2] == number) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

        int[][] samplePuzzleSecond = new int[][]{
                {0, 0, 2, 5, 0, 0, 0, 0, 3},
                {0, 4, 0, 0, 6, 7, 0, 0, 0},
                {1, 5, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 8, 0, 0, 0, 0, 0, 4},
                {5, 6, 0, 0, 0, 0, 0, 1, 7},
                {4, 0, 0, 0, 0, 0, 8, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 8, 1},
                {0, 0, 0, 1, 8, 0, 0, 2, 0},
                {2, 0, 0, 0, 0, 5, 7, 0, 0}};

        Sudoku sudoku = new Sudoku(samplePuzzleSecond);

        System.out.println(myPrint(sudoku));
        //Enter x and y like a number from 1 to 9
        System.out.println(checkNumber(9, 9, 3, sudoku));
    }

}