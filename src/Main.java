import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String line1 = sc.nextLine();
//        String line2 = sc.nextLine();
//        String nums = sc.nextLine();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(getMaxSale(n, m, nums));
    }

    //3-3 최대 매출 구하기
    public static int getMaxSale(int n, int m, int[] nums){
        int answer = 0, sum = 0;
        int st = 0;
        int ed = 0;

        for(int i = 0; i < m; i++){
            sum += nums[i];
        }
        answer = sum;

        for(int i = m; i < n; i++){
            sum += nums[i] - nums[i - m];
            if(answer < sum)
                answer = sum;
        }

        return answer;
    }

    //3-2 공통 원소 구하기
    public static ArrayList<Integer> getCommonElement(int n, int m, int[] nums1, int[] nums2){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m){
                if(nums1[p1] < nums2[p2]) {
                    p1++;
                }else if(nums1[p1] > nums2[p2]) {
                    p2++;
                }else {
                    answer.add(nums1[p1]);
                    p1++;
                    p2++;
                }
        }

        return answer;
    }

    //3-1 두 배열 합치기
    public static int[] combineArray(int n, int m, int[] nums1, int[] nums2){
        int[] answer = new int[n + m];
        System.arraycopy(nums1, 0, answer, 0, n);
        System.arraycopy(nums2, 0, answer, n, m);

        for (int i = 0; i < answer.length; i++){
            for(int j = i; j < answer.length; j++){
                int temp = 0;
                if(answer[i] > answer[j]){
                    temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
            }
        }

        return answer;
    }

    //3-1 두 배열 합치기 강의 풀이(two pointers algorithm)
    public static ArrayList<Integer> combineArrayV2(int n, int m, int[] nums1, int[] nums2){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m){
            if(nums1[p1] > nums2[p2]) answer.add(nums2[p2++]);
            else answer.add(nums1[p1++]);

        }
        while (p1 < n){
            answer.add(nums1[p1++]);
        }
        while (p2 < m){
            answer.add(nums2[p2++]);
        }

        return answer;
    }

    //2-12 멘토링 강의 풀이
    public static int getMetoringNum(int m, int n, int[][] nums){
        int answer = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i != j) {
                    int cnt = 0;
                    for (int k = 0; k < m; k++) {
                        int pi = 0, pj = 0;
                        for (int s = 0; s < n; s++) {
                            if (nums[k][s] == i) pi = s;
                            if (nums[k][s] == j) pj = s;
                        }
                        if (pi < pj) cnt++;
                    }
                    if (cnt == m) answer++;
                }
            }
        }
        return answer;
    }

    //2-11 임시반장 정하기
    public static int getLeader(int n, int [][] nums){
        int answer = Integer.MIN_VALUE;
        int[] same = new int[n];

        for (int i = 0; i < n; i++){
            int cnt = 0;
            for (int j = 0; j < n; j++){
                for(int k = 0; k < 5; k++){
                    if(nums[i][k] == nums[j][k]){
                        same[i] = cnt++;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < same.length; i++) {
            if (same[i] > answer) {
                answer = i + 1;
            }
        }

        return answer;
    }

    //2-11 임시반장 구하기 강의 풀이
    public static int getLeaderV2(int n, int [][] nums){
        int answer = 0, max = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= 5; k++){
                    if(nums[i][k] == nums[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    //2-10 봉우리 구하기
    public static int getPeak(int n, int[][] nums) {
        int answer = 0;

        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(nums[i][j] > nums[i][j - 1]){
                    if(nums[i][j] > nums[i - 1][j]){
                        if(nums[i][j] > nums[i][j + 1]){
                            if(nums[i][j] > nums[i + 1][j])
                                answer += 1;
                        }
                    }
                }
            }
        }

        return answer;
    }

    //2-10 봉우리 구하기 강의 풀이
    public static int getPeakV2(int n, int[][] nums) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                boolean flag = true;
                for (int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = i + dy[k];

                    if(nx >= 0 && nx < n && nx >= 0 && nx < n) {
                        if (nums[nx][ny] >= nums[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) answer++;
            }
        }

        return answer;
    }

    //2-9 격자판 최대합 구하기
    public static int getMaxPlusNum(int n, int[][] nums){
        int answer = 0;
        int[] resultNums = new int[n * 2 + 2];
        int c = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                resultNums[c] += nums[i][j];
            }
            c++;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                resultNums[c] += nums[j][i];
            }
            c++;
        }

        for(int i = 0; i < n; i++){
            resultNums[c] += nums[i][i];
        }
        c++;

        for(int i = 0; i < n; i++)
        {
            int j = 4;
            resultNums[c] += nums[i][j--];
        }

        answer = resultNums[0];
        for(int i = 0; i < resultNums.length - 1; i++){
            if(answer < resultNums[i])
                answer = resultNums[i];
        }

        return answer;
    }

    //2-9 격자판 최대합 구하기 강의풀이
    public static int getMaxPlusNumV2(int n, int[][] nums){
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for(int i = 0; i < n; i++){
            sum1 = sum2 = 0;
            for(int j = 0; j < n; j++){
                sum1 += nums[i][j];
                sum2 += nums[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        for (int i = 0; i < n; i++){
            sum1 = sum2 = 0;
            sum1 = nums[i][i];
            sum2 = nums[i][n - i - 1];
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        return answer;
    }

    //2-8 등수 구하기
    public static int[] getRank(int[] nums){
        int[] ranks = IntStream.generate(() -> 1).limit(nums.length).toArray();

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]) {
                    ++ranks[j];
                }
                else if(nums[i] < nums[j]){
                    ++ranks[i];
                }
            }
        }

        return ranks;
    }

    //2-8 등수 구하기 강의 풀이
    public static int[] getRankV2(int n,int[] nums){
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++){
                if (nums[j] > nums[i]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }

    //2-7 점수 계산
    public static int calResult(int n, int[] nums){
        int answer = 0;
        boolean prev = false;

        int num = 0;
        for(int i = 0; i < n; i++) {
            if (nums[i] == 1 && prev == false) {
                prev = true;
                answer += ++num;
            } else if (nums[i] == 1 && prev == true) {
                answer += ++num;
            } else {
                prev = false;
                num = 0;
            }
        }

        return answer;
    }

    //2-7 점수 계산 강의 문제풀이
    public static int solution(int n, int[] arr){
        int answer = 0, cnt = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 1){
                cnt++;
                answer += cnt;
            }
            else cnt = 0;
        }

        return answer;
    }

    //2-6 뒤집은 소수
    public static String convertPrimeNum(int n, String nums){
        String answer = "";
        String[] numsStringArray = nums.split(" ");

        for(int i = 0; i < n; i++){
            StringBuffer sb = new StringBuffer(numsStringArray[i]);
            int num = Integer.parseInt(sb.reverse().toString());
            boolean result = true;

            if(num > 1) {
                for (int j = 2; j <= num / 2; j++) {
                    if (num % j == 0) {
                        result = false;
                        break;
                    } else {
                        result = true;
                    }
                }

                if(result)
                    answer += num + " ";
            }


        }
        return answer;
    }

    //2-6 뒤집은 소수 강의 풀의
    public static ArrayList<Integer> convertPrimeNum2(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i =0; i < n; i++){
            int temp = arr[i];
            int res = 0;
            while (temp > 0){
                int t = temp % 10;
                res = res * 10 + t;
                temp /= 10;
            }
            if(isPrime(res))
                answer.add(res);
        }
        return answer;
    }

    public static boolean isPrime(int num){
        if(num == 1)
            return false;
        for(int i = 0; i < num; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }

    //2-5 소수(에라토스테네스의 체)
    public static int SieveOfEratosthenes(int num){
        int answer = 0;
        int[] ch = new int[num + 1];
        for(int i = 2; i <= num; i++){
            if(ch[i] == 0){
                answer++;
            }
            for (int j = i; j <= num; j = j + i) {
                ch[j] = 1;
            }
        }

        return answer;
    }

    //2-4 피보나치 수열 강의 풀이
    public static int[] fibonacciSequence(int num) {
        int[] answer = new int[num];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < num; i++){
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }

    //2-4 피보나치 수열 강의 풀이(배열 없이)
    public static void fibonacciSequence2(int num){
        int fir = 1;
        int sec = 1;
        int tmp = 0;

        System.out.print(fir + " ");
        System.out.print(sec + " ");
        for (int i = 2; i < num; i++){
            tmp = fir + sec;
            System.out.print(tmp + " ");
            fir = sec;
            sec = tmp;
        }
    }

    //2-3 가위 바위 보
    public static ArrayList<String> rockScissorPaper(int n, int[] numsA, int[] numsB){
        ArrayList<String> result = new ArrayList<String>();

        for(int i = 0; i < n; i++)
        {
            if(numsA[i] == numsB[i])
                result.add("D");
            else if(numsA[i] == 1 && numsB[i] == 3)
                result.add("A");
            else if(numsA[i] == 2 && numsB[i] == 1)
                result.add("A");
            else if(numsA[i] == 3 && numsB[i] == 2)
                result.add("A");
            else
                result.add("B");
        }

        return result;
    }

    //2-2 보이는 학생 수 세기
    public static int seeBigStudent(int n, int[] nums){
        int answer = 1;
        int max = nums[0];

        for(int i = 1; i < n; i++) {
            if(max < nums[i]){
                answer++;
                max = nums[i];
            }
        }

        return answer;
    }

    //2-1 큰 수 출력하기
    public static String showBigNum(String line1, String line2){
        String answer = "";
        int num = Integer.parseInt(line1);
        int[] nums = new int[num];

        for(int i = 0; i < num; i++){
            nums[i] = Integer.parseInt(line2.split(" ")[i]);
        }

        answer += nums[0];
        for(int i = 1; i < num; i++){
            if(nums[i] > nums[i -1])
                answer += " " + nums[i];
        }

        return answer;
    }

    //1-12 암호 해독
    public static String decode(String line1, String line2){
        String answer = "";
        int num = Integer.parseInt(line1);

        for(int i = 0; i < num; i++)
        {
            String code = line2.substring(i * 7, (i+1) * 7);
            char decode = 0;
            code = code.replace('#', '1').replace('*', '0');

            decode += Integer.parseInt(code, 2);
            answer += decode;
        }


        return answer;
    }

    //1-11 문자열 압축
    public static String compressionWord(String s){
        String answer = "";
        char[] chars = s.toCharArray();
        int count = 1;

        for(int i = 0; i < chars.length - 1; i++){
            if(chars[i] == chars[i + 1]){
                count++;
            }
            else {
                answer += chars[i];
                if(count > 1) answer += String.valueOf(count);
                count = 1;

            }
        }
        answer += chars[chars.length - 1];
        if(count > 1) answer += count;


        return answer;
    }

    //1-10 가장 짧은 문자 거리
    public static int[] getCharDistance(String line) {
        String[] split = line.split(" ");
        String standard = split[0];
        char target = split[1].charAt(0);
        int[] answer = new int[standard.length()];
        int p = 1000;

        for(int i = 0; i < standard.length(); i++){
            if(standard.charAt(i) == target){
                p = 0;
                answer[i] = p;
            }
            else
                answer[i] = ++p;
        }
        p = 1000;

        for(int i = standard.length() - 1; i >= 0; i--){
            if (standard.charAt(i) == target)
                p = 0;
            else{
                answer[i] = Math.min(answer[i], ++p);
            }

        }

        return answer;
    }

    //1-9 숫자만 추출
    public static int extractNum(String line){
        int answer = 0;
        char[] chars = line.toCharArray();
        for(char x: chars){
            if(x >= 48 && x <= 57){
                answer = answer * 10 + (x - 48);
            }
        }
        return answer;
    }

    //1-9 숫자만 추출
    public static int extractNum2(String line){
        String answer = "";
        for(char x: line.toCharArray()){
            if(Character.isDigit(x)){
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    //1-8 유효한 팰린드롬
    public static String palindromeString(String line){
//        String answer = "NO";
//        line = line.toLowerCase().replaceAll("[^a-z]", "");
//        String tmp = new StringBuffer(line).reverse().toString();
//
//        if(tmp.equals(line))
//            answer = "YES";
//
//        return answer;
        String answer = "NO";
        int end = line.length() - 1;
        for(int i=0; i< line.length()/2; i++, end--) {
            if (line.charAt(i) != line.charAt(end)) {
                return "NO";
            }
        }
        return "YES";
    }



    //1-7 회문 문자열
    public static String palindromeWord(String line){
        /*char[] chars = line.toLowerCase().toCharArray();
        int lt = 0;
        int rt = chars.length - 1;


        while (lt < rt){
            if(!(chars[lt] == chars[rt])) {
                return "NO";
            }

            lt++;
            rt--;
        }

        return "YES";*/

        String tmp = new StringBuffer(line).reverse().toString();
        if(tmp.equalsIgnoreCase(line))
            return "YES";
        else
            return "NO";
    }

    //1-6 중복문자제거
    public static String removeDuplicateChar(String line){
        char[] chars = line.toCharArray();
        int lt = 0;
        int rt = line.length() - 1;
        String returnString = new String();

        for (int i = 0; i < line.length(); i++)
        {
            if(line.indexOf(line.charAt(i)) == i){
                returnString += line.charAt(i);
            }
        }
/*

        while (lt < rt){
            if (chars[lt] == chars[rt]){
                chars[rt] = 0;
                rt--;
            }
            else rt--;

            if(lt + 1 == rt) {
                lt++;
                rt = chars.length - 1;
            }
        }

        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= 0x61 && chars[i] <= 0x7A) {
                returnString += chars[i];
            }
        }
*/

        return returnString;
    }

    //1-5 특정 문자 뒤집기
    public static String reverseSpecWord(String line){
        char[] chars = line.toCharArray();
        int lt = 0;
        int rt = chars.length - 1;

        while (lt < rt){
/*            if((chars[lt] >= 0x41 && chars[lt] <= 0x5A)
                    || (chars[lt] >= 0x61 && chars[lt] <= 0x7A)) {
                tmp = chars[lt];

                if((chars[rt] >= 0x41 && chars[rt] <= 0x5A)
                        || (chars[rt] >= 0x61 && chars[rt] <= 0x7A)) {
                    chars[lt] = chars[rt];
                    lt++;
                }
            } else {
                lt++;
            }

            if((chars[rt] >= 0x41 && chars[rt] <= 0x5A)
                    || (chars[rt] >= 0x61 && chars[rt] <= 0x7A)) {
                chars[rt] = tmp;
                if((chars[lt] >= 0x41 && chars[lt] <= 0x5A)
                        || (chars[lt] >= 0x61 && chars[lt] <= 0x7A)) {
                    rt--;
                    tmp = 0;
                }
            } else{
                rt--;
            }*/
            if(!Character.isAlphabetic(chars[lt])){
                lt++;
            } else if(!Character.isAlphabetic(chars[rt])){
                rt--;
            }else {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt]= tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(chars);
    }

    //1-4 단어 뒤집기
    public static ArrayList<String> reverseWords(String[] words){
//       ArrayList<String> stringArrayList = new ArrayList<>();
//
//        for(int i = 0; i < words.length; i++){
//           StringBuffer sb = new StringBuffer(words[i]);
//           stringArrayList.add(sb.reverse().toString());
//       }

        ArrayList<String> stringArrayList = new ArrayList<>();

       for (String s : words){
           char[] chars = s.toCharArray();
           int lt = 0;
           int rt = s.length() - 1;
           while (lt < rt){
               char tmp = chars[lt];
               chars[lt] = chars[rt];
               chars[rt] = tmp;
               lt++;
               rt--;
           }

           stringArrayList.add(String.valueOf(chars));
       }

       return stringArrayList;
    }

    //1-3 문장 속 단어
    public static String findLongestWord(String line){
        String[] words = line.split(" ");
        int index = 0;
        int length = words[0].length();

        for (int i = 0; i < words.length - 1; i++){
            if(length < words[i + 1].length())
                index = i + 1;

        }

        return words[index];
    }

    //1-2 대소문자 변환
    public static String changeUpperLowerCase(String line){
//        char[] returnChar = new char[line.length()];
//
//        for (int i = 0; i < returnChar.length; i++){
//            char c = line.charAt(i);
//
//            if(Character.isUpperCase(c))
//                returnChar[i] = Character.toLowerCase(c);
//            else if(Character.isLowerCase(c))
//                returnChar[i] = Character.toUpperCase(c);
//        }

        String returnString = "";
        for(char c: line.toCharArray()){
            if(Character.isUpperCase(c))
                returnString += Character.toLowerCase(c);
            else if(Character.isLowerCase(c))
                returnString += Character.toUpperCase(c);
        }

        return returnString;
    }

    //1-1 문자 찾기
    public static int findAlphabet(String line1, char c){
        line1 = line1.toUpperCase();
        char specialChar = Character.toUpperCase(c);
        int count = 0;

//        for(int i = 0; i < line1.length(); i++){
//            if(line1.charAt(i) == specialChar)
//                count++;
//        }

        for(char x : line1.toCharArray()){
            if(x == specialChar)
                count++;
        }

        return count;
    }

    public static void findWord(String line){
        String[] lines = line.split(" ");
        int count = 0;

        for(String s: lines){
            if(s.equals("") != true)
                count++;

        }

        System.out.println(count);
    }


    public static void findAlphabetNum(String line){
        int[] alphabetNums = new int[26];
        int bigAlphabetNum = 0;
        char bigAlphabet = 0;


        for (int i = 0; i < line.length(); i++){
            char alphabet = (Character.isUpperCase(line.charAt(i)) == true)? Character.toLowerCase(line.charAt(i)) : line.charAt(i);
            alphabetNums[alphabet - 'a']++;
        }

        for(int i = 0; i < alphabetNums.length; i++){
            if(bigAlphabetNum < alphabetNums[i]) {
                bigAlphabetNum = alphabetNums[i];
                bigAlphabet = (char)(i + 'A');
            }
            else if(bigAlphabetNum == alphabetNums[i]){
                bigAlphabet = '?';
            }
            else {

            }
        }

        System.out.println(bigAlphabet);
    }

    public static void newAverage(String line, String scoreString) throws IOException {


        int scoreNum = Integer.parseInt(line);
        String[] scoreStrings = scoreString.split(" ");
        int[] scoreNums = new int[scoreNum];
        int bigNum = 0;
        float result = 0;

        for(int i = 0; i < scoreNum; i++){
            scoreNums[i] = Integer.parseInt(scoreStrings[i]);
            if(bigNum < scoreNums[i])
                bigNum = scoreNums[i];
        }

        for(int i = 0; i < scoreNum; i++){
            result += (((float)scoreNums[i] / bigNum) * 100);
        }

        System.out.println(result / scoreNum);
    }
}