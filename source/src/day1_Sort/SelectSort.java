package day1_Sort;

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
//    for (int i=0;i<a.length;i++){
//        System.out.print(a[i]+" ");
//    }
//        System.out.println();
//        System.out.print("SelectSort");

//    public static void main(String[] args) {
//        SelectSort selectSort=new SelectSort();
//        int[] a=new int[]{5,8,6,7,4,3,16,2,9,12,};
//        selectSort.Sort(a);
//    }

