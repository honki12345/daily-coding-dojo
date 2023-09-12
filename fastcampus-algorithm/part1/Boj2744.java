import java.util.Scanner;

public class Boj2744 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if ('a' <= ch && ch <= 'z') {
                charArray[i] = Character.toUpperCase(ch);
            } else if ('A' <= ch && ch <= 'Z') {
                charArray[i] = Character.toLowerCase(ch);
            }
        }

        System.out.println(new String(charArray));

        scanner.close();
    }
}
