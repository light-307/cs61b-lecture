# CS61B

## **1. Intro, Hello World Java**

```
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

```
public class Dog {
    public static void makeNoise() {
        System.out.println("Bark!");
    }
}
```
以上单独不能编译，但是可以在另一个`class`里的`main`调用，然后一起编译

```
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
```
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

```
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

```
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

```
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
```
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
```
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
```
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
```
public class AList<Item> implements List61B<Item>{...}

public class SList<Item> implements List61B<Item>{...}
```
之后针对 List61B 写的方法对 AList 和 SList 都适用  
AList 中的方法会 `override` List61B 中的同名方法。可以加上 `@Override` 做个标注并且用于检查函数名有没有写错

<br/>

```
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

```
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

```
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

```
// compile-time type 的类型转换
//Right hand side has compile-time type Poodle after casting

Poodle largerPoodle = (Poodle) maxDog(frank, frankJr);
```

<br/>

-----------------
<br/>

## **10. Subtype Polymorphism vs. HoFs**

![](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210512154217.png)


<br/>

-----------------
<br/>

## **11. Exceptions, Iterators, Object Methods**

```
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

```
//Sets

import java.util.Set;
import java.util.HashSet;

Set<String> s = new HashSet<>();
s.add("Tokyo");
s.add("Lagos");
System.out.println(S.contains("Tokyo")); // true
```
<br/>

`System.out.println(Object x)` calls `x.toString()`

```
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

```
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

```
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

# CS50

## **week2_Arrays**

* it turns out that a string ends with a special character, ‘\0’, or a byte with all bits set to 0. This character is called the null character, or null terminating character. So we actually need four bytes to store our string “HI!”:

![](https://cdn.jsdelivr.net/gh/light266/pic@main/study/memory_with_string.png)

<br/>

-----------------
<br/>

## **week3_Algorithms**

* Merge sort

![](https://cdn.jsdelivr.net/gh/light266/pic@main/study/Merge_sort.jpg)

* 注意**递归算法**

<br/>

-----------------
<br/>

## **week4_Memory**
```
typedef char *string;
```

C 库函数 void *malloc(size_t size) 分配所需的内存空间，并返回一个指向它的指针。

valgrind ./copy2   可以用来检查程序使用和释放的内存

程序的内存分布
![程序的内存](https://cdn.jsdelivr.net/gh/light266/pic@main/study/20201215202633.png)

所有JPG图的开头3个字节都是 FF D8 FF

<br/>

-----------------
<br/>

## **week5_Data_Structures**

`int *y` 这样的初始化实际并没有赋值
没有给y赋值，y没有具体指向的位置，所以`*y=13`那里是错的
![](https://cdn.jsdelivr.net/gh/light266/pic@main/study/20201221143029.png)

### **malloc()和calloc()**

    malloc()函数有一个参数,即要分配的内存空间的大小:
    void *malloc(size_t size);

    calloc()函数有两个参数,分别为元素的数目和每个元素的大小,这两个参数的乘积就是要分配的内存空间的大小。
    void *calloc(size_t numElements,size_t sizeOfElement);

    如果调用成功,函数malloc()和函数calloc()都将返回所分配的内存空间的首地址。

    函数calloc()会将所分配的内存空间中的每一位都初始化为零，而malloc()不会

<br/>

nul是\0   null是0x0

<br/>

a linked list struct in C
![](https://cdn.jsdelivr.net/gh/light266/pic@main/study/20201221160933.png)

`(*n).number = 2;` 和 `n->number = 2;` 等价

```
// Print list
for (node *tmp = list; tmp != NULL; tmp = tmp->next)
{
    printf("%i\n", tmp->number);
}
```

二分法搜索  在tree结构里
```
bool search(node *tree)
{
    if (tree == NULL)
    {
        return false;
    }
    else if (50 < tree->number)
    {
        return search(tree->left);
    }
    else if (50 > tree->number)
    {
        return search(tree->right);
    }
    else
    {
        return true;
    }
}
```

<br/>

* hash tables  按前几个字母的顺序，把东西扔进不同的盒子，从而近似得到O(1)

* tries   真正的O(1)，但是消耗大量存储空间
![](https://cdn.jsdelivr.net/gh/light266/pic@main/study/20201221203942.png)

* queue  一个FIFO(first in, first out)的数据结构
* stack  LIFO

<br/>

-----------------
<br/>

## **week6_Python**

* 在循环或者条件语句里面被定义的变量可以在外面后面使用（Python可以，C不行）

    Python和C 在函数里面定义的变量都不能跨函数使用

* 可以用这种形式写Python，有内容的主函数在前面，然后是一堆子函数，最后放个`main()`
```
def main():
    cough(3)

def cough(n):
    for i in range(n):
        print("cough")

main()
```

python可以用这种类似 `%s` 的 `print(f"Average: {scores}")` 注意里面有个 `f`

`print(c, end="")` 普通的print末尾自带'\n'

dictionary in python
```
# dictionary in python

people = {
    "EMMA": "617-555-0100",
    "RODRIGO": "617-555-0101",
    "BRIAN": "617-555-0102",
    "DAVID": "617-555-0103"
}

# Search for EMMA
if "EMMA" in people:
    print(f"Found {people['EMMA']}")
```

python 里没有char，所以用 `"` 和 `'` 都可以，除非在 `" "` 里套 `' '` 用作区分

`s[i:j]` 取字符串的第i个至第j个（不包括j的那个）

<br/>

-----------------
<br/>

## **week7_SQL**

可以直接用 `sorted` 来排序；`lambda item: item[1]` 定义了一个一行的函数，输入是item，输出是item[1]
```
for title, count in sorted(counts.items(), key=lambda item: item[1], reverse=True):
    print(title, count, sep=" | ")
```

**SQL**: Structured Query Language

<br/>

-----------------
<br/>

## **week8_HTML, CSS, JavaScript**

<br/>

-----------------
<br/>

## **week9_Flask**

在python里，`__name__` 表示当前文件的文件名

永远不要相信你的用户，他们总是会整出各种骚操作233

<br/>

-----------------
<br/>

## **week10_Ethics**


-----------------

![](https://cdn.jsdelivr.net/gh/light266/pic@main/study/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201221162358.png)