package day1_Sort;

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

//    public void sort(int[] a, int low, int high) {
//        if (low < high) {
//            int middle = getMiddle(a, low, high);//将a数组进行一分为二
//            sort(a, low, middle - 1);//对低字表进行递归排序
//            sort(a, middle + 1, high);//对高字表进行递归排序
//        }
//    }
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
        a[i] = temp;//中轴记录到尾
        return i;//返回中轴的位置
    }
}

//    public static void main(String[] args) {
//        QuickSort quickSort = new QuickSort();
//        int[] a = new int[]{5, 8, 6, 7, 4, 3, 8, 2, 9, 12,};
//        quickSort.sort(a, 0, a.length - 1);
//        for (int b : a) {
//            System.out.printf(" " + b);
//        }
//    }

