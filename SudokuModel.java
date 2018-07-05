package Sudoku;

public class SudokuModel {

    // X[hàng][cột] = value // value in [1, 9] and 0 là giá trị cần được điền
    private int [][] X;

    public SudokuModel(int [][] array) {
        this.X = array;
    }

    /**
     * trả về true nếu v có thể được gán cho ô (i, j) mà không vi phạm các ràng buộc.
     * ràng buộc
     * cột  : mỗi ô xuất hiện ít nhất một lần trong một cột
     * hàng : mỗi ô xuất hiện ít nhất một lần trong mỗi hàng
     * cell : mỗi ô xuất hiện ít nhất một lần trong mỗi ô
     * @param v giá trị
     * @param r hàng
     * @param c cột
     * @return
     */
    public boolean check(int v, int r, int c) {
        // Kiểm tra ràng buộc về các cột
        // Nếu v không có trong cột thì v có thể được điền vào ô r,c với đk ô r,c mang giá trị là 0
        for (int row = 0; row < 9; row ++ ) {
            if (this.X[row][c] == v) {
                return false;
            }
        }
        // Kiểm tra ràng buộc về các hàng
        for (int col = 0; col < 9; col ++ ) {
            if (this.X[r][col] == v) {
                return false;
            }
        }
        // Kiểm tra ràng buộc về các cell
        int r1 = r - r%3;
        int c1 = c - c%3;
        for (int r2 = 0; r2 < 3; r2++) {
            // i1 = 0 ,1, 2
            for (int c2 = 0; c2 < 3; c2++) {
                // i2 = 0, 1, 2
                int r3 = r1 + r2;
                int c3 = c1 + c2;
                if(this.X[r3][c3] == v) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * thử tất cả giá trị cho ô ở hàng r và cột c
     * @param r hàng
     * @param c cột
     */
    public void tryValue(int r, int c) {
        if (r == 9 && c == 0) {
            printSolution();
            System.exit(0);
        } else {
            if (this.X[r][c] == 0) {
                for (int v = 1; v <= 9; v ++) {
                    if (check(v, r, c)) {
                        this.X[r][c] = v;
                        int r1, c1;
                        if (c == 8) {
                            r1 = r + 1;
                            c1 = 0;
                        } else {
                            r1 = r;
                            c1 = c + 1;
                        }
                        tryValue(r1, c1);
                        this.X[r][c] = 0;
                    }
                }
            } else {
                int r1, c1;
                if (c == 8) {
                    r1 = r + 1;
                    c1 = 0;
                } else {
                    r1 = r;
                    c1 = c + 1;
                }
                tryValue(r1, c1);
            }
        }
    }


    /**
     * in ra màn hình trò chơi soduku
     */
    public void printSolution() {
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(this.X[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
