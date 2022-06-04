package inflear_problem.string;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    Main t = new Main();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
    Integer count = Integer.valueOf(br.readLine());
    String password = br.readLine();

    t.password_12(count, password);
  }

  public void password_12(Integer count, String password) {
    StringBuilder answer = new StringBuilder();


    for (int i = 0; i < count; i++) {
      StringBuilder onePassword = new StringBuilder();
      char ch = 0;
      for (int j = i * 7; j < i * 7 + 7; j++) {
        if (password.charAt(j) == '#') {
          onePassword.append("1");
        }else {
          onePassword.append("0");
        }
        ch = (char) Integer.parseInt(onePassword.toString(), 2);
      }
      answer.append(ch);
    }

    System.out.println(answer);
  }

  public void compressString_11(String word) {
    StringBuilder answer = new StringBuilder();
    int num = 1;

    char temp = word.charAt(0);
    answer.append(temp);
    for (int i = 1; i < word.length(); i++) {
      if (word.charAt(i) != temp) {
        if (num > 1) {
          answer.append(num);
        }
        answer.append(word.charAt(i));
        temp = word.charAt(i);
        num = 1;
      } else {
        num++;
      }
    }

    System.out.println(answer.append(num));
  }

  public void distanceChar_10(String word, Character ch) {
    int length = word.length();
    Integer[] nums = new Integer[length];
    StringBuilder answer = new StringBuilder();

    Integer num = 100;
    for (int i = 0; i < length; i++) {
      if (word.charAt(i) != ch) {
        nums[i] = ++num;
      } else {
        nums[i] = num = 0;
      }
    }

    for (int i = length - 1; i >= 0; i--) {
      if (word.charAt(i) != ch) {
        num++;
        if (nums[i] > num) {
          nums[i] = num;
        }
      } else {
        num = 0;
      }
    }

    for (Integer n : nums) {
      answer.append(n).append(" ");
    }
    System.out.println(answer);
  }

  public void extractNum_09(String word) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      if (Character.isDigit(word.charAt(i))) {
        sb.append(word.charAt(i));
      }
    }

    System.out.println(Integer.valueOf(sb.toString()));
  }

  public void palindromeString_08(String word) {
    int length = word.length();
    String answer = "YES";
    int lt = 0;
    int rt = length - 1;

    while (lt < rt) {
      if (Character.isAlphabetic(word.charAt(lt)) && Character.isAlphabetic(word.charAt(rt))) {
        if (word.charAt(lt) != word.charAt(rt)) {
          answer = "NO";
          break;
        }
        lt++;
        rt--;
      } else if (Character.isAlphabetic(word.charAt(lt))) {
        rt--;
      } else if (Character.isAlphabetic(word.charAt(rt))) {
        lt++;
      } else {
        lt++;
        rt--;
      }
    }

    System.out.println(answer);
  }

  public void palindromeString_07(String word) {
    int length = word.length();
    String answer = "YES";

    for (int i = 0; i < length / 2; i++) {
      if (word.charAt(i) != word.charAt(length - i - 1)) {
        answer = "NO";
        break;
      }
    }

    System.out.println(answer);
  }

  public void removeDuplicateChar_06(String word) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < word.length(); i++) {
      if (i == word.indexOf(word.charAt(i))) {
        sb.append(word.charAt(i));
      }
    }

    System.out.println(sb);
  }

  public void reversWords_05(String word) {
    char[] chars = word.toCharArray();
    int lt = 0;
    int rt = chars.length - 1;

    while (lt < rt) {
      if (Character.isAlphabetic(chars[lt]) && Character.isAlphabetic(chars[rt])) {
          char temp = chars[lt];
          chars[lt++] = chars[rt];
          chars[rt--] = temp;
      } else if (Character.isAlphabetic(chars[lt])) {
        rt--;
      } else if (Character.isAlphabetic(chars[rt])) {
        lt++;
      } else {
        lt++;
        rt--;
      }
    }
    System.out.println(chars);
  }

  public void reversWords_04(String[] words) {
    for (String word : words) {
      char[] chars = word.toCharArray();
      int length = chars.length;

      for (int i = 0; i < length / 2; i++) {
        Character temp = chars[i];
        chars[i] = chars[length - i - 1];
        chars[length - i - 1] = temp;
      }

      System.out.println(chars);
    }
  }

  public void wordsInASentence_03(String string) {
    Integer max = Integer.MIN_VALUE;
    Integer index = 0;

    String[] words = string.split(" ");

    for (int i = 0; i < words.length; i++) {
      if (max < words[i].length()) {
        max = words[i].length();
        index = i;
      }
    }

    System.out.println(words[index]);
  }

  public void caseConversion_02(char[] string) {
    for (int i = 0; i < string.length; i++) {
      char c = string[i];

      if (Character.isUpperCase(c)) {
        string[i] = Character.toLowerCase(c);
        continue;
      }

      string[i] = Character.toUpperCase(c);
    }
    System.out.println(string);
  }

  public void findChar_01(char[] string, Character ch) {
    int count = 0;
    for (Character character : string) {
      if (character == ch) {
        count++;
      }
    }

    System.out.println(count);
  }
}
