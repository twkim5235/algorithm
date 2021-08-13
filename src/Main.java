import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();


        System.out.print(findLongestWord(line));
    }

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