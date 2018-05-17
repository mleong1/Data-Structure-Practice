package RecursionProblems;

public class Board {
    private Square[][] board;

    //can add a param to make an n x n board later
    public Board(){
        board = new Square[8][8];
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                Square s = new Square(i, j);
                System.out.println(s.getCol() + " col : row " + s.getRow());
                board[i][j] = s;
            }
        }
    }

    public void setQueen(int row, int col){
        Square queenSquare = board[row][col];
        queenSquare.setQueenHere(true);
        queenSquare.setQueenPlaceable(false);
    }

    public void setVertical(Square queen){
        int col = queen.getCol();
        for(int i = 0; i < col; i ++){
            board[i][col].setQueenPlaceable(false);
        }
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
        b.setQueen(0, 0);
        System.out.println(b.board[0][0].isQueenHere());
        System.out.println(b.board[0][1].isQueenHere());
    }
}
