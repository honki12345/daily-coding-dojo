import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int times = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for (int i = 0; i < times; i++) {
			String[] statement = br.readLine().split(" ");
			int result = op(statement[0], statement[1], statement[2]);
			sum += result;
		}

		System.out.println(sum);

	}

	public static int op(String x, String y, String operator) {
		int intX = Integer.parseInt(x);
		int intY = Integer.parseInt(y);

		if (operator.equals("+")) {
			return intX + intY;
		} else if (operator.equals("-")) {
			return intX - intY;
		} else if (operator.equals("*")) {
			return intX * intY;
		} else if (operator.equalsIgnoreCase("/")) {
			return intX / intY;
		}

		return 0;
	}
}