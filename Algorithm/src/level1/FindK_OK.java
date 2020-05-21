package level1;

import java.util.Arrays;

public class FindK_OK {
    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    public int[] solution (int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int firstIndex = 0;
            int lastIndex = 0;
            int pick = 0;

            for (int j = 0; j < commands[i].length; j++) {

                switch (j) {
                    case 0: firstIndex = commands[i][0] - 1;
                        break;
                    case 1: lastIndex = commands[i][1] - 1;
                        break;
                    case 2: pick = commands[i][2] - 1;
                        break;
                }

            }
            int[] arraySort = new int[(lastIndex - firstIndex) + 1];

            for (int j = 0; firstIndex <= lastIndex; j++, firstIndex++) {
                arraySort[j] = array[firstIndex];
            }

            Arrays.sort(arraySort);
            answer[i] = arraySort[pick];
        }
        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }

    public static void main (String[] args) {
        FindK_OK k = new FindK_OK();
        k.solution(k.array, k.commands);
    }
}
