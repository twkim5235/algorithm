import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        for (int x: getCharDistance(line)){
            System.out.print(x + " ");
        }
    }

    //1-10
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

    //1-9
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

    //1-9
    public static int extractNum2(String line){
        String answer = "";
        for(char x: line.toCharArray()){
            if(Character.isDigit(x)){
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    //1-8
    public static String palindromeString(String line){
        String answer = "NO";
        line = line.toLowerCase().replaceAll("[^a-z]", "");
        String tmp = new StringBuffer(line).reverse().toString();

        if(tmp.equals(line))
            answer = "YES";

        return answer;
    }

    //1-7
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

    //1-6
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

    //1-5
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

    //1-4
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

    //1-3
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

    //1-2
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

    //1-1
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