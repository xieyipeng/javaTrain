* BaseSort

```java
package day2;

public class BaseSort {
    //bublic
    //private
    //protect
    //
    //重写，继承类，子类重写方法，重载，函数名称相同，返回值类型不构成重载
    //子类，没有继承任何类，默认继承object类
    //instanceof
    //一个类里面有抽象函数，则这个勒必须是抽象类，抽象类里面可以没有抽象方法  abstract
    //别的类集成这个抽象类，必须重写抽象函数

    /**
     * 没有方法体的方法 抽象方法
     * 抽象类不能被实例化，但是可以定义它的引用，不会再堆内开辟空间，可以指向子类的实例化
     *
     *
     *
     *
     *
     */
    void Sort(){

    }
    void sort(int[] a){

    }
    private String name;

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    private BaseSort baseSort;
}
```

* InserSort

```java
package day2;

public class insertSort extends BaseSort {
    @Override
    void Sort() {
        super.Sort();
        System.out.println("kuaipai");
    }

}
```

* inter

```java
package day2;

/**
 * 默认public abstract类型
 * 可以定义常量
 *
 * 常量前面public static final
 *
 * final修饰类，表示不能被继承
 *
 * 接口里面只存在常量
 *
 * 局部类，ststic修饰的类，内部类，if里面的内部类
 *
 * ！！！匿名内部类：没有名字的内部类
 * 回调
 *
 * 策略模式
 *
 * 学习一种设计模式
 *
 */
public interface inter {

    int a=10;
    public abstract void sing();

    static void dance(){

    }

    default void drew(){

    }
}
```

* JVMtest

```java
package day2;

public class JVMtest {
    public static void main(String[] args) {
        String[] ar={"hello","world"};
        test.main(ar);
    }
}
```

* QUickSort

```java
package day2;

public class QuickSort extends BaseSort implements inter{
    @Override
    void Sort() {
        super.Sort();
        System.out.println("xuanze");
        Sort(1,2);
    }
    void Sort(int start,int end) {
        System.out.println("chongxie");
    }

    @Override
    public void sing() {

    }
}
```

* selentSort

```java
package day2;

public class selentSort extends BaseSort{
    @Override
    void Sort() {
        super.Sort();
        System.out.println("插入");
    }
}
```

* Test

```java
package day2;

public class test extends Object{
    public static void main(String[] args) {
        for (String a:
             args) {
            System.out.println(a);
        }
        insertSort insertSort=new insertSort();
    }

}
```

# 作业

### 有了接口为什么还要有抽象类
* 抽象类：
抽象类中可以有抽象方法，抽象方法，可以只定义方法，不用写方法的实现。普通类继承抽象类必须要实现抽象类的方法，抽象类继承抽象类可以实现抽象方法也可以不实现。
* 接口：
只定义方法，不写方法的实现。一个接口可以继承另一个接口，一个类可以实现一个或多个接口。
* 有了接口为什么还要有抽象类？
java中，只能实现单继承，但可以实现多个接口。假定现在有3个类，A1，A2，A3，都实现接口B，同时他们三个都想要实现接口的某个方法，而接口中不能定义方法实体，就必须在他们三个内部重复写三遍相同的代码。这种做法明显不符合代码重用的规则。因此可以重新写一个抽象类C，在抽象类内实现该方法，再令他们三个实现接口同时继承C。因此，并不能没有抽象类。
### 命令模式
* command

```java
package day2;

public interface Command {
    public void exe();
}
```

* Invoker

```java
package day2;

/**
 * 长官
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
```

* Receiver

```java
package day2;

/**
 * 士兵
 */
public class Receiver {

    public void action(){
        System.out.println("command received!");
    }

}
```

* MyCommand

```java
package day2;

/**
 * 命令
 */
public class MyCommand implements Command{

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
```

* Test

```java
package day2;

public class test {
    public static void main(String[] args) {
        Receiver receiver=new Receiver();
        Command command=new MyCommand(receiver);
        Invoker invoker=new Invoker(command);
        invoker.action();
    }
}
```
