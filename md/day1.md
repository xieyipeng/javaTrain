* animal

```java
package day1;

public class animal {
	//ststic 全局变量，属于类，但不属于任何一个类对象
	//supre 父类对象。this，当前对象
	//向上转型

	private int height;
	private String type;
	private String sex;

	public animal() {
		System.out.println("构造函数");
	}
	public animal(int height,String type,String sex) {
		this.height=height;
		this.type=type;
		this.sex=sex;
	}

	public void eat() {
		System.out.println("动物会吃");
	}
	public void run() {
		System.out.println("动物会跑");
	}
	public void say() {
		System.out.println("动物会叫");
	}

	public static void mian(String[] args) {

	}
}
```

* Animal

```java
package day1;

public class Animal1 {
	public static void main(String[] args) {
		animal a1=new animal();
		a1.eat();
		a1.run();
		a1.say();
	}
}
```

* GirlFriend

```java
package day1;

public class GirlFriend {
	    //private public
	    private int age = 15;
	    private double height;
	    private boolean isBigStudent;
	    private String name;
	    //构造函数
	    GirlFriend(){
	        System.out.println("init girl");
	        age = 19;
	        height = 160;
	        isBigStudent = true;
	        name = "xiaoli";
	    }
	    public GirlFriend(int age, double height, boolean isBigStudent, String name) {
	        this.age = age;
	        this.height = height;
	        this.isBigStudent = isBigStudent;
	        this.name = name;
	    }
	    //protected  friendly
	    public void dance(){
	        System.out.println(this.name);
	        System.out.println("hui dance");
	    }
	    public int getAge() {
	        return age;
	    }
	    public void setAge(int age) {
	        this.age = age;
	    }
	    public double getHeight() {
	        return height;
	    }
	    public void setHeight(double height) {
	        this.height = height;
	    }
	    public boolean isBigStudent() {
	        return isBigStudent;
	    }
	    public void setBigStudent(boolean bigStudent) {
	        isBigStudent = bigStudent;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public static void main(String[] args) {
	    }
}
```

* person

```java
package day1;

import java.util.Scanner;

public class persen {



		/*
		int a=5;
		int b=3;
		a=a+b;//加减号换成亦或~
		b=a-b;
		a=a-b;
		System.out.println(a+" "+b);
		*/

		/*
		int a[][]=new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				a[i][j]=scanner.nextInt();
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<(i+1)/2;j++) {
				a[i][j]=a[i][j]+a[j][i];
				a[j][i]=a[i][j]-a[j][i];
				a[i][j]=a[i][j]-a[j][i];
			}
			*/

			/*
			 * for(int j=i+1;j<3;j++)
			 *
			 */

			/*
			for(int j=0;j<3;j++) {//for(int j=0;j<(i+1)/2;j++)
				if(i<=j) {
					a[i][j]=a[i][j]+a[j][i];
					a[j][i]=a[i][j]-a[j][i];
					a[i][j]=a[i][j]-a[j][i];
				}
			}
			*/


		/*
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		*/


}
```

# 作业

排序算法
```java
public class baseSort {
    public void sort(int[] a){

    }
}
```
快速排序
```java
public class QuickSort extends baseSort {

    @Override//重写
    public void sort(int[] a){
        sort(a,0,a.length-1);
    }

    public void sort(int[] a,int low,int high) {

        super.sort(a);
        if (low < high) {
            int middle = getMiddle(a, low, high);//将a数组进行一分为二
            sort(a, low, middle - 1);//对低字表进行递归排序
            sort(a, middle + 1, high);//对高字表进行递归排序
        }
    }

    public int getMiddle(int[] a, int low, int high) {
        int tmp = a[low];//数组的第一个作为中轴
        int i = low;
        int j = high;
        while (i != j) {
            while (a[j] >= tmp && i < j) {
                j--;
            }
            //a[low] = a[high];//比中轴小的记录移到低端
            while (a[i] <= tmp && i < j) {
                i++;
            }
            int temp = a[i];
            a[i] = a[j];//比中轴大的记录移到高端
            a[j] = temp;
        }
        int temp = a[low];
        a[low] = a[i];
        a[i] = temp;
        return i;
    }
}
```
插入排序
```java
public class InsertSort extends baseSort{//插入排序

    @Override
    public void sort(int[] a) {
        for (int j = 1; j < a.length; j++) {//j从第二个元素开始
            int key = a[j];
            int i = j - 1;//i表示在j前面有多少个元素
            while (i >= 0 && a[i] > key) {//i控制循环次数，循环i次并且a[i]要大于key
                a[i + 1] = a[i];//
                i = i - 1;
                a[i + 1] = key;//符合条件换一次
            }
            //a[i + 1] = key;//不好理解。。。
        }
    }
```
选择排序
```java
public class SelectSort extends baseSort {//选择排序

    @Override
    public void sort(int[] a) {
        int min = 0;//最小值的下标
        int temp;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {//在后面的集合中寻找最小的下标
                    min = j;//小的下标赋给min
                }
            }
            if (min != i) {//最小值的下标和i不一样的时候，交换
                temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
```
Factory
```java
public class Factory {
    private baseSort Sort;//依赖注入
    public void setSort(baseSort Sort){//建立任意三种排序
        this.Sort=Sort;
    }
    public void doSort(int[] a){
        Sort.sort(a);
    }
}
```
Test
```java
public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入10个数字");
        int[] a=new int[10];
        for (int i=0;i<10;i++){
            a[i]=scanner.nextInt();
        }

//        int[] a = new int[]{5, 8, 6, 7, 4, 3, 16, 2, 9, 12,};

        Factory factory = new Factory();
        baseSort quick_sort = new QuickSort();//向上转型
        factory.setSort(quick_sort);
        factory.doSort(a);

        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
```
