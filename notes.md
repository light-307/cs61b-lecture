# CS61B

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

### Autocomplete

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210612215414.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210612215542.png"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210612215612.png" style="zoom: 25%;"/>















<br/>

# Markdown 基础语法

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






-----------------

![](https://cdn.jsdelivr.net/gh/light266/pic@main/study/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201221162358.png)