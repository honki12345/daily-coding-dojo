import java.util.Scanner;

public class Boj1919 {
    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        // a와 b의 알파벳 구성성분 개수(배열)를 구한다
        int[] countA = getAlphabetCount(a);
        int[] countB = getAlphabetCount(b);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(countA[i] - countB[i]);
        }
        System.out.println(ans);
    }
}
