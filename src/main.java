import java.util.Arrays;

public class main {

    public static void main(String[] args){
        int turn = 0;
        int winner = -1;
        int[] board = new int[9];

        Arrays.fill(board, -1);

        Player a = new Player(0);
        Player b = new Player(1);
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        while (winner == -1){
            printBoard(board);
            int turnField = players[turn].getTurn();
            if(players[turn].valideteTurn(board, turnField)){
                board[turnField] = players[turn].number;
                turn = (turn + 1) % 2;
            }
            winner = checkWinner(board);
        }
        System.out.println("Herzlichen Glückwunsch! Der Gewinner ist " + winner);
    }

    public static void printBoard(int[] board){
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-------------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-------------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    public static int checkWinner(int[] board) {
        int winner;
        if(board[0] == board[1] && board[0] == board[2] && board[0] != -1){
            winner = board[0];
        }
        else if(board[3] == board[4] && board[3] == board[5] && board[3] != -1){
            winner = board[3];
        }
        else if(board[6] == board[7] && board[6] == board[8] && board[6] != -1){
            winner = board[6];
        }
        else if(board[0] == board[3] && board[0] == board[6] && board[0] != -1){
            winner = board[0];
        }
        else if(board[1] == board[4] && board[1] == board[7] && board[1] != -1){
            winner = board[1];
        }
        else if(board[2] == board[5] && board[2] == board[8] && board[2] != -1){
            winner = board[2];
        }
        else if(board[0] == board[4] && board[0] == board[8] && board[0] != -1){
            winner = board[0];
        }
        else if(board[6] == board[4] && board[6] == board[2] && board[6] != -1){
            winner = board[6];
        }
        else{
            winner = -1;
        }

        return winner;
    }
}
