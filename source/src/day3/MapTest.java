package day3;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,Student>map=new HashMap<>();
        map.put(1,new Student(12,"a"));
        map.put(2,new Student(18,"b"));
        map.put(3,new Student(14,"c"));
        map.put(4,new Student(16,"d"));
        map.put(5,new Student(13,"e"));
        map.put(6,new Student(11,"f"));
        map.put(7,new Student(12,"j"));
        map.put(8,new Student(15,"h"));
        map.put(9,new Student(14,"i"));
        map.put(10,new Student(18,"g"));

        System.out.println("fori :");
        for (Map.Entry<Integer,Student> entry:map.entrySet()) {
            System.out.print(entry.getKey() + " = ");
            System.out.println(entry.getValue().getAge() + " " + entry.getValue().getName());
        }
//        for (int i = 0; i < map.size(); i++) {
//            System.out.println(map.get(i).getAge());
//        }
        System.out.println("foreach :");
        for (Map.Entry<Integer,Student> entry:
             map.entrySet()) {
            System.out.print(entry.getKey() + " = ");
            System.out.println(entry.getValue().getAge() + " " + entry.getValue().getName());
        }

        System.out.println("stream :");



    }
}
