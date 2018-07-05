package Sudoku;

import java.io.*;

public class SudokuSolver {

    private SudokuModel model;

    public SudokuSolver(int [][] array) {
        model = new SudokuModel(array);
    }

    /**
     * lời giải trò chơi sudoku
     * @return
     */
    public boolean solve() {
        this.model.tryValue(0, 0);
        return false;
    }

    public static void main(String[] args) {
        int [][] array = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        SudokuSolver ss = new SudokuSolver(array);
        ss.solve();
    }
}
