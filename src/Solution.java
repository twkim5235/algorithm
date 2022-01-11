import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int maxCount = 0;
        int minCount = 0;

        Set<Integer> lottoSet = new HashSet<>();
        for (int num : win_nums) {
            lottoSet.add(num);
        }

        for (int num : lottos) {
            if (num == 0) {
                maxCount++;
            }
            if (lottoSet.contains(num)) {
                maxCount++;
                minCount++;
            }
        }

        answer[0] = findRank(maxCount);
        answer[1] = findRank(minCount);

        return answer;
    }

    public int findRank(int num) {
        switch (num) {
            case 0:
            case 1:
                return 6;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};

        for (int i : T.solution(lottos, winNums)) {
            System.out.println("i = " + i);
        }
    }
}