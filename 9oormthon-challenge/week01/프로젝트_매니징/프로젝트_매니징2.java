package 프로젝트_매니징;
import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int times = Integer.parseInt(br.readLine());
		String[] timeString = br.readLine().split(" ");
		Time time = new Time(Integer.parseInt(timeString[0]),
												 Integer.parseInt(timeString[1]));
		
		for (int i = 0; i < times; i++) {
			times = Integer.parseInt(br.readLine());
			timeString = br.readLine().split(" ");
			Time tmp = new Time(Integer.parseInt(timeString[0]),
											 Integer.parseInt(timeString[1]));
			time.addTime(tmp);
		}
	System.out.println(time);
	}
	
}

class Time {
	private int hour;
	private int minute;

	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	public int getHour() {
		return this.hour;
	}
	
	public int getMinute() {
		return this.minute;
	}
	
	@Override
	public String toString() {
		return hour + " " + minute;
	}	
	
	public void addMinute(int minute) {
		int totalMinute = this.minute + minute;
		int addHour = totalMinute / 60;
		addHour(addHour);
		
		this.minute = totalMinute % 60;
	}
	
	public void addHour(int hour) {
		this.hour += hour;
	}
	
	public void addTime(Time time) {
		addMinute(time.getMinute());
		addHour(time.getHour());
	}
}