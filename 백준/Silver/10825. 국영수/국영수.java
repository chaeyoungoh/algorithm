import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;
        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(this.korean == o.korean) {
                if(this.english == o.english) {
                    if(this.math == o.math) {
                        return this.name.compareTo(o.name);
                    }
                    return o.math - this.math;
                }
                return this.english - o.english;
            }

            return o.korean - this.korean;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Student> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, kor, eng, math));
        }

        Collections.sort(list);

        for(Student s : list) {
            sb.append(s.name).append('\n');
        }

        System.out.print(sb.toString());
    }
}