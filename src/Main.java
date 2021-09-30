import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int answer = 0;
    static int weight;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        Main T = new Main();
        weight = sc.nextInt();
        int num = sc.nextInt();

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        T.heaviestRideDog(0, 0, arr);

        System.out.println(answer);

    }

    //8-2 바둑이 승차(DFS)
    public void heaviestRideDog(int level, int sum, int[] dogs){
        if(weight < sum) return;
        if(level == dogs.length) {
            answer = Math.max(answer, sum);
        }
        else {
            heaviestRideDog(level + 1,sum + dogs[level], dogs);
            heaviestRideDog(level + 1, sum, dogs);
        }
    }


//    //8-1 합이 같은 부분 집합(DFS)
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
}