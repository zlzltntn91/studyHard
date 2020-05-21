package level1;

import java.util.ArrayList;

public class CraneGame_OK {

    /*
        board 배열은 2차원 배열로 크기는 5 x 5 이상 30 x 30 이하입니다.
        board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
        0은 빈 칸을 나타냅니다.
        1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
        moves 배열의 크기는 1 이상 1,000 이하입니다.
        moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.


     */
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
