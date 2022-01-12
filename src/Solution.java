import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution T = new Solution();
        T.solution("1zerotwozero3");
    }

    //프로그래머스 숫자 문자열과 영단어
    public int solution(String s) {
        int answer = 0;
        if (!s.matches("\\d")) {
            if (s.contains("zero")) {
                s = s.replace("zero", "0");
            }
            if (s.contains("one")) {
                s = s.replace("one", "1");
            }
            if (s.contains("two")) {
                s = s.replace("two", "2");
            }
            if (s.contains("three")) {
                s = s.replace("three", "3");
            }
            if (s.contains("four")) {
                s = s.replace("four", "4");
            }
            if (s.contains("five")) {
                s = s.replace("five", "5");
            }
            if (s.contains("six")) {
                s = s.replace("six", "6");
            }
            if (s.contains("seven")) {
                s = s.replace("seven", "7");
            }
            if (s.contains("eight")) {
                s = s.replace("eight", "8");
            }
            if (s.contains("nine")) {
                s = s.replace("nine", "9");
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }

    //프로그래머스 신규 아이디 추천
//    public String solution(String new_id) {
//        String answer = "";
//        //1단계
//        new_id = new_id.toLowerCase();
//        //2단계
//        new_id = new_id.replaceAll("[^\\da-z._-]", "");
//        //3단계
//        new_id = new_id.replaceAll("\\.\\.+", ".");
//        //4단계
//        new_id = new_id.replaceAll("^\\.", "");
//        new_id = new_id.replaceAll("\\.$", "");
//        //5단계
//        if (new_id.isEmpty()) {
//            new_id += "a";
//        }
//        //6단계
//        if (new_id.length() >= 16) {
//            new_id = new_id.substring(0, 15);
//        }
//        new_id = new_id.replaceAll("\\.$", "");
//        //7단계
//        if (new_id.length() < 3) {
//            String temp = String.valueOf(new_id.charAt(new_id.length() - 1));
//            while (new_id.length() < 3) {
//                new_id += temp;
//            }
//        }
//
//        answer = new_id;
//
//        return answer;
//    }

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