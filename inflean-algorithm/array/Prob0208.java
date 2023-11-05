import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Prob0208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            int score = sc.nextInt();
            students[i] = new Student(i, score);
        }

        Arrays.sort(students, (s1, s2) -> s2.getScore() - s1.getScore());
        for (int i = 0; i < students.length; i++) {
            if (i != 0 && students[i - 1].getScore() == students[i].getScore()) {
                int previousRank = students[i - 1].getRank();
                students[i].setRank(previousRank);
            } else {
                students[i].setRank(i + 1);
            }
        }
        Arrays.sort(students, Comparator.comparingInt(Student::getIndex));
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i].getRank() + " ");
        }
        // System.out.println();
        // for (int i = 0; i < students.length; i++) {
        // System.out.print(students[i].getIndex() + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < students.length; i++) {
        // System.out.print(students[i].getScore() + " ");
        // }
    }

    /**
     * Student
     */
    public static class Student {
        private int index;
        private int score;
        private int rank;

        public Student(int index, int score) {
            this.index = index;
            this.score = score;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

    }

}
