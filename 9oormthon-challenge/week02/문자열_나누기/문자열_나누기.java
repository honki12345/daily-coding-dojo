import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 문자열_나누기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        List<String> sortedP = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                String substring = str.substring(i, j);
                sortedP.add(substring);
                System.out.println(substring);
            }
        }


    }
}
