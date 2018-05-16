package day1_Sort;

public class Factory {
    private baseSort Sort;//依赖注入
    public void setSort(baseSort Sort){//建立任意三种排序
        this.Sort=Sort;
    }
    public void doSort(int[] a){
        Sort.sort(a);
    }
}
