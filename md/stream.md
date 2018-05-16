### Stream学习(可以把Stream当成高版本的Iterator)
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
