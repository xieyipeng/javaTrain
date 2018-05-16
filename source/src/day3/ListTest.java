package day3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 遍历集合的操作，（list，map），eg:fori，foreach，stream，iterator；
 */
public class ListTest {
    public static void main(String[] args) {
        List<Student>stringList=new ArrayList<>();
        stringList.add(new Student(16,"a"));
        stringList.add(new Student(15,"b"));
        stringList.add(new Student(18,"c"));
        stringList.add(new Student(11,"d"));
        stringList.add(new Student(16,"e"));
        stringList.add(new Student(19,"f"));
        stringList.add(new Student(12,"j"));
        stringList.add(new Student(14,"h"));
        stringList.add(new Student(17,"i"));
        stringList.add(new Student(16,"j"));

        System.out.println("fori :");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i).getName()+" ");
            System.out.println(stringList.get(i).getAge());
        }

        System.out.println("foreach :");
        for (Student student:
             stringList) {
            System.out.print(student.getName()+" ");
            System.out.println(student.getAge());
        }

        System.out.println("stream :");
        stringList.stream()
                .forEach(student -> System.out.println(student.getName()+" "+student.getAge()));

        System.out.println("iterator :");
        Iterator iterator=stringList.iterator();
        while (iterator.hasNext()){
            Student student=(Student)iterator.next();
            System.out.println(student.getName()+" "+student.getAge());
        }
    }
}
