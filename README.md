# CS61B笔记

<!--ts-->
* [CS61B笔记](#cs61b笔记)
   * [<strong>1. Intro, Hello World Java</strong>](#1-intro-hello-world-java)
   * [<strong>2. Defining and Using Classes</strong>](#2-defining-and-using-classes)
   * [<strong>3. References, Recursion, and Lists</strong>](#3-references-recursion-and-lists)
   * [<strong>4. SLLists, Nested Classes, Sentinel Nodes</strong>](#4-sllists-nested-classes-sentinel-nodes)
   * [<strong>5. DLLists, Arrays</strong>](#5-dllists-arrays)
   * [<strong>6. ALists, Resizing, vs. SLists</strong>](#6-alists-resizing-vs-slists)
   * [<strong>7. Testing</strong>](#7-testing)
      * [Java Integer 类中 128 陷阱](#java-integer-类中-128-陷阱)
   * [<strong>8. Inheritance, Implements</strong>](#8-inheritance-implements)
      * [interface and implements ](#interface-and-implements-)
   * [<strong>9. Extends, Casting, Higher Order Functions</strong>](#9-extends-casting-higher-order-functions)
   * [<strong>10. Subtype Polymorphism vs. HoFs</strong>](#10-subtype-polymorphism-vs-hofs)
   * [<strong>11. Exceptions, Iterators, Object Methods</strong>](#11-exceptions-iterators-object-methods)
   * [<strong>12. Coding in the Real World, Review</strong>](#12-coding-in-the-real-world-review)
   * [<strong>13. Asymptotics I</strong>](#13-asymptotics-i)
   * [<strong>14. Disjoint Sets</strong>](#14-disjoint-sets)
   * [<strong>15. Asymptotics II</strong>](#15-asymptotics-ii)
   * [<strong>16. ADTs, Sets, Maps, BSTs</strong>](#16-adts-sets-maps-bsts)
   * [<strong>17. B-Trees (2-3, 2-3-4 Trees)</strong>](#17-b-trees-2-3-2-3-4-trees)
   * [<strong>18. Red Black Trees</strong>](#18-red-black-trees)
      * [<strong>summary</strong>](#summary)
   * [<strong>19. Range Searching and Multi-Dimensional Data</strong>](#19-range-searching-and-multi-dimensional-data)
      * [QuadTree](#quadtree)
      * [K-D Tree （K个维度的tree）](#k-d-tree-k个维度的tree)
      * [K-D Tree nearest method](#k-d-tree-nearest-method)
      * [summary](#summary-1)
   * [<strong>20. Hashing</strong>](#20-hashing)
      * [Two Important Warnings When Using HashMaps/HashSets](#two-important-warnings-when-using-hashmapshashsets)
   * [<strong>21. Heaps and PQs</strong>](#21-heaps-and-pqs)
      * [Heap Operations Summary](#heap-operations-summary)
      * [Data Structures Summary](#data-structures-summary)
   * [<strong>22. Prefix Operations and Tries</strong>](#22-prefix-operations-and-tries)
      * [string specific operation](#string-specific-operation)
      * [Autocomplete](#autocomplete)
   * [<strong>23. Tree and Graph Traversals</strong>](#23-tree-and-graph-traversals)
      * [Tree Traversal Orderings](#tree-traversal-orderings)
      * [graph](#graph)
      * [simple graph](#simple-graph)
      * [s-t Connectivity Problem （使用深度优先搜寻）](#s-t-connectivity-problem-使用深度优先搜寻)
      * [Depth First Traversal 深度优先搜寻](#depth-first-traversal-深度优先搜寻)
   * [<strong>24. Graph Traversals and Implementations</strong>](#24-graph-traversals-and-implementations)
      * [<strong>BFS</strong> - BreadthFirstPaths Demo](#bfs---breadthfirstpaths-demo)
      * [Bare-Bones Undirected Graph Implementation](#bare-bones-undirected-graph-implementation)
      * [Depth First Search Implementation](#depth-first-search-implementation)
      * [BreadthFirstPaths Implementation](#breadthfirstpaths-implementation)
   * [<strong>25. Shortest Paths</strong>](#25-shortest-paths)
      * [<strong>Dijkstra’s Algorithm</strong>:](#dijkstras-algorithm)
      * [A*](#a)
      * [Graph Problems summary](#graph-problems-summary)
   * [<strong>26. Minimum Spanning Trees</strong>](#26-minimum-spanning-trees)
      * [Generic MST Finding Algorithm](#generic-mst-finding-algorithm)
      * [Prim’s Algorithm](#prims-algorithm)
      * [Prim’s vs. Dijkstra’s](#prims-vs-dijkstras)
      * [Kruskal’s Algorithm](#kruskals-algorithm)
      * [Shortest Paths and MST Algorithms Summary](#shortest-paths-and-mst-algorithms-summary)
   * [<strong>27. Software Engineering I</strong>](#27-software-engineering-i)
      * [Strategic Programming （战略编程）](#strategic-programming-战略编程)
   * [<strong>28. Reductions and Decomposition</strong>](#28-reductions-and-decomposition)
      * [Topological Sort (拓扑排序)](#topological-sort-拓扑排序)
      * [Shortest Paths on DAGs](#shortest-paths-on-dags)
      * [Longest Paths](#longest-paths)
         * [The Longest Paths Problem on DAGs](#the-longest-paths-problem-on-dags)
   * [<strong>29. Basic Sorts</strong>](#29-basic-sorts)
   * [<strong>30. Quick Sort</strong>](#30-quick-sort)
      * [Backstory, Partitioning](#backstory-partitioning)
      * [Quicksort](#quicksort)
      * [Avoiding the Quicksort Worst Case （在后面的课中更详细地讲述）](#avoiding-the-quicksort-worst-case-在后面的课中更详细地讲述)
   * [<strong>31. Software Engineering II</strong>](#31-software-engineering-ii)
      * [Build Your Own World](#build-your-own-world)
      * [Modular Design](#modular-design)
   * [<strong>32. More Quick Sort, Sorting Summary</strong>](#32-more-quick-sort-sorting-summary)
      * [Tony Hoare’s In-place Partitioning Scheme](#tony-hoares-in-place-partitioning-scheme)
      * [Quicksort vs. Mergesort](#quicksort-vs-mergesort)
      * [Quick Select](#quick-select)
      * [Stability, Adaptiveness, Optimization](#stability-adaptiveness-optimization)
   * [<strong>33. Software Engineering III</strong>](#33-software-engineering-iii)
   * [<strong>34. Sorting and Algorithmic Bounds</strong>](#34-sorting-and-algorithmic-bounds)
   * [<strong>35. Radix Sorts</strong>](#35-radix-sorts)
      * [Counting Sort](#counting-sort)
      * [LSD Radix Sort 从最低位开始](#lsd-radix-sort-从最低位开始)
      * [MSD (Most Significant Digit) Radix Sort 从最高位开始](#msd-most-significant-digit-radix-sort-从最高位开始)
   * [<strong>36. Sorting and Data Structures Conclusion</strong>](#36-sorting-and-data-structures-conclusion)
      * [Intuitive(直觉的): Radix Sort vs. Comparison Sorting](#intuitive直觉的-radix-sort-vs-comparison-sorting)
      * [Cost Model: Radix Sort vs. Comparison Sorting](#cost-model-radix-sort-vs-comparison-sorting)
      * [Empirical Study: Radix Sort vs. Comparison Sorting](#empirical-study-radix-sort-vs-comparison-sorting)
      * [Rerunning Our Empirical Study With No JIT](#rerunning-our-empirical-study-with-no-jit)
      * [Sorting Summary](#sorting-summary)
   * [<strong>38. Compression(压缩)</strong>](#38-compression压缩)
      * [Prefix Free Codes](#prefix-free-codes)
      * [Shannon Fano Codes](#shannon-fano-codes)
      * [Huffman Coding](#huffman-coding)
      * [Huffman Coding Data Structures](#huffman-coding-data-structures)
      * [Huffman Coding in Practice](#huffman-coding-in-practice)
      * [Compression Theory](#compression-theory)
   * [<strong>39. Compression, Complexity, and P=NP?</strong>](#39-compression-complexity-and-pnp)
      * [Optimal Compression and Kolmogorov Complexity](#optimal-compression-and-kolmogorov-complexity)
      * [Space/Time Bounded Compression](#spacetime-bounded-compression)
      * [P = NP?](#p--np)
* [Markdown 基础语法](#markdown-基础语法)
* [这是 H1](#这是-h1)
   * [这是 H2](#这是-h2)
      * [这是 H3](#这是-h3)

<!-- Added by: light, at: Fri Jul 23 20:32:57 CST 2021 -->

<!--te-->

## **1. Intro, Hello World Java**

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
```

<br/>

-----------------
<br/>

## **2. Defining and Using Classes**

* Static vs. Non-Static Methods

```java
public class Dog {
    public static void makeNoise() {
        System.out.println("Bark!");
    }
}
```
以上单独不能编译，但是可以在另一个`class`里的`main`调用，然后一起编译

```java
public class DogLauncher {
    public static void main(String[] args) {
        Dog.makeNoise();
    }
}
```

静态方法与实例方法。静态方法和实例方法之间的区别非常重要。实例方法是只能由类的实例（即特定对象）采取的操作，而静态方法则由类本身采取。使用对特定实例的引用来调用实例方法，例如`d.bark()`，而静态方法应使用类名来调用（例如）`Math.sqrt()`     
static variables（静态变量）也类似，所有对象共享静态变量，各个对象单独享有各自的实例变量

Static vs. Instance methods. The distinction between static and instance methods is incredibly important. Instance methods are actions that can only be taken by an instance of the class (i.e. a specific object), whereas static methods are taken by the class itself. An instance method is invoked using a reference to a specific instance, e.g. `d.bark()`, whereas static methods should be invoked using the class name, e.g. `Math.sqrt()`

<br/>

* 在Java里`args[0]`是不包括程序名字的第一个参数

所以输入`java ArgsDemo these are`输出`these`
```java
public class ArgsDemo {
    public static void main(String[] args) {
        System.out.println(args[0]);
    }
}
```

<br/>

-----------------
<br/>

## **3. References, Recursion, and Lists**

```java
Walrus a = new Walrus(1000, 8.3);
Walrus b;
b = a;
b.weight = 5;
```
改变b的同时会改变a，因为只new了一个Walrus，a和b指向的是同一个东西

不过在声明int之类的基础变量时就直接分配了内存，但是Java在初始化或赋值变量前不能像C那样访问那段无序的内存

<br/>

`int[] x = new int[]{0, 1, 2, 95, 4};` 数组x也是一个指针


<br/>

-----------------
<br/>

## **4. SLLists, Nested Classes, Sentinel Nodes**

```java
public class SLList {
    private IntNode first;
...
```
`private` 使得 `first` 只能在这个class里使用

class 里可以嵌套放 class，嵌套的 class 加上 static 之后不能访问他外面的 class 里的东西

<br/>

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210414215942.png)

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210414221801.png)

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210414221831.png)

<br/>

-----------------
<br/>

## **5. DLLists, Arrays**

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210415200444.png)

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210415201209.png)

If you need to instantiate a generic over a primitive type, use `Integer`, `Double`, `Character`, `Boolean`, `Long`, `Short`, `Byte`, or `Float` instead of their primitive equivalents.

<br/>

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210415204642.png)

<br/>

-----------------
<br/>

## **6. ALists, Resizing, vs. SLists**

用数组来创建一个类似上节SList的东西

默认创建的数组大小可能较小，可以用下面的方式较有效率的增加数组总大小

```java
public void insertBack(int x) {
    if (size == items.length) {
           resize(size * RFACTOR);
    }
    items[size] = x;
    size += 1;
}
```
同时为了节省内存，可以在数组利用率小于0.25的时候减半数组大小

Java不允许我们创建泛型对象的数组
Java does not allow us to create an array of generic objects due to an obscure issue with the way generics are implemented. That is, we `cannot` do something like:  `Glorp[] items = new Glorp[8];`

Instead, we have to use the awkward syntax shown below: `Glorp[] items = (Glorp []) new Object[8];`

注意 removeLast 的时候要把删掉的 item 置为 null 以节省内存

<br/>

-----------------
<br/>

## **7. Testing**

`org.junit`库提供了许多有用的方法和有用的功能，以简化`test`程序的编写

例如`org.junit.Assert.assertArrayEquals(expected, input);`

<br/>

可以用一个同名的辅助函数来帮助主要函数实现功能，称之为 `overload`
```java
/** Sorts strings destructively. */
public static void sort(String[] x) { 
   sort(x, 0);
}

/** Sorts strings destructively starting from item start. */
private static void sort(String[] x, int start) { 
   if (start == x.length) {
       return;
   }
   int smallestIndex = findSmallest(x, start);
   swap(x, start, smallestIndex);
   sort(x, start + 1);
}
```

<br/>

更精简的`test`写法
```java
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the the Sort class. */
public class TestSort {
    /** Test the Sort.sort method. */
    
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        assertArrayEquals(expected, input);
    }
}
```

<br/>

### Java Integer 类中 128 陷阱  
在整数的包装类当中，在第一次创建 Integer 类的对象的时候，都会首先创建好缓存数组。当需要包装的值是在 IntegerCache 数组当中的元素的时候，就会返回数组当中的 Integer 对象。而当超出缓存数组的时候，就会创建新的对象。JVM 默认设置数组的范围为 -128 ~ 127  
所以小于128的调用的是缓存数组中的对象，两个一样大的数是同一个对象。而大于128的是新建的对象，两者地址不一样，不能直接用 `==` 比较，要用 `equals()` 方法

<br/>

-----------------
<br/>

## **8. Inheritance, Implements**

### `interface` and `implements ` 
```java
//前面几个是Interface Inheritance，最后一个是Implementation Inheritance
//注意default关键字。Implementation Inheritance中可以使用前面的方法。

public interface List61B<Item> {
    public void addFirst(Item x);
    public void add Last(Item y);
    public Item getFirst();
    public Item getLast();
    public Item removeLast();
    public Item get(int i);
    public void insert(Item x, int position);
    public int size();

    default public void print() {
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
```  
```java
public class AList<Item> implements List61B<Item>{...}

public class SList<Item> implements List61B<Item>{...}
```
之后针对 List61B 写的方法对 AList 和 SList 都适用  
AList 中的方法会 `override` List61B 中的同名方法。可以加上 `@Override` 做个标注并且用于检查函数名有没有写错

<br/>

```java
public static void main(String[] args) {
    List61B<String> someList = new SLList<String>();
    someList.addFirst("elk");
}
```
以上代码可以正常运行。因为 SLList 也是 List61B，可以把 SLList 的地址存在  List61B 变量中。同时因为 someList 里实际放的是 SLList，SLList 已经实现了 addFirst 方法，所以最后一行也可以正常运行  
换句话说，List61B 是 `static type`，SLList 是 `dynamic type`。调用函数的时候遵循 `dynamic method selection`  
`dynamic method selection` 适用于 `override` 而不是 `overload`。即在在考虑选择同名不同输入参数的函数的时候，根据是 `static type`。  
然后编译器判断有没有出错的根据是 `static type` 。

`static type` = `compile-time type`  
`dynamic type` = `run-time type`

**先根据 `static type` 进行 `overload`（选择不同输入的同名函数），再根据 `dynamic type` 进行 `override`（子类重载）**

<br/>

-----------------
<br/>

## **9. Extends, Casting, Higher Order Functions**

```java
//继承所有 SLList 有的东西（除了构造函数），并且可以加其他的东西
//不过不能访问父类里的 private 的东西，
//所以在 Override 的时候需要用 super.removeLast() 调用父类的方法，再对其做改动

public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    public VengefulSLList() {
        deletedItems = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    /** Prints deleted items. */
    public void printLostItems() {
        deletedItems.print();
    }
}
```

```java
public VengefulSLList() {
    super();   //调用父类的构造函数。就算不写这句，子类的构造函数也会默认先隐式调用这个
    deletedItems = new SLList<Item>();
}


public VengefulSLList(Item x) {
    super(x);    //如果子类构造函数要加参数的话必须写这句
    deletedItems = new SLList<Item>();
}
```

所有类都是 `Object` 的子类。interface 不是class

the `Object` class provides operations that every Object should be able to do - like `.equals(Object obj)`, `.hashCode()`, and `toString()`.

继承和 `Override` 有可能会破坏封装，导致无限循环调用之类的

<br/>

```java
// compile-time type 的类型转换
//Right hand side has compile-time type Poodle after casting

Poodle largerPoodle = (Poodle) maxDog(frank, frankJr);
```

<br/>

-----------------
<br/>

## **10. Subtype Polymorphism vs. HoFs**

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210512154217.png)

```java
/* 如果指定的数与参数相等返回0。
*  如果指定的数小于参数返回 -1。
*  如果指定的数大于参数返回 1。 */
public interface Comparable<T> {
     public int compareTo(T obj);
}
```


<br/>

-----------------
<br/>

## **11. Exceptions, Iterators, Object Methods**

* **Exceptions  throw  catch**
```java
throw new RuntimeException("For no reason.");

try {
    dog.run()
} catch (Exception e) {
    System.out.println("Tried to run: " + e);
}
System.out.println("Hello World!");
```



```java
// Lists in Real Java Code

import java.util.List;
import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        List<Integer> L = new ArrayList<>();
        L.add(5);
        L.add(10);
        System.out.println(L);
    }
}
```

```java
//Sets

import java.util.Set;
import java.util.HashSet;

Set<String> s = new HashSet<>();
s.add("Tokyo");
s.add("Lagos");
System.out.println(S.contains("Tokyo")); // true
```

<br/>

* **Iterable  Iterator**

```java
public interface Iterable<T> {
    Iterator<T> iterator();
}

public interface Iterator<T> {
  boolean hasNext();
  T next();
}
```

```java
import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size; // the next item to be added will be at position size

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /** returns an iterator (a.k.a. seer) into ME */
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }
    }

}
```

<br/>

`System.out.println(Object x)` calls `x.toString()`

```java
public String toString() {
    String returnString = "{";
    for (int i = 0; i < size; i += 1) {
        returnString += keys[i];
        returnString += ", ";
    }
    returnString += "}";
    return returnString;
}

//在迭代里使用 + 连接字符串效率很低，因为每次操作都在新建一个更长的字符串
//下面这个用 StringBuilder 的效果更好，它的字符串操作是线性的

public String toString() {
    StringBuilder returnSB = new StringBuilder("{");
    for (int i = 0; i < size - 1; i += 1) {
        returnSB.append(items[i].toString());
        returnSB.append(", ");
    }
    returnSB.append(items[size - 1]);
    returnSB.append("}");
    return returnSB.toString();
}

//下面这个耗时大概是上面那个的2倍，不过看起来更简洁

public String toString() {
    list<String> listOfItems = new ArrayList<>();
    for (T x : this) {
        listOfItems.add(x.toString());
    }
    return "{" + String.join(",", listOfItems) + "}";
}

```

```java
//考虑边界条件的比较完备的 equal 方法

public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }
```

```java
//做到类似 Set<Integer> javaset = Set.of(5, 23, 42); 的事

public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
    ArraySet<Glerp> returnSet = new ArraySet<Glerp>();
    for (Glerp x : stuff) {
        returnSet.add(x);
    }
    return returnSet;
}
```


<br/>

-----------------
<br/>

## **12. Coding in the Real World, Review**



<br/>

-----------------
<br/>

## **13. Asymptotics I**

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210526155210.png)

<br/>

-----------------
<br/>

## **14. Disjoint Sets**

ListOfSetsDS  用一堆 List 存放各类 sets
QuickFindDS   用数组存，同一类随便给同样的某个数
QuickUnionDS  用数组存，里面放上一级的序号，做成像树一样的
WeightedQuickUnionDS  用数组存，里面放上一级的序号，做成像树一样的，小的树挂到大的树的根下面
WeightedQuickUnionDSWithPathCompression  用数组存，里面放上一级的序号，做成像树一样的，小的树挂到大的树的根下面。每次查找都把路过的元素直接挂到最上级的根下面

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210521172318.png)

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210521172155.png)

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210531163743.png)

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210531163838.png)


Weighted Quick Union with Path Compression
```java
import java.util.ArrayList;

public class UnionFind {
    int[] parent;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parent = new int[n];
        // set all the parents to be -1 to symbolize that they are disjoint
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid vertex. */
    private void validate(int v1) {
        if (v1 < 0 || v1 >= parent.length) {
            throw new IllegalArgumentException("Not a valid vertex!");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        int root = find(v1);
        return -1 * parent[root];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        validate(v1);
        return parent[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean isConnected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Connecting a
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void connect(int v1, int v2) {
        int i = find(v1);
        int j= find(v2);
        if (i != j) {
            if (parent[i] >= parent[j]) {
                parent[j] = parent[i] + parent[j];
                parent[i] = j;
            }
            else {
                parent[i] = parent[i] + parent[j];
                parent[j] = i;
            }
        }
    }

    /* Returns the root of the set v1 belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int v1) {
        int p = v1;
        int tmp = v1;
        while (parent(p) >= 0) {
            p = parent(p);
        }
        while (parent(v1) >= 0) {
            tmp = v1;
            v1 = parent(v1);
            parent[tmp] = p;
        }
        return p;
    }
}
```

<br/>

-----------------
<br/>

## **15. Asymptotics II**

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210525203806.png)


This is the essence of **merge sort**:
- If the list is size 1, return. Otherwise:
- Mergesort the left half
- Mergesort the right half
- Merge the results

the overall runtime is **Θ(NlogN)**

<br/>

-----------------
<br/>

## **16. ADTs, Sets, Maps, BSTs**

**ADTs**: Abstract Data Types

**Binary Search Trees  二叉树**
![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210528145451.png)

删除操作：
没有下级的直接删；
有一个下级的让上级指向下级；
有两个下级的，找到它的一堆下级中的左边的最大值或者右边的最小值，删掉那个值，然后用那个值替换它

```java
private class BST<Key> {
    private Key key;
    private BST left;
    private BST right;

    public BST(Key key, BST left, BST Right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BST(Key key) {
        this.key = key;
    }

    static BST find(BST T, Key sk) {
        if (T == null)
            return null;
        if (sk.equals(T.key))
            return T;
        else if (sk ≺ T.key)
            return find(T.left, sk);
        else
            return find(T.right, sk);
    }

    static BST insert(BST T, Key ik) {
        if (T == null)
            return new BST(ik);
        if (ik ≺ T.key)
            T.left = insert(T.left, ik);
        else if (ik ≻ T.key)
            T.right = insert(T.right, ik);
        return T;
    }

    /** Delete the instance of label L from T that is closest to
    * to the root and return the modified tree. The nodes of
    * the original tree may be modified. */
    public static BST remove(BST T, int L) {
        if (T == null)
            return null;
        if (L < T.label)
            T.left = remove(T.left, L);
        else if (L > T.label)
            T.right = remove(T.right, L);
        // Otherwise, we’ve found L
        else if (T.left == null)
            return T.right;
        else if (T.right == null)
            return T.left;
        else
            T.right = swapSmallest(T.right, T);
        return T;
    }
    /** Move the label from the first node in T (in an inorder
    * traversal) to node R (over-writing the current label of R),
    * remove the first node of T from T, and return the resulting tree.
    */
    private static BST swapSmallest(BST T, BST R) {
        if (T.left == null) {
            R.label = T.label;
            return T.right;
        } else {
            T.left = swapSmallest(T.left, R);
            return T;
        }
    }
}
```

<br/>

-----------------
<br/>

## **17. B-Trees (2-3, 2-3-4 Trees)**

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210601172457.png)

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210601172231.png)

A B-tree has the following helpful invariants:
* All leaves must be the same distance from the source.
* A non-leaf node with k items must have exactly k+1 children.

In tandem, these invariants cause the tree to always be **bushy**.

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210601172538.png)


<br/>

-----------------
<br/>

## **18. Red Black Trees**

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210602182257.png)

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607150434.png)

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607152526.png)

* **操作例子**
* 插入都用红线
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607162645.png" style="zoom: 25%;"/>
* 右倾的转成左倾
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607162836.png" style="zoom: 25%;"/>
* 暂时的两根红线
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607163034.png" style="zoom: 25%;"/>
* 插入的调整
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607164256.png" style="zoom: 25%;"/>
* 两根红线的调整
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607164826.png" style="zoom: 25%;"/>
* 右倾的转成左倾
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607164952.png" style="zoom: 25%;"/>

**LLRB Runtime**
* LLRB tree has height O(log N).
* Contains is trivially O(log N).
* Insert is O(log N).
  * O(log N) to add the new node.
  * O(log N) rotation and color flip operations per insert.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607165541.png"/>

### **summary**
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607170107.png"/>

<br/>

-----------------
<br/>

## **19. Range Searching and Multi-Dimensional Data**

### QuadTree
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607203121.png"/>

### K-D Tree （K个维度的tree）
插入时 每次比较一个维度，每过一级换一个维度比较。完全相同就替换，正在比较的维相等视作大于
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607205636.png"/>

### K-D Tree nearest method
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607212414.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/QQ%E6%88%AA%E5%9B%BE20210609160239.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/QQ%E6%88%AA%E5%9B%BE20210607213043.png"/>

### summary
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210607215536.png"/>

<br/>

-----------------
<br/>

## **20. Hashing**

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/QQ%E6%88%AA%E5%9B%BE20210610211831.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210610210728.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210610210806.png"/>


### Two Important Warnings When Using HashMaps/HashSets

Warning #1: Never store objects that can change in a HashSet or HashMap!
* If an object’s variables changes, then its hashCode changes. May result in items getting lost.

Warning #2: Never override equals without also overriding hashCode.
* Can also lead to items getting lost and generally weird behavior.
* HashMaps and HashSets use equals to determine if an item exists in a particular bucket.
* See study guide problems.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210610213801.png"/>

<br/>

-----------------
<br/>

## **21. Heaps and PQs**

```java
/** (Min) Priority Queue: Allowing tracking and removal of 
  * the smallest item in a priority queue. */
public interface MinPQ<Item> {
    /** Adds the item to the priority queue. */
    public void add(Item x);
    /** Returns the smallest item in the priority queue. */
    public Item getSmallest();
    /** Removes the smallest item from the priority queue. */
    public Item removeSmallest();
    /** Returns the size of the priority queue. */
    public int size();
}
```

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611144534.png"/>

### Heap Operations Summary

Given a heap, how do we implement PQ operations?
* getSmallest() - return the item in the root node.
* add(x) - place the new employee in the last position, and promote as high as possible.
* removeSmallest() - assassinate the president (of the company), promote the rightmost person in the company to president. Then demote repeatedly, always taking the ‘better’ successor.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611154306.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611154338.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/QQ%E6%88%AA%E5%9B%BE20210611155133.png"/>

### Data Structures Summary

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611162333.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611162425.png"/>

<br/>

-----------------
<br/>

## **22. Prefix Operations and Tries**

Suppose we know that our keys are always strings.
* Can use a special data structure known as a Trie.
* Basic idea: Store each letter of the string as a node in a tree.

Tries will have great performance on:
* get
* add
* special string operations


<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611203419.png"/>

The DataIndexedCharMap Trie|The Hash-Table Based Trie|The BST-Based Trie
:--:|:--:|:--:
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611211151.png"/>|<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611211505.png"/>|<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611211557.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210611212226.png"/>

### string specific operation

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210612214043.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210612214308.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210612214455.png"/>

```java {.line-numbers}
public class Trie {
    private final Map<Character, Trie> nextNodes = new HashMap<>();
    private boolean isWordEnd = false;

    public Trie() {
    }

    /**
        * Inserts a word into the trie.
        */
    public void insert(String word) {
        Trie current = this;
        Trie next;
        for (char c : word.toCharArray()) {
            next = current.nextNodes.getOrDefault(c, new Trie());
            current.nextNodes.put(c, next);
            current = next;
        }
        current.isWordEnd = true;
    }

    /**
        * Returns if the word is in the trie.
        */
    public boolean search(String word) {
        Trie current = this;
        for (char c: word.toCharArray()) {
            if (!current.nextNodes.containsKey(c)) {
                return false;
            }
            current = current.nextNodes.get(c);
        }
        return current.isWordEnd;
    }

    /**
        * Returns words in the trie that starts with the given prefix.
        */
    public List<String> KeysWithPrefix(String prefix) {
        List<String> x = new LinkedList<>();

        Trie current = this;
        for (char c: prefix.toCharArray()) {
            if (!current.nextNodes.containsKey(c)) {
                return x;
            }
            current = current.nextNodes.get(c);
        }

        for (char c : current.nextNodes.keySet()) {
            colHelp(prefix+c, x, current.nextNodes.get(c));
        }

        return x;
    }
    public void colHelp(String s, List<String> x, Trie n) {
        if (n.isWordEnd) {
            x.add(names.get(s));
        }
        for (char c : n.nextNodes.keySet()) {
            colHelp(s+c, x, n.nextNodes.get(c));
        }
    }
}
```

### Autocomplete

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210612215414.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210612215542.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210612215612.png" style="zoom: 25%;"/>

<br/>

-----------------
<br/>

## **23. Tree and Graph Traversals**

### Tree Traversal Orderings

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210618164028.png"/>

* 前序遍历 Preorder: “Visit” a node, then traverse its children:  D B A C F E G
  可以用来 print 文件目录结构
```java
preOrder(BSTNode x) {
    if (x == null)
        return;
    print(x.key)
    preOrder(x.left)
    preOrder(x.right)
}
```

* 中序遍历 Inorder traversal: Traverse left child, visit, then traverse right child: A B C D E F G
```java
inOrder(BSTNode x) {
    if (x == null) 
        return;
    inOrder(x.left)
    print(x.key)
    inOrder(x.right)
}
```

* 后序遍历 Postorder traversal: Traverse left, traverse right, then visit:  A C B E G F D
  可以用来计算 文件目录中所有文件 总大小
```java
postOrder(BSTNode x) {
    if (x == null) 
        return;
    postOrder(x.left)
    postOrder(x.right)
    print(x.key)
}
```
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210618174657.png"/>

### graph

**A tree** is a graph where there are no cycles and every vertex is connected.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210618202053.png"/>

### simple graph

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210618202528.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210618203033.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210618204044.png"/>

### s-t Connectivity Problem （使用深度优先搜寻）
One possible recursive algorithm for connected(s, t). 
* Mark s.
* Does s == t? If so, return true.
* Otherwise, if connected(v, t) for any unmarked neighbor v of s, return true.
* Return false.
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210618211119.png" style="zoom: 25%;"/>

### Depth First Traversal 深度优先搜寻
This idea of exploring a neighbor’s entire subgraph before moving on to the next neighbor is known as Depth First Traversal.
* Example: Explore 1’s subgraph completely before using the edge 0-3.
* Called “depth first” because you go as deep as possible.
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210618210950.png" style="zoom: 25%;"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210618212142.png"/>+

**DFS Preorder**: Action is before DFS calls to neighbors. One valid DFS preorder for this graph: 012543678

**DFS Postorder**: Action is after DFS calls to neighbors. Results for dfs(0) would be: 347685210

**BFS order**: Act in order of distance from s.
* BFS stands for “breadth first search”.
* Analogous to “level order”. Search is wide, not deep.
* 0 1 24 53 68 7  

<br/>

-----------------
<br/>

## **24. Graph Traversals and Implementations**

**queue**(队列): enqueue (addLast),  dequeue (removeFirst)  先进先出

**stack**(堆栈): push (addFirst), pop (removeFirst)  后进先出

### **BFS** - BreadthFirstPaths Demo
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621134355.png"/>

**API** (Application Programming Interface)

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621141939.png"/>

**We used the Princeton algorithms book API today** （这节课使用普林斯顿的课的interface）

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621160109.png"/>

```java {.line-numbers}
public class Graph {
  public Graph(int V):               Create empty graph with v vertices
  public void addEdge(int v, int w): add an edge v-w
  Iterable<Integer> adj(int v):      vertices adjacent to v
  int V():                           number of vertices
  int E():                           number of edges
...
```

Adjacency lists
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621142913.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621143425.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621143955.png"/>

### Bare-Bones Undirected Graph Implementation
```java {.line-numbers}
public class Graph {
	private final int V;  private List<Integer>[] adj;
	
	public Graph(int V) {
    	    this.V = V;
    	    adj = (List<Integer>[]) new ArrayList[V];
    	    for (int v = 0; v < V; v++) {
             adj[v] = new ArrayList<Integer>();
         }
	} 

	public void addEdge(int v, int w) {
         adj[v].add(w);   adj[w].add(v);
	}

	public Iterable<Integer> adj(int v) {
        return adj[v];
	}
}
```

### Depth First Search Implementation

Common design pattern in graph algorithms: Decouple type from processing algorithm.
* Create a graph object.
* Pass the graph to a graph-processing method (or constructor) in a client class.
* Query the client class for information.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621150650.png"/>

```java {.line-numbers}
public class DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private int s;
 	
  public DepthFirstPaths(Graph G, int s) {
      ...
      dfs(G, s);
  }
  private void dfs(Graph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }        	
    } 
  }
  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    List<Integer> path = new ArrayList<>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.add(x);
    }
    path.add(s);
    Collections.reverse(path);
    return path;
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }
}
```

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621154740.png"/>

### BreadthFirstPaths Implementation

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621154956.png"/>

```java {.line-numbers}
public class BreadthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  ...
	
  private void bfs(Graph G, int s) {
  Queue<Integer> fringe = 
          new Queue<Integer>();
  fringe.enqueue(s);
  marked[s] = true;
  while (!fringe.isEmpty()) {
    int v = fringe.dequeue();
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        fringe.enqueue(w);
        marked[w] = true;
        edgeTo[w] = v;
      }
    }
  }
}
```

DFS 和 BFS 的效率一样，而且 BFS 能找到最优路径，所以一般直接用 BFS，除非是只需要确定有没有路径
不过这两个都不适合用来在实际地图中寻路，因为实际的各条路的长度是不同的等等

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621155311.png"/>


<br/>

-----------------
<br/>

## **25. Shortest Paths**

SPT: **Shortest Paths Tree**
一个有 V 个点的图，其起点为 s 的最短路径树有 V-1 条边

### **Dijkstra’s Algorithm**: 
Perform a best first search (closest first).
* Insert all vertices into fringe PQ, storing vertices in order of distance from source.
* Repeat: Remove (closest) vertex v from PQ, and relax all edges pointing from v.

在当前节点找到起点距离最小的下一个节点，一直找到头，然后返回
只有路径没有 负权重 的时候这个算法才是正确的

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621195057.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621202908.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621204320.png"/>

### A*

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621211134.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621212053.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210622212012.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621212936.png"/>

### Graph Problems summary
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210621212811.png"/>

<br/>

-----------------
<br/>

## **26. Minimum Spanning Trees**

Given an **undirected** graph, a **spanning tree** T is a subgraph of G, where T:
* Is connected.
* Is acyclic（非循环）.
* Includes all of the vertices.
前两点使其为 tree，后一点使其 spanning

A **minimum spanning tree**（最小生成树） is a spanning tree of minimum total weight.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210629204057.png"/>


### Generic MST Finding Algorithm

Start with no edges in the MST.
* Find a cut that has no crossing edges in the MST. 
* Add smallest crossing edge to the MST.
* Repeat until V-1 edges.

This should work, but we need some way of finding a cut with no crossing edges!

### Prim’s Algorithm

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210629211046.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210629213012.png"/>

### Prim’s vs. Dijkstra’s

Prim’s and Dijkstra’s algorithms are exactly the same, except Dijkstra’s considers “distance from the source”, and Prim’s considers “distance from the tree.”

Visit order:
* Dijkstra’s algorithm visits vertices in order of distance from the source.
* Prim’s algorithm visits vertices in order of distance from the MST under construction.

Relaxation:
* Relaxation in Dijkstra’s considers an edge better based on distance to source.
* Relaxation in Prim’s considers an edge better based on distance to tree.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210630190256.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210630190330.png"/>

```java {.line-numbers}
public class PrimMST {
  public PrimMST(EdgeWeightedGraph G) {
    edgeTo = new Edge[G.V()];
    distTo = new double[G.V()];
    marked = new boolean[G.V()];
    fringe = new SpecialPQ<Double>(G.V());
 
    distTo[s] = 0.0;
    setDistancesToInfinityExceptS(s);
    insertAllVertices(fringe);
 
    /* Get vertices in order of distance from tree. */
    while (!fringe.isEmpty()) {
      int v = fringe.delMin();
      scan(G, v);
    } 
  }
  private void scan(EdgeWeightedGraph G, int v) {
    marked[v] = true;
    for (Edge e : G.adj(v)) {
      int w = e.other(v);
      if (marked[w]) { continue; } 
      if (e.weight() < distTo[w]) {
        distTo[w] = e.weight();
        edgeTo[w] = e;
        pq.decreasePriority(w, distTo[w]);
      }
    }
  }
}
```

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210630190740.png"/>

### Kruskal’s Algorithm

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210630192219.png"/>

```java {.line-numbers}
public class KruskalMST {
  private List<Edge> mst = new ArrayList<Edge>();
 
  public KruskalMST(EdgeWeightedGraph G) {
    MinPQ<Edge> pq = new MinPQ<Edge>();
    for (Edge e : G.edges()) {
      pq.insert(e);
    }
    WeightedQuickUnionPC uf = 
             new WeightedQuickUnionPC(G.V());
    while (!pq.isEmpty() && mst.size() < G.V() - 1) {
      Edge e = pq.delMin();
      int v = e.from();
      int w = e.to();
      if (!uf.connected(v, w)) {
        uf.union(v, w);
        mst.add(e); 
} } } }
```

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210630193022.png"/>

### Shortest Paths and MST Algorithms Summary

| Problem        | Algorithm                       | Runtime (if E > V) | Notes                            |
|----------------|---------------------------------|--------------------|----------------------------------|
| Shortest Paths | Dijkstra’s                      | O(E log V)         | Fails for negative weight edges. |
| MST            | Prim’s                          | O(E log V)         | Analogous to Dijkstra’s.         |
| MST            | Kruskal’s                       | O(E log E)         | Uses WQUPC.                      |
| MST            | Kruskal’s with pre-sorted edges | O(E log* V)        | Uses WQUPC.                      |

<br/>

-----------------
<br/>

## **27. Software Engineering I**

### Strategic Programming （战略编程）
The first step towards becoming a good software designer is to realize that working code isn’t enough.
* The most important thing is the long term structure of the system.
* Adding complexities to achieve short term time games is unacceptable.

For each new class/task:
* Rather than implementing the first idea, try coming up with (and possibly even partially implementing) a few different ideas.
* When you feel like you have found something that feels clean, then fully implement that idea.
* In real systems: Try to imagine how things might need to be changed in the future, and make sure your design can handle such changes.

No matter how careful you try to be, there will be mistakes in your design.
* Avoid the temptation(诱惑) to patch(打补丁) around these mistakes. Instead, fix the design.
    * Example: Don’t add a bunch of special cases! Instead, make sure the system gracefully handles the cases you didn’t think about.
    * Specific example: Adding sentinel nodes to SLLists.
* Indeed, it is impossible to design large software systems entirely in advance.

<br/>

-----------------
<br/>

## **28. Reductions and Decomposition**

### Topological Sort (拓扑排序)

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210701205511.png"/>

Another better topological sort algorithm:
* Run DFS from an arbitrary vertex.
* If not all marked, pick an unmarked vertex and do it again.
* Repeat until done.

A topological sort only **exists** if the graph is a **directed acyclic graph** （**DAG 有向无环图**）.


### Shortest Paths on DAGs

If we allow negative edges, Dijkstra’s algorithm can fail.

One simple idea: Visit vertices in topological order.
* On each visit, relax all outgoing edges.
* Each vertex is visited only when all possible info about it has been used!

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210703143100.png"/>


### Longest Paths

Consider the problem of finding the longest path tree (LPT) from s to every other vertex. The path must be simple (no cycles!).

Some surprising facts:
* Best known algorithm is exponential (指数级) (extremely bad).
* Perhaps the most important unsolved problem in mathematics.

#### The Longest Paths Problem on DAGs

DAG LPT solution for graph G:   把所有路径权重取负，然后跑求最短路径的算法
* Form a new copy of the graph G’ with signs of all edge weights flipped.
* Run DAGSPT on G’ yielding result X.
* Flip signs of all values in X.distTo. X.edgeTo is already correct. 

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210703144409.png"/>

<br/>

-----------------
<br/>

## **29. Basic Sorts**

**Selection Sort**
* Find smallest item.
* Swap this item to the front and ‘fix’ it.
* Repeat for unfixed items until all items are fixed.
* **Θ(N^2)** ***time*** if we use an array (or similar data structure).

<br>

**Naive Heapsort**: Leveraging (借用) a Max-Oriented Heap
* Idea: Instead of rescanning entire array looking for minimum, maintain a heap so that getting the minimum is fast!

Naive heapsorting N items: 
* Insert all items into a max heap, and discard input array. Create output array.
* Repeat N times:
  * Delete largest item from the max heap.
  * Put largest item at the end of the unused part of the output array.
* ***Overall runtime*** is O(N log N) + Θ(N) + O(N log N) = **O(N log N)**
* 对于所有值都一样的，这种 best case 是 **Θ(N)**
* ***Memory usage*** is **Θ(N)** to build the additional copy of all of our data.

<br>

**In-place Heapsort**
Alternate approach, treat input array as a heap!
* Rather than inserting into a new array of length N + 1, use a process known as “bottom-up heapification” to convert the array into a heap. 
  * To bottom-up heapify, just sink nodes in reverse level order.
* Avoids need for extra copy of all data. (不需要额外内存)
* Once heapified, algorithm is almost the same as naive heap sort. 

直接把输入数组当做一个未完成的 Heap，从最下层到上层把每个元素按大小往下沉，最后变成一个正确的 MaxHeap
然后 removeFirst，把最大的值放到数组最后，把换上来的 MaxHeap 中最后的那个放到第一再下沉。

* overall runtime is **O(N log N)**.

<br>

**Mergesort**
* Split items into 2 roughly even pieces.
* Mergesort each half (steps not shown, this is a recursive algorithm!)
* Merge the two sorted halves to form the final result.

***Time*** complexity: **Θ(N log N** runtime)
Space complexity with aux array: Costs **Θ(N)** ***memory***.

<br>

**Insertion Sort**
General strategy: 
* Starting with an empty output sequence.
* Add each item from input, inserting into output at right point (正确的地方).

More efficient method (**In-place Insertion Sort**):
* Do everything in place using swapping 在原数组中一个一个往前swap，直到位置正确
* Repeat for i = 0 to N - 1:
  * Designate (指派) item i as the traveling item.
  * Swap item backwards until traveller is in the right place among all previously examined items.

***runtime*** of insertion sort **Ω(N), O(N^2)**

For arrays that are almost sorted, insertion sort does very little work.
针对差不多排好的数组，用 insertion sort 相当快

Less obvious: For small arrays (N < 15 or so), insertion sort is fastest.
* More of an empirical fact than a theoretical one.
* Theoretical analysis beyond scope of the course.
* Rough idea: Divide and conquer algorithms like heapsort / mergesort spend too much time dividing, but insertion sort goes straight to the conquest.
很小的数组用 Insertion Sort 是最快的，由实际经验得出。所以像 mergesort 之类的在细分到15个元素以内后，一般会切换到 Insertion Sort

<br>

**Shell’s Sort** : Optimizing Insertion Sort
Big idea: Fix multiple inversions （倒置） at once.
* Instead of comparing adjacent（相邻） items, compare items that are one stride length h apart. 
* Start with large stride, and decrease towards 1.
* Example: h = 7, 3, 1.
从大的间隔开始排，然后慢慢排间隔小的

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210703211256.png"/>

h=1 is just normal insertion sort.
* By using large strides first, fixes most of the inversions.

We used 7, 3, 1. Can generalize to 2k - 1 from some k down to 1.
* Requires Θ(N1.5) time in the worst case (see CS170).
* Other stride patterns can be faster.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210703211432.png"/>

<br/>

-----------------
<br/>

## **30. Quick Sort**

### Backstory, Partitioning

Quicksort:  Much stranger core idea: Partitioning （分区）.

**Partitioning**
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210705161437.png"/>

### Quicksort

Quicksorting N items: 
* Partition on leftmost item. 
* Quicksort left half.
* Quicksort right half.

Theoretical analysis:
* Best case: Θ(N log N)
* Worst case: Θ(N^2)
* But on average it is Θ(N log N). Randomly chosen array case: Θ(N log N) expected

Quicksort is Partitioning Sort, Quicksort is BST Sort. 

### Avoiding the Quicksort Worst Case （在后面的课中更详细地讲述）

If pivot always lands somewhere “good”, Quicksort is Θ(N log N). However, the very rare Θ(N2) cases do happen in practice, e.g.
* Bad ordering: Array already in sorted order (or almost sorted order).
* Bad elements: Array with all duplicates（重复）. 

What can we do to avoid worst case behavior?
* Always use the median as the pivot（支点） -- this works.
* Randomly swap two indices occasionally.
    * Sporadic（零星的） randomness. Maybe works?
* Shuffle（洗牌） before quicksorting.
  * This definitely works and is a harder core version of the above.

<br/>

-----------------
<br/>

## **31. Software Engineering II**

### Build Your Own World

There are two primary sources of complexity:
* **Dependencies**: When a piece of code cannot be read, understood, and modified independently.
* **Obscurity**: When important information is not obvious.

不要用一大堆的标志位和 if-else 之类的，把任务分块，变成一些可以独立调试的 helper_method

记得用 interface 之类的 Java 特性

### Modular Design

Ousterhout: “The best modules are those that provide powerful functionality yet have simple interfaces. I use the term ***deep*** to describe such modules.”

The most important way to make your modules deep is to practice “information hiding”. 
* Embed knowledge and design decision in the module itself, without exposing them to the outside world.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210705195119.png"/>

Ousterhout: 
* “Information leakage is one of the most important red flags in software design.”
* “One of the best skills you can learn as a software designer is a high level of sensitivity to information leakage.”

<br/>

-----------------
<br/>

## **32. More Quick Sort, Sorting Summary**

What can we do to avoid running into the worst case for QuickSort?

Four philosophies(观点):
1. **Randomness**: Pick a random pivot or shuffle before sorting.
2. **Smarter pivot selection**: Calculate or approximate the median.
3. **Introspection**(内省): Switch to a safer sort if recursion goes to deep.
4. **Preprocess the array**: Could analyze array to see if Quicksort will be slow. No obvious way to do this, though (can’t just check if array is sorted, almost sorted arrays are almost slow).

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210706100507.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210706101416.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210706110725.png"/>

### Tony Hoare’s In-place Partitioning Scheme
<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210706134242.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210706134432.png"/>


### Quicksort vs. Mergesort

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210706141721.png"/>

Using Tony Hoare’s two pointer scheme, Quicksort is better than mergesort!
* More recent pivot/partitioning schemes do somewhat better. 
  * Best known Quicksort uses a two-pivot scheme.

Quicksort using PICK to find the exact median (Quicksort PickTH) is terrible!
* Cost to compute medians is too high.
* Have to live with worst case Θ(N2) if we want good practical performance.


### Quick Select

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210706141904.png"/>

Worst asymptotic performance Θ(N^2) occurs if array is in sorted order. 

On average, Quick Select will take Θ(N) time. 
Quick Select 加上洗牌之类的 random 后是最快的找中位数的算法


### Stability, Adaptiveness, Optimization

A sort is said to be **stable** if order of equivalent items is preserved（排序后数组中相同大小的元素原来的前后顺序没变）.

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210706143524.png"/>

Selection Sort 不稳定，因为会有把最小的直接往最前面 swap 的操作


<br/>

-----------------
<br/>

## **33. Software Engineering III**

<br/>

-----------------
<br/>

## **34. Sorting and Algorithmic Bounds**

排序算法的 worst case 讨论：
* 设有 N 个元素需要排序，那么共有 N！种可能的顺序。
* 将这些可能塞到二叉树里作为叶子（二叉树的其余是 `is a>b ?` 这样的用于比较排序的问题）
* 那么最少需要 $log_2(N!)$ 层的二叉树，也即最少需要 $\varOmega(log_2(N!)) = \varOmega(NlogN)$ 次比较操作
* 综上，最好的排序算法的 worst case 是 $\varTheta(NlogN)$

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210708212900.png"/>

<br/>

-----------------
<br/>

## **35. Radix Sorts**

### Counting Sort

如果不需要用到 compare (比较) 操作，那么是可以达到 $\varTheta(N)$ 的
比如 有N个东西，它们的标号是 0~N-1，可以直接创建大小为 N 的数组，把它们直接按标号放进去

<br/>

Counting sort:
* Count number of occurrences of each item.
* Iterate through list, using count array to decide where to put everything.
* Bottom line, we can use counting sort to sort N objects in Θ(N) time. 

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210709151507.png"/>

Total runtime on N keys with alphabet of size R（不同的key值的数量）: Θ(N+R)
* Create an array of size R to store counts: Θ(R)
* Counting number of each item: Θ(N)
* Calculating target positions of each item: Θ(R)
* Creating an array of size N to store ordered data: Θ(N)
* Copying items from original array to ordered array: Do N times:
  * Check target position: Θ(1)
  * Update target position: Θ(1)
* Copying items from ordered array back to original array: Θ(N)

Memory usage: Θ(N+R)

Bottom line: If N is ≥ R, then we expect reasonable performance.

### LSD Radix Sort 从最低位开始

LSD (Least Significant Digit 最低位有效数字) Radix(基数) Sort -- Using Counting Sort
从最低位开始，对每位数做 Counting Sort（Counting Sort is stable）

runtime of LSD sort: 
* Θ(WN+WR)
* N: Number of items, R: size of alphabet, W: Width of each item in # digits

### MSD (Most Significant Digit) Radix Sort 从最高位开始

Key idea: Sort each subproblem separately. 
从高位开始，对上一位相同的各组分别做排序

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210709163044.png"/>

<br/>

-----------------
<br/>

## **36. Sorting and Data Structures Conclusion**

### Intuitive(直觉的): Radix Sort vs. Comparison Sorting

Merge Sort requires Θ(N log N) compares.

What is Merge Sort’s runtime on strings of length W?
* It depends!
  * Θ(N log N) if each comparison takes constant time.
    * Example: Strings are all different in top character.
  * Θ(WN log N) if each comparison takes Θ(W) time.
    * Example: Strings are all equal.

<br/>

The facts:
* Treating alphabet size as constant, LSD Sort has runtime Θ(WN). 
* Merge Sort is between Θ(N log N) and Θ(WN log N).

Which is better? It depends.
* When might LSD sort be faster?
  * Sufficiently large N.
  * If strings are very similar to each other.
    * Each Merge Sort comparison costs Θ(W) time.
* When might Merge Sort be faster?
  * If strings are highly dissimilar from each other. 
    * Each Merge Sort comparison is very fast.

### Cost Model: Radix Sort vs. Comparison Sorting

An alternate approach is to pick a cost model.
* We’ll use number of characters examined.
* By “examined”, we mean:
  * Radix Sort: Calling charAt in order to count occurrences of each character.
  * Merge Sort: Calling charAt in order to compare two Strings.

<br/>

For N equal strings of length 1000, we found that:
* MSD radix sort will examine ~1000N characters (For N= 100: 100,000).
* Merge sort will examine ~1000Nlog2(N) characters (For N=100: 660,000).

### Empirical Study: Radix Sort vs. Comparison Sorting

对字符的比较操作的数量确实像前面算的那样，但实际上 Merge sort 跑得快得多。
* 因为还有大量的诸如创建数组、复制、缓存之类的操作，
* 以及java的 The “**Just In Time(JIT)**” Compiler
  * java 编译之后，在 Interpreter(解释器) 里跑的时候，会 study and re-implement your code based on what it learned by watching WHILE ITS RUNNING (!!).
  * 比如重复创建长度为1000的链表几百次，跑到一定的次数后 java 认为你实际上没有用到创建的这些东西，之后就自动停止创建新的链表

### Rerunning Our Empirical Study With No JIT

关掉JIT之后两者都变慢了，然后在上述的比较大量重复字符串的任务中，Merge sort 确实如预料般比 MSD radix sort 慢

**Bottom Line: Algorithms Can Be Hard to Compare**
Comparing algorithms that have the same order of growth is challenging.
* Have to perform computational experiments.
* In modern programming environments, experiments can be tricky due to optimizations like the JIT in Java.

Note: There’s always the chance that some small optimization to an algorithm can make it significantly faster.

### Sorting Summary

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210709205650.png"/>

<br/>

-----------------
<br/>

## **38. Compression(压缩)**

### Prefix Free Codes

A **prefix-free(无前缀) code** is one in which no codeword is a prefix of any other. 
例如：没有任何一个字母的二进制码是另一个字母的二进制码的前缀 像这样的编码方式


### Shannon Fano Codes 

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210712142416.png"/>

### Huffman Coding

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210712143339.png"/>

### Huffman Coding Data Structures

编码的时候可以用 **Map**。 
* **hashmap**慢一点，占用空间小；
* **array** (用字符的index去对应转换后的二进制码) 更快，占用空间稍大，更倾向于用这个

解码的时候可以用 **trie**

### Huffman Coding in Practice

Two possible philosophies for using Huffman Compression:
1. Build one corpus per input type.
2. For every possible input file, create a unique code just for that file. Send the code along with the compressed file.
第二种用的多一点

### Compression Theory

为了比较不同的压缩算法，把某个压缩算法的解码代码和压缩后产生的数据流视为一个整体，然后去比较这个整体

<br/>

-----------------
<br/>

## **39. Compression, Complexity, and P=NP?**

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210714163315.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210714163355.png"/>


### Optimal Compression and Kolmogorov Complexity 

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210714164435.png"/>

Fact #1: Kolmogorov Complexity is effectively **independent** of language.

Fact #2: It is **impossible** to write a program that even calculates the Kolmogorov Complexity of any bitstream. 
* Corollary: If we can’t even compute the length of the shortest program, it is also **impossible** to write the “perfect” compression algorithm. 


### Space/Time Bounded Compression 

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210714165918.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210714170000.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210714170032.png"/>


### P = NP? 

Two important classes of yes/no problems:
* P: Efficiently solvable problems.
* NP: Problems with solutions that are efficiently verifiable(可以用有效率的方式验证).*

Examples of problems in P:
* Is this array sorted?
* Does this array have duplicates?

Examples of problems in NP:
* Is there a solution to this 3SAT problem?
* In graph G, does there exist a path from s to t of weight > k?

*: Technically it’s problems for a which a “yes” answer is efficiently verifiable.

**P = NP? 问题：**
* 针对 能够用有效率的方式验证回答是否正确的问题，能否找到该问题的有效率的解答？3

所有的数学证明都是NP问题，所以如果 P = NP 被解决了，其他的也都被解决了233














<br/>

# Markdown 基础语法

https://katex.org/docs/supported.html   Markdown Preview Enhanced 的数学公式写法

Markdown 目录：
[TOC]

Markdown 标题：
# 这是 H1
## 这是 H2
### 这是 H3

Markdown 列表：
- 列表项目
1. 列表项目

*斜体*或_斜体_
**粗体**
***加粗斜体***
~~删除线~~

Markdown 插入链接：
[链接文字](链接网址 "标题")

Markdown 插入图片：
![alt text](/path/to/img.jpg "Title")

Markdown 插入代码块：
    ```python
    #!/usr/bin/python3
    print("Hello, World!");
    ```

Markdown 引用：
> 引用内容

Markdown 分割线：

---

Markdown 换行：
<br>

Markdown 段首缩进：
&ensp; or &#8194; 表示一个半角的空格
&emsp; or &#8195;  表示一个全角的空格
&emsp;&emsp; 两个全角的空格（用的比较多）
&nbsp; or &#160; 不断行的空白格

Markdown 表格
| Syntax      | Description | Test Text     |
| :---        |    :----:   |          ---: |
| Header      | Title       | Here's this   |
| Paragraph   | Text        | And more      |




-----------------

![](https://cdn.jsdelivr.net/gh/light266/pic@main/study/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201221162358.png)