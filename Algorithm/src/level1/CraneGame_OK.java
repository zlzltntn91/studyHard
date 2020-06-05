package level1;

import java.util.ArrayList;

public class CraneGame_OK {

    int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
    int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

    public int solution (int[][] board, int[] moves) {

        int moveNum = 0;
        int answer = 0;
        ArrayList<Integer> getList = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            int crane = moves[i] - 1;
            second:
            for (int j = 0; j < board[crane].length; j++) {
                if (board[j][crane] != 0) {
                    getList.add(board[j][crane]);

                    board[j][crane] = 0;
                    break second;
                }
            }
        }
        boolean check;
        do{
            check = false;
            for (int i = 1; i < getList.size(); i++) {
                if (getList.get(i - 1).equals(getList.get(i))) {
                    getList.remove(i-1);
                    getList.remove(i-1);
                    check = true;
                    ++answer;
                }
            }
        }
        while (check);
        return answer*2;
    }


    public static void main (String[] args) {
        CraneGame_OK cg = new CraneGame_OK();
        System.out.println("Answer : " + cg.solution(cg.board, cg.moves));
    }
}
