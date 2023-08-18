package 완벽한_햄버거_만들기;
import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int times = scanner.nextInt();
		long sum = 0;
		int before = 0;
		boolean upFlag = true;
		boolean downFlag= false;
		boolean perfectFlag = true;
		
		for (int i = 0; i < times; i++) {
			int input = scanner.nextInt();
			if (upFlag) {
				if (input >= before) {
					sum += input;
					before = input;
				} else {
					upFlag = false;
					sum += input;
					before = input;
				}
			} else {
				if (input <= before) {
					sum += input;
					before = input;
				} else {
					perfectFlag = false;
				}
			}
		}
		
		if (perfectFlag) {
			System.out.println(sum);
		} else {
			System.out.println(0);
		}
	}
}
