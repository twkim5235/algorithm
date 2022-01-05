import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


//class Player implements Comparable<Player>{
//    int height;
//    int weight;
//
//    public Player(int height, int weight) {
//        this.height = height;
//        this.weight = weight;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    @Override
//    public int compareTo(Player o) {
//        return o.height - this.height;
//    }
//}

//class Node{
//    public int num;
//    public Node nextNode;
//
//    public Node(int num) {
//        this.num = num;
//        this.nextNode = null;
//    }
//
//    public Node(int num, Node nextNode) {
//        this.num = num;
//        this.nextNode = nextNode;
//    }
//}

class Doc {
    int severity;
    int num;

    public Doc(int severity, int num) {
        this.severity = severity;
        this.num = num;
    }
}

class ZeroOne {
    int zeroCnt;
    int oneCnt;

    public ZeroOne() {
    }

    public ZeroOne(int zeroCnt, int oneCnt) {
        this.zeroCnt = zeroCnt;
        this.oneCnt = oneCnt;
    }
}

class Node {
    int data;
    Node rt;
    Node lt;

    public Node(int data) {
        this.data = data;
        rt = null;
        lt = null;
    }
}

class Location {
    int st;
    int end;

    public Location(int st, int end) {
        this.st = st;
        this.end = end;
    }
}

public class Main {

    static int[] coins;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }

        T.solution(N, K);
    }

    //백준 11047 문제풀이 동전
    public void solution(int N, int K) {
        int restMoney = K;
        int coinCount = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (restMoney / coins[i] > 0) {
                coinCount += restMoney / coins[i];
                restMoney = restMoney % coins[i];
            }
        }

        System.out.println(coinCount);
    }

    //백준 1931번 문제풀이 회의실 배정
//    public void solution(int N) {
//        Arrays.sort(meetingTime, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1] == o2[1]) {
//                    return o1[0] - o2[0];
//                }
//                return o1[1] - o2[1];
//            }
//        });
//
//        int count = 0;
//        int prevEndTime = 0;
//
//        for (int i = 0; i < N; i++) {
//            if (prevEndTime <= meetingTime[i][0]) {
//                prevEndTime = meetingTime[i][1];
//                count++;
//            }
//        }
//
//        System.out.println(count);
//    }

    //백준 1780번 문제풀이 종이의 개수
//    public void solution(int j, int k, int size) {
//        if (checkColor(j, k, size)) {
//            switch (graph[j][k]) {
//                case -1:
//                    minusOne++;
//                    break;
//                case 0:
//                    zero++;
//                    break;
//                case 1:
//                    one++;
//                    break;
//            }
//            return;
//        }
//
//        int newSize = size / 3;
//        for (int i = 0; i < 9; i++) {
//            if(i / 3 == 0){
//                switch (i % 3) {
//                    case 0:
//                        solution(j, k, newSize);
//                        break;
//                    case 1:
//                        solution(j, k + newSize, newSize);
//                        break;
//                    case 2:
//                        solution(j, k + newSize * 2, newSize);
//                        break;
//                }
//            } else if(i / 3 == 1){
//                switch (i % 3) {
//                    case 0:
//                        solution(j + newSize, k, newSize);
//                        break;
//                    case 1:
//                        solution(j + newSize, k + newSize, newSize);
//                        break;
//                    case 2:
//                        solution(j + newSize, k + newSize * 2, newSize);
//                        break;
//                }
//            } else if(i / 3 == 2){
//                switch (i % 3) {
//                    case 0:
//                        solution(j + newSize * 2, k, newSize);
//                        break;
//                    case 1:
//                        solution(j + newSize * 2, k + newSize, newSize);
//                        break;
//                    case 2:
//                        solution(j + newSize * 2, k + newSize * 2, newSize);
//                        break;
//                }
//            }
//        }
//
//    }
//
//    public boolean checkColor(int j, int k, int size) {
//        int color = graph[j][k];
//
//        for (int i = j; i < j + size; i++) {
//            for (int l = k; l < k + size; l++) {
//                if(color != graph[i][l]) return false;
//            }
//        }
//
//        return true;
//    }

    //백준 1541번 문제풀이 잃어버린 괄호
//    public void solution(String expression) {
//        StringTokenizer st;
//        int result = 0;
//        boolean flag = true;
//
//        if(expression.contains("-")){
//            st = new StringTokenizer(expression, "-");
//            while (st.hasMoreTokens()) {
//                String[] plusNums = st.nextToken().split("\\+");
//                int num = 0;
//                for (int i = 0; i < plusNums.length; i++) {
//                    num += Integer.parseInt(plusNums[i]);
//                }
//                if (flag == true) {
//                    result = num;
//                    flag = false;
//                }else {
//                    result -= num;
//                }
//            }
//        }else {
//            st = new StringTokenizer(expression, "+");
//            while (st.hasMoreTokens()) {
//                result += Integer.parseInt(st.nextToken());
//            }
//        }
//
//        System.out.println(result);
//    }

    //백준 1012 문제풀이 유기농 배추
//    public void solution(int j, int k) {
//        ch[j][k] = 1;
//
//        for (int i = 0; i < 4; i++) {
//            int nr = j + dr[i];
//            int nc = k + dc[i];
//            if (nr >= 0 && nc >= 0 && nr < graph.length && nc < graph[0].length) {
//                if (graph[nr][nc] == 1 && ch[nr][nc] == 0) {
//                    solution(nr, nc);
//                }
//            }
//        }
//    }

    //백준 9095 문제풀이 1, 2, 3 더하기
//    public void solution(int num) {
//        if(num == 0) {
//            cnt++;
//            return;
//        }else {
//            for (int i = 1; i <= 3; i++) {
//                int j = num - i;
//                if (j >= 0) {
//                    solution(j);
//                }else {
//                    return;
//                }
//            }
//        }
//    }

    //백준 2630번 문제풀이 색종이 만들기
//    public void solution(int row, int col, int size) {
//
//        if (checkColor(row, col, size)) {
//            if(graph[row][col] == 1) blue++;
//            else white++;
//            return;
//        }
//
//        int newSize = size / 2;
//
//        solution(row, col, newSize); //2사분면
//        solution(row, col + newSize, newSize); //1사분면
//        solution(row + newSize, col, newSize); //3사분면
//        solution(row + newSize, col + newSize, newSize); //4사분면
//    }
//
//    public boolean checkColor(int row, int col, int size) {
//        int color = graph[row][col]; //첫 번째 원소를 기준으로 검사
//
//        for (int i = row; i < row + size; i++) {
//            for (int j = col; j < col + size; j++) {
//                int checkColor = graph[i][j];
//                if(color != checkColor) return false;
//            }
//        }
//
//        return true;
//    }

    //백준 2606번 문제풀이 웜 바이러스
//    public void solutionBFS(int num) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(num);
//        int cnt = 0;
//
//        while (!queue.isEmpty()) {
//            int queSize = queue.size();
//            for (int i = 0; i < queSize; i++) {
//                int nx = queue.poll();
//                for (int j = 1; j < graph.length; j++) {
//                    if (graph[nx][j] == 1 && ch[j] == 0) {
//                        ch[j] = 1;
//                        queue.offer(j);
//                        cnt++;
//                    }
//                }
//            }
//        }
//
//        System.out.println(cnt);
//    }
//
//    public void solutionDFS(int num) {
//        for (int i = 1; i < graph.length; i++) {
//            if (graph[num][i] == 1 && ch[i] == 0) {
//                cnt++;
//                ch[i] = 1;
//                solutionDFS(i);
//            }
//        }
//    }

    //백준 2579번 계단 오르기 문제풀이
//    public int solution(int num) {
//        if (dp[num] == null) {
//            dp[num] = Math.max(solution(num - 2), solution(num - 3) + stairs[num - 1]) + stairs[num];
//        }
//
//        return dp[num];
//    }

    //백준 1260번 문제풀이 DFS BFS
//    public void DFS(int num) {
//        for (int i = 1; i <= N; i++) {
//            if (graph[num][i] == 1 && ch[i] == 0) {
//                ch[i] = 1;
//                System.out.print(i + " ");
//                DFS(i);
//            }
//        }
//    }
//
//    public void BFS(int num) {
//        Queue<Integer> queue = new LinkedList();
//        queue.offer(num);
//        ch[num] = 1;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Integer nx = queue.poll();
//                System.out.print(nx + " ");
//                for (int j = 1; j <= N; j++) {
//                    if (graph[nx][j] == 1 && ch[j] == 0) {
//                        ch[j] = 1;
//                        queue.offer(j);
//                    }
//                }
//            }
//        }
//    }

    //백준 1463번 문제풀이 1로 만들기 (재귀)
//    public int solution(int N) {
//        if (dp[N] == null) {
//            if (N % 6 == 0) {
//                dp[N] = Math.min(Math.min(solution(N / 2), solution(N / 3)), solution(N - 1)) + 1;
//            } else if (N % 3 == 0) {
//                dp[N] = Math.min(solution(N / 3), solution(N - 1)) + 1;
//            } else if (N % 2 == 0) {
//                dp[N] = Math.min(solution(N / 2), solution(N - 1)) + 1;
//            } else {
//                dp[N] = solution(N - 1) + 1;
//            }
//        }
//        return dp[N];
//    }

    //백준 1003번 문제풀이 피보나치 함수 (재귀)
//    public ZeroOne solution(int num) {
//        if (zeroOnes[num] != null) {
//            return zeroOnes[num];
//        }
//        if (num == 0) {
//            zeroOnes[num] = new ZeroOne(1, 0);
//        } else if (num == 1) {
//            zeroOnes[num] = new ZeroOne(0, 1);
//        } else {
//            if(zeroOnes[num] == null) zeroOnes[num] = new ZeroOne();
//            zeroOnes[num].zeroCnt = solution(num - 1).zeroCnt + solution(num - 2).zeroCnt;
//            zeroOnes[num].oneCnt = solution(num - 1).oneCnt + solution(num - 2).oneCnt;
//        }
//        return zeroOnes[num];
//    }

    //백준 17219번 문제풀기 비밀번호 찾기
//    public void solution(int N, int M, BufferedReader bf) throws IOException {
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        Map<String, String> sitePassword = new HashMap<>();
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(bf.readLine(), " ");
//            sitePassword.put(st.nextToken(), st.nextToken());
//        }
//
//        for (int i = 0; i < M; i++) {
//            String password = sitePassword.get(bf.readLine());
//            sb.append(password).append("\n");
//        }
//
//        System.out.println(sb);
//    }

    // 백준 1764번 문제풀이 듣보잡 (Hashset 사용)
//    public void solution(HashSet<String> listeners, String[] watchers) {
//        Arrays.sort(watchers);
//        ArrayList<String> listenWatchers = new ArrayList<>();
//        int cnt = 0;
//
//        for (String watcher : watchers) {
//            if (listeners.contains(watcher)) {
//                cnt++;
//                listenWatchers.add(watcher);
//            }
//        }
//
//        System.out.println(cnt);
//        for (String listenWatcher : listenWatchers) {
//            System.out.println(listenWatcher);
//        }
//    }

    //백준 1676번 문제풀이 팩토리얼 0의 개수
//    public void solution(int N) {
//        int cnt = 0;
//
//        while (N >= 5) {
//            cnt += N / 5;
//            N /= 5;
//        }
//
//        System.out.println(cnt);
//    }

    //백준 1929번 문제풀이 소수 구하기
//    public void solution(int N, int M) {
//        int[] nums = new int[M + 1];
//        StringBuilder sb = new StringBuilder();
//        for (int i = 2; i <= M; i++) {
//            if (i >= N && i <= M && nums[i] == 0) {
//                sb.append(i).append("\n");
//            }
//
//            for (int j = i; j <= M; j += i) {
//                if(nums[j] == 0) nums[j] = 1;
//            }
//        }
//
//        System.out.println(sb);
//    }


    //백준 1874번 스택 수열 풀이
//    public void solution() throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(bf.readLine());
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < N; i++) {
//            int num = Integer.parseInt(bf.readLine());
//
//            int j;
//            if(num >= start) {
//                for (j = start; j <= num; j++) {
//                    stack.push(j);
//                    sb.append("+").append("\n");
//                }
//                start = j;
//            }
//
//            if (stack.peek() == num) {
//                sb.append("-").append("\n");
//                stack.pop();
//            }else {
//                if (start > num) {
//                    System.out.println("NO");
//                    return;
//                }
//            }
//        }
//
//        System.out.println(sb);
//    }

    //백준 1966번 문제풀이 프린터 큐
//    public int solution(int paperNum, int cnt, Queue<Doc> docs) {
//        int answer = 0;
//        while (!docs.isEmpty()) {
//            Doc doc = docs.poll();
//            for (Doc compareDoc : docs) {
//                if (doc.severity < compareDoc.severity) {
//                    docs.offer(doc);
//                    doc = null;
//                    break;
//                }
//            }
//
//            if (doc != null) {
//                answer++;
//                if(doc.num == cnt){
//                    return answer;
//                }
//
//            }
//        }
//        return -1;
//    }

    // 백준 2805번 나무자르기 이분검색
//    public void solution(int M) {
//        long min = 0;
//        long mid = 0;
//
//        while (min < max) {
//            mid = (min + max) / 2;
//            long length = 0;
//
//            for (int i = 0; i < trees.length; i++) {
//                if (trees[i] > mid) {
//                    length += (trees[i] - mid);
//                }
//            }
//
//            if (length < M) {
//                max = mid;
//            }else {
//                min = mid + 1;
//            }
//        }
//
//        System.out.println(min - 1);
//    }

    //백준 1654번 랜선자르기
//    public void solution(int K, int N) {
//        long min = 0;
//        long mid = 0;
//        while (min < max) {
//            mid = (min + max) / 2;
//
//            long count = 0;
//            for (int i = 0; i < K; i++) {
//                count += lines[i] / mid;
//            }
//
//            if (count < N) {
//                max = mid;
//            }else {
//                min = mid + 1;
//            }
//        }
//
//        System.out.println(min - 1);
//    }

    //백준 1920번 수 찾기
//    public void solution(int N, int[] nNums, int M, int[] mNums) {
//        StringBuilder sb = new StringBuilder();
//
//        Arrays.sort(nNums);
//
//        for (int mNum : mNums) {
//            if (searchBinary(nNums, mNum) >= 0) sb.append(1).append("\n");
//            else sb.append(0).append("\n");
//        }
//
//        System.out.println(sb);
//    }
//
//    public int searchBinary(int[] nNums, int mNum) {
//        int lt = 0;
//        int rt = nNums.length - 1;
//
//        while (lt <= rt) {
//            int mid = (lt + rt) / 2;
//
//            if (mNum > nNums[mid]) {
//                lt = mid + 1;
//            } else if (mNum < nNums[mid]) {
//                rt = mid - 1;
//            } else{
//                return mid;
//            }
//        }
//
//        return -1;
//    }

    //백준 1978번 소수 찾기
//    public void solution(int N, int[] nums) {
//        int cnt = 0;
//        for (int i = 0; i < N; i++) {
//            boolean isPrime = true;
//
//            int num = nums[i];
//            if(num == 1) continue;
//            ;
//            for (int j = 2; j <= Math.sqrt(num); j++) {
//                if(num % j == 0){
//                    isPrime = false;
//                    break;
//                }
//            }
//
//            if(isPrime) cnt++;
//        }
//
//        System.out.println(cnt);
//    }

    //백준 18111번 마인크래프트
//    public void solution(int width, int vertical, int inventory, int[][] map, int min, int max) {
//        int time = Integer.MAX_VALUE;
//        int height = Integer.MIN_VALUE;
//
//        for (int i = min; i <= max; i++) {
//            int tempTime = 0;
//            int tempInventory = inventory;
//
//            for (int j = 0; j < width; j++) {
//                for (int k = 0; k < vertical; k++) {
//                    if(map[j][k] > i) {
//                        int num = map[j][k] - i;
//                        tempTime += num * 2;
//                        tempInventory += num;
//                    } else if (map[j][k] < i) {
//                        int num = i - map[j][k];
//                        tempTime += num;
//                        tempInventory -= num;
//                    }
//                }
//            }
//
//            if(tempInventory >= 0) {
//                time = Math.min(time, tempTime);
//                if (tempTime == time) {
//                    height = Math.max(height, i);
//                }
//            }
//        }
//
//        System.out.println(time + " " + height);
//    }

    //백준 2108번 통계학
//    public void solution() throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int sum = 0;
//        int mid = 0;
//        int mode = 0;
//        int N = Integer.parseInt(bf.readLine());
//        int[] nums = new int[N];
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < N; i++) {
//            int num = Integer.parseInt(bf.readLine());
//            nums[i] = num;
//            sum += num;
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        int max = 0;
//        ArrayList<Integer> maxKeyList = new ArrayList<>();
//        for (Integer integer : map.keySet()) {
//            max = Math.max(max, map.get(integer));
//        }
//
//        for (Integer integer : map.keySet()) {
//            if (max == map.get(integer)) {
//                maxKeyList.add(integer);
//            }
//        }
//
//        Collections.sort(maxKeyList);
//
//        if (maxKeyList.size() > 1) {
//            mode = maxKeyList.get(1);
//        } else {
//            mode = maxKeyList.get(0);
//        }
//
//        Arrays.sort(nums);
//
//        System.out.println((int) Math.round((double) sum / N));
//        System.out.println(nums[N / 2]);
//        System.out.println(mode);
//        System.out.println(nums[N - 1] - nums[0]);
//
//    }

    //백준 2164번 카드2
//    public void solution(int num) {
//        Queue<Integer> queue = new LinkedList<>();
//
//        for (int i = 1; i <= num; i++) {
//            queue.offer(i);
//        }
//
//        while (queue.size() != 1) {
//            queue.poll();
//            queue.offer(queue.poll());
//        }
//
//        System.out.println(queue.poll());
//    }

    //백준 4949번 균형잡힌 세상
//    public void solution(String string) {
//        Stack<Character> stack = new Stack();
//        String answer = "yes";
//        for (int i = 0; i < string.length(); i++) {
//            if (string.charAt(i) == '(' || string.charAt(i) == '[') {
//                stack.push(string.charAt(i));
//            } else if (string.charAt(i) == ')') {
//                if(stack.isEmpty() || stack.peek() == '[') {
//                    answer = "no";
//                    break;
//                }else if (stack.peek() == '(') {
//                    stack.pop();
//                }
//            } else if (string.charAt(i) == ']') {
//                if(stack.isEmpty() || stack.peek() == '('){
//                    answer = "no";
//                    break;
//                }else if (stack.peek() == '[') {
//                    stack.pop();
//                }
//            }
//        }
//        if(!stack.isEmpty()) answer = "no";
//
//        System.out.println(answer);
//    }

    //백준 9012번 괄호
//    public void solution(String[] brackets) {
//        for (int i = 0; i < brackets.length; i++) {
//            String bracket = brackets[i];
//            String answer = "YES";
//            Stack<String> stack = new Stack();
//
//            String[] split = bracket.split("");
//            for (int j = 0; j < split.length; j++) {
//                String st = split[j];
//                if (st.equals("(")) {
//                    stack.push(st);
//                }else {
//                    if(stack.isEmpty()) {
//                        answer = "NO";
//                        break;
//                    }else {
//                        if(stack.peek().equals("(")) {
//                            stack.pop();
//                        }
//                    }
//                }
//            }
//            if(!stack.isEmpty()) answer = "NO";
//
//            System.out.println(answer);
//        }
//    }

    // 백준 10773번 제로(스택)
//    public void solution(BufferedReader bf,int N, Stack<Integer> stack) throws IOException {
//
//        for (int i = 0; i < N; i++) {
//            int num = Integer.parseInt(bf.readLine());
//            if (num == 0) stack.pop();
//            else stack.push(num);
//        }
//
//        int result = 0;
//        for (Integer integer : stack) {
//            result += integer;
//        }
//
//        System.out.println(result);
//    }

    //백준 10816번 숫자카드2
//    public void solution(int N, int M, int[] sangNums, int[] cardNums, Map<Integer, Integer> map) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < N; i++) {
//            if(map.containsKey(sangNums[i])) map.put(sangNums[i], map.getOrDefault(sangNums[i], 0) + 1);
//        }
//
//        for (int i = 0; i < M; i++) {
//            if(i == M-1) sb.append(map.get(cardNums[i]));
//            else sb.append(map.get(cardNums[i])).append(" ");
//
//        }
//
//        System.out.println(sb);
//    }

    //백준 10828번 스택
//    public void solution(Stack stack, String[] strings) {
//        String command = strings[0];
//
//        Integer num;
//        switch (command) {
//            case "push":
//                num = Integer.parseInt(strings[1]);
//                stack.push(num);
//                break;
//            case "pop":
//                System.out.println(stack.pop());
//                break;
//            case "size":
//                System.out.println(stack.size());
//                break;
//            case "empty":
//                System.out.println(stack.empty());
//                break;
//            case "top":
//                System.out.println(stack.top());
//                break;
//        }
//    }
//
//    static class Stack{
//        Node head;
//        Node top;
//        int size;
//
//        public Stack() {
//            top = null;
//            size = 0;
//        }
//
//        public void push(int data) {
//            Node node = new Node(data);
//            if(top == null) top = node;
//            else {
//                top.nextNode = node;
//                top = top.nextNode;
//            }
//
//            if(head == null) head = top;
//            size++;
//        }
//
//        public int pop() {
//            if(size == 0) return -1;
//
//            int num = top.num;
//
//            Node temp = head;
//            if(temp == top){
//                head = null;
//            }else {
//                while (temp.nextNode != top) {
//                    temp = temp.nextNode;
//                }
//                top = temp;
//            }
//
//            size--;
//            return num;
//        }
//
//        public int size() {
//            return size;
//        }
//
//        public int empty() {
//            if(size == 0) return 1;
//            return 0;
//        }
//
//        public int top() {
//            if(size == 0) return -1;
//            else return top.num;
//        }
//    }

    //백준 10845번 큐
//    public void solution(Queue queue, String[] strings) {
//        String command = strings[0];
//
//        Integer num = 0;
//        switch (command) {
//            case "push":
//                num = Integer.parseInt(strings[1]);
//                queue.push(num);
//                break;
//            case "pop":
//                num = queue.pop();
//                System.out.println(num);
//                break;
//            case "size":
//                System.out.println(queue.size);
//                break;
//            case "empty":
//                System.out.println(queue.empty());
//                break;
//            case "front":
//                System.out.println(queue.front());
//                break;
//            case "back":
//                System.out.println(queue.back());
//                break;
//        }
//    }
//
//    static class Queue {
//        Node head;
//        Node tail;
//        int size = 0;
//
//        public Queue() {
//            this.head = null;
//            this.tail = null;
//            this.size = 0;
//        }
//
//        public void push(int data) {
//            Node node = new Node(data);
//            if(tail == null) tail = node;
//            else {
//                tail.nextNode = node;
//                tail = tail.nextNode;
//            }
//
//            if(head == null) head = tail;
//            size++;
//        }
//
//        public int pop() {
//            if(size == 0) return -1;
//            Node temp = head.nextNode;
//            int num = head.num;
//            head = null;
//            head = temp;
//            size--;
//            return num;
//        }
//
//        public int size() {
//            return size;
//        }
//
//        public int empty() {
//            if(size == 0) return 1;
//            return 0;
//        }
//
//        public int front() {
//            if(size == 0) return -1;
//            return head.num;
//        }
//
//        public int back() {
//            if(size == 0) return -1;
//            return tail.num;
//        }
//    }


    //백준 10866번 덱 문제
//    public void solution(Deque<Integer> deque, String[] strings) {
//        String command = strings[0];
//        Integer num = 0;
//        switch (command) {
//            case "push_front":
//                num = Integer.parseInt(strings[1]);
//                deque.addFirst(num);
//                break;
//            case "push_back":
//                num = Integer.parseInt(strings[1]);
//                deque.addLast(num);
//                break;
//            case "pop_front":
//                if(deque.isEmpty()) System.out.println(-1);
//                else System.out.println(deque.pollFirst());
//                break;
//            case "pop_back":
//                if(deque.isEmpty()) System.out.println(-1);
//                else System.out.println(deque.pollLast());
//                break;
//            case "size":
//                System.out.println(deque.size());
//                break;
//            case "empty":
//                if(deque.isEmpty()) System.out.println(1);
//                else System.out.println(0);
//                break;
//            case "front":
//                if(deque.isEmpty()) System.out.println(-1);
//                else System.out.println(deque.getFirst());
//                break;
//            case "back":
//                if(deque.isEmpty()) System.out.println(-1);
//                else System.out.println(deque.getLast());
//                break;
//        }
//    }

    //백준 11866번 요세푸스문제 큐
//    public void solution(Queue<Integer> queue, int K) {
//        int cnt = 0;
//        StringBuilder sb = new StringBuilder();
//        sb.apend("<");
//        while (queue.size() != 0) {
//            int num = queue.poll();
//            cnt++;
//            if (cnt == K) {
//                if (queue.size() != 0) {
//                    sb.append(num).append(", ");
//                }else {
//                    sb.append(num).append(">");
//                }
//                cnt = 0;
//            }else {
//                queue.offer(num);
//            }
//        }
//
//        System.out.println(sb);
//    }

    //백준 11650번 좌표정렬하기 문제풀이
//    static class Point implements Comparable<Point>{
//        int x;
//        int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public int compareTo(Point o) {
//            if(this.x > o.x) {
//                return 1;
//            } else if(this.x == o.x){
//                if(this.y > o.y) return 1;
//                else return -1;
//            } else return -1;
//        }
//    }


    //백준 1018번 체스판 다시칠하기 문제풀이
//    public void solution(int N, int M, Boolean[][] map) {
//        //경우의 수
//        int N_row = N - 7;
//        int M_row = M - 7;
//
//        for (int i = 0; i < N_row; i++) {
//            for (int j = 0; j < M_row; j++) {
//                find(i, j);
//            }
//        }
//
//        System.out.println(min);
//    }
//
//    public void find(int x, int y) {
//        int end_x = x + 8;
//        int end_y = y + 8;
//        int cnt = 0;
//
//        boolean TF = map[x][y]; //첫 번재 칸의 색
//
//        for (int i = x; i < end_x; i++) {
//            for (int j = y; j < end_y; j++) {
//                if (map[i][j] != TF) {
//                    cnt++;
//                }
//
//                //다음 칸에 색이 바뀌므로 toggle
//                TF = (!TF);
//            }
//            //줄마다 색이 바뀌므로 toggle
//            TF = !TF;
//        }
//
//        cnt = Math.min(cnt, 64 - cnt);
//
//        min = Math.min(min, cnt);
//    }

    //백준 10841번 나이순 정렬
//    public void solution(Person[] people) {
//        StringBuilder sb = new StringBuilder();
//        Person key;
//
//        Arrays.sort(people);
//
//        for (Person person : people) {
//            sb.append(person.age).append(" ").append(person.name).append("\n");
//        }
//
//        System.out.println(sb);
//    }
//
//    static class Person implements Comparable<Person>{
//        int age;
//        String name;
//
//        public Person(int age, String name) {
//            this.age = age;
//            this.name = name;
//        }
//
//        @Override
//        public int compareTo(Person o) {
//            return this.age - o.age;
//        }
//    }


    //백준 7568문제 풀이 덩치 - 브루트포스
//    public void solution(Person[] people) {
//        StringBuilder sb = new StringBuilder();
//
//        int max = Integer.MIN_VALUE;
//        int cnt = 1;
//
//        for (Person person : people) {
//            int rank = 1;
//
//            for (Person comPerson : people) {
//                if (person == comPerson) continue;
//
//                if (person.weight < comPerson.weight && person.height < comPerson.height) {
//                    rank++;
//                }
//            }
//            sb.append(rank).append(" ");
//        }
//
//
//        System.out.println(sb);
//    }
//
//    static class Person {
//        int weight;
//        int height;
//
//        public Person(int weight, int height) {
//            this.weight = weight;
//            this.height = height;
//        }
//
//        @Override
//        public String toString() {
//            return "Person{" +
//                    "weight=" + weight +
//                    ", height=" + height +
//                    '}';
//        }
//    }


    //백준 2751 수정렬하기 2번
//    public void solution(ArrayList<Integer> nums) {
//        StringBuilder sb = new StringBuilder();
//
//        Collections.sort(nums);
//
//        for (Integer num : nums) {
//            sb.append(num).append("\n");
//        }
//
//        System.out.println(sb);
//    }


    //백준 2609 최대공약수, 최소공배수
//    public void solution(int num1, int num2) {
//        //내가 풀은 풀이 시간초과로 틀림
//        /*
//        int comFactor = 0;
//        int comMultiple = 0;
//        int cnt = 2;
//        boolean factorFlag = false;
//        while (true) {
//            if (num1 % cnt == 0 && num2 % cnt == 0) {
//                num1 /= cnt;
//                num2 /= cnt;
//                if(comFactor != 0) comFactor *= cnt;
//                else comFactor = cnt;
//
//                if (num1 == 1 || num2 == 1) {
//                    factorFlag = true;
//                }else if(num1 <= cnt || num2 <= cnt){
//                    factorFlag = true;
//                }
//            }else {
//                cnt++;
//            }
//
//            if (factorFlag == true) {
//                comMultiple = num1 * num2 * comFactor;
//                System.out.println(comFactor);
//                System.out.println(comMultiple);
//                break;
//            }
//        }*/
//
//        //예제 풀이 GCD 공식을 사용 GCD(A,B) = GCD(B,R(A % B)) 의 최대 공약수는 같다.
//        int numA = num1;
//        int numB = num2;
//        while (num2 != 0) {
//            int r = num1 % num2;
//            num1 = num2;
//            num2 = r;
//        }
//        System.out.println(num1);
//        System.out.println((numA / num1) * (numB/num1) * num1);
//    }


    //백준 1436번 영화감독 숌 풀이
//    public void solution(int num) {
//        int endNum = 666;
//        int count = 1;
//
//        while (count != num) {
//            endNum++;
//
//            if (String.valueOf(endNum).contains("666")) {
//                count++;
//            }
//        }
//
//        System.out.println(endNum);
//    }


    //백준 1181번 단어의 정렬 문제
//    public void solution(int num, String[] words) {
//
//        Arrays.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                if(s1.length() == s2.length()) {
//                    return s1.compareTo(s2); //사전 순
//                }else {
//                    return s1.length() - s2.length(); //길이 순
//                }
//
//            }
//        });
//
//        System.out.println(words[0]);
//
//        for (int i = 1; i < num; i++) {
//            // 중복되지 않는 단어만 출력
//            if (!words[i].equals(words[i - 1])) {
//                System.out.println(words[i]);
//            }
//        }
//    }

//    //씨름선수(그리디 알고리즘)
//    public void solution(int playerNum, List<Player> players) {
//        int max = Integer.MIN_VALUE;
//        int cnt = 0;
//
//        Collections.sort(players);
//        for (int i = 0; i < players.size(); i++) {
//            if(players.get(i).weight > max){
//                cnt++;
//                max = players.get(i).weight;
//            }
//        }
//
//        System.out.println(cnt);
//    }


    //백준 1259번 팰린드롬수
//    public void solution(BufferedReader bf) throws IOException {
//        while (true) {
//            String answer = "yes";
//            String num = bf.readLine();
//            if(num.equals("0")) break;
//
//            int length = num.length() - 1;
//            for (int i = 0; i < num.length() / 2; i++) {
//                if (num.charAt(i) != num.charAt(length - i)) {
//                    answer = "no";
//                    break;
//                }
//            }
//
//            System.out.println(answer);
//        }
//    }

    //백준 2577번
//    public void solution(Integer num) {
//        Map<Integer, Integer> numMap = new HashMap<>();
//        while (num != 0) {
//            numMap.put(num % 10, numMap.getOrDefault(num % 10, 0) + 1);
//            num /= 10;
//        }
//
//        for (int i = 0; i < 10; i++) {
//            if(numMap.containsKey(i)) System.out.println(numMap.get(i));
//            else System.out.println(0);
//        }
//    }

//    백준 2869번
//    public void solution(int a, int b, int v) {
//        double sum = 0;
//        int count = 0;
//
//        count = (v - b) / (a - b);
//        if ((v - b) % (a - b) != 0) {
//            count++;
//        }
//
//
//        System.out.println(count);
//    }

//    백준 1924번
//    public String solution(int n, int m) {
//
//        int[] month = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        int sum = 0;
//        String answer = "";
//
//        if (n > 1) {
//            for (int i = 0; i < n - 1; i++) {
//                sum += month[i];
//            }
//        }
//
//        sum += m;
//        switch (sum % 7) {
//            case 0:
//                answer = "SUN";
//                break;
//            case 1:
//                answer = "MON";
//                break;
//            case 2:
//                answer = "TUE";
//                break;
//            case 3:
//                answer = "WED";
//                break;
//            case 4:
//                answer = "THU";
//                break;
//            case 5:
//                answer = "FRI";
//                break;
//            case 6:
//                answer = "SAT";
//                break;
//        }
//
//        return answer;
//    }

//    public void solution(int n, String[] lines) {
//        for (int i = 0; i < n; i++) {
//            String[] s = lines[i].split(" ");
//            int sum = 0;
//            int num = Integer.parseInt(s[0]);
//            for (int j = 1; j < s.length; j++) {
//                sum += Integer.parseInt(s[j]);
//            }
//            int avg = sum / num;
//            int cnt = 0;
//            for (int j = 1; j < s.length; j++) {
//                if (avg < Integer.parseInt(s[j])) {
//                    cnt++;
//                }
//            }
//
//            float ratio = (float) cnt / num * 100;
//            System.out.println(String.format("%.3f", ratio) + "%");
//        }
//    }

//    //오늘의 집 코테2
//    public int solution2(String str) {
//        int answer = 0;
//        int length = str.length();
//        boolean[] colorCheck = new boolean[str.length()];
//        String check = "";
//
//        for (int i = 0; i < length; i++) {
//            if (str.charAt(i) == 'o' && colorCheck[i] == false) {
//                check += str.charAt(i);
//                colorCheck[i] = true;
//                int j;
//                for (j = i + 1; j < length; j++) {
//                    if(str.charAt(i) != str.charAt(j) && colorCheck[j] == false){
//                        colorCheck[j] = true;
//                        check += str.charAt(j);
//                        break;
//                    }
//                }
//
//                for (int k = length - 1; k > j; k--) {
//                    if(str.charAt(j) != str.charAt(k) && colorCheck[k] == false){
//                        colorCheck[k] = true;
//                        check += str.charAt(k);
//
//                        System.out.println("i: " + i + ", j: " + j + ", k: " + k);
//
//                        if(check.equals("oho")) {
//                            answer++;
//                            check = "";
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    //오늘의 집 코테1
//    public long solution1(int N, int[] height) {
//        long answer = 0;
//
//        for (int i = 0; i < N - 1; i++) {
//            for (int j = N - 1; j >= i + 1; j--) {
//                boolean flag2 = false;
//                for (int k = j - 1; k >= i + 1; k--) {
//                    if(height[i] > height[k] && height[j] > height [k]){
//                        flag2 = true;
//                    }else {
//                        flag2 = false;
//                        break;
//                    }
//                }
//                if(flag2 == true) answer++;
//            }
//        }
//
//        return answer + (N - 1);
//    }

//    static class Node{
//        private int data;
//        private Node next;
//
//        public Node(){
//
//        }
//
//        public Node(int data) {
//            this.data = data;
//            this.next = null;
//        }
//
//        public Node(int data, Node next) {
//            this.data = data;
//            this.next = next;
//        }
//
//        public int getData() {
//            return this.data;
//        }
//    }
//
//    static class Queue {
//        Node firstNode;
//        Node lastNode;
//
//        public void offer(int data) {
//            Node newNode = new Node(data);
//
//            if(lastNode != null) lastNode.next = newNode;
//            lastNode = newNode;
//            if (firstNode == null) firstNode = lastNode;
//        }
//
//        public int poll() {
//            if(firstNode == null) throw new NoSuchElementException();
//
//            int data = firstNode.getData();
//            firstNode = firstNode.next;
//
//            if(firstNode == null) lastNode = null;
//            return data;
//        }
//
//        public int peek() {
//            if(firstNode == null) throw new NoSuchElementException();
//
//            return firstNode.getData();
//        }
//
//        public boolean isEmpty() {
//            return (firstNode == null);
//        }
//
//        public void clear() {
//            firstNode = lastNode = null;
//        }
//    }

//    interface Queue {
//        void offer(int data);
//        int poll();
//        boolean isEmpty();
//        boolean isFull();
//        void clear();
//        int peek();
//        void printQueue();
//    }
//
//    static class ArrayQueue implements Queue {
//        int front, back;
//        int queueSize;
//        int[] queueArray;
//
//        public ArrayQueue(int queueSize) {
//            front = back = -1;
//            this.queueSize = queueSize;
//            queueArray = new int[this.queueSize];
//        }
//
//        @Override
//        public void offer(int data) {
//            if (isFull()) {
//                System.out.println("queue is full");
//            }else {
//                queueArray[++back] = data;
//            }
//        }
//
//        @Override
//        public int poll() {
//            if (isEmpty()) {
//                System.out.println("queue is empty");
//                return 0;
//            }else {
//                int data;
//                front = (front + 1) % queueSize;
//                data = queueArray[front];
//                if (isEmpty()) {
//                    clear();
//                }
//                return data;
//            }
//        }
//
//        @Override
//        public boolean isEmpty() {
//            if (front == back) {
//                front = -1;
//                back = -1;
//            }
//
//            return (front == back);
//        }
//
//        @Override
//        public boolean isFull() {
//            return (back == this.queueSize - 1);
//        }
//
//        @Override
//        public void clear() {
//            front = back = -1;
//            queueArray = new int[queueSize];
//        }
//
//        @Override
//        public int peek() {
//            if (front == back) {
//                System.out.println("queue is empty");
//                return 0;
//            }else {
//                return queueArray[front + 1];
//            }
//        }
//
//        @Override
//        public void printQueue() {
//            if (isEmpty()) {
//                System.out.println("queue is empty");
//            }else {
//                for (int i = front + 1; i <= back; i++) {
//                    System.out.print(queueArray[i] + " ");
//                }
//                System.out.println();
//            }
//        }
//    }

//    interface Stack{
//        boolean isEmpty();
//        boolean isFull();
//        void push(int item);
//        int pop();
//        int peek();
//        void clear();
//        void printStack();
//    }
//
//    static class ArrayStack implements Stack {
//        private int top;
//        private int stackSize;
//        private int[] stackArr;
//
//        public ArrayStack(int stackSize) {
//            top = -1;
//            this.stackSize = stackSize;
//            stackArr = new int[this.stackSize];
//        }
//
//        @Override
//        public boolean isEmpty() {
//            return (top == -1);
//        }
//
//        @Override
//        public boolean isFull() {
//            return (top == stackSize - 1);
//        }
//
//        @Override
//        public void push(int item) {
//            if (isFull()) {
//                System.out.println("stack is full");
//            }else {
//                stackArr[++top] = item;
//            }
//        }
//
//        @Override
//        public int pop() {
//            if (isEmpty()) {
//                System.out.println("stack is empty");
//                return 0;
//            }else {
//                return stackArr[top--];
//            }
//        }
//
//        @Override
//        public int peek() {
//            if(isEmpty()) {
//                System.out.println("stack is empty");
//                return 0;
//            }else {
//                return stackArr[top];
//            }
//        }
//
//        @Override
//        public void clear() {
//            top = -1;
//            stackArr = new int[stackSize];
//        }
//
//        @Override
//        public void printStack() {
//            if (isEmpty()) {
//                System.out.println("stack is empty");
//            }else {
//                for (int i = 0; i <= top; i++) {
//                    System.out.print(stackArr[i] + " ");
//                }
//                System.out.println();
//            }
//        }
//    }


//    //연결리스트를 위한 Node
//    static class Node{
//        private int data;
//        private Node next;
//
//        public Node(){
//
//        }
//
//        public Node(int data) {
//            this.data = data;
//            this.next = null;
//        }
//
//        public Node(int data, Node next) {
//            this.data = data;
//            this.next = next;
//        }
//
//        public int getData() {
//            return this.data;
//        }
//    }
//
//    //연결리스트
//    static class MyLinkedList {
//        Node head;
//        private int size;
//
//        public MyLinkedList() {
//            head = null;
//        }
//
//        //중간에 삽입
//        public void insertNode(Node preNode, int data) {
//            Node newNode = new Node(data);
//
//            //이전 노드의 next를 생성된 Node의 Next가 가르키게 함
//            newNode.next = preNode.next;
//
//            //이전 노드는 생성된 Node를 가르킴
//            preNode.next = newNode;
//            size++;
//        }
//
//        //마지막에 삽입
//        public void insertLastNode(int data) {
//            Node newNode = new Node(data);
//            if (head == null) {
//                this.head = newNode;
//            }else {
//                Node tempNode = head;
//
//                while (tempNode.next != null) {
//                    tempNode = tempNode.next;
//                }
//
//                tempNode.next = newNode;
//            }
//            size++;
//        }
//
//        //Node 삭제(중간 또는 첫번째)
//        public void deleteNode(int data) {
//            Node preNode = this.head;
//            Node tempNode = this.head.next;
//
//            if (data == preNode.getData()) {
//                this.head = preNode.next;
//                preNode.next = null;
//            } else {
//                while (data != tempNode.getData()) {
//                    preNode = tempNode;
//                    tempNode = tempNode.next;
//                }
//                preNode.next = tempNode.next;
//                tempNode.next = null;
//            }
//            size--;
//        }
//
//        public void deleteLastNode() {
//            Node preNode = this.head;
//            Node tempNode = this.head.next;
//
//            if (this.head == null) {
//                return;
//            }
//
//            if (this.head.next == null) {
//                this.head = null;
//            }else {
//                while (tempNode.next != null) {
//                    preNode = tempNode;
//                    tempNode = tempNode.next;
//                }
//                preNode.next = null;
//            }
//            size--;
//        }
//
//        public void reverseList(){
//            Node nextNode = head;
//            Node curNode = null;
//            Node preNode = null;
//
//            while (nextNode != null) {
//                preNode = curNode;
//                curNode = nextNode;
//                nextNode = nextNode.next;
//                curNode.next = preNode;
//            }
//
//            head = curNode;
//        }
//
//        public Node searchNode(int data) {
//            Node tempNode = this.head;
//
//            while (data != tempNode.getData()) {
//                tempNode = tempNode.next;
//            }
//
//            return tempNode;
//        }
//
//        public void printList() {
//            Node tempNode = this.head;
//
//            while (tempNode != null) {
//                System.out.print(tempNode.data + " ");
//                tempNode = tempNode.next;
//            }
//            System.out.println();
//        }
//
//        public int getSize(){
//            return size;
//        }
//    }

//    //백준 - 2839번
//    public Integer solution(int n) {
//        if(n == 4 || n == 7){
//            return -1;
//        }else if(n % 5 == 0){
//            return n / 5;
//        } else if (n % 5 == 1 || n % 5 == 3) {
//            return n / 5 + 1;
//        } else if (n % 5 == 2 || n % 5 == 4) {
//            return n / 5 + 2;
//        }
//        return 0;
//    }

//    //15. 피자 배달 거리(DFS) 강의 풀이
//    public void deliveryPizza(int level, int s) {
//        if(level == m){
//            int sum = 0;
//            for (Point h : hs) {
//                int dis = Integer.MAX_VALUE;
//                for (int i : combi) {
//                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
//                }
//                sum += dis;
//            }
//            answer = Math.min(answer, sum);
//        }else {
//            for (int i = s; i < len; i++) {
//                combi[level] = i;
//                deliveryPizza(level + 1, i+1);
//            }
//        }
//    }

//    //14. 섬나라 아일랜드(BFS)
//    public void findIslandBFS(int x, int y, Queue<Point> queue) {
//        while (!queue.isEmpty()) {
//            Point tmp = queue.poll();
//            for (int i = 0; i < dx.length; i++) {
//                int nx = tmp.x + dx[i];
//                int ny = tmp.y + dy[i];
//                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1) {
//                    map[nx][ny] = 0;
//                    queue.offer(new Point(nx, ny));
//                }
//            }
//        }
//    }
//
//    //14. 섬나라 아일랜드(BFS)
//    public void solution() {
//        Queue<Point> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(map[i][j] == 1){
//                    answer++;
//                    map[i][j] = 0;
//                    queue.offer(new Point(i, j));
//                    findIslandBFS(i, j, queue);
//                }
//            }
//        }
//    }

//    //13. 섬나라 아일랜드(DFS)
//    public void findIslandDFS(int x, int y){
//        if(map[x][y] == 0) return;
//        else {
//            map[x][y] = 0;
//            for (int i = 0; i <dx.length; i++){
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                if(nx >= 0 && nx < n && ny >= 0 && ny < n)
//                findIslandDFS(nx, ny);
//            }
//        }
//    }
//
//    //13. 섬나라 아일랜드(DFS)
//    public void solution(){
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(map[i][j] == 1){
//                    answer++;
//                    findIslandDFS(i, j);
//                }
//            }
//        }
//    }

//    //8-12 토마토 - 강의 풀이
//    public void tomato(){
//        int nx = 0;
//        int ny = 0;
//
//        while (!queue.isEmpty()) {
//            Point tmp = queue.poll();
//            for (int i = 0; i < 4; i++) {
//                nx = tmp.x + dx[i];
//                ny = tmp.y + dy[i];
//                if(nx >= 0 && nx < m && ny >= 0 && ny < n && store[nx][ny] == 0){
//                    store[nx][ny] = 1;
//                    queue.offer(new Point(nx, ny));
//                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
//                }
//            }
//        }
//    }

//    //8-11 미로 최단거리 통로 - 강의 풀이
//    public void findShortestDistance(int x, int y) {
//        Queue<Point> queue = new LinkedList();
//        queue.offer(new Point(x, y));
//        maze[x][y] = 1;
//        while (!queue.isEmpty()) {
//            Point tmp = queue.poll();
//            for (int i = 0; i < 4; i++) {
//                int nx = tmp.x + dx[i];
//                int ny = tmp.y + dy[i];
//                if (nx > 0 && nx < 8 && ny > 0 && ny < 8 && maze[nx][ny] == 0) {
//                    maze[nx][ny] = 1;
//                    queue.offer(new Point(nx, ny));
//                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
//                }
//            }
//        }
//    }
//

//    //8-10 미로탐색
//    public void exploreMaze(int n, int m){
//        if (n == 6 && m == 6){
//            answer++;
//            return;
//        }else {
//            if(n < 7 && m < 7) {
//                if (maze[n][m] == 0) {
//                    maze[n][m] = 1;
//                    exploreMaze(n + 1, m);
//                    exploreMaze(n, m + 1);
//                    if(n > 1)
//                        exploreMaze(n - 1, m);
//                    if(m > 1)
//                        exploreMaze(n, m - 1);
//                    maze[n][m] = 0;
//                }
//            }
//        }
//    }
//
//    //8-10 미로탐색 - 강의 풀이
//    public void exploreMazeV2(int x, int y) {
//        if(x == 6 && y== 6)
//            answer++;
//        else {
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dx[i];
//                if(nx > 0 && nx < 7 && ny > 0 && ny < 6 && maze[nx][ny] == 0) {
//                    maze[nx][ny] = 1;
//                    exploreMazeV2(nx, ny);
//                    maze[nx][ny] = 0;
//                }
//            }
//        }
//    }

//    //8-9 조합 구하기 - 강의 풀이
//    public void getCombination(int level, int start){
//        if(level == m){
//            for (int i : pm) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }else {
//            for (int i = start; i <= n; i++){
//                    pm[level] = i;
//                    getCombination(level + 1, i + 1);
//            }
//        }
//
//    }

//    //8-8 수열 추측하기 - 강의 풀이
//    public void guessPermutation(int level, int sum) {
//        if(flag == true) return;
//        if (level == n) {
//            if(sum == f) {
//                for (int i : p) {
//                    System.out.print(i + " ");
//                }
//                flag = true;
//            }
//        } else {
//            for (int i = 1; i <= n; i++) {
//                if (ch[i] == 0) {
//                    ch[i] = 1;
//                    p[level] = i;
//                    guessPermutation(level + 1, sum+(p[level] * b[level]));
//                    ch[i] = 0;
//                }
//            }
//        }
//    }
//
//    //8-7 조합의 경우수 - 강의 풀이
//    public int getNumOfCombinations(int n, int r){
//        if(dy[n][r] > 0) return dy[n][r];
//        if(n == r || r == 0) return 1;
//        else return dy[n][r] = getNumOfCombinations(n - 1, r - 1) + getNumOfCombinations(n - 1, r);
//    }

//    //8-6 순열구하기 - 강의 풀이
//    public void getPermutation(int level, int[] nums) {
//        if (level == m) {
//            for (int i : pm) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//            return;
//        }else {
//            for (int i = 0; i < n; i++) {
//                if(check[i] == 0){
//                    check[i] = 1;
//                    pm[level] = nums[i];
//                    getPermutation(level + 1, nums);
//                    check[i] = 0;
//                }
//            }
//        }
//    }

//    //8-5 동전교환
//    public void changeCoins(int coin, int value) {
//        if(coin > answer) return;
//        if (value == 0) {
//            answer = Math.min(answer, coin);
//            return;
//        } else {
//            if (value > 0) {
//                for (int i = 0; i < n; i++) {
//                    changeCoins(coin + 1, value - coins[i]);
//                }
//            } else return;
//        }
//    }

//    //8-4 중복순열 - 강의 풀이
//    public void doublePermutation(int level) {
//        if (level == m) {
//            for (int i : pm) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//            return;
//        }else {
//            for (int i = 1; i <= n; i++) {
//                pm[level] = i;
//                doublePermutation(level + 1);
//            }
//        }
//    }

//    //8-3 최대 점수 구하기(DFS)
//    public void getMaxNum(int level, int sum, int minSum, int[][] proScoNum) {
//        if(minSum < 0) return;
//        if(level == proNum){
//            answer = Math.max(answer, sum);
//        }else {
//            getMaxNum(level + 1, sum + proScoNum[level][0], minSum - proScoNum[level][1], proScoNum);
//            getMaxNum(level + 1, sum, minSum, proScoNum);
//        }
//    }

//    //8-2 바둑이 승차(DFS)
//    public void heaviestRideDog(int level, int sum, int[] dogs){
//        if(weight < sum) return;
//        if(level == dogs.length) {
//            answer = Math.max(answer, sum);
//        }
//        else {
//            heaviestRideDog(level + 1,sum + dogs[level], dogs);
//            heaviestRideDog(level + 1, sum, dogs);
//        }
//    }

    //    //8-1 합이 같은 부분 집합(DFS) - 강의 풀이
//    public void sameSumSubSet(int level, int sum, int[] arr) {
//        if(flag) return;
//        if(sum > total/2) return;
//        if (level == n) {
//            if ((total - sum) == sum) {
//                answer = "YES";
//                flag = true;
//            }
//        }else {
//            sameSumSubSet(level + 1, sum + arr[level], arr);
//            sameSumSubSet(level + 1, sum, arr);
//        }
//    }
//
//    //7-14 그래프 최단거리(BFS)
//    public void findShortestPath(int v) {
//        Queue<Integer> que = new LinkedList<>();
//        ch[v] = 1;
//        disV2[0] = 0;
//        que.offer(v);
//        while (!que.isEmpty()) {
//            int cv = que.poll();
//            for (int nv : graphV2.get(cv)) {
//                if (ch[nv] == 0) {
//                    ch[nv] = 1;
//                    que.offer(nv);
//                    disV2[nv] = disV2[cv] + 1;
//                }
//            }
//        }
//    }
//
//    //7-13 경로탐색(인접리스트, ArrayList)
//    public void findPathV2(int v) {
//        int answer = 0;
//        if(v == n) answer++;
//        else {
//            for (int nv : graphV2.get(v)) {
//                if (ch[nv] == 0) {
//                    ch[nv] = 1;
//                    findPathV2(nv);
//                    ch[nv] = 0;
//                }
//            }
//        }
//    }
//
//    //7-12 경로탐색(DFS)
//    public void findPathDFS(int v) {
//        int answer = 0;
//        if(v == n) answer++;
//        else {
//            for (int i = 1; i <= n; i++) {
//                if(graph[v][i] == 1 && ch[i] == 0){
//                    ch[i] = 1;
//                    findPathDFS(i);
//                    ch[i] = 0;
//                }
//            }
//        }
//
//    }
//
//    //7-10 Tree Node에서 말단 Node까지 가장 짧은 거리 구하기(BFS)
//    public int getShortestDistanceBFS(Node root) {
//        Queue<Node> que = new LinkedList();
//        que.offer(root);
//        int level = 0;
//        while (!que.isEmpty()) {
//            int len = que.size();
//            for(int i = 0; i < len; i++){
//                Node cur = que.poll();
//                if (cur.lt == null && cur.rt == null) return level;
//                if(cur.lt != null) que.offer(cur.lt);
//                if(cur.rt != null) que.offer(cur.rt);
//            }
//            level++;
//        }
//        return -1;
//    }
//
//    //7-9 Tree Node에서 말단 Node까지 가장 짧은 거리 구하기(DFS)
//    public int getShortestDistanceDFS(int L, Node root) {
//        if (root.lt == null && root.rt == null) return L;
//        else return Math.min(getShortestDistanceDFS(L + 1, root.lt), getShortestDistanceDFS(L + 1, root.rt));
//    }
//
//    //7-8 송아지 찾기
//    public int findCalfBFS(int s, int e){
//        ch = new int[10001];
//        ch[s] = 1;
//        Q.offer(s);
//        int level = 0;
//        while (!Q.isEmpty()){
//            int len = Q.size();
//            for (int i = 0; i < len; i++) {
//                int x = Q.poll();
//                for (int j = 0; j < 3; j++){
//                    int nx = x + dis[j];
//                    if(nx == e) return level + 1;
//                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
//                        ch[nx] = 1;
//                        Q.offer(nx);
//                    }
//                }
//            }
//            level++;
//        }
//        return -1;
//    }
//
//    //7-7 이진트리 순회(BFS: 레벨 탐색)
//    public void binaryTreeTourBFS(Node root){
//        Queue<Node> Q = new LinkedList<>();
//        Q.offer(root);
//        int level = 0;
//        while (!Q.isEmpty()){
//            int len = Q.size();
//            System.out.print(level + " : ");
//            for (int i = 0; i < len; i++) {
//                Node cur = Q.poll();
//                System.out.print(cur.data + " ");
//                if(cur.lt != null) Q.offer(cur.lt);
//                if(cur.rt != null) Q.offer(cur.rt);
//            }
//            level++;
//            System.out.println();
//        }
//    }
//
//    //7-6 부분집합 구하기(DFS)
//    public void getPartSet(int L){
//        if (L == n + 1) {
//            String tmp = "";
//            for(int i = 1; i <= n; i++){
//                if(ch[i] == 1) tmp += i + " ";
//            }
//            if(tmp.length() > 0) System.out.println(tmp);
//        }else {
//            ch[L] = 1;
//            getPartSet(L + 1); // left
//            ch[L] = 0;
//            getPartSet(L + 1); // right
//        }
//    }
//
//    //7-5 이진트리 순회(DFS: 깊이 우선 탐색)
//    public void binaryTreeTourDFS(Node root) {
//        if(root == null) return;
//        else {
//            binaryTreeTourDFS(root.lt);
//            binaryTreeTourDFS(root.rt);
//            System.out.print(root.data + " ");
//        }
//    }
//
//    //7-4 피보나치 (재귀)
//    public static int reclusiveFibonacci(int n) {
//        if(fibo[n] > 0) return fibo[n];
//        if(n == 1) return fibo[n] = 1;
//        else if(n == 2) return fibo[n] = 1;
//        else return fibo[n] = reclusiveFibonacci(n - 2) + reclusiveFibonacci(n - 1);
//    }
//
//    //7-3 팩토리얼
//    public static int factorial(int n) {
//        if(n == 1) return 1;
//        else return n * factorial(n - 1);
//    }
//
//    //7-2 이진수 출력(재귀)
//    public static void showBinary(int n) {
//        if(n == 0) {
//            return;
//        }
//        else {
//            showBinary(n / 2);
//            System.out.print(n % 2);
//        }
//    }
//
//    //7-1 재귀 함수(스택 프레임)
//    public static void recursiveFunction(int n) {
//        if(n == 0) {
//            return;
//        }
//        else {
//            recursiveFunction(n - 1);
//            System.out.print(n + " ");
//        }
//    }
//
//    //6-10 마구간 정하기(결정 알고리즘) 강의 풀이
//    public static int selectStall(int n, int m, int[] nums){
//        Arrays.sort(nums);
//        int answer = 0;
//        int low = 1;
//        int high = nums[n - 1];
//        while (low <= high){
//            int mid = (low + high) / 2;
//            if (getHorseNum(nums, mid) >= m) {
//                answer = mid;
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//
//        return answer;
//    }
//
//    //6-10 마구간 정하기용 말 마리 수 구하는 함수
//    public static int getHorseNum(int[] arr, int distance){
//        int cnt = 1; //말의 수
//        int loc = arr[0];
//
//        for (int i : arr) {
//            if(i - loc >= distance){
//                cnt++;
//                loc = i;
//            }
//        }
//
//        return cnt++;
//    }
//
//    //6-9 뮤직비디오(결정 알고리즘) 강의 풀이
//    public static int musicVideo(int n, int m, int[] nums){
//        int answer = 0;
//        int low = Arrays.stream(nums).min().getAsInt();
//        int high = Arrays.stream(nums).max().getAsInt();
//
//        while (low <= high){
//            int mid = (low + high) / 2;
//            if (count(nums, mid) <= m) {
//                answer = mid;
//                high = mid - 1;
//            } else low = mid + 1;
//        }
//
//        return answer;
//    }
//
//    //6-9 뮤직비디오 용 cd 개수 구하는 함수
//    public static int count(int[] arr, int capacity){
//        int cnt = 1; //dvd 장수
//        int sum = 0;
//
//        for (int x : arr){
//            if(sum+x > capacity){
//                cnt++;
//                sum = x;
//            } else sum += x;
//        }
//
//        return cnt;
//    }
//
//    //6-8 이진 검색
//    public static int binarySearch(int n, int target, int[] nums){
//        int low = 0, high = n - 1, mid;
//        Arrays.sort(nums);
//
//        while (low <= high){
//            mid = (low + high) / 2;
//            if (nums[mid] == target)
//                return mid + 1;
//            else if(nums[mid] > target)
//                high = mid - 1;
//            else
//                low = mid + 1;
//        }
//
//        return -1;
//    }
//
//    //6-7 좌표 정렬
//    public static int[][] locationSort(int n, int[][] locations){
//        for(int i = 1; i < n; i++){
//            int[] tmp = locations[i];
//            int tmpX = locations[i][0], tmpY = locations[i][1], j;
//            for(j = i - 1; j >= 0; j--){
//                if(tmpX < locations[j][0]) locations[j + 1] = locations[j];
//                else if(tmpX == locations[j][0]){
//                    if(tmpY < locations[j][1]) locations[j + 1] = locations[j];
//                    else break;
//                } else break;
//            }
//            locations[j + 1] = tmp;
//        }
//        return locations;
//    }
//
//    //6-7 좌표 정렬 - 강의 풀이
//    public static ArrayList<Point> locationSortV2(int n, Scanner sc){
//        ArrayList<Point> arr = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            arr.add(new Point(x, y));
//        };
//        Collections.sort(arr);
//
//        for (Point point : arr) {
//            System.out.println(point.x + " " + point.y);
//        }
//
//        return arr;
//    }
//
//    //6-6 장난 꾸러기
//    public static ArrayList<Integer> naughtiness (int n, int[] nums){
//        ArrayList<Integer> answer = new ArrayList<>();
//        int[] falseNum = nums.clone();
//        Arrays.sort(nums);
//
//        for(int i = 0; i < n; i++){
//            if(falseNum[i] != nums[i]) answer.add(i + 1);
//        }
//
//        return answer;
//    }
//
//    //6-5 중복 확인
//    public static Character checkOverlap(int n, int[] nums){
//        Character answer = 'U';
//        Map<Integer, Integer> map = new HashMap<>();
//        //1안
//        for(int i = 0; i < n; i++){
//            if(!map.containsKey(nums[i])){
//                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//            }else {
//                return 'D';
//            }
//        }
//
//        //2안
//        for (int i = 0; i < n - 1; i++){
//            for(int j = i + 1; j < n; j++){
//                if(nums[i] == nums[j]){
//                    return 'D';
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    //6-5 중복 확인 - 강의 풀이
//    public static Character checkOverlapV2(int n, int[] nums) {
//        Character answer = 'U';
//        Arrays.sort(nums);
//
//        for(int i = 0; i < n - 1; i++){
//            if(nums[i] == nums[i + 1]) return 'D';
//        }
//
//        return answer;
//    }
//
//    //6-4 LRU CACHE - 강의 풀이
//    public static int[] lruCache(int n, int m, int[] nums){
//        int [] cache = new int[n];
//        for (int num : nums) {
//            int pos = - 1;
//            for (int i = 0; i < n; i++) if(num == cache[i]) pos = i;
//            if (pos == -1){
//                for(int i  = n - 1; i > 0; i--){
//                    cache[i] = cache[i - 1];
//                }
//            } else {
//                for(int i  = pos; i > 0; i--){
//                    cache[i] = cache[i - 1];
//                }
//            }
//            cache[0] = num;
//        }
//        return cache;
//    }
//
//    //6-3 삽입 정렬
//    public static int[] insertSort(int n, int[] nums){
//        for (int i = 1; i < n; i++){
//            int tmp = nums[i], j;
//            for(j = i - 1; j >= 0; j--){
//                if(nums[j] > tmp) nums[j + 1] = nums[j];
//                else break;
//            }
//            nums[j + 1] = tmp;
//        }
//
//        return nums;
//    }
//
//    //6-2 버블 정렬
//    public static int[] bubbleSort(int n, int[] nums){
//        for(int i = 0; i < n - 1; i++){
//            for(int j = 0; j < n - i - 1; j++){
//                if(nums[j] > nums[j + 1]){
//                    int tmp = nums[j + 1];
//                    nums[j + 1] = nums[j];
//                    nums[j] = tmp;
//                }
//            }
//        }
//        return nums;
//    }
//
//    //6-1 선택 정렬
//    public static int[] selectSort(int n, int[] nums){
//        for(int i = 0; i < n - 1; i++){
//            int minValue = i;
//            for (int j = i + 1; j < n; j++) {
//                if(nums[minValue] > nums[j]){
//                    minValue = j;
//                }
//            }
//            int tmp = nums[minValue];
//            nums[minValue] = nums[i];
//            nums[i] = tmp;
//        }
//        return nums;
//    }
//
//    //5-8 응급실 - 강의 풀이
//    public static int emergencyRoom(int pNum, int order, Integer[] crits){
//        int answer = 0;
//        Queue<Person> list = new LinkedList<>();
//        for(int i = 0; i < pNum; i++){
//            list.offer(new Person(i, crits[i]));
//        }
//
//        while (!list.isEmpty()) {
//            Person tmp = list.poll();
//            for (Person person : list) {
//                if(person.crit > tmp.crit){
//                    list.offer(tmp);
//                    tmp = null;
//                    break;
//                }
//            }
//            if(tmp != null){
//                answer++;
//                if(tmp.id == order) return answer;
//            }
//        }
//
//        return answer;
//
//    }
//
//    //5-7 교육과정 설계(QUEUE)
//    public static String organizeEdu(String line1, String line2) {
//        Queue<Character> queue = new LinkedList();
//        String answer = "YES";
//        for(int i = 0; i < line1.length(); i++){
//            queue.add(line1.charAt(i));
//        }
//
//        for(int i = 0; i < line2.length(); i++){
//            if(queue.contains(line2.charAt(i))){
//                if (queue.peek() == line2.charAt(i)) queue.poll();
//                else return "NO";
//            }
//            if(queue.isEmpty()) break;
//        }
//
//        if(!queue.isEmpty()) return "NO";
//
//        return answer;
//    }
//
//    //5-7 교육 과정 설계 - 강의 풀이(QUEUE)
//    public static String organizeEduV2(String line1, String line2) {
//        String answer = "YES";
//        Queue<Character> Q = new LinkedList<>();
//
//        for(char x: line1.toCharArray()) Q.offer(x);
//        for(char x: line2.toCharArray()){
//            if(Q.contains(x)){
//                if(Q.poll() != x) return "NO";
//            }
//        }
//
//        if(!Q.isEmpty()) return "NO";
//
//        return answer;
//
//    }
//
//    //5-6 공주 구하기(QUEUE)
//    public static int savePrincess(int n, int m){
//        int answer = 0;
//        Queue<Integer> prince = new LinkedList();
//        for (int i = 1; i <= n; i++) {
//            prince.add(i);
//        }
//
//        int cnt = 1;
//        while (prince.size() != 1) {
//            int tmp = prince.poll();
//            if(cnt == m){
//                cnt = 1;
//            }else {
//                prince.add(tmp);
//                cnt++;
//            }
//        }
//        answer = prince.poll();
//
//        return answer;
//    }
//
//    //5-5 쇠막대기 - 강의 풀이(STACK)
//    public static int ironStick(String line1){
//        int answer = 0;
//        Stack<Character> stack = new Stack<>();
//        boolean flag = false;
//
//        for(int i = 0; i < line1.length(); i++)
//            if(line1.charAt(i) == '(') {
//                stack.push(line1.charAt(i));
//            }
//            else {
//                if(!stack.isEmpty()) {
//                    stack.pop();
//                    if(line1.charAt(i - 1) == '(') {
//                        answer += stack.size();
//                    } else {
//                        answer++;
//                    }
//                }
//        }
//
//        return answer;
//    }
//
//    //5-4 후위식 연산(STACK)
//    public static int postFix(String line1){
//        Stack<Integer> stack = new Stack<>();
//
//
//        for (char c : line1.toCharArray()) {
//            int result = 0;
//            if (Character.isDigit(c)) {
//                stack.push(Character.getNumericValue(c));
//            }else {
//                switch (c){
//                    case '+':
//                        result = stack.pop() + stack.pop();
//                        stack.push(result);
//                        break;
//                    case '-':
//                        result = (stack.pop() - stack.pop()) * -1;
//                        stack.push(result);
//                        break;
//                    case '*':
//                        result = stack.pop() * stack.pop();
//                        stack.push(result);
//                        break;
//                    case '/':
//                        result = stack.pop() / stack.pop();
//                        stack.push(result);
//                        break;
//                }
//            }
//        }
//        return stack.pop();
//    }
//
//    //5-3 크레인 인형뽑기(카카오)(STACK)
//    public static int drawDoll(int n, int[][] crane, int m, int[] moves){
//        int answer = 0;
//        Stack<Integer> bucket = new Stack();
//
//        for(int i = 0; i < m; i++){
//            int doll = 0;
//            for(int j = 0; j < n; j++){
//                if(crane[j][moves[i]] != 0){
//                    doll = crane[j][moves[i]];
//                    crane[j][moves[i]] = 0;
//
//                    break;
//                }
//            }
//
//            if(!bucket.isEmpty() && bucket.peek() == doll){
//                bucket.pop();
//                answer += 2;
//            }else {
//                bucket.push(doll);
//            }
//
//        }
//        return answer;
//    }
//
//    //5-2 괄호 문자 제거(STACK)
//    public static String removeBracketChar(String line1){
//        String answer = "";
//        Stack<Character> stack = new Stack<>();
//        for (char c : line1.toCharArray()) {
//            if(c == ')'){
//              while (stack.pop() != '(');
//            } else stack.push(c);
//        }
//
//        for (Character character : stack) {
//            answer += character;
//        }
//
//        return answer;
//    }
//
//    //5-1 올바른 괄호(STACK)
//    public static String rightBracket(String line1) {
//        String answer = "YES";
//        Stack<Character> stack = new Stack<>();
//        for (char c : line1.toCharArray()) {
//            if(c == '(') stack.push(c);
//            else if(c == ')'){
//                if (stack.isEmpty()) return "NO";
//                stack.pop();
//            }
//        }
//        if(!stack.isEmpty())
//            return "NO";
//
//        return answer;
//    }
//
//    //4-5 k번째 큰 수 - 강의 풀이(TreeSet)
//    public static int findK(int n, int m, int[] nums){
//        int answer = -1;
//        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
//
//        for(int i = 0; i < n; i++){
//            for(int j = i + 1; j < n; j++){
//                for(int k = j + 1; k < n; k++){
//                    set.add(nums[i] + nums[j] + nums[k]);
//                }
//            }
//        }
//
//        int cnt = 0;
//        for (Integer x : set) {
//            cnt++;
//            if(cnt == m) return x;
//        }
//        return answer;
//    }
//
//    //4-4 모든 아나그램 찾기(HashMap, slidingWindow)
//    public static int findAllAnagram(String line1, String line2){
//        int answer = 0, lt = 0;
//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();
//        char[] chars1 = line1.toCharArray();
//        char[] chars2 = line2.toCharArray();
//
//        for (char key : chars2) {
//            map2.put(key, map2.getOrDefault(key, 0) + 1);
//        }
//        for (int i = 0; i < chars2.length - 1; i++){
//            map1.put(chars1[i], map1.getOrDefault(chars1[i], 0) + 1);
//        }
//
//        for(int rt = line2.length() - 1; rt < chars1.length; rt++){
//            map1.put(chars1[rt], map1.getOrDefault(chars1[rt], 0) + 1);
//            if (map1.equals(map2)) {
//                answer++;
//            }
//            map1.put(chars1[lt], map1.get(chars1[lt]) - 1);
//            if(map1.get(chars1[lt]) == 0) map1.remove(chars1[lt]);
//            lt++;
//
//        }
//
//        return answer;
//    }
//
//    //4-3 매출액의 종류(HashMap, slidingWindow)
//    public static ArrayList<Integer> takeKind(int n, int m, int[] nums) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        Map<Integer, Integer> kinds = new HashMap<>();
//        int lt = 0;
//
//        kinds.put(nums[0], kinds.getOrDefault(nums[0], 0) + 1);
//        for (int rt = 1; rt < n; rt++) {
//            kinds.put(nums[rt], kinds.getOrDefault(nums[rt], 0) + 1);
//            if((rt - lt) % (m - 1) == 0){
//                answer.add(kinds.size());
//
//                kinds.put(nums[lt], kinds.get(nums[lt]) - 1);
//                if(kinds.get(nums[lt]) == 0) kinds.remove(nums[lt]);
//
//                lt++;
//            }
//        }
//
//        return answer;
//    }
//
//    //4-3 매출액의 종류 - 강의 풀이(HashMap, slidingWindow)
//    public static ArrayList<Integer> takeKindV2(int n, int m, int[] nums){
//        ArrayList<Integer> answer = new ArrayList<>();
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//        for(int i = 0; i < m - 1; i++){
//            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
//        }
//        int lt = 0;
//        for (int rt = m - 1; rt < n; rt++) {
//            hashMap.put(nums[rt], hashMap.getOrDefault(nums[rt], 0) + 1);
//            answer.add(hashMap.size());
//            hashMap.put(nums[lt], hashMap.get(nums[lt]) - 1);
//            if (hashMap.get(nums[lt]) == 0) {
//                hashMap.remove(nums[lt]);
//            }
//            lt++;
//        }
//
//        return answer;
//    }
//
//    //4-2 아나그램(HashMap)
//    public static String anaGram(String s1, String s2) {
//        String answer = "NO";
//        Map<Character, Integer> mapS1 = new HashMap<>();
//        Map<Character, Integer> mapS2 = new HashMap<>();
//
//        for (char key : s1.toCharArray()) {
//            mapS1.put(key, mapS1.getOrDefault(key, 0) + 1);
//        }
//
//        for (char key : s2.toCharArray()) {
//            mapS2.put(key, mapS2.getOrDefault(key, 0) + 1);
//        }
//
//        for (char key : mapS1.keySet()) {
//            if(mapS2.containsKey(key)){
//                if(mapS1.get(key) == mapS2.get(key)) answer = "YES";
//                else {
//                    answer = "NO";
//                    break;
//                }
//            }
//            else {
//                answer = "NO";
//                break;
//            }
//        }
//
//        return answer;
//    }
//
//    //4-2 아나그램 - 강의 풀이(HashMap)
//    public static String anaGramV2(String s1, String s2){
//        String answer = "YES";
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (char x : s1.toCharArray()) {
//            map.put(x, map.getOrDefault(x, 0) + 1);
//        }
//        for (char x : s2.toCharArray()){
//            if (!map.containsKey(x) || map.get(x) == 0) {
//                return "NO";
//            }
//            map.put(x, map.get(x) - 1);
//        }
//
//        return answer;
//    }
//
//    //4-1 학급 회장 hashMap(HashMap)
//    public static Character classPresident(int n, char[] marks){
//        Character answer = 0;
//        Map<Character, Integer> presidentMap = new HashMap<>();
//
//
//        for (int i = 0; i < n; i++) {
//
//            if (presidentMap.containsKey(marks[i])) {
//                int temp = presidentMap.get(marks[i]) + 1;
//                presidentMap.put(marks[i], temp);
//            } else {
//                presidentMap.put(marks[i], 1);
//            }
//        }
//
//
//        int cnt = 0;
//        for (Character s : presidentMap.keySet()) {
//            if (cnt < presidentMap.get(s)) {
//                cnt = presidentMap.get(s);
//                answer = s;
//            }
//        }
//
//        return answer;
//    }
//
//    //4-1 학급 회장 hashMap - 강의 풀이(HashMap)
//    public static Character classPresidentV2(int n, char[] marks){
//        char answer = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (char x : marks) {
//            map.put(x, map.getOrDefault(x, 0) + 1);
//        }
//
//
//        /**
//         * containsKey
//         * 함수 설명: hashMap에 특정 key가 있는지 확인한다
//         * 특정 key가 존재하면 true, 없으면 false를 반환한다.
//         * return: boolean
//         */
////        map.containsKey(marks[0]);
//
//        int cnt = 0;
//        for (char key : map.keySet()) {
//            if (cnt < map.get(key)) {
//                cnt = map.get(key);
//                answer = key;
//            }
//        }
//
//        return answer;
//    }
//
//    //4-1 문제용 키찾기 함수
//    private static boolean findKey(Map<Character, Integer> map, Character mark){
//        for (Character s : map.keySet()) {
//            if(mark.equals(s)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    //3-6 최대 길이 연속부분수열 - 강의 풀이
//    public static int seqMaxLengthArray(int n, int m, int[] nums){
//        int answer = 0, cnt = 0, lt = 0, zeroCount = 0;
//
//        for(int rt = 0; rt < n; rt++){
//            if(nums[rt] == 0) cnt++;
//            while (cnt > m){
//                if(nums[lt] == 0) cnt--;
//                lt++;
//            }
//            answer = Math.max(answer, rt - lt + 1);
//        }
//
//        return answer;
//    }
//
//    //3-5 연속된 자연수의 합
//    public static int seqNumSum(int n, int[] nums){
//        int answer = 0, sum = 0, lt = 0;
//
//        for (int rt = 0; rt < nums.length; rt++) {
//            sum += nums[rt];
//            if(sum == n) {
//                answer++;
//            }
//            while (sum >= n){
//                sum -= nums[lt++];
//                if(sum == n) {
//                    answer++;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    //3-5 연속된 자연수의 합
//    public static int seqNumSum(int n){
//        int answer = 0, cnt = 1;
//        n--;
//        while (n > 0){
//            cnt++;
//            n = n - cnt;
//            if(n % cnt == 0)
//                answer++;
//        }
//
//        return answer;
//    }
//
//    //3-4 연속 부분 수열(복합적 문제)
//    public static int seqPartArray(int n, int m, int[] nums){
//        int answer = 0, sum = 0;
//        int st = 0, ed = 0;
//
//        sum = nums[st];
//        while (st < n) {
//            if(sum == m){
//                answer++;
//                sum -= nums[st++];
//            }else if(sum > m){
//                sum -= nums[st++];
//            }else {
//                if(ed < n - 1)
//                    sum += nums[++ed];
//            }
//
//            if(ed == n -1){
//                st++;
//            }
//        }
//
//        return answer;
//    }
//
//    //3-4 연속 부분 수열(복합적 문제) - 강의 풀이
//    public static int seqPartArrayV2(int n, int m, int[] nums){
//        int answer = 0, sum = 0, lt = 0;
//        for (int rt = 0; rt < n; rt++) {
//            sum += nums[rt];
//            if(sum == m) answer++;
//            while (sum >= m){
//                sum -= nums[lt++];
//                if(sum == m) answer++;
//            }
//        }
//        return answer;
//    }
//
//    //3-3 최대 매출 구하기
//    public static int getMaxSale(int n, int m, int[] nums){
//        int answer = 0, sum = 0;
//
//        for(int i = 0; i < m; i++){
//            sum += nums[i];
//        }
//        answer = sum;
//
//        for(int i = m; i < n; i++){
//            sum += nums[i] - nums[i - m];
//            if(answer < sum)
//                answer = sum;
//        }
//
//        return answer;
//    }
//
//    //3-2 공통 원소 구하기
//    public static ArrayList<Integer> getCommonElement(int n, int m, int[] nums1, int[] nums2){
//        ArrayList<Integer> answer = new ArrayList<Integer>();
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//
//        int p1 = 0, p2 = 0;
//
//        while (p1 < n && p2 < m){
//                if(nums1[p1] < nums2[p2]) {
//                    p1++;
//                }else if(nums1[p1] > nums2[p2]) {
//                    p2++;
//                }else {
//                    answer.add(nums1[p1]);
//                    p1++;
//                    p2++;
//                }
//        }
//
//        return answer;
//    }
//
//    //3-1 두 배열 합치기
//    public static int[] combineArray(int n, int m, int[] nums1, int[] nums2){
//        int[] answer = new int[n + m];
//        System.arraycopy(nums1, 0, answer, 0, n);
//        System.arraycopy(nums2, 0, answer, n, m);
//
//        for (int i = 0; i < answer.length; i++){
//            for(int j = i; j < answer.length; j++){
//                int temp = 0;
//                if(answer[i] > answer[j]){
//                    temp = answer[i];
//                    answer[i] = answer[j];
//                    answer[j] = temp;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    //3-1 두 배열 합치기 강의 풀이(two pointers algorithm)
//    public static ArrayList<Integer> combineArrayV2(int n, int m, int[] nums1, int[] nums2){
//        ArrayList<Integer> answer = new ArrayList<>();
//        int p1 = 0;
//        int p2 = 0;
//
//        while (p1 < n && p2 < m){
//            if(nums1[p1] > nums2[p2]) answer.add(nums2[p2++]);
//            else answer.add(nums1[p1++]);
//
//        }
//        while (p1 < n){
//            answer.add(nums1[p1++]);
//        }
//        while (p2 < m){
//            answer.add(nums2[p2++]);
//        }
//
//        return answer;
//    }
//
//    //2-12 멘토링 강의 풀이
//    public static int getMetoringNum(int m, int n, int[][] nums){
//        int answer = 0;
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                if(i != j) {
//                    int cnt = 0;
//                    for (int k = 0; k < m; k++) {
//                        int pi = 0, pj = 0;
//                        for (int s = 0; s < n; s++) {
//                            if (nums[k][s] == i) pi = s;
//                            if (nums[k][s] == j) pj = s;
//                        }
//                        if (pi < pj) cnt++;
//                    }
//                    if (cnt == m) answer++;
//                }
//            }
//        }
//        return answer;
//    }
//
//    //2-11 임시반장 정하기
//    public static int getLeader(int n, int [][] nums){
//        int answer = Integer.MIN_VALUE;
//        int[] same = new int[n];
//
//        for (int i = 0; i < n; i++){
//            int cnt = 0;
//            for (int j = 0; j < n; j++){
//                for(int k = 0; k < 5; k++){
//                    if(nums[i][k] == nums[j][k]){
//                        same[i] = cnt++;
//                        break;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < same.length; i++) {
//            if (same[i] > answer) {
//                answer = i + 1;
//            }
//        }
//
//        return answer;
//    }
//
//    //2-11 임시반장 구하기 강의 풀이
//    public static int getLeaderV2(int n, int [][] nums){
//        int answer = 0, max = Integer.MAX_VALUE;
//        for(int i = 1; i <= n; i++){
//            int cnt = 0;
//            for(int j = 1; j <= n; j++){
//                for(int k = 1; k <= 5; k++){
//                    if(nums[i][k] == nums[j][k]){
//                        cnt++;
//                        break;
//                    }
//                }
//            }
//            if(cnt > max){
//                max = cnt;
//                answer = i;
//            }
//        }
//        return answer;
//    }
//
//    //2-10 봉우리 구하기
//    public static int getPeak(int n, int[][] nums) {
//        int answer = 0;
//
//        for(int i = 1; i < n - 1; i++){
//            for(int j = 1; j < n - 1; j++){
//                if(nums[i][j] > nums[i][j - 1]){
//                    if(nums[i][j] > nums[i - 1][j]){
//                        if(nums[i][j] > nums[i][j + 1]){
//                            if(nums[i][j] > nums[i + 1][j])
//                                answer += 1;
//                        }
//                    }
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    //2-10 봉우리 구하기 강의 풀이
//    public static int getPeakV2(int n, int[][] nums) {
//        int answer = 0;
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, 1, 0, -1};
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                boolean flag = true;
//                for (int k = 0; k < 4; k++){
//                    int nx = i + dx[k];
//                    int ny = i + dy[k];
//
//                    if(nx >= 0 && nx < n && nx >= 0 && nx < n) {
//                        if (nums[nx][ny] >= nums[i][j]) {
//                            flag = false;
//                            break;
//                        }
//                    }
//                }
//                if(flag) answer++;
//            }
//        }
//
//        return answer;
//    }
//
//    //2-9 격자판 최대합 구하기
//    public static int getMaxPlusNum(int n, int[][] nums){
//        int answer = 0;
//        int[] resultNums = new int[n * 2 + 2];
//        int c = 0;
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                resultNums[c] += nums[i][j];
//            }
//            c++;
//        }
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                resultNums[c] += nums[j][i];
//            }
//            c++;
//        }
//
//        for(int i = 0; i < n; i++){
//            resultNums[c] += nums[i][i];
//        }
//        c++;
//
//        for(int i = 0; i < n; i++)
//        {
//            int j = 4;
//            resultNums[c] += nums[i][j--];
//        }
//
//        answer = resultNums[0];
//        for(int i = 0; i < resultNums.length - 1; i++){
//            if(answer < resultNums[i])
//                answer = resultNums[i];
//        }
//
//        return answer;
//    }
//
//    //2-9 격자판 최대합 구하기 강의풀이
//    public static int getMaxPlusNumV2(int n, int[][] nums){
//        int answer = Integer.MIN_VALUE;
//        int sum1, sum2;
//        for(int i = 0; i < n; i++){
//            sum1 = sum2 = 0;
//            for(int j = 0; j < n; j++){
//                sum1 += nums[i][j];
//                sum2 += nums[j][i];
//            }
//            answer = Math.max(answer, sum1);
//            answer = Math.max(answer, sum2);
//        }
//
//        for (int i = 0; i < n; i++){
//            sum1 = sum2 = 0;
//            sum1 = nums[i][i];
//            sum2 = nums[i][n - i - 1];
//            answer = Math.max(answer, sum1);
//            answer = Math.max(answer, sum2);
//        }
//
//        return answer;
//    }
//
//    //2-8 등수 구하기
//    public static int[] getRank(int[] nums){
//        int[] ranks = IntStream.generate(() -> 1).limit(nums.length).toArray();
//
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i + 1; j < nums.length; j++){
//                if(nums[i] > nums[j]) {
//                    ++ranks[j];
//                }
//                else if(nums[i] < nums[j]){
//                    ++ranks[i];
//                }
//            }
//        }
//
//        return ranks;
//    }
//
//    //2-8 등수 구하기 강의 풀이
//    public static int[] getRankV2(int n,int[] nums){
//        int[] answer = new int[n];
//        for (int i = 0; i < n; i++) {
//            int cnt = 1;
//            for (int j = 0; j < n; j++){
//                if (nums[j] > nums[i]) cnt++;
//            }
//            answer[i] = cnt;
//        }
//        return answer;
//    }
//
//    //2-7 점수 계산
//    public static int calResult(int n, int[] nums){
//        int answer = 0;
//        boolean prev = false;
//
//        int num = 0;
//        for(int i = 0; i < n; i++) {
//            if (nums[i] == 1 && prev == false) {
//                prev = true;
//                answer += ++num;
//            } else if (nums[i] == 1 && prev == true) {
//                answer += ++num;
//            } else {
//                prev = false;
//                num = 0;
//            }
//        }
//
//        return answer;
//    }
//
//    //2-7 점수 계산 강의 문제풀이
//    public static int solution(int n, int[] arr){
//        int answer = 0, cnt = 0;
//        for(int i = 0; i < n; i++){
//            if(arr[i] == 1){
//                cnt++;
//                answer += cnt;
//            }
//            else cnt = 0;
//        }
//
//        return answer;
//    }
//
//    //2-6 뒤집은 소수
//    public static String convertPrimeNum(int n, String nums){
//        String answer = "";
//        String[] numsStringArray = nums.split(" ");
//
//        for(int i = 0; i < n; i++){
//            StringBuffer sb = new StringBuffer(numsStringArray[i]);
//            int num = Integer.parseInt(sb.reverse().toString());
//            boolean result = true;
//
//            if(num > 1) {
//                for (int j = 2; j <= num / 2; j++) {
//                    if (num % j == 0) {
//                        result = false;
//                        break;
//                    } else {
//                        result = true;
//                    }
//                }
//
//                if(result)
//                    answer += num + " ";
//            }
//
//
//        }
//        return answer;
//    }
//
//    //2-6 뒤집은 소수 강의 풀의
//    public static ArrayList<Integer> convertPrimeNum2(int n, int[] arr){
//        ArrayList<Integer> answer = new ArrayList<>();
//        for(int i =0; i < n; i++){
//            int temp = arr[i];
//            int res = 0;
//            while (temp > 0){
//                int t = temp % 10;
//                res = res * 10 + t;
//                temp /= 10;
//            }
//            if(isPrime(res))
//                answer.add(res);
//        }
//        return answer;
//    }
//
//    public static boolean isPrime(int num){
//        if(num == 1)
//            return false;
//        for(int i = 0; i < num; i++){
//            if(num % i == 0)
//                return false;
//        }
//        return true;
//    }
//
//    //2-5 소수(에라토스테네스의 체)
//    public static int SieveOfEratosthenes(int num){
//        int answer = 0;
//        int[] ch = new int[num + 1];
//        for(int i = 2; i <= num; i++){
//            if(ch[i] == 0){
//                answer++;
//            }
//            for (int j = i; j <= num; j = j + i) {
//                ch[j] = 1;
//            }
//        }
//
//        return answer;
//    }
//
//    //2-4 피보나치 수열 강의 풀이
//    public static int[] fibonacciSequence(int num) {
//        int[] answer = new int[num];
//        answer[0] = 1;
//        answer[1] = 1;
//        for(int i = 2; i < num; i++){
//            answer[i] = answer[i - 2] + answer[i - 1];
//        }
//
//        return answer;
//    }
//
//    //2-4 피보나치 수열 강의 풀이(배열 없이)
//    public static void fibonacciSequence2(int num){
//        int fir = 1;
//        int sec = 1;
//        int tmp = 0;
//
//        System.out.print(fir + " ");
//        System.out.print(sec + " ");
//        for (int i = 2; i < num; i++){
//            tmp = fir + sec;
//            System.out.print(tmp + " ");
//            fir = sec;
//            sec = tmp;
//        }
//    }
//
//    //2-3 가위 바위 보
//    public static ArrayList<String> rockScissorPaper(int n, int[] numsA, int[] numsB){
//        ArrayList<String> result = new ArrayList<String>();
//
//        for(int i = 0; i < n; i++)
//        {
//            if(numsA[i] == numsB[i])
//                result.add("D");
//            else if(numsA[i] == 1 && numsB[i] == 3)
//                result.add("A");
//            else if(numsA[i] == 2 && numsB[i] == 1)
//                result.add("A");
//            else if(numsA[i] == 3 && numsB[i] == 2)
//                result.add("A");
//            else
//                result.add("B");
//        }
//
//        return result;
//    }
//
//    //2-2 보이는 학생 수 세기
//    public static int seeBigStudent(int n, int[] nums){
//        int answer = 1;
//        int max = nums[0];
//
//        for(int i = 1; i < n; i++) {
//            if(max < nums[i]){
//                answer++;
//                max = nums[i];
//            }
//        }
//
//        return answer;
//    }
//
//    //2-1 큰 수 출력하기
//    public static String showBigNum(String line1, String line2){
//        String answer = "";
//        int num = Integer.parseInt(line1);
//        int[] nums = new int[num];
//
//        for(int i = 0; i < num; i++){
//            nums[i] = Integer.parseInt(line2.split(" ")[i]);
//        }
//
//        answer += nums[0];
//        for(int i = 1; i < num; i++){
//            if(nums[i] > nums[i -1])
//                answer += " " + nums[i];
//        }
//
//        return answer;
//    }
//
//    //1-12 암호 해독
//    public static String decode(String line1, String line2){
//        String answer = "";
//        int num = Integer.parseInt(line1);
//
//        for(int i = 0; i < num; i++)
//        {
//            String code = line2.substring(i * 7, (i+1) * 7);
//            char decode = 0;
//            code = code.replace('#', '1').replace('*', '0');
//
//            decode += Integer.parseInt(code, 2);
//            answer += decode;
//        }
//
//
//        return answer;
//    }
//
//    //1-11 문자열 압축
//    public static String compressionWord(String s){
//        String answer = "";
//        char[] chars = s.toCharArray();
//        int count = 1;
//
//        for(int i = 0; i < chars.length - 1; i++){
//            if(chars[i] == chars[i + 1]){
//                count++;
//            }
//            else {
//                answer += chars[i];
//                if(count > 1) answer += String.valueOf(count);
//                count = 1;
//
//            }
//        }
//        answer += chars[chars.length - 1];
//        if(count > 1) answer += count;
//
//
//        return answer;
//    }
//
//    //1-10 가장 짧은 문자 거리
//    public static int[] getCharDistance(String line) {
//        String[] split = line.split(" ");
//        String standard = split[0];
//        char target = split[1].charAt(0);
//        int[] answer = new int[standard.length()];
//        int p = 1000;
//
//        for(int i = 0; i < standard.length(); i++){
//            if(standard.charAt(i) == target){
//                p = 0;
//                answer[i] = p;
//            }
//            else
//                answer[i] = ++p;
//        }
//        p = 1000;
//
//        for(int i = standard.length() - 1; i >= 0; i--){
//            if (standard.charAt(i) == target)
//                p = 0;
//            else{
//                answer[i] = Math.min(answer[i], ++p);
//            }
//
//        }
//
//        return answer;
//    }
//
//    //1-9 숫자만 추출
//    public static int extractNum(String line){
//        int answer = 0;
//        char[] chars = line.toCharArray();
//        for(char x: chars){
//            if(x >= 48 && x <= 57){
//                answer = answer * 10 + (x - 48);
//            }
//        }
//        return answer;
//    }
//
//    //1-9 숫자만 추출
//    public static int extractNum2(String line){
//        String answer = "";
//        for(char x: line.toCharArray()){
//            if(Character.isDigit(x)){
//                answer += x;
//            }
//        }
//        return Integer.parseInt(answer);
//    }
//
//    //1-8 유효한 팰린드롬
//    public static String palindromeString(String line){
////        String answer = "NO";
////        line = line.toLowerCase().replaceAll("[^a-z]", "");
////        String tmp = new StringBuffer(line).reverse().toString();
////
////        if(tmp.equals(line))
////            answer = "YES";
////
////        return answer;
//        String answer = "NO";
//        int end = line.length() - 1;
//        for(int i=0; i< line.length()/2; i++, end--) {
//            if (line.charAt(i) != line.charAt(end)) {
//                return "NO";
//            }
//        }
//        return "YES";
//    }
//
//
//
//    //1-7 회문 문자열
//    public static String palindromeWord(String line){
//        /*char[] chars = line.toLowerCase().toCharArray();
//        int lt = 0;
//        int rt = chars.length - 1;
//
//
//        while (lt < rt){
//            if(!(chars[lt] == chars[rt])) {
//                return "NO";
//            }
//
//            lt++;
//            rt--;
//        }
//
//        return "YES";*/
//
//        String tmp = new StringBuffer(line).reverse().toString();
//        if(tmp.equalsIgnoreCase(line))
//            return "YES";
//        else
//            return "NO";
//    }
//
//    //1-6 중복문자제거
//    public static String removeDuplicateChar(String line){
//        char[] chars = line.toCharArray();
//        int lt = 0;
//        int rt = line.length() - 1;
//        String returnString = new String();
//
//        for (int i = 0; i < line.length(); i++)
//        {
//            if(line.indexOf(line.charAt(i)) == i){
//                returnString += line.charAt(i);
//            }
//        }
///*
//
//        while (lt < rt){
//            if (chars[lt] == chars[rt]){
//                chars[rt] = 0;
//                rt--;
//            }
//            else rt--;
//
//            if(lt + 1 == rt) {
//                lt++;
//                rt = chars.length - 1;
//            }
//        }
//
//        for(int i = 0; i < chars.length; i++){
//            if(chars[i] >= 0x61 && chars[i] <= 0x7A) {
//                returnString += chars[i];
//            }
//        }
//*/
//
//        return returnString;
//    }
//
//    //1-5 특정 문자 뒤집기
//    public static String reverseSpecWord(String line){
//        char[] chars = line.toCharArray();
//        int lt = 0;
//        int rt = chars.length - 1;
//
//        while (lt < rt){
///*            if((chars[lt] >= 0x41 && chars[lt] <= 0x5A)
//                    || (chars[lt] >= 0x61 && chars[lt] <= 0x7A)) {
//                tmp = chars[lt];
//
//                if((chars[rt] >= 0x41 && chars[rt] <= 0x5A)
//                        || (chars[rt] >= 0x61 && chars[rt] <= 0x7A)) {
//                    chars[lt] = chars[rt];
//                    lt++;
//                }
//            } else {
//                lt++;
//            }
//
//            if((chars[rt] >= 0x41 && chars[rt] <= 0x5A)
//                    || (chars[rt] >= 0x61 && chars[rt] <= 0x7A)) {
//                chars[rt] = tmp;
//                if((chars[lt] >= 0x41 && chars[lt] <= 0x5A)
//                        || (chars[lt] >= 0x61 && chars[lt] <= 0x7A)) {
//                    rt--;
//                    tmp = 0;
//                }
//            } else{
//                rt--;
//            }*/
//            if(!Character.isAlphabetic(chars[lt])){
//                lt++;
//            } else if(!Character.isAlphabetic(chars[rt])){
//                rt--;
//            }else {
//                char tmp = chars[lt];
//                chars[lt] = chars[rt];
//                chars[rt]= tmp;
//                lt++;
//                rt--;
//            }
//        }
//
//        return String.valueOf(chars);
//    }
//
//    //1-4 단어 뒤집기
//    public static ArrayList<String> reverseWords(String[] words){
////       ArrayList<String> stringArrayList = new ArrayList<>();
////
////        for(int i = 0; i < words.length; i++){
////           StringBuffer sb = new StringBuffer(words[i]);
////           stringArrayList.add(sb.reverse().toString());
////       }
//
//        ArrayList<String> stringArrayList = new ArrayList<>();
//
//       for (String s : words){
//           char[] chars = s.toCharArray();
//           int lt = 0;
//           int rt = s.length() - 1;
//           while (lt < rt){
//               char tmp = chars[lt];
//               chars[lt] = chars[rt];
//               chars[rt] = tmp;
//               lt++;
//               rt--;
//           }
//
//           stringArrayList.add(String.valueOf(chars));
//       }
//
//       return stringArrayList;
//    }
//
//    //1-3 문장 속 단어
//    public static String findLongestWord(String line){
//        String[] words = line.split(" ");
//        int index = 0;
//        int length = words[0].length();
//
//        for (int i = 0; i < words.length - 1; i++){
//            if(length < words[i + 1].length())
//                index = i + 1;
//
//        }
//
//        return words[index];
//    }
//
//    //1-2 대소문자 변환
//    public static String changeUpperLowerCase(String line){
////        char[] returnChar = new char[line.length()];
////
////        for (int i = 0; i < returnChar.length; i++){
////            char c = line.charAt(i);
////
////            if(Character.isUpperCase(c))
////                returnChar[i] = Character.toLowerCase(c);
////            else if(Character.isLowerCase(c))
////                returnChar[i] = Character.toUpperCase(c);
////        }
//
//        String returnString = "";
//        for(char c: line.toCharArray()){
//            if(Character.isUpperCase(c))
//                returnString += Character.toLowerCase(c);
//            else if(Character.isLowerCase(c))
//                returnString += Character.toUpperCase(c);
//        }
//
//        return returnString;
//    }
//
//    //1-1 문자 찾기
//    public static int findAlphabet(String line1, char c){
//        line1 = line1.toUpperCase();
//        char specialChar = Character.toUpperCase(c);
//        int count = 0;
//
////        for(int i = 0; i < line1.length(); i++){
////            if(line1.charAt(i) == specialChar)
////                count++;
////        }
//
//        for(char x : line1.toCharArray()){
//            if(x == specialChar)
//                count++;
//        }
//
//        return count;
//    }
//
//    public static void findWord(String line){
//        String[] lines = line.split(" ");
//        int count = 0;
//
//        for(String s: lines){
//            if(s.equals("") != true)
//                count++;
//
//        }
//
//        System.out.println(count);
//    }
//
//
//    public static void findAlphabetNum(String line){
//        int[] alphabetNums = new int[26];
//        int bigAlphabetNum = 0;
//        char bigAlphabet = 0;
//
//
//        for (int i = 0; i < line.length(); i++){
//            char alphabet = (Character.isUpperCase(line.charAt(i)) == true)? Character.toLowerCase(line.charAt(i)) : line.charAt(i);
//            alphabetNums[alphabet - 'a']++;
//        }
//
//        for(int i = 0; i < alphabetNums.length; i++){
//            if(bigAlphabetNum < alphabetNums[i]) {
//                bigAlphabetNum = alphabetNums[i];
//                bigAlphabet = (char)(i + 'A');
//            }
//            else if(bigAlphabetNum == alphabetNums[i]){
//                bigAlphabet = '?';
//            }
//            else {
//
//            }
//        }
//
//        System.out.println(bigAlphabet);
//    }
//
//    public static void newAverage(String line, String scoreString) throws IOException {
//
//
//        int scoreNum = Integer.parseInt(line);
//        String[] scoreStrings = scoreString.split(" ");
//        int[] scoreNums = new int[scoreNum];
//        int bigNum = 0;
//        float result = 0;
//
//        for(int i = 0; i < scoreNum; i++){
//            scoreNums[i] = Integer.parseInt(scoreStrings[i]);
//            if(bigNum < scoreNums[i])
//                bigNum = scoreNums[i];
//        }
//
//        for(int i = 0; i < scoreNum; i++){
//            result += (((float)scoreNums[i] / bigNum) * 100);
//        }
//
//        System.out.println(result / scoreNum);
//    }
//}
//
////5 - 8 응급실 문제용 클래스
//class Person {
//    public int id;
//    public int crit;
//
//    public Person(int id, int crit) {
//        this.id = id;
//        this.crit = crit;
//    }
//}
//
////6-7 좌표 정렬용 클래스
//class Point implements Comparable<Point>{
//    public int x, y;
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public int compareTo(Point o) {
//        if(this.x == o.x) return this.y - o.y;
//        else return this.x - o.x;
//    }
//}
//
////7-5 이진트리 순회(DFS)용 클래스
//class Node{
//    int data;
//    Node lt, rt;
//
//    public Node(int val) {
//        data = val;
//        lt = rt = null;
//    }
//    static class Point {
//        public int x;
//        public int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}