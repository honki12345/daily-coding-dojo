package me.honki12345.timecalcul;

import java.util.Scanner;

public class TimeCalculator {
    private static final String inputRequestString = "더하고자하는 시간의 분(minute)과 초(seconds)를 입력하세요";
    public static final String inputExampleString = "e.g. (3분 40초를 입력하고자할시) 3 40";
    public static final String numberFormatExceptionMessage = "잘못된 입력입력입니다. 다시 입력해주세요";
    public static final String inputEndConditionString = "종료를 원하시면 END 를 입력해주세요";
    public static final String END_COMMAND = "END";

    public static void main(String[] args) {
        System.out.println(inputRequestString);
        System.out.println(inputExampleString);
        System.out.println(inputEndConditionString);

        Time time = new Time();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String inputLine = scanner.nextLine();

            if (inputLine != null && inputLine.equalsIgnoreCase(END_COMMAND)) {
                System.out.println(time);
                break;
            }

            String[] stringArray = inputLine.split(" ");
            int minute;
            int seconds;

            try {
                minute = Integer.parseInt(stringArray[0]);
                seconds = Integer.parseInt(stringArray[1]);
            } catch (NumberFormatException e) {
                System.out.println(numberFormatExceptionMessage);
                continue;
            }

            time.add(minute, seconds);
            System.out.println(time);

        }
    }

    static class Time {
        private int hour;
        private int minute;
        private int seconds;

        public Time() {
            this.hour = 0;
            this.minute = 0;
            this.seconds = 0;
        }

        public void add(int minute, int seconds) {
            this.seconds += seconds;

            if (this.seconds >= 60) {
                this.minute += this.seconds / 60;
                this.seconds = this.seconds % 60;
            }

            this.minute += minute;

            if (this.minute >= 60) {
                this.hour += this.minute / 60;
                this.minute = this.minute % 60;
            }
        }

        @Override
        public String toString() {
            return String.format("%d시간 %d분 %d초", this.hour, this.minute, this.seconds);
        }
    }
}
