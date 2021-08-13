import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        char c = sc.next().charAt(0);

        System.out.print(findAlphabet(line1, c));
    }

    public static int findAlphabet(String line1, char c){
        line1 = line1.toUpperCase();
        char specialChar = Character.toUpperCase(c);
        int count = 0;

        for(int i = 0; i < line1.length(); i++){
            if(line1.charAt(i) == specialChar)
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