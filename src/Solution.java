import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Solution {
    public static void main(String[] args) throws IOException {
        Solution T = new Solution();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

//        String str = bf.readLine();

        String[] inputs = {
                "aabbaccc",
                "ababcdcdababcdcd",
                "abcabcdede",
                "abcabcabcabcdededededede",
                "xababcdcdababcdcd",
                "xxxxxxxxxxyyy",
                "a"
        };

        for (String s : inputs) {
            System.out.println(T.solution(s));
        }
    }

    //프로그래머스 카카오 문자열 압축
    public int solution(String str) {
        int answer = str.length();

        if (answer == 1) {
            return 1;
        }

        for (int i = 1; i <= str.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            String prev = str.substring(0, i);
            for (int j = i; j < str.length(); j += i) { //전체 조회
                String temp;
                if(j + i > str.length()) temp = str.substring(j); // j+i가 length보다 크면 전체 다 붙이기
                else temp = str.substring(j, j+i);

                if (prev.equals(temp)) { // 이전과 같으면 cnt 증가
                    cnt++;
                } else {//이전과 다르면 sringBuilder를 통해 문자를 붙이고 cnt 초기화
                    if (cnt > 1) sb.append(cnt);
                    sb.append(prev);
                    prev = temp;
                    cnt = 1;
                }
            }
            if(cnt > 1) sb.append(cnt);
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }

//    public String solution(String str) {
//        StringBuilder stringBuilder = new StringBuilder();
//
//        char[] chars = str.toCharArray();
//        char prev = 0;
//        int cnt = 1;
//        for (char c : chars) {
//            if (prev != c) {
//                if (cnt > 1) {
//                    stringBuilder.append(cnt);
//                }
//                stringBuilder.append(c);
//                cnt = 1;
//                prev = c;
//            }else {
//                cnt++;
//            }
//        }
//        stringBuilder.append(cnt);
//
//        return stringBuilder.toString();
//    }

    //프로그래머스 우선순위 프린터
//    class Print {
//        int severity;
//        int num;
//
//        public Print(int severity, int num) {
//            this.severity = severity;
//            this.num = num;
//        }
//    }
//
//    public int solution(int[] priorities, int location) {
//        int answer = 0;
//        int cnt = 0;
//        Queue<Print> printQueue = new LinkedList<>();
//        for (int i = 0; i < priorities.length; i++) {
//            printQueue.offer(new Print(priorities[i], i));
//        }
//
//        while (!printQueue.isEmpty()) {
//            Print poll = printQueue.poll();
//            boolean flag = true;
//            for (Print print : printQueue) {
//                if (poll.severity < print.severity) {
//                    printQueue.offer(poll);
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                cnt++;
//                if (poll.num == location) {
//                    answer = cnt;
//                    break;
//                }
//            }
//        }
//
//        System.out.println("answer = " + answer);
//
//        return answer;
//    }

    //프로그래머스 기능개발
//    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
//        Queue<Integer> queue = new LinkedList<>();
//        ArrayList<Integer> answer = new ArrayList<>();
//
//        for (int i = 0; i < progresses.length; i++) {
//            int rest = 100 - progresses[i];
//            int day = rest / speeds[i];
//            if (rest % speeds[i] > 0) {
//                 day += 1;
//            }
//            queue.add(day);
//        }
//
//        while (!queue.isEmpty()) {
//            int cnt = 1;
//
//            int top = queue.poll();
//            while (!queue.isEmpty() && top >= queue.peek()) {
//                cnt++;
//                queue.poll();
//            }
//
//            answer.add(cnt);
//        }
//
//        for (Integer count : answer) {
//            System.out.println("count = " + count);
//        }
//
//        return answer;
//    }

    //프로그래머스 위장
//    public int solution(String[][] clothes) {
//        int answer = 1;
//        Map<String, Integer> clotheMap = new HashMap<>();
//
//        for (int i = 0; i < clothes.length; i++) {
//            clotheMap.put(clothes[i][1], clotheMap.getOrDefault(clothes[i][1], 0) + 1);
//        }
//
//        for (String key : clotheMap.keySet()) {
//            answer *= (clotheMap.get(key) + 1);
//        }
//
//        System.out.println("answer = " + answer);
//        return answer - 1;
//    }

    //프로그래머스 전화번호 목록
//    public boolean solution(String[] phoneBook) {
//        boolean answer = true;
//        Set<String> hashSet = new HashSet<>();
//
//        for (int i = 0; i < phoneBook.length; i++) {
//            hashSet.add(phoneBook[i]);
//        }
//
//        for (int i = 0; i < phoneBook.length; i++)
//            for (int j = 0; j < phoneBook[i].length(); j++)
//                if (hashSet.contains(phoneBook[i].substring(0, j))) return false;
//
//        return answer;
//    }

    //프로그래머스 폰켓몬
//    public int solution(int[] nums) {
//        int answer = 0;
//        int size = nums.length / 2;
//        int cnt = 0;
//        int prev = 0;
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length; i++) {
//            if (prev != nums[i]) {
//                cnt++;
//            }
//            prev = nums[i];
//        }
//
//        if (cnt > size) {
//            answer = size;
//        }else {
//            answer = cnt;
//        }
//
//        System.out.println("answer = " + answer);
//        return answer;
//    }

    //프로그래머스 체육복
    //n: 전체 학생 수, lost: 잃어버린 학생의 번호, reserve: 여분의 체육복이 있는 학생 번호
//    public int solution(int n, int[] lost, int[] reserve) {
//        int answer = 0;
//        int[] students = new int[n];
//        Arrays.sort(lost);
//        Arrays.sort(reserve);
//
//        for (int i : lost) {
//            students[i - 1]--;
//        }
//
//        for (int i : reserve) {
//            students[i - 1]++;
//        }
//
//
//        for (int i = 0; i < students.length; i++) {
//            if (students[i] == -1) {
//                if (i == 0) {
//                    if (students[i + 1] == 1) {
//                        students[i + 1]--;
//                        answer++;
//                    }
//                } else if (i == students.length - 1) {
//                    if (students[i - 1] == 1) {
//                        students[i - 1]--;
//                        answer++;
//                    }
//                } else {
//                    if (students[i - 1] == 1) {
//                        students[i - 1]--;
//                        answer++;
//                    } else if (students[i + 1] == 1) {
//                        students[i + 1]--;
//                        answer++;
//                    }
//                }
//            } else {
//                answer++;
//            }
//        }
//
//        System.out.println("answer = " + answer);
//        return answer;
//    }
    //프로그래머스 모의고사
//    public ArrayList<Integer> solution(int[] answers) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        int[][] students = {
//                {1, 2, 3, 4, 5},
//                {2, 1, 2, 3, 2, 4, 2, 5},
//                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
//        };
//        int one, two, three;
//        int max = Integer.MIN_VALUE;
//        one = two = three = 0;
//
//        for (int i = 0; i < 3; i++) {
//            switch (i) {
//                case 0:
//                    for (int j = 0; j < answers.length; j++) {
//                        if (students[i][j % 5] == answers[j]) {
//                            one++;
//                            max = Math.max(max, one);
//                        }
//                    }
//                    break;
//                case 1:
//                    for (int j = 0; j < answers.length; j++) {
//                        if (students[i][j % 8] == answers[j]) {
//                            two++;
//                            max = Math.max(max, two);
//                        }
//                    }
//                    break;
//                case 2:
//                    for (int j = 0; j < answers.length; j++) {
//                        if (students[i][j % 10] == answers[j]) {
//                            three++;
//                            max = Math.max(max, three);
//                        }
//                    }
//                    break;
//            }
//        }
//
//        if (one == max) {
//            answer.add(1);
//        }
//        if (two == max) {
//            answer.add(2);
//        }
//        if (three == max) {
//            answer.add(3);
//        }
//
//        return answer;
//    }

    //프로그래머스 없는 숫자 더하기
//    public int solution(int[] numbers) {
//        int answer = -1;
//        int[] compareNums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Arrays.sort(numbers);
//
//        int p1 = 0;
//        int p2 = 0;
//        answer = 0;
//        while (true) {
//            if(p2 >= compareNums.length) break;
//            if (numbers[p1] != compareNums[p2]) {
//                System.out.println(compareNums[p2]);
//                answer += compareNums[p2++];
//            }else{
//                if(p1 < numbers.length - 1) p1++;
//                if(p2 < compareNums.length) p2++;
//            }
//        }
//
//        System.out.println(answer);
//
//        return answer;
//    }

    //프로그래머스 크레인 인형뽑기 게임
//    public int solution(int[][] board, int[] moves) {
//        int answer = 0;
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < moves.length; i++) {
//            int move = moves[i] - 1;
//            for (int j = 0; j < board.length; j++) {
//                if (board[j][move] != 0) {
//                    if (stack.empty() || stack.peek() != board[j][move]) {
//                        stack.push(board[j][move]);
//                    }else if (stack.peek() == board[j][move]){
//                        stack.pop();
//                        answer += 2;
//                    }
//                    board[j][move] = 0;
//                    break;
//                }
//            }
//        }
//
//        System.out.println("answer = " + answer);
//
//        return answer;
//    }

    //프로그래머스 숫자 문자열과 영단어
//    public int solution(String s) {
//        int answer = 0;
//        if (!s.matches("\\d")) {
//            if (s.contains("zero")) {
//                s = s.replace("zero", "0");
//            }
//            if (s.contains("one")) {
//                s = s.replace("one", "1");
//            }
//            if (s.contains("two")) {
//                s = s.replace("two", "2");
//            }
//            if (s.contains("three")) {
//                s = s.replace("three", "3");
//            }
//            if (s.contains("four")) {
//                s = s.replace("four", "4");
//            }
//            if (s.contains("five")) {
//                s = s.replace("five", "5");
//            }
//            if (s.contains("six")) {
//                s = s.replace("six", "6");
//            }
//            if (s.contains("seven")) {
//                s = s.replace("seven", "7");
//            }
//            if (s.contains("eight")) {
//                s = s.replace("eight", "8");
//            }
//            if (s.contains("nine")) {
//                s = s.replace("nine", "9");
//            }
//        }
//
//        answer = Integer.parseInt(s);
//
//        return answer;
//    }

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