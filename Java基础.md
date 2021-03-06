# Java 历史

Java 是由 Sun Microsystems 公司于 1995 年 5 月推出的 Java 面向对象程序设计语言和 Java 平台的总称。由 James Gosling和同事们共同研发，并在 1995 年正式推出。

后来 Sun 公司被 Oracle （甲骨文）公司收购，Java 也随之成为 Oracle 公司的产品。

# Java 基础语法

一个 Java 程序可以认为是一系列对象的集合，而这些对象通过调用彼此的方法来协同工作。下面简要介绍下类、对象、方法和实例变量的概念。

- **对象**：对象是类的一个实例，有状态和行为。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。

- **类**：类是一个模板，它描述一类对象的行为和状态。

- **方法**：方法就是行为，一个类可以有很多方法。逻辑运算、数据修改以及所有动作都是在方法中完成的。

- **实例变量**：每个对象都有独特的实例变量，对象的状态由这些实例变量的值决定。

  ![img](https://www.runoob.com/wp-content/uploads/2013/12/662E827A-FA32-4464-B0BD-40087F429E98.jpg)

下面将逐步介绍如何保存、编译以及运行这个程序：

```java
public class HelloWorld {
    // 基本语法
    public static void main(String []args) {
        System.out.println("Hello World"); // 打印 Hello World
    }
}
```

- 打开代码编辑器，把上面的代码添加进去；
- 把文件名保存为：HelloWorld.java；
- 打开 cmd 命令窗口，进入目标文件所在的位置，假设是 C:\
- 在命令行窗口输入 **javac HelloWorld.java** 按下回车键编译代码。如果代码没有错误，cmd 命令提示符会进入下一行（假设环境变量都设置好了）。
- 再键输入 **java HelloWorld** 按下回车键就可以运行程序了

你将会在窗口看到 Hello World

```bash
$ javac HelloWorld.java
$ java HelloWorld 
Hello World
```

如果遇到编码问题，我们可以使用 **-encoding** 选项设置 **utf-8** 来编译：

```bash
javac -encoding UTF-8 HelloWorld.java 
java HelloWorld 
```

## 基本语法

编写 Java 程序时，应注意以下几点：

- **大小写敏感**：Java 是大小写敏感的，这就意味着标识符 Hello 与 hello 是不同的。
- **类名**：对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如 **MyFirstJavaClass** 。
- **方法名**：所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写。
- **源文件名**：源文件名必须和类名相同。当保存文件的时候，你应该使用类名作为文件名保存（切记 Java 是大小写敏感的），文件名的后缀为 **.java**。（如果文件名和类名不相同则会导致编译错误）。
- **主方法入口**：所有的 Java 程序由 **public static void main(String[] args)** 方法开始执行。

## Java 标识符

Java 所有的组成部分都需要名字。类名、变量名以及方法名都被称为标识符。

关于 Java 标识符，有以下几点需要注意：

- 所有的标识符都应该以字母（A-Z 或者 a-z）,美元符（$）、或者下划线（_）开始
- 首字符之后可以是字母（A-Z 或者 a-z）,美元符（$）、下划线（_）或数字的任何字符组合
- 关键字不能用作标识符
- 标识符是大小写敏感的
- 合法标识符举例：age、$salary、_value、__1_value
- 非法标识符举例：123abc、-salary

## Java修饰符

像其他语言一样，Java可以使用修饰符来修饰类中方法和属性。主要有两类修饰符：

- 访问控制修饰符 : default, public , protected, private
- 非访问控制修饰符 : final, abstract, static, synchronized

在后面的章节中我们会深入讨论 Java 修饰符。

## Java 变量

Java 中主要有如下几种类型的变量

- 局部变量
- 类变量（静态变量）
- 成员变量（非静态变量）

## Java 数组

数组是储存在堆上的对象，可以保存多个同类型变量。在后面的章节中，我们将会学到如何声明、构造以及初始化一个数组。

------

## Java 枚举

Java 5.0引入了枚举，枚举限制变量只能是预先设定好的值。使用枚举可以减少代码中的 bug。

例如，我们为果汁店设计一个程序，它将限制果汁为小杯、中杯、大杯。这就意味着它不允许顾客点除了这三种尺寸外的果汁。

### 实例

```java
class FreshJuice {   
    enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }   
    FreshJuiceSize size; 
}  
public class FreshJuiceTest {   
    public static void main(String[] args){      
        FreshJuice juice = new FreshJuice();      
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;   
    } 
}
```

**注意：**枚举可以单独声明或者声明在类里面。方法、变量、构造函数也可以在枚举中定义。

------

## Java 关键字

下面列出了 Java 关键字。这些保留字不能用于常量、变量、和任何标识符的名称。

```java
public class HelloWorld {   
    /* 这是第一个Java程序    
    * 它将输出 Hello World    
    * 这是一个多行注释的示例    
    */    
    public static void main(String[] args){       
        // 这是单行注释的示例       
        /* 这个也是单行注释的示例 */       
        System.out.println("Hello World");     
    } 
}
```

## Java 空行

空白行或者有注释的行，Java 编译器都会忽略掉。

------

## 继承

在 Java 中，一个类可以由其他类派生。如果你要创建一个类，而且已经存在一个类具有你所需要的属性或方法，那么你可以将新创建的类继承该类。

利用继承的方法，可以重用已存在类的方法和属性，而不用重写这些代码。被继承的类称为超类（super class），派生类称为子类（sub class）。

------

## 接口

在 Java 中，接口可理解为对象间相互通信的协议。接口在继承中扮演着很重要的角色。

接口只定义派生要用到的方法，但是方法的具体实现完全取决于派生类。

------

## Java 源程序与编译型运行区别

如下图所示：

![img](https://www.runoob.com/wp-content/uploads/2013/12/ZSSDMld.png)

# Java 对象和类

Java作为一种面向对象语言。支持以下基本概念：

- 多态
- 继承
- 封装
- 抽象
- 类
- 对象
- 实例
- 方法
- 重载

本节我们重点研究对象和类的概念。

- **对象**：对象是类的一个实例（**对象不是找个女朋友**），有状态和行为。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。
- **类**：类是一个模板，它描述一类对象的行为和状态。

下图中**男孩（boy）**、**女孩（girl）**为**类（class）**，而具体的每个人为该类的**对象（object）**：

![img](https://www.runoob.com/wp-content/uploads/2013/12/object-class.jpg)

下图中**汽车**为**类（class）**，而具体的每辆车为该**汽车**类的**对象（object）**，对象包含了汽车的颜色、品牌、名称等。

![img](https://www.runoob.com/wp-content/uploads/2013/12/class-object2020-10-27.png)

## Java中的对象

现在让我们深入了解什么是对象。看看周围真实的世界，会发现身边有很多对象，车，狗，人等等。所有这些对象都有自己的状态和行为。

拿一条狗来举例，它的状态有：名字、品种、颜色，行为有：叫、摇尾巴和跑。

对比现实对象和软件对象，它们之间十分相似。

软件对象也有状态和行为。软件对象的状态就是属性，行为通过方法体现。

在软件开发中，方法操作对象内部状态的改变，对象的相互调用也是通过方法来完成。

## Java 中的类

类可以看成是创建 Java 对象的模板。

## Java 中的类

类可以看成是创建 Java 对象的模板。

![img](https://www.runoob.com/wp-content/uploads/2013/12/20210105-java-object-1.png)

通过上图创建一个简单的类来理解下 Java 中类的定义：

```java
public class Dog {    
    String breed;    
    int size;    
    String colour;    
    int age;     
    void eat() {
    }
    void run() {
    }
    void sleep() {    
    }
    void name() {
    }
}
```

一个类可以包含以下类型变量：

- **局部变量**：在方法、构造方法或者语句块中定义的变量被称为局部变量。变量声明和初始化都是在方法中，方法结束后，变量就会自动销毁。
- **成员变量**：成员变量是定义在类中，方法体之外的变量。这种变量在创建对象的时候实例化。成员变量可以被类中方法、构造方法和特定类的语句块访问。
- **类变量**：类变量也声明在类中，方法体之外，但必须声明为 static 类型。

一个类可以拥有多个方法，在上面的例子中：eat()、run()、sleep() 和 name() 都是 Dog 类的方法。

------

## 构造方法

每个类都有构造方法。如果没有显式地为类定义构造方法，Java 编译器将会为该类提供一个默认构造方法。

在创建一个对象的时候，至少要调用一个构造方法。构造方法的名称必须与类同名，一个类可以有多个构造方法。

下面是一个构造方法示例：

```java
public class Puppy{    
    public Puppy(){    
    }     
    public Puppy(String name){        
        // 这个构造器仅有一个参数：name    
    } 
}
```

## 创建对象

对象是根据类创建的。在Java中，使用关键字 new 来创建一个新的对象。创建对象需要以下三步：

- **声明**：声明一个对象，包括对象名称和对象类型。
- **实例化**：使用关键字 new 来创建一个对象。
- **初始化**：使用 new 创建对象时，会调用构造方法初始化对象。

下面是一个创建对象的例子：

```java
public class Puppy{   
    public Puppy(String name){      
        //这个构造器仅有一个参数：name      
        System.out.println("小狗的名字是 : " + name );    
    }   
    public static void main(String[] args){      
        // 下面的语句将创建一个Puppy对象      
        Puppy myPuppy = new Puppy( "tommy" );   
    } 
}
```

编译并运行上面的程序，会打印出下面的结果：

```java
小狗的名字是 : tommy
```

## 访问实例变量和方法

通过已创建的对象来访问成员变量和成员方法，如下所示：

```java
/* 实例化对象 */ 
Object referenceVariable = new Constructor(); 
/* 访问类中的变量 */ 
referenceVariable.variableName; 
/* 访问类中的方法 */ 
referenceVariable.methodName();
```

## 实例

下面的例子展示如何访问实例变量和调用成员方法：

```java
public class Puppy{   
    int puppyAge;  
    public Puppy(String name){      
        // 这个构造器仅有一个参数：name     
        System.out.println("小狗的名字是 : " + name );    
    }   
    public void setAge( int age ){   
        puppyAge = age; 
    }   
    public int getAge( ){  
        System.out.println("小狗的年龄为 : " + puppyAge );   
        return puppyAge; 
    }  
    public static void main(String[] args){  
        /* 创建对象 */  
        Puppy myPuppy = new Puppy( "tommy" );   
        /* 通过方法来设定age */   
        myPuppy.setAge( 2 );  
        /* 调用另一个方法获取age */    
        myPuppy.getAge( );    
        /*你也可以像下面这样访问成员变量 */    
        System.out.println("变量值 : " + myPuppy.puppyAge );  
    } 
}
```

编译并运行上面的程序，产生如下结果：

```java
小狗的名字是 : tommy
小狗的年龄为 : 2
变量值 : 2
```

## 源文件声明规则

在本节的最后部分，我们将学习源文件的声明规则。当在一个源文件中定义多个类，并且还有import语句和package语句时，要特别注意这些规则。

- 一个源文件中只能有一个 public 类
- 一个源文件可以有多个非 public 类
- 源文件的名称应该和 public 类的类名保持一致。例如：源文件中 public 类的类名是 Employee，那么源文件应该命名为Employee.java。
- 如果一个类定义在某个包中，那么 package 语句应该在源文件的首行。
- 如果源文件包含 import 语句，那么应该放在 package 语句和类定义之间。如果没有 package 语句，那么 import 语句应该在源文件中最前面。
- import 语句和 package 语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。

类有若干种访问级别，并且类也分不同的类型：抽象类和 final 类等。这些将在访问控制章节介绍。

除了上面提到的几种类型，Java 还有一些特殊的类，如：[内部类](https://www.runoob.com/java/java-inner-class.html)、[匿名类](https://www.runoob.com/java/java-anonymous-class.html)。

## Java 包

包主要用来对类和接口进行分类。当开发 Java 程序时，可能编写成百上千的类，因此很有必要对类和接口进行分类。

## import 语句

在 Java 中，如果给出一个完整的限定名，包括包名、类名，那么 Java 编译器就可以很容易地定位到源代码或者类。import 语句就是用来提供一个合理的路径，使得编译器可以找到某个类。

例如，下面的命令行将会命令编译器载入 java_installation/java/io 路径下的所有类

```java
import java.io.*;
```

------

## 一个简单的例子

在该例子中，我们创建两个类：**Employee** 和 **EmployeeTest**。

首先打开文本编辑器，把下面的代码粘贴进去。注意将文件保存为 Employee.java。

Employee 类有四个成员变量：name、age、designation 和 salary。该类显式声明了一个构造方法，该方法只有一个参数。

## Employee.java 文件代码：

```java
import java.io.*;  
public class Employee{  
    String name;  
    int age;  
    String designation; 
    double salary;   
    // Employee 类的构造器 
    public Employee(String name){     
        this.name = name;  
    } 
    // 设置age的值 
    public void empAge(int empAge){   
        age =  empAge; 
    }  
    /* 设置designation的值*/   
    public void empDesignation(String empDesig){  
        designation = empDesig;  
    }  
    /* 设置salary的值*/  
    public void empSalary(double empSalary){  
        salary = empSalary; 
    }  
    /* 打印信息 */   
    public void printEmployee(){  
        System.out.println("名字:"+ name );   
        System.out.println("年龄:" + age ); 
        System.out.println("职位:" + designation ); 
        System.out.println("薪水:" + salary);  
    } 
}
```

程序都是从main方法开始执行。为了能运行这个程序，必须包含main方法并且创建一个实例对象。

下面给出EmployeeTest类，该类实例化2个 Employee 类的实例，并调用方法设置变量的值。

将下面的代码保存在 EmployeeTest.java文件中。

## EmployeeTest.java 文件代码：

```java
import java.io.*;
public class EmployeeTest{  
    public static void main(String[] args){ 
        /* 使用构造器创建两个对象 */     
        Employee empOne = new Employee("RUNOOB1");   
        Employee empTwo = new Employee("RUNOOB2");      
        // 调用这两个对象的成员方法    
        empOne.empAge(26);  
        empOne.empDesignation("高级程序员");    
        empOne.empSalary(1000);  
        empOne.printEmployee();      
        empTwo.empAge(21);    
        empTwo.empDesignation("菜鸟程序员");    
        empTwo.empSalary(500);     
        empTwo.printEmployee();  
    }
}
```

编译这两个文件并且运行 EmployeeTest 类，可以看到如下结果：

```java
$ javac EmployeeTest.java
$ java EmployeeTest 
名字:RUNOOB1
年龄:26
职位:高级程序员
薪水:1000.0
名字:RUNOOB2
年龄:21
职位:菜鸟程序员
薪水:500.0
```

# Java 基本数据类型

变量就是申请内存来存储值。也就是说，当创建变量的时候，需要在内存中申请空间。

内存管理系统根据变量的类型为变量分配存储空间，分配的空间只能用来储存该类型数据。

![img](https://www.runoob.com/wp-content/uploads/2013/12/2020-10-27-code-mem.png)

因此，通过定义不同类型的变量，可以在内存中储存整数、小数或者字符。

Java 的两大数据类型:

- 内置数据类型
- 引用数据类型

## 内置数据类型

Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。

**byte：**

- byte 数据类型是8位、有符号的，以二进制补码表示的整数；
- 最小值是 **-128（-2^7）**；
- 最大值是 **127（2^7-1）**；
- 默认值是 **0**；
- byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
- 例子：byte a = 100，byte b = -50。

**short：**

- short 数据类型是 16 位、有符号的以二进制补码表示的整数
- 最小值是 **-32768（-2^15）**；
- 最大值是 **32767（2^15 - 1）**；
- Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
- 默认值是 **0**；
- 例子：short s = 1000，short r = -20000。

**int：**

- int 数据类型是32位、有符号的以二进制补码表示的整数；
- 最小值是 **-2,147,483,648（-2^31）**；
- 最大值是 **2,147,483,647（2^31 - 1）**；
- 一般地整型变量默认为 int 类型；
- 默认值是 **0** ；
- 例子：int a = 100000, int b = -200000。

**long：**

- long 数据类型是 64 位、有符号的以二进制补码表示的整数；
- 最小值是 **-9,223,372,036,854,775,808（-2^63）**；
- 最大值是 **9,223,372,036,854,775,807（2^63 -1）**；
- 这种类型主要使用在需要比较大整数的系统上；
- 默认值是 **0L**；
- 例子： **long a = 100000L**，**long b = -200000L**。
  "L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写。

**float：**

- float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
- float 在储存大型浮点数组的时候可节省内存空间；
- 默认值是 **0.0f**；
- 浮点数不能用来表示精确的值，如货币；
- 例子：float f1 = 234.5f。

**double：**

- double 数据类型是双精度、64 位、符合 IEEE 754 标准的浮点数；

- 浮点数的默认类型为 double 类型；

- double类型同样不能表示精确的值，如货币；

- 默认值是 **0.0d**；

- 例子：

  ```java
  double   d1  = 7D ;
  double   d2  = 7.; 
  double   d3  =  8.0; 
  double   d4  =  8.D; 
  double   d5  =  12.9867; 
  ```

  7 是一个 int 字面量，而 7D，7. 和 8.0 是 double 字面量。

**boolean：**

- boolean数据类型表示一位的信息；
- 只有两个取值：true 和 false；
- 这种类型只作为一种标志来记录 true/false 情况；
- 默认值是 **false**；
- 例子：boolean one = true。

**char：**

- char 类型是一个单一的 16 位 Unicode 字符；
- 最小值是 **\u0000**（十进制等效值为 0）；
- 最大值是 **\uffff**（即为 65535）；
- char 数据类型可以储存任何字符；
- 例子：char letter = 'A';。

### 实例

对于数值类型的基本类型的取值范围，我们无需强制去记忆，因为它们的值都已经以常量的形式定义在对应的包装类中了。请看下面的例子：

## 实例

```java
public class PrimitiveTypeTest {    
    public static void main(String[] args) {    
        // byte        
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);    
        System.out.println("包装类：java.lang.Byte"); 
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);  
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);    
        System.out.println();         
        // short      
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);    
        System.out.println("包装类：java.lang.Short");  
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);    
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);  
        System.out.println();      
        // int  
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);  
        System.out.println("包装类：java.lang.Integer");     
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);      
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);       
        System.out.println();        
        // long      
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE); 
        System.out.println("包装类：java.lang.Long");    
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);   
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);      
        System.out.println();      
        // float       
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);      
        System.out.println("包装类：java.lang.Float");     
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);     
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);    
        System.out.println();        
        // double         
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);     
        System.out.println("包装类：java.lang.Double");       
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);   
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);    
        System.out.println();        
        // char      
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);     
        System.out.println("包装类：java.lang.Character");      
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台     
        System.out.println("最小值：Character.MIN_VALUE="                  + (int) Character.MIN_VALUE);   
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台         
        System.out.println("最大值：Character.MAX_VALUE="                  + (int) Character.MAX_VALUE);     	}
}
```

运行实例 

编译以上代码输出结果如下所示：

```java
基本类型：byte 二进制位数：8
包装类：java.lang.Byte
最小值：Byte.MIN_VALUE=-128
最大值：Byte.MAX_VALUE=127

基本类型：short 二进制位数：16
包装类：java.lang.Short
最小值：Short.MIN_VALUE=-32768
最大值：Short.MAX_VALUE=32767

基本类型：int 二进制位数：32
包装类：java.lang.Integer
最小值：Integer.MIN_VALUE=-2147483648
最大值：Integer.MAX_VALUE=2147483647

基本类型：long 二进制位数：64
包装类：java.lang.Long
最小值：Long.MIN_VALUE=-9223372036854775808
最大值：Long.MAX_VALUE=9223372036854775807

基本类型：float 二进制位数：32
包装类：java.lang.Float
最小值：Float.MIN_VALUE=1.4E-45
最大值：Float.MAX_VALUE=3.4028235E38

基本类型：double 二进制位数：64
包装类：java.lang.Double
最小值：Double.MIN_VALUE=4.9E-324
最大值：Double.MAX_VALUE=1.7976931348623157E308

基本类型：char 二进制位数：16
包装类：java.lang.Character
最小值：Character.MIN_VALUE=0
最大值：Character.MAX_VALUE=65535
```

Float和Double的最小值和最大值都是以科学记数法的形式输出的，结尾的"E+数字"表示E之前的数字要乘以10的多少次方。比如3.14E3就是3.14 × 103 =3140，3.14E-3 就是 3.14 x 10-3 =0.00314。

实际上，JAVA中还存在另外一种基本类型 void，它也有对应的包装类 java.lang.Void，不过我们无法直接对它们进行操作。

### 类型默认值

下表列出了 Java 各个类型的默认值：

| **数据类型**           | **默认值** |
| :--------------------- | :--------- |
| byte                   | 0          |
| short                  | 0          |
| int                    | 0          |
| long                   | 0L         |
| float                  | 0.0f       |
| double                 | 0.0d       |
| char                   | 'u0000'    |
| String (or any object) | null       |
| boolean                | false      |

## 实例

```java
public class Test {   
    static boolean bool; 
    static byte by;   
    static char ch;  
    static double d;  
    static float f;   
    static int i;  
    static long l;  
    static short sh;  
    static String str;   
    public static void main(String[] args) {   
        System.out.println("Bool :" + bool);  
        System.out.println("Byte :" + by);   
        System.out.println("Character:" + ch);    
        System.out.println("Double :" + d);    
        System.out.println("Float :" + f);    
        System.out.println("Integer :" + i);   
        System.out.println("Long :" + l);     
        System.out.println("Short :" + sh);    
        System.out.println("String :" + str);  
    } 
}
```

实例输出结果为：

```java
Bool     :false
Byte     :0
Character:
Double   :0.0
Float    :0.0
Integer  :0
Long     :0
Short    :0
String   :null
```

## 引用类型

- 在Java中，引用类型的变量非常类似于C/C++的指针。引用类型指向一个对象，指向对象的变量是引用变量。这些变量在声明时被指定为一个特定的类型，比如 Employee、Puppy 等。变量一旦声明后，类型就不能被改变了。
- 对象、数组都是引用数据类型。
- 所有引用类型的默认值都是null。
- 一个引用变量可以用来引用任何与之兼容的类型。
- 例子：Site site = new Site("Runoob")。

------

## Java 常量

常量在程序运行时是不能被修改的。

在 Java 中使用 final 关键字来修饰常量，声明方式和变量类似：

```java
final double PI = 3.1415927;
```

虽然常量名也可以用小写，但为了便于识别，通常使用大写字母表示常量。

字面量可以赋给任何内置类型的变量。例如：

```java
byte a = 68;
char a = 'A'
```

byte、int、long、和short都可以用十进制、16进制以及8进制的方式来表示。

当使用字面量的时候，前缀 **0** 表示 8 进制，而前缀 **0x** 代表 16 进制, 例如：

```java
int decimal = 100;
int octal = 0144;
int hexa =  0x64;
```

和其他语言一样，Java的字符串常量也是包含在两个引号之间的字符序列。下面是字符串型字面量的例子：

```java
"Hello World"
"two\nlines"
"\"This is in quotes\""
```

字符串常量和字符变量都可以包含任何 Unicode 字符。例如：

```java
char a = '\u0001';
String a = "\u0001";
```

Java语言支持一些特殊的转义字符序列。

| 符号   | 字符含义                 |
| :----- | :----------------------- |
| \n     | 换行 (0x0a)              |
| \r     | 回车 (0x0d)              |
| \f     | 换页符(0x0c)             |
| \b     | 退格 (0x08)              |
| \0     | 空字符 (0x0)             |
| \s     | 空格 (0x20)              |
| \t     | 制表符                   |
| \"     | 双引号                   |
| \'     | 单引号                   |
| \\     | 反斜杠                   |
| \ddd   | 八进制字符 (ddd)         |
| \uxxxx | 16进制Unicode字符 (xxxx) |

------

## 自动类型转换

**整型、实型（常量）、字符型数据可以混合运算。运算中，不同类型的数据先转化为同一类型，然后进行运算。**

转换从低级到高级。

```java
低  ------------------------------------>  高

byte,short,char—> int —> long—> float —> double 
```

数据类型转换必须满足如下规则：

- \1. 不能对boolean类型进行类型转换。

- \2. 不能把对象类型转换成不相关类的对象。

- \3. 在把容量大的类型转换为容量小的类型时必须使用强制类型转换。

- \4. 转换过程中可能导致溢出或损失精度，例如：

  ```java
  int i =128;   
  byte b = (byte)i;
  ```

  因为 byte 类型是 8 位，最大值为127，所以当 int 强制转换为 byte 类型时，值 128 时候就会导致溢出。

- \5. 浮点数到整数的转换是通过舍弃小数得到，而不是四舍五入，例如：

  ```java
  (int)23.7 == 23;        
  (int)-45.89f == -45
  ```

### 自动类型转换

必须满足转换前的数据类型的位数要低于转换后的数据类型，例如: short数据类型的位数为16位，就可以自动转换位数为32的int类型，同样float数据类型的位数为32，可以自动转换为64位的double类型。

## 实例

```java
public class ZiDongLeiZhuan{    
    public static void main(String[] args){      
        char c1='a';
        //定义一个char类型        
        int i1 = c1;
        //char自动类型转换为int    
        System.out.println("char自动类型转换为int后的值等于"+i1);  
        char c2 = 'A';
        //定义一个char类型      
        int i2 = c2+1;
        //char 类型和 int 类型计算      
        System.out.println("char类型和int计算后的值等于"+i2); 
    }
}
```

运行结果为:

```java
char自动类型转换为int后的值等于97
char类型和int计算后的值等于66
```

**解析：**c1 的值为字符 **a** ,查 ASCII 码表可知对应的 int 类型值为 97， A 对应值为 65，所以 **i2=65+1=66**。

### 强制类型转换

- \1. 条件是转换的数据类型必须是兼容的。

- \2. 格式：(type)value type是要强制类型转换后的数据类型 实例：

  ## 实例

  ```java
  public class QiangZhiZhuanHuan{  
      public static void main(String[] args){    
          int i1 = 123;     
          byte b = (byte)i1;
          //强制类型转换为byte       
          System.out.println("int强制类型转换为byte后的值等于"+b);
      }
  }
  ```

  运行结果：

  ```java
  int强制类型转换为byte后的值等于123
  ```

### 隐含强制类型转换

- 1、 整数的默认类型是 int。

- \2. 小数默认是 double 类型浮点型，在定义 float 类型时必须在数字后面跟上 F 或者 f。

  

