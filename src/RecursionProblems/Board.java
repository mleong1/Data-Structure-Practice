package RecursionProblems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Board {
    private Square[][] board;

    //can add a param to make an n x n board later
    public Board(){
        board = new Square[8][8];
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                Square s = new Square(i, j);
                board[i][j] = s;
            }
        }
    }

    public void setQueen(int row, int col){
        Square queenSquare = board[row][col];
        queenSquare.setQueenHere(true);
        queenSquare.setQueenPlaceable(false);
    }

    public void setVertical(int col){
        for(int i = 0; i < 8; i ++){
            board[i][col].setQueenPlaceable(false);
        }
    }

    public void setHorizontal(int row){
        for(int i = 0; i < 8; i ++){
            board[row][i].setQueenPlaceable(false);
        }
    }

    public void setDiagonal(int row, int col){
        int leftDiagnolRow = row;
        int leftDiagnolCol = col;

        int rightDiagnolRow = row;
        int rightDiagnolCol = col;

        //todo need to account for when queen has diagonal behind actually all diagonals
        while(leftDiagnolRow != 0 && leftDiagnolCol != 0){
            leftDiagnolRow --;
            leftDiagnolCol --;
        }
        System.out.println(leftDiagnolRow + ":" + leftDiagnolCol);

        for(; leftDiagnolRow < 8 && leftDiagnolCol < 8; leftDiagnolRow ++, leftDiagnolCol++){
            board[leftDiagnolRow][leftDiagnolCol].setQueenPlaceable(false);
        }

        while(rightDiagnolRow != 0 && rightDiagnolCol != 7){
            rightDiagnolRow --;
            rightDiagnolCol ++;
        }
        System.out.println(rightDiagnolRow + ":" + rightDiagnolCol);

        for(; rightDiagnolRow < 8 && rightDiagnolCol >= 0; rightDiagnolRow ++, rightDiagnolCol --){
            board[rightDiagnolRow][rightDiagnolCol].setQueenPlaceable(false);
        }
    }

    public void printBoard(){
        String[] boardOutput = new String[8];
        for(int r = 0; r < 8; r++){
            for(int c = 0; c < 8; c++){
                if(board[r][c].isQueenHere()){
                    boardOutput[c] = "Q";
                } else if(!board[r][c].isQueenPlaceable()){
                    boardOutput[c] = "U";
                } else {
                    //in this case this square is Available
                    boardOutput[c] = "A";
                }
            }
            System.out.println("This is row " + r + ": " + Arrays.toString(boardOutput));
        }
    }

    public void setQueenAndUpdate(int row, int col){
        setQueen(row, col);
        setVertical(col);
        setHorizontal(row);
        setDiagonal(row, col);
    }






    /*Private square class for the board.
     */
    private class Square{
        private boolean queenHere;
        private boolean queenPlaceable;
        private int row;
        private int col;

        public Square(int row, int col){
            this.row = row;
            this.col = col;
            this.queenHere = false;
            this.queenPlaceable = true;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public boolean isQueenPlaceable() {
            return queenPlaceable;
        }

        public void setQueenPlaceable(boolean queenPlaceable) {
            this.queenPlaceable = queenPlaceable;
        }

        public boolean isQueenHere() {
            return queenHere;
        }

        public void setQueenHere(boolean queenHere) {
            this.queenHere = queenHere;
        }
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.setQueenAndUpdate(0, 0);
        b.setQueenAndUpdate(1, 2);
        b.setQueenAndUpdate(2, 4);
        b.setQueenAndUpdate(3, 6);
        b.printBoard();
    }
}
