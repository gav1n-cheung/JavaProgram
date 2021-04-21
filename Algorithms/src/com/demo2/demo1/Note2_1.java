package com.demo2.demo1;

/**
 * @author Cheung
 * @date 2021/4/4 9:46
 */
public class Note2_1 {
    /*
    排序就是将一组对象按照某种逻辑顺序重新排列地过程，学习排序算法仍然有三大实际意义：
    （1）对排序算法地分析将有助于你全面理解本书中比较算法性能地方法
    （2）类似的技术也能有效解决其他类型的问题
    （3）排序算法常常是我们解决其他问题地第一
     */
    /*
    2.1 初级排序算法
        2.1.1 游戏规则
            我们关注的主要对象是重新排列数组元素的算法，其中每个元素都有一个主键。排序算法地目标就是将所有元素的主键按照某种方式排列（通常是按照大小和字母排序）。
            排序后索引较大的主键大于等于索引较小的主键。元素和主键的具体性质在不同的应用中千差万别。在Java中，元素通常都是对象，对主键的抽象描述则是通过一种内置的机制来完成的。
            通过观察“排序算法类模板”中的Example类展示了我们的习惯约定--将排序代码放在sort()方法中，该类还包括辅助函数less()和exch()以及一个示例用例main()。
            大多数情况下，我们的排序代码只会通过两个方法来操作数据：less()方法对元素进行比较，exch()方法将元素交换位置。exch()方法的实现很简单，通过Comparable接口实现less也不困难。
            将数据操作限制在这两个方法中使得代码的可读性和可移植性更好，更容易验证代码的正确性、分析性能以及排序算法之间的比较。在学习具体的排序算法实现之前，我们先讨论几个对于所有排序算法都很重要的问题。
            Example类展示的是数组排序实现的框架。对于我们学习的每种排序算法，我们都会为这样的一个类实现一个sort()方法并将Example改为算法的名称。测试用力会将标准输入得到的字符串排序，但是这段代码使我们的排序
            方法适用于任意实现了Comparable接口的数据类型。
            2.1.1.1 验证
                无论数组的初始状态是什么，排序算法都能成功吗？谨慎起见，我们会在测试代码中添加一条语句assert isSorted(a)；来确认排序后数组元素都是有序的。尽管一般都会测试代码并从数学上证明算法的正确性，
                但在实现每个排序算法时加上这条语句仍然是必要的。需要注意的是，如果我们只使用exch()来交换数组的元素，这个测试足够了。当我们直接将值存入数组中时，这条语句无法提供足够的保证。
            2.1.1.2 运行时间
                我们还要评估算法的性能。首先，要计算各个排序算法在不同的随机输入下的基本操作的次数（包括比较和交换，或是读写数组的次数）。然后，我们用这些数据来估计计算法的相对性能并介绍在实验中
                验证这些猜想所使用的工具。对于大多数实现，代码风格一致会使我们更容易做出对性能的合理猜想。
                {排序成本模型} 在研究排序算法时，我们需要计算比较和交换的数量。对于不交换元素的算法，我们会计算访问数组的次数。
            2.1.1.3 额外的内存使用
                排序算法的额外内存开销和运行时间是同等重要的。排序算法可以分为两类：除了函数调用所需的栈和固定数目的实例变量之外无需额外内存的原地排序算法，以及需要额外内存空间来存储另一份数组副本的其他排序算法。
            2.1.1.4 数据类型
                我们的排序算法模板适用于任何实现了Comparable接口的数据类型。Java的封装数字类型Integer和Double，以及String和其他许多高级数据类型都实现了Comparable接口。因此你可以直接用这些类型的数组作为
                参数调用我们的排序方法。
                在创建自己的数据类型时，我们只要实现Comparable接口就能够保证用例代码可以将其排序。要做到这一点，只需要实现一个compareTo()方法来定义目标类型对象的自然次序。
                对于v<w,v=w,v>w三种情况，Java的习惯是在v.compareTo(w)被调用时分别返回一个负整数、零和一个正整数（一般是-1、0、+1）。一般来说，如果v和w无法比较或者两者之一为null，v.comparaTo(w)将会抛出一个
                异常。此外，comparaTo()必须实现一个全序关系，即：
                    （1）自反性，对于所有的v,有v=v;
                    （2）反对称性，对于所有的v<w都有w>v，且v=w时w=v
                    （3）传递性：对于所有的v、w和x，如果v<=w且w<=x,则v<=x
                从数学上这些规律都很自然和标准，遵守他们应该不难。总之，compareTo()实现了我们的主键抽象---他给出了实现了Comparable接口的任意数组类型的对象大小顺序的定义。需要注意的是compareTo()方法不一定会用到进行
                比较的实例的所有实例变量，毕竟数组元素的主键很可能只是每个元素的一小部分。
        2.1.2 选择排序
            一种最简单的排序算法是这样的：首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素
            交换位置。如此往复，直到将整个数组排序。这种方法叫做选择排序，因为他在不断地选择剩余元素中最小者。
            见类【Selection】
            {命题A}对于长度为N的数据，选择排序需要大约(N^2)/2次比较和N次交换
            {证明}可以通过算法的排序轨迹来证明这一点。
            总的来说，选择排序是一种很容易理解和实现的简单排序算法，他有两个很鲜明的特点：
            运行时间和输入无关，为了找出最小的元素而扫描一边数组并不能为下一遍扫描提供什么信息。这种性质在某些情况下是缺点，因为一个已经有序的数组或是主键全部相等的数组和一个元素随机排列的数组所用的
            排序时间是相同的。我们会看到，其他算法会更善于利用输入的初始状态。
            数据移动是最少的。每次交换都会改变两个数组元素的值，因此选择排序用了N次交换---交换次数和数组大小是线性相关的。我们将研究的其他任何算法都不具备这个特征（大部分的增长数量级都是线性对数或是平方级别）
       2.1.3 插入排序
            在计算机的实现中，为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位，这种算法叫做插入排序。
            与选择排序一样，当前索引左边的所有元素都是有序的，但它们的最终位置还不确定，为了给更小的元素腾出空间，它们可能会被移动。但是当索引到达数组的右端时，数组排序就完成了。
            和选择排序不同的是，插入排序所需的时间取决于输入中元素的初始顺序。例如，对一个很大且其中元素已经有序（或接近有序）的数组进行排序将会比对随机顺序的数组或是逆序数组进行排序要快得多。
            见类【Insertion】
            {命题B}对于随机排列的长度为N且主键不重复的数组，平均情况下插入排序需要~（N^4）/4次比较以及~（N^4）/4次交换。最坏情况下需要~（N^4）/2次比较和~（N^4）/2次交换，最好情况下需要N-1次比较和0次交换。
            对于1到N-1之间的每一个i，将a[i]与a[0]到a[i-1]中比它小的所有元素依次有序地交换，在索引i由左到右变化的过程中，它左侧的元素总是有序的，所以当i到达数组的右侧时排序就完成了。
            我们要考虑的更一般的情况是部分有序的数组。倒置指的是数组中的两个顺序颠倒的元素。如果数组中倒置的数量小于数组大小的某个倍数，那么我们说这个数组是部分有序的。
            下面是几种典型的部分有序的数组：
            （1）数组中每个元素距离它的最终位置都不远
            （2）一个有序的大数组接一个小数组
            （3）数组中只有几个元素的位置不正确
            插入排序对这样的数组很有效，而选择排序则不然。事实上，当倒置的数量很少时，插入排序很可能比本章中的其他任何算法都要快。
            {命题C}插入排序需要的交换操作和数组中导致的数量相同，需要的比较次数大于等于倒置的数量，小于等于倒置的数量加上数组的大小再减一。
            要大幅提高排序插入排序的速度并不难，只需要在内循环中将较大的元素都向右移动而不总是交换两个元素（这样访问数组的次数就能减半）。
            总的来说，插入排序对于部分有序的数组十分高效，也很适合小规模数组。这很重要，因为这些类型的数组在实际应用中经常出现，而且它们也是高级排序算法的中间过程。
       2.1.4 排序算法的可视化
       2.1.5 比较两种排序算法
            现在我们已经实现了两种排序算法，我们很自然地想知道选择排序和插入排序哪种更快。
            我们将通过以下步骤来比较两种算法：
            （1）实现并调试它们
            （2）分析他们的基本性质
            （3）对他们的相对性能做出猜想
            （4）用实验验证我们的猜想
            现在，算法2.1和2.2表示已经完成了第一步，命题A、B和C组成了第二步，下面的性质D将是第三步，之后“比较两种排序算法”的SortCompare类将会完成第四步。这些行为都是紧密相关的。
            通过命题A、B、C我们得知：对于随机排序数组，两者运行时间都是平方级别的。也就是说，在这种输入下插入排序的运行时间和N^2乘以一个小常数成正比，选择排序的运行时间和N^2乘以另一个小常数成比例。
            这两个常数的值取决于所使用的计算机中比较和交换元素的成本。对于许多数据类型和一般的计算机，可以假设这些成本是相近的（但我们也会看到一些大不相同的例外）。因此，我们直接得出了以下猜想。
            {性质D}对于随机排序的无重复主键的数组，插入排序和选择排序的运行时间是平方级别的，两者之比应该是一个较小的常数。
            {例证}插入排序比选择排序快一倍。
            为了证明这一点，我们用SortCompare来做几次实验。我们使用StopWatch来计时
            随机数组的输入模型由SortCompare类中的timeRandomInput（）来实现。这个方法会生成随机的Double值，将他们排序，并返回指定次测试的总时间。
            见类【SortCompare】
            对于实际应用，还有一个很重要的步骤，那就是用实际数据在实验中验证我们的猜想。尽管有比基础排序算法快得多的算法，但仍然有必要学习这些算法，因为：
            （1）他们帮助我们建立了一些基本的规则
            （2）它们展示了一些性能基础
            （3）使某些特殊情况下他们也是很快的选择
            （4）他们是开发更强大的算法的基石
       2.1.6 希尔排序
            对于大规模乱序数组插入排序很慢，因为他只会交换相邻的元素，因此元素只能一点一点的从数组的一端到另一端。如果主键最小的元素正好位于数组的末尾，让他从尽头移动到首端，则需要
            N-1次移动。
            希尔排序为了加快速度简单的改进了插入排序，交换不相邻的元素以对数组的局部进行排序，并最终用输入排序将局部有序的数组排序。
            希尔排序的思想是使数组中任意间隔为h的元素都是有序的。这样的数组被称为h有序数组。换句话说，一个h有序数组就是h个互相独立的有序数组编织在一起组成的一个数组。
            在进行排序时，如果h很大，我们就能将元素移动到很远的位置，为实现更小的h有序创造方便。用这种方式，对于任意以1结尾的h序列，我们都能够将数组排序。这就是希尔排序。
            算法2.3的实现使用了序列1/2（3^k-1），从N/3开始递减至1。我们把这个序列称为递增序列。算法2.3实时计算了它的递增数列，另一种方法是将递增序列储存在一个数组中。
            实现希尔排序的一个方法是对于每个h，用插入排序将h个子数组独立地排序，但因为子数组都是相互独立的，一个更简单的方法是在h-子数组中将每个元素交换到比它大的元素之前去（将比它大的元素向右移动一格）。
            只需在插入排序的代码中将移动元素的距离由1改为h即可。这样，希尔排序的实现就转化成了一个类似于插入排序但使用不同增量的过程。
            希尔排序更为高效的原因是它权衡了子数组的规模和有序性。排序之初，各个子数组都很短，排序之后子数组是部分有序的。这两种情况都很适合插入排序。子数组部分有序的程度取决于递增序列的选择。
            和选择排序以及插入排序形成对比的是，希尔排序也可以用于大型数组。他对任意排序（不一定是随机的）的数组表现也很好。实际上，对于一个给定的递增序列，构造一个使希尔排序运行缓慢的数组并不容易。
            我们发现shell排序能够解决一些初级排序算法无能为力的问题。这个例子是我们第一次用实际应用说明一个贯穿本书的重要理念：
            {通过提升速度来解决其他方式无法解决的问题是研究算法的设计和性能的主要原因之一}
            shell算法的重要结论是它的运行时间达不到平方级别。
            {性质E}使用递增序列1、4、13、的希尔排序所需的比较次数不会超出N的若干倍乘以递增序列的长度
            对于中等大小的数组它的运行时间是可以接受的。它的代码量很小，并且不需要额外的内存空间。如果需要解决一个排序问题而又没有系统排序函数可用，可以先用希尔排序，然后再考虑是否值得将他替换为更加
            复杂的排序算法。






     */
}