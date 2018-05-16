### **part1**
* basedata

```java
package day3.part1;

public interface basedata <T>{
    void set(T t);
    T setT();
}
```

* Datalmp

```java
package day3.part1;

import day3.part1.basedata;

/**
 * 泛型类，泛型接口，泛型方法
 */
public class DataImp implements basedata<String> {
    @Override
    public void set(String s) {

    }

    @Override
    public String setT() {
        return null;
    }

    public static void main(String[] args) {

    }
}
```

* DataManger

```java
package day3.part1;

/**
 * 定义一个泛型
 *
 */
public class DataManager<T extends Number> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
```

* interData

```java
package day3.part1;

public class InterData {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
```

* StringData

```java
package day3.part1;

public class StringData {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

* test

```java
package day3.part1;

/**
 * 设计模式
 */
public class test {
    /**
     * 可变参数
     * @param args
     */
    public static void main(String...args) {
//        InterData interData=new InterData();
//        interData.setA(2);
//        System.out.println(interData.getA());

//        DataManager<Integer,String ,Boolean> integerDataManager=new DataManager<>();//泛型
//        integerDataManager.setE(5,"hello",false);
//        System.out.println(integerDataManager.getE());

//        DataManager<String> stringDataManager=new DataManager<>();
//        stringDataManager.setE("hello");
//        System.out.println(stringDataManager);

        /**
         * 写成 int a[]= {1,2,3,4}; 出错
         */
        Integer a[]= {1,2,3,4};
        say(a);
//        String string[]=new String[]{"hello","world","android"};
//        say(string);

    }

    /**
     * 泛型方法
     * 返回值类型随意
     * 可变参数
     * static 属于整个类
     * 泛型传入的类型是包装类
     * 传入多个参数种类时，可变参数必须放在最后一位
     * @param <T>
     * @param t
     */
     static <T> void say(T...t){
        //System.out.println(t.length);
        for (T aT : t) {
            System.out.println(aT);
        }
    }
}
```

### **part2**
* MapTest

```java
package day3.part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * list<String> 添加十个list，遍历。。。
 */
public class MapTest {
    public static void main(String[] args) {

        ArrayList<String>strings=new ArrayList<>();
        strings.add("hello");
        strings.add("android");
        strings.add("android");
        strings.add("nihao");

        Map<Integer,ArrayList<String>> map=new HashMap<>();
        map.put(1,  strings);
        map.put(2,  strings);


        //map.get(2);
        System.out.println(map.get(2));//key

        ArrayList<String>list=map.get(1);
        for (Map.Entry<Integer, ArrayList<String>> m:
             map.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }
    }
}
```

* SetTest

```java
package day3.part2;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * 与Arrange不同点：不能有相同的元素
 * set 是无序的；
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String >strings=new HashSet<>();
        strings.add("hello");
        strings.add("android");
        strings.add("android");
        strings.add("nihao");
        System.out.println(strings.size());
        strings.stream().forEach(new Consumer<String>() {//stream流输出；
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
```

* Student

```java
package day3.part2;


/**
 *
 * 创建一个集合，添加10个学生的元素，把age>20的放到一个集合，从第三个元素开始输出两个；
 */
public class student {
    private int age;
    private String name;

    public student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

* test

```java
package day3.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class test {
    public static void main(String[] args) {
        List<student>list=new ArrayList<>();
        List<student>age=new ArrayList<>();
        list.add(new student(16,"xiaoming"));
        list.add(new student(25,"xiaolan"));
        list.add(new student(23,"xiaohua"));
        list.add(new student(18,"xiaozo"));
        list.add(new student(15,"xiaobao"));
        list.add(new student(17,"xiaona"));
        list.add(new student(27,"xiaoguo"));
        list.add(new student(28,"xiaopeng"));
        list.add(new student(21,"xiaoxie"));
        list.add(new student(20,"xiaozhang"));
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getAge()>20){
                age.add(list.get(i));
            }
//            System.out.print(list.get(i).getAge());
//            System.out.println(list.get(i).getName());
        }

        for (int i = 0; i < age.size(); i++) {
            age.get(i).setName(age.get(i).getName()+" android lab");
        }

        for (int i=2;i<5;i++){
            System.out.print(age.get(i).getAge()+" ");
            System.out.println(age.get(i).getName());
        }
/**
 * stream 表达式
 */
//        list.stream().filter(new Predicate<student>() {
//            @Override
//            public boolean test(student student) {
//                return student.getAge()>20;
//            }
//        }).map(new Function<student, student>() {
//
//            @Override
//            public student apply(student student) {
//                student.setName(student.getName()+"androidlab");
//                return null;
//            }
//        }).skip(3).limit(2).peek(new Consumer<student>() {
//            @Override
//            public void accept(student student) {
//
//            }
//        });
//        for (student s :
//                list) {
//            System.out.println(s);
//        }
    }
}
```
### **part3**

```java
package day3;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合
 */
public class text {
    public static void main(String[] args) {

//        String s[]=new String[10];

        List<String >list=new ArrayList<>();
        list.add("nihao");



        ArrayList<String>strings=new ArrayList<>();
        strings.add("hello");
        strings.add(0,"android");
        strings.add("lab");
        strings.add("hello");
        strings.add("lab");



        System.out.println(strings.indexOf("hello"));//第一次出现的下标
        System.out.println(strings.lastIndexOf("hello"));//最后一个



        strings.addAll(list);//添加集合进去

        if(strings.contains("hello")){
            System.out.println("contain...");
        }else {
            System.out.println("null...");
        }


        strings.remove("lab");
        strings.remove("lab");//没执行一次只删除一个

        System.out.println(strings.get(0));//获得下标0的元素

        for (String s:
             strings) {
            System.out.println(s);
        }

        System.out.println("-------");
        strings.removeAll(list);
        //strings.clear();

        for (String s:
                strings) {
            System.out.println(s);
        }
    }
}
```

# 作业

### **Stream学习(可以把Stream当成高版本的Iterator)**
#### **剖析Stream通用语发**
* start
![](http://img04.taobaocdn.com/imgextra/i4/90219132/T2ycFgXQ8XXXXXXXXX_!!90219132.jpg)
一条语句被分割成三部分，红色框是Stream生命开始的地方，创建Stream实例，绿色框赋予Stream灵魂，把一个Stream转换成另一个Stream。红框语句是包含所有变量的Stream，进入绿色框以后，过滤掉不符合条件的元素，并生成一个新的Stream。蓝色框把Stream的里面包含的内容按照某种算法来汇聚成一个值，例子中是获取Stream中包含的元素个数。
* 使用Stream的基本步骤：

1、创建Stream；

2、转换Stream，每次转换原有Stream对象不改变，返回一个新的Stream对象

3、对Stream进行聚合（Reduce）操作，获取想要的结果；
#### **创建Stream**
* of方法
```java
Stream<IntegerStream> IntegerStream=Stream.of(1,2,3,4,5);
Stream<String> stringStream = Stream.of("taobao");
```
* generator方法
```java
Stream.generate(new Supplier<Double>(){
  @Override
  public Double get(){
    return Math.random();
  }
});
Stream.generate(()->Math.random);
Stream.generate(Math::random);
```
三条语句效果一样，生成无限长的Stream，使用了lambda表达式和方法引用来简化代码。
* iterate方法
```java
Stream.iterate(1,item->item+1).limit(10).forEach;
(System.out.println);
```
这段代码就是先获取一个无限长度的正整数集合的Stream，然后取出前10个打印
* Collection子类获取Stream
```java
public interface Collection<E> extends Iterable<E> {
    default Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
```

#### **转换Stream**
转换Stream其实就是把一个Stream通过某些行为转换成一个新的Stream。
* distinct-对Stream中的元素进行去重操作。
* filter- 对于Stream中包含的元素使用给定的过滤函数进行过滤操作。
* map- 对于Stream中包含的元素使用给定的转换函数进行转换操作
* flatMap-和map类似，不同的是其每个元素转换得到的是Stream对象，会把子Stream中的元素压缩到父集合中
* peek-生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数
* limit-对一个Stream进行截断操作，获取其前N个元素，如果原Stream中包含的元素个数小于N，那就获取其所有的元素
* skip-返回一个丢弃原Stream的前N个元素后剩下元素组成的新Stream，如果原Stream中包含的元素个数小于N，那么返回空Stream
* 上面的方法结合到一起：
```java
List<Integer>nums=Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
System.out.println(“sum is:”+nums.stream()
.filter(num -> num != null)
.distinct().mapToInt(num -> num * 2)
.peek(System.out::println)
.skip(2)
.limit(4)
.sum());
```
* 性能问题
在对于一个Stream进行多次转换操作，每次都对Stream的每个元素进行转换，而且是执行多次，这样时间复杂度就是一个for循环里把所有操作都做掉的N（转换的次数）倍啊。其实不是这样，转换操作都是lazy的，多个转换操作只会在汇聚操作的时候融合起来，一次循环完成。Stream里有个操作函数的集合，每次转换操作就是把转换函数放入这个集合中，在汇聚操作的时候循环Stream对应的集合，然后对每个元素执行所有的函数。

#### **汇聚（Reduce）Stream**
先对java doc中的定义进行翻译:

汇聚操作（也称为折叠）接受一个元素序列为输入，反复使用某个合并操作，把序列中的元素合并成一个汇总的结果。比如查找一个数字列表的总和或者最大值，或者把这些数字累积成一个List对象。Stream接口有一些通用的汇聚操作，比如reduce()和collect()；也有一些特定用途的汇聚操作，比如sum(),max()和count()。注意：sum方法不是所有的Stream对象都有的，只有IntStream、LongStream和DoubleStream是实例才有。
##### 1、可变汇聚
可变汇聚对应的方法只有一个：collect，它可以把Stream中的要有元素收集到一个结果容器collection中。
```java
List<Integer>nums=Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
List<Integer> numsWithoutNull = nums.stream()
.filter(num -> num != null)
.collect(() -> new ArrayList<Integer>(),
(list, item) -> list.add(item),
(list1, list2) -> list1.addAll(list2));
```
* 第一个函数生成一个新的ArrayList实例；
* 第二个函数接受两个参数，第一个是前面生成的ArrayList对象，二个是stream中包含的元素，函数体就是把stream中的元素加入ArrayList对象中。第二个函数被反复调用直到原stream的元素被消费完毕；
* 第三个函数也是接受两个参数，这两个都是ArrayList类型的，函数体就是把第二个ArrayList全部加入到第一个中；

##### 2、其他汇聚
```java
List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -&gt; sum + item).get());
```
### 遍历集合的操作，（list，map），eg:fori，foreach，stream，iterator；
* list
```java
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
```
```java
//运行结果
fori :
a 16
b 15
c 18
d 11
e 16
f 19
j 12
h 14
i 17
j 16
foreach :
a 16
b 15
c 18
d 11
e 16
f 19
j 12
h 14
i 17
j 16
stream :
a 16
b 15
c 18
d 11
e 16
f 19
j 12
h 14
i 17
j 16
iterator :
a 16
b 15
c 18
d 11
e 16
f 19
j 12
h 14
i 17
j 16
```
* map
```java
package day3;

import java.util.*;
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

        System.out.println("iterator :");
        Iterator iterator=map.values().iterator();
        while (iterator.hasNext()){
            //System.out.println(iterator.next());
            Student student=(Student)iterator.next();
            System.out.println(student.getName()+" "+student.getAge());
        }
    }
}
```
```java
//运行结果
fori :
1 = 12 a
2 = 18 b
3 = 14 c
4 = 16 d
5 = 13 e
6 = 11 f
7 = 12 j
8 = 15 h
9 = 14 i
10 = 18 g
foreach :
1 = 12 a
2 = 18 b
3 = 14 c
4 = 16 d
5 = 13 e
6 = 11 f
7 = 12 j
8 = 15 h
9 = 14 i
10 = 18 g
iterator :
a 12
b 18
c 14
d 16
e 13
f 11
j 12
h 15
i 14
g 18
```
* student
```java
package day3;

/**
 * 姓名，学号
 * construct,set,get
 */
public class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
