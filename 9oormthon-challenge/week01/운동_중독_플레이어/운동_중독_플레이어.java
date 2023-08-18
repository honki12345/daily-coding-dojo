package 운동_중독_플레이어;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] stringArray = input.split(" ");
		Double w = Double.parseDouble(stringArray[0]);
		Double r = Double.parseDouble(stringArray[1]);
		
		int result = (int)Math.floor(w * (1 + r / 30));
		System.out.println(result);
	}
}
