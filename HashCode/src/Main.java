import java.util.HashSet;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "heihei";
        System.out.println(((String)d).hashCode());

        Student student = new Student(3, 2, "chen", "cheng");
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(student);

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 88);

        Student student2 = new Student(3, 2, "chen", "cheng");
        System.out.println(student2.hashCode());
    }
}
