package com.demo.demo1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author Cheung
 * @date 2021/2/3 16:59
 * 编程基础模型
 */
public class Note1_1 {
    //Java中的基础原始数据类型包括int(整型32位),double(双浮点数),bool（布尔型）,char（字符类型），基于此，
    // 还有long（64位整型），short(16位整型)，byte(8位整型)，float（32位单精度浮点数）
    //对其做操作的运算符的优先顺序为高优先级*,/,%；低优先级+，-
    //逻辑运算符包括&&(与)，||（或），！（非）,^(异或)，优先级排序为！。&&。||
    //类型的转换需要注意，尽量避免这种情况的出现
    //布尔表达式，即运算结果为布尔值的表达式，常常产生于比较运算符（==，<=,>=,!=,<,>），常见于循环和条件语句

    //Java为强类型的语言，因此要保证运算类型的一致性，我们一般在第一次使用该变量时声明该变量，一般在首次使用变量的时候声明并赋值该变量,
    //是为了限制其使用域，也就是限制局部变量的使用范围

    //简便写法，i/=2 ==> i=i/2;若循环和条件语句的执行体只有一句，那就可以省略大括号

    //在声明数组时，必须指定数组的名称和数据类型，并且声明数组的长度,在下面写一个示例
    ///将数组生成的每一步都分开表示，较为繁琐
    private static void MakeNewArrays() {
        double[] a;//声明数组
        a=new double[5];//赋值数组长度
        for (int i = 0; i < 5; i++) {
            a[i]=0;
            System.out.println(a[i]);
        }//通过for循环来为数组的每个元素赋值
    }
    ///省略中间的步骤，直接生成数组
    private static void MakeNewArraysSimple(){
        double[] a=new double[5];//同时声明和赋值数组长度，《《《这里需要注意的是，此时数组内的元素默认的就是0.0，bool值默认为false,int默认为0》》》
        int[] b={0,0,0,0,0};//同时声明数组和直接赋值数组元素，跳过了赋值长度，会根据大括号里的值的数量来生成匹配长度的数组
    }
    //经典的几个数组操作
    private static void ClassicalArraysFunction(){
        int[] a=new int[5];
        //找到数组最大值
        int maxNum=a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i]>maxNum) maxNum=a[i];
        }

        //计算数组元素平均值
        int average;
        int numSum=0;
        int n=a.length;

        for (int i = 0; i < a.length; i++)
            numSum+=a[i];

        average=numSum/n;

        //复制数组
        int lengthOfArrays=a.length;
        int[] b=new int[lengthOfArrays];

        for (int i = 0; i < a.length; i++)
            b[i] = a[i];

        //颠倒数组元素
        for (int i = 0; i < a.length/2; i++) {
            int num = a[i];
            a[i]=a[lengthOfArrays-i];
            a[lengthOfArrays-i]=num;
        }
        //矩阵相乘（方阵）***********
        int[][] arraysA=new int[3][3];
        int[][] arraysB=new int[3][3];
        int[][] arraysC=new int[3][3];//在Java中直接对二维数组使用.length获取到的是二维数组的行数，用arr[i].length获取的是第i行的长度（元素数）
        for (int i = 0; i < arraysA.length; i++) {
            for (int j = 0; j < arraysB.length; j++) {
                for (int k = 0; k < arraysC.length; k++)
                    arraysC[i][j]+=arraysA[i][k]*arraysB[k][j];
            }

        }


    }
    //起别名：我们在创建了一个数组后，再将这个数组赋值给一个新的数组，那这两个变量都会指向这个数组，此时对后面的数组做操作，也会对前一个数组产生影响，我们应该尽量避免这种情况
    //在需要创建两个相同元素的数组时，通过上面复制数组的方法来添加他的元素值，也就是说，我们应该创建两个不相关的数组，下面给出示例
    private static void GiveOtherName(){
        int[] a=new int[5];
        a[0]=123;
        int[] b=a;
        b[0]=1234;
        System.out.println(b[0]);
        System.out.println(a[0]);//这时两个输出结果是相同的，也是就说，后面对b的操作也影响了a，我们要尽量避免这样的情况，防止变量间的关系混乱,如果我们用另一种方法
        //来将a的值给到新的数组，这样对新数组的操作就不会影响a
        int[] c=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        System.out.println(a[0]);
        System.out.println(c[0]);
        c[0]=1;
        System.out.println(a[0]);//输出为1234
        System.out.println(c[0]);//此时的结果不同，输出为1，我们通过这样的方法创建了两个不相关，但是元素相同的数组


    }
    //二维数组：即一维数组的数组，虽然可以每行不同元素数量，但我们一般都是将二维数组规定为M*N的，类似于矩阵，各数据类型的默认值也适用于二维数组，
    private static void DoubleArrays(){
        int[][] a=new int[3][3];//此时为3*3的二维数组，里面的元素都是0，[行][列]，如果我们要对其中单独的元素赋值，那我们需要循环语句进行辅助操作

    }
    //在语言中的e代表一个极小的数，1e-6就是0.000001，用于处理bool判断时的绝对值，使其存在误差，举一例
    private static void Epslon(){
        double a=1/3+1/3+1/3;//因为两个整型相除是保留整数，去掉小数，因此这里的a=0
        double b=0.333333;
        double c=b*3;
        if (c==1){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }//此时我们获得的结果为No，这是因为计算机中的1/3==0.33333，这三个值相加为0.999999，显然不等于1，但是在现实的数学中我们确实认为结果是True的,此时我们加入一个epslon来
        //给结果一个判断的误差，如果这个结果和我们期望的结果小于这个误差，我们可以认为这是我们想要的结果
        if (1-c<=1e-5){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }//我们在这里添加了一个极小的值，它代表了我们能够忍受的误差，或者说这里的1e-5就是我们所说的精度，在我们对精度做出了规定之后，这个结果我们就能够认为他是==1的

    }

    // TODO: 2021/2/3  平方根计算原理
    ///静态函数static几个示例
    //计算一个整数的绝对值（验证成功）
    private static int GetIntAbsoluteValue(int a){
        int num=a;
        if (num<0) return -num;
        else return num;
    }
    //计算一个浮点数的绝对值（验证成功）
    private static double GetDoubleAbsoluteValue(double a){
        double num=a;
        if (num<0) return -num;
        else return num;
    }
    //判断一个数是否为素数（验证成功）
    private static boolean GetNumIsOrNotPrimerNum(int a){
        int num=a;
        if (num<2) return false;

            for (int i = 2; i < num; i++)
                if( num%i==0) return true;
            return false;

    }
    //计算平方根(牛顿迭代法，原理--https://blog.csdn.net/chenrenxiang/article/details/78286599)(验证成功)
    private static double GetSquareRoot(double a){
        double num=a;
        double err=1e-15;
        if (num<0) return Double.NaN;
        else {
            double root=num;
            while (Note1_1.GetDoubleAbsoluteValue(num-root*root)>err){
                root=(root+num/root)/2.0;
            }
            return root;
        }
    }
    //计算直角三角形的斜边（勾股定理）（验证成功）
    private static double GetTriangleEdge(double a,double b){
        return Note1_1.GetSquareRoot(a*a+b*b);
    }
    //计算调和级数(验证成功)
    private static double GetHarmonicProgression(int a){
        int num=a;
        double result=0;
        for (int i = 1; i <= num; i++) {
             result+=1.0/i;
        }
        return result;
    }

    //方法的性质
    /*（1）方法的参数按数值传递，在静态方法被调用传入参数时，该参数就类似于被调用方法的局部变量，但是需要注意的是，调用方法时传入的参数实际是按值传送的，也就是我们不能修改主动调用方法的
        值
      （2）方法可以被重载，我们可以定义几个参数不同但功能相同的方法，即使他们的方法名相同，我们也能够根据方法的参数来区分它们，并且便于使用
      （3）方法只能返回一个值，但一个方法可以有多个返回语句，在第一个返回语句执行后，方法执行结束
      （4）方法即使没有返回值，也可以产生一些副作用，这些作用可以影响系统的状态，数值等
     */
    //方法可以调用自己，即递归，
    // （1）递归总有一个最简单的情况，即方法的第一条语句总是包含return的条件语句
    // （2）递归调用总是去尝试解决一个规模更小的问题，这样递归才能收敛到最简单的情况
    // （3）递归调用的父物体和尝试解决问题的子问题之间不应该有任何交集
    //举一例，二分查找的递归实现。所谓二分查找，就是在一个数组内找到一个值的索引，采用的方法是先取中间值，在通过不断取中间值从而逼近（前提是我们查找的数组是顺序储存结构，可以是升序或者降序）
    //调用的方法体
    private static int Rank(int key,int[] a){
        return Rank(key,a,0,a.length-1);
    }
    //被调用方法体内调用的重载的函数，这里用到了递归
    private static int Rank(int key,int[] a,int ol,int hi){
        if(ol>hi) return -1;
        int mid=ol+(hi-ol)/2;
        if(key>a[mid]) return Rank(key,a,mid+1,hi);
        else if(key<a[mid]) return Rank(key,a,ol,mid-1);
        return mid;
    }

    //API(应用程序编程接口)，目的就是将调用和实现分离，除了API中给出的信息，调用者不需要知道实现的其他细节。

    /*字符串
    （1）可以使用+来拼接字符串
    （2）字符串一个很重要的作用就是用于与各种数据类型的转换，我们可以将输入的字符串转换为其他类型方便操作，也能够将我们处理完的数据转换为字符串输出
        这里常用的API：字符串转换为int，parseInt（string s）；字符串转换为double，parseDouble（string s）；int转换为字符串：toString（int i）；
        double转换为字符串：toString（double d）
    （3）实际上我们很少使用toString的API，在Java中只要与字符串使用+进行拼接的数据类型都能够转换为字符串，利用这个特性，我们可以利用“”这样的空字符串专门来转换数据类型为String
     */
    //在类TestPrintf中测试了标注库中的格式化输出
    //对于格式化输出的格式化方法，在下面举一例
    // TODO: 2021/2/5 所有数据类型都适用于长度>宽度，宽度无效原则
    private static void PrintfTest(){

        StdOut.printf("%14d\n",512);//首先：格式字符串内的转换代码的类型必须与后面的输出的参数类型一致，在格式字符串中，int的转换代码就是d，d之前的参数代表了要输出的宽度
        //所谓宽度，就是输出的结果所占的长度，在这里我们规定他的宽度为14，很明显的512只占了3个长度，那输出的结果就会在512之前（左边）插入11个空白的字符
        StdOut.printf("%-14d\n",512);//这里我们规定的宽度为-14，这时512占据14个宽度的前3个宽度，而空白的宽度在其后

        StdOut.printf("%14.2f\n",1595.12837189237);//double对应的转换代码为f（浮点数）或e（科学计数法）,这里的.2代表了我们转换后保留的小数点后的位数，空白宽度在右
        StdOut.printf("%.7f\n",1595.12837189237);//这里不规定输出宽度，限制精度为小数点后7位
        StdOut.printf("%14.4e\n",1595.12837189237);//同时规定宽度和保留精度，但用科学计数法表示

        StdOut.printf("%14s\n","Hello,World");//String对应的转换代码为s，宽度规定为14，空白宽度在左
        StdOut.printf("%-14s\n","Hello,World");//空白宽度在右
        StdOut.printf("%14.5s\n","Hello,World");//这里规定了宽度14，但是规定了保留精度为5，因此空宽度在左，结果如下

        //这里的数据输出不受宽度约束
        StdOut.printf("%1d\n",512);//需要注意的是，如果数据本身的长度就超过了规定的宽度，宽度就不再起作用
        StdOut.printf("%10.10f\n",5.12837189237);//不规定宽度，宽度就是小数点前+7个小数点后
        StdOut.printf("%3s\n","Hello,World");//这里的数据输出不受宽度约束

        /*输出为
        512
        512
        1595.13
        1595.1283719
        1.5951e+03
        Hello,World
        Hello,World
        Hello
        512
        5.1283718924
        Hello,World
        */
    }

    //数据抽象（面向对象编程）：
    //（1）主要思想：鼓励程序定义自己的数据类型（一系列的值和相关的操作）
    //（2）使用数据抽象的原因：1：允许通过模块化编程复用代码；2：是我们能够构造多种链式数据结构；3：我们能够准确的定义所面对的算法问题
    public static void main(String[] args) {

        MakeNewArrays();
        GiveOtherName();
        Epslon();


        double res= GetTriangleEdge(3,4);
        double res1=GetDoubleAbsoluteValue(-5.134214);
        boolean res2=GetNumIsOrNotPrimerNum(6);
        double res3=GetSquareRoot(9);
        double res4=GetTriangleEdge(3,4);
        double res5=GetHarmonicProgression(2);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        int[] a={-3,1,3,5};
        int res6=Rank(2,a);
        System.out.println(res);


        PrintfTest();


    }

}
