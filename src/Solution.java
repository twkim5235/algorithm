import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution T = new Solution();

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};

//        T.solution("...!@BaT#*..y.abcdefghijklm.");
//        T.solution("z-+.^.");
        T.solution("abcdefghijklmn.p");
    }

    //프로그래머스 신규 아이디 추천
    public String solution(String new_id) {
        String answer = "";
        //1단계
        new_id = new_id.toLowerCase();
        //2단계
        new_id = new_id.replaceAll("[^\\da-z._-]", "");
        //3단계
        new_id = new_id.replaceAll("\\.\\.+", ".");
        //4단계
        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");
        //5단계
        if (new_id.isEmpty()) {
            new_id += "a";
        }
        //6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        new_id = new_id.replaceAll("\\.$", "");
        //7단계
        if (new_id.length() < 3) {
            String temp = String.valueOf(new_id.charAt(new_id.length() - 1));
            while (new_id.length() < 3) {
                new_id += temp;
            }
        }

        answer = new_id;

        return answer;
    }

//    public int[] solution(int[] lottos, int[] win_nums) {
//        int[] answer = new int[2];
//        int maxCount = 0;
//        int minCount = 0;
//
//        Set<Integer> lottoSet = new HashSet<>();
//        for (int num : win_nums) {
//            lottoSet.add(num);
//        }
//
//        for (int num : lottos) {
//            if (num == 0) {
//                maxCount++;
//            }
//            if (lottoSet.contains(num)) {
//                maxCount++;
//                minCount++;
//            }
//        }
//
//        answer[0] = findRank(maxCount);
//        answer[1] = findRank(minCount);
//
//        return answer;
//    }
//
//    public int findRank(int num) {
//        switch (num) {
//            case 0:
//            case 1:
//                return 6;
//            case 2:
//                return 5;
//            case 3:
//                return 4;
//            case 4:
//                return 3;
//            case 5:
//                return 2;
//            case 6:
//                return 1;
//        }
//        return -1;
//    }
}