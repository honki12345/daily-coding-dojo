import java.util.List;
import java.util.Stack;

public class Day0308 {
  public static void main(String[] args) {
    String str = "bacedufivo";
    char[] charArray = str.toCharArray();
    boolean[] isVowel = new boolean[charArray.length];
    List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < charArray.length; i++) {
      if (vowels.contains(charArray[i])) {
        isVowel[i] = true;
        stack.push(charArray[i]);
      }
    }

    for (int i = 0; i < charArray.length; i++) {
      if (isVowel[i]) {
        charArray[i] = stack.pop();
      }
    }

    System.out.println(new String(charArray));

  }

}
