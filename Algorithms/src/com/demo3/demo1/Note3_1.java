package com.demo3.demo1;

/**
 * @author Cheung
 * @date 2021/4/16 10:04
 * 符号表
 */
public class Note3_1 {
    /*
    符号表
    我们会使用符号表这个词来描述一张抽象的表格，我们会将信息（值）存储在其中，然后按照指定的键来搜索并获取这些信息。键和值的具体意义取决于不同的应用。符号表中可能会保存很多键和很多信息，因此实现一张高效的符号表也是
    一项很有挑战性的任务。符号表有时被称为字典，在英语中，键就是单词，值就是单词对应的定义、发音和词源。符号表有时又叫做索引，即书本最后将术语按照字母顺序列出以方便查找的那部分。在一本书得索引中，键就是术语，而值就是在书中该术语出现得所有页码。
    我们会学习三种经典得数据类型来实现高效得符号表：二叉查找树、红黑树和散列表。
    3.1 符号表
        符号表最主要的目的就是将一个键和一个值联系起来。用例能够将一个键值对插入符号表并希望在之后能够从符号表的所有键值对中按照键直接找到相对应的值。本章会讲解多种构造这样的数据结构的方法，他们不光能够高效地插入和查找，还可以
        进行其他几种方便的操作。要实现符号表，我们首先要定义其背后的数据结构，并指明创建并操作这种数据结构以实现插入、查找等操作所需的算法。
        查找在大多数应用程序中都至关重要，许多编程环境也因此将符号表实现为高级的抽象数据结构，包括Java。
        {定义}符号表是一种存储键值对的数据结构，支持两种操作：插入（put），即将一组新的键值对存入表中；查找（get），即根据给定的键得到相应的值。
       3.1.1 API
            符号表是一种典型的抽象数据类型：它代表着一组定义清晰的值以及相应的操作，使得我们能够将类型的实现和使用区分开来。和以前一样，我们要用应用程序编程接口来精确地定义这些操作。
            为了保证代码的一致、简洁和实用，我们要先说明具体实现中的几个设计决策。
         3.1.1.1 泛型
                和排序一样，在设计方法时我们没有指定处理对象的类型，而是使用了泛型。对于符号表，我们通过明确地指定查找时键和值的类型来区分它们不同的角色，而非像优先队列一样将键和元素本身混为一谈。
         3.1.1.2 重复的键
                我们的所有实现都遵循以下规则：
                （1）每个键都只对应着一个值（表中不允许重复的键）
                （2）当用例代码向表中存入的键值对和表中已有的键（及关联的值）冲突时，新的值会替代旧的值。
                这些规则定义了关联数组的抽象形式。你可以将符号表想象成一个数组，键即数组的索引，值即数组的元素。在一个一般的数组中，键就是整型的索引，我们用它来快速访问数组的内容；在一个关联数组
                （符号表）中，键可以是任意类型，但我们仍然可以用它来快速访问数组的内容。
         3.1.1.3 空（null）键
                键不能为空，使用空键会产生一个运行异常。
         3.1.1.4 空（null）值
                我们还规定不能有空值。这个规定的原因是在我们的API定义中，当键不存在时get()方法会返回空，这也意味着任何不在表中的键关联的值都是空。这个规定产生了两个结果：
                （1）我们可以用get()方法是否返回空来测试给定的键是否存在于符号表中；第二，我们可以将空值作为put()方法的第二个参数存入表中来实现删除。
         3.1.1.5 删除操作
                在操作表中，删除的实现可以有两种方法：
                （1）延时删除：也就是将键对应的值置为空，然后在某个时候删去所有的值为空的值；
                （2）即时删除：也就是立即从表中删除指定的键。
                put(key,null)是delete(key)的一种简单的（延时型）实现。而实现(即时型)delete()就是为了替代这种默认的方案。在我们的符号表中不会使用默认的方案，而在本书的网站上put()实现的开头有
                if(val==null) {delete(key);return;}
                这保证了符号表任何键都不为空。
         3.1.1.6 便捷方法
         3.1.1.7 迭代
                为了方便用例处理表中的所有键值，我们有时会在API的第一行加上implements Iterable<Key>这句话，强制所有实现都必须包含iterator()方法来返回一个实现了hasNext()和next()方法的迭代器。
                但是对于符号表我们采用了一个更简单的方法。我们定义了keys()方法来返回一个Iterable<Key>对象来方便用例遍历所有的键。这么做时为了和以后的有序符号表的所有方法保持一致，使得用例可以遍历
                表的键集的一个指定的部分。
         3.1.1.8 键的等价性
                要确定一个给定的键是否存在于符号表中，首先要确立对象等价性的概念。在Java中，按照约定所有的对象都继承了一个equals()方法，Java也为它的标准数据类型和一些更为复杂的类型实现了
                equals()方法--当使用这些数据类型时你可以直接使用内置的实现。
      3.1.2 有序符号表
            典型的应用程序中，键都是Comparable的对象，因此可以使用a.compareTo(b)来比较a和b两个键。许多符号表的实现都利用了Comparable接口带来的键的有序性来更好的实现put()和get()方法。更重要的是在这些实现中，我们可以认为
            符号表都会保持键的有序并大大扩展它的API，根据键的相对位置定义更多实用的操作。
         3.1.2.1 最大值和最小值
            对于一组有序的键，最自然的反应就是查询其中的最大值和最小值。符号表和优先队列区别在于优先队列中可以存在重复的键但符号表不行，而且有序符号表支持的操作更多。
         3.1.2.2 向下取整和向上取整
            对于给定的键，向下取整（floor）操作（找出小于等于该键的最大键）和向上取整（ceiling）操作（找出大于等于该键的最小键）有时是很有用的。这两个术语来自于实数的取整函数。
            （对一个实数x向下取整即为小于等于x的最大整数，向上取整则为大于等于x的最小整数）
         3.1.2.3 排名和选择
            检验一个新的键是否插入合适位置的基本操作是排名(rank,找出小于指定的键的数量)和选择(select，找出排名为k的键)
         3.1.2.4 范围查找
            给定范围内（有两个给定的键之间）键的数量、内容、可以使用接受两个参数的size()和keys()方法。
         3.1.2.5 例外情况
            当一个方法需要返回一个键但表中却没有合适的键可以返回时，我们约定抛出一个异常（另一种合理的方法是在这种情况下返回空）。
         3.1.2.6 便捷方法
         3.1.2.7 （再谈）键的等价性
            Java的一条最佳实践就是维护所有Comparable类型中compareTo()方法和equals()方法的一致性。也就是说，任何一种Comparable类型的两个值a和b都要保证(a.compareTo(b)==0)和a.equals()方法。
            作为替代，我们只会使用compareTo()方法来比较两个键,即我们用布尔表达式a.comparaTo(b)==0来表示a和b相等吗？一般来说，这样的比较都代表着在符号表中的一次成功查找(找到了b)。
         3.1.2.8 成本模型
            无论我们是使用equals()方法还是使用compareTo()方法，我们使用比较一词来表示将一个符号表条目和一个被查找的键进行比较操作。在大多数的符号表实现中，这个操作都出现在内循环中。
            在少数的例外中，我们则会统计数组的访问次数。
            {查找的成本模型}在学习符号表的实现中，我们会统计比较的次数（等价性测试或是键的相互比较）。在内循环不进行比较（极少）的情况下，我们会统计数组的访问次数。
    3.1.3 用例举例
        3.1.3.1 行为测试用例
         见类【symbolTableTest1】
        3.1.3.2 性能测试用例
         见类【FrequencyCounter】
        FrequencyCounter是一种极为常见的应用的代表，它的这些特性也是许多其他符号应用的共性：
        （1）混合使用查找和插入的操作
        （2）大量的不同键
        （3）查找操作比插入操作多得多
        （4）虽然不可预测，但查找操作和插入操作的使用模式并非随机
    3.1.4 无需链表中的顺序查找
        符号表中使用的数据结构的一个简单选择是链表，每个结点存储一个键值对。get()的实现即为遍历列表，用equals()方法比较需要被查找的键和每个结点中的键。如果匹配成功我们就返回相应的值，否则我们返回null.
        put()的实现也是遍历链表，用equals()方法比较需被查找的键和每个结点中的键。如果匹配成功我们就用第二个参数指定的值更新和该键相关联的值，否则我们就用给定的键值对创建一个新的结点并将其插入到链表的开头。
        这种方法也被称为顺序查找：在查找中我们一个一个顺序遍历符号表中的所有键并使用equals()方法来寻找与被查找的键匹配的键。
        见类【SequentialSearchST】
        符号表的实现使用了一个私有内部Node类来在链表中保存键和值。get()的实现会顺序地搜索链表查找给定的键（找到则返回相关联的值）。put()的实现也会顺序地搜索链表查找给定的键，如果找到则更新相关联的值，否则它会用给定
        的键值对创建一个新的结点并将其插入到链表的开头。
        {命题A}在含有N对键值对的基于（无序）链表的符号表中，未命中的查找和插入操作都需要N次比较。命中的查找在最坏的情况下需要N次比较。特别地，想一个空表中插入N个不同的键需要进行~(N^2)/2次比较。
   3.1.5 有序数组中的二分查找
        见类【BinarySearchST】,它使用的数据结构是一对平行的数组，一个存储键一个储存值。
        这份实现的核心是rank()方法，它返回表中小于给定键的值的数量。对于get()方法，只要给定的键存在于表中，rank()方法就能够精确地告诉我们在哪里能够找到它；
        对于put()方法，只要给定的键存在于表中，rank()方法就能够精确地告诉我们到哪里去更新它的值，以及当键不在表中时将键存储到表的何处。我们将所有更大的键向后移动一格来腾出位置（从后向前移动）并将给定的
        键值对分别插入到各自数组中的合适位置。
        类【BinarySearchST】符号表的实现用两个数组来保存键和值。put()方法会再插入新元素前将所有较大的值向后移动一格。
   3.1.5.1 二分查找
        我们使用有序数组存储键，是因为我们会使用有序索引数组来标识被查找的键可能存在的子数组的大小范围。在查找时，我们先将被查找的键和子数组的中间键相比较。
        如果被查找的键小于中间键，我们就在左子数组中继续查找，如果大于我们就在右子数组中继续查找，否则中间键就是我们要找的键。

















     */
}
