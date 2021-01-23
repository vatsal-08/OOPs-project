public class Board {
    private char board[][];
    private int boardSize = 3;
    private char p1symbol, p2symbol;
    private int count;

    public static final int Player_1_Wins = 1;
    public static final int Player_2_Wins = 2;
    public static final int DRAW = 3;
    public static final int INCOMPLETE = 4;
    public static final int INVALID = 5;

    public Board(char p1symbol, char p2symbol) {
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = ' ';
            }
        }
        this.p1symbol = p1symbol;
        this.p2symbol = p2symbol;
    }

    public int move(char symbol, int x, int y) {

        if (x < 0 || y < 0 || x > boardSize || y > boardSize || board[x][y] != ' ') {
            return INVALID;
        }
        board[x][y] = symbol;
        count++;

        // Checking Row
        if (board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
            return symbol == p1symbol ? Player_1_Wins : Player_2_Wins;
        }

        // Checking Column
        if (board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
            return symbol == p2symbol ? Player_2_Wins : Player_1_Wins;
        }

        // First Diagonal
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return symbol == p1symbol ? Player_1_Wins : Player_2_Wins;
        }

        // Second Diagonal
        if (board[2][0] != ' ' && board[2][0] == board[1][1] && board[0][2] == board[2][0]) {
            return symbol == p1symbol ? Player_1_Wins : Player_2_Wins;
        }
        if (count == boardSize * boardSize)
            return DRAW;
        return INCOMPLETE;
    }

    public void print() {
        System.out.println("-------------------");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(" | " + board[i][j] + " | ");
            }
            System.out.println();
        }
    }

}
