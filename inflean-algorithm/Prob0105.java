import java.util.Scanner;

public class Prob0105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] arr = input.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            if (('a' <= arr[i] && arr[i] <= 'z') || ('A' <= arr[i] && arr[i] <= 'Z')) {
                sb.append(arr[i]);
            }
        }

        char[] reverseArray = sb.reverse().toString().toCharArray();
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (('a' <= arr[i] && arr[i] <= 'z') || ('A' <= arr[i] && arr[i] <= 'Z')) {
                System.out.print(reverseArray[j++]);
            } else {
                System.out.print(arr[i]);
            }
        }
    }

}
