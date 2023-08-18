import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
    /**
     * 2진수에 포함된 1의 개수
     * 1) 2로 나누었을 때 나누어떨어지지 않는 횟수
     * 최대 2의 20승이라면 나누는 횟수는 20번
     * 정수의 수 최대 500,000
     * 총 최대 횟수는 10,000,000
     * -> 1억이안되어 연산횟수 1초 안됨
     */
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int answerIndex = scanner.nextInt() - 1;
        ArrayList<Number> numberList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int input = scanner.nextInt();
            Number number = new Number(input);
            numberList.add(number);
        }

        Collections.sort(numberList);
        System.out.println(numberList.get(answerIndex));
	}
}

class Number implements Comparable<Number> {
    private int decimal;
    private int binaryCount;

    public Number(int decimal) {
        this.decimal = decimal;
        this.binaryCount = createBinaryCount();
    }

    public int createBinaryCount() {
        int count = 0;
        int number = this.decimal;
        
        while (number != 0) {
            if (number == 0) {
                break;
            } else {
                if (number % 2 == 1) {
                    count++;
                }
                number = number / 2;
            }
        }

        return count;
    }

    public int getDecimal() {
        return decimal;
    }

    public int getBinaryCount() {
        return binaryCount;
    }

    @Override
    public int compareTo(Number o) {
        int number1BinaryCount = this.getBinaryCount();
        int number2BinaryCount = o.getBinaryCount();

        if (number1BinaryCount < number2BinaryCount) {
            return 1;
        } else if (number1BinaryCount > number2BinaryCount) {
            return -1;
        } else {
            int number1Decimal = this.getDecimal();
            int number2Decimal = o.getDecimal();

            if (number1Decimal < number2Decimal) {
                return 1;
            } else if (number1Decimal > number2Decimal) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return this.decimal + "";
    }
}