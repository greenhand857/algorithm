package ZuoShen.Class04;

import java.util.Arrays;
import java.util.Comparator;

public class _01_Comparator {

    // 定义一个学生类
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    // 定义Id升序比较器
    // 返回负数的时候，第一个参数排在前面
    // 返回正数的时候，第二个参数排在前面
    // 返回0的时候，谁在前面无所谓
    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    // 年龄倒序比较器
    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    // 先按照id排序，id小的，放前面；
    // id一样，age大的，前面；
    public static class IdInAgeDe implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id != o2.id ? (o1.id-o2.id) : (o2.age - o1.age);
        }
    }

    // for test
    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
    }

    public static void printArray(Integer[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static class AComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }

        public static void main(String[] args) {
        Integer[] arr = {5,4,3,2,7,9,1,0};
        Arrays.sort(arr, new AComp());

        for(int i = 0 ;i < arr.length;i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        System.out.println("===========================");

        Student student1 = new Student("A", 2, 20);
        Student student2 = new Student("B", 3, 21);
        Student student3 = new Student("C", 1, 22);
        Student student4 = new Student("D", 2, 24);

        Student[] students = new Student[] { student1, student2, student3, student4 };
        System.out.println("第一条打印");
        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);
        System.out.println("===========================");
        System.out.println("第二条打印");
        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);
        System.out.println("===========================");
        System.out.println("第三条打印");
        Arrays.sort(students, new IdInAgeDe());
        printStudents(students);
        System.out.println("===========================");
    }
}
