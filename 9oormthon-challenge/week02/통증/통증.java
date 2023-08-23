import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int answer = 0;
        answer += N / 14;
        N = N % 14;
        
        answer += N / 7;
        N = N % 7;

        answer += N;

        System.out.println(answer);
        
	}
}