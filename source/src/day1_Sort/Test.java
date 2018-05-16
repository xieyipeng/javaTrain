package day1_Sort;

import java.util.Scanner;

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
