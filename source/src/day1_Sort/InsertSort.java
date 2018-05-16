package day1_Sort;

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
//    public static void main(String[] args) {
//        InsertSort insertSort=new InsertSort();
//        int[] a=new int[]{5,8,6,7,4,3,8,2,9,12,};
//        insertSort.Sort(a);
//    }
}
