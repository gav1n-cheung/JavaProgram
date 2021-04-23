package com.demo3.demo2;

/**
 * @author Cheung
 * @date 2021/4/23 8:01
 * 二叉树查找
 */
public class Note3_2 {
    /*在本节中我们将学习一种能够将链表插入的灵活性和有序数组查找的高效性结合起来的符号表实现。
    具体来说，就是使用每个结点含有两个链接（链表中每个结点只含有一个链接）的二叉查找树来实现高效地实现符号表。
    首先，我们需要定义一些术语。我们所使用的数据结构由结点组成，结点包含的链接可以为空（null）或者指向其他结点。在二叉树中，每个结点只能有一个父结点（只有一个例外，也就是根节点，他是没有父结点的），
    而且每个结点都只有左右两个链接，分别指向自己的左子节点和右子节点。尽管链接指向的是结点，但我们可以将每个链接看作指向了另一颗二叉树，而这棵树的根节点就是被指向的结点。因此我们可将二叉树定义为一个
    空链接，或者是一个有左右两个链接的结点，每个链接都指向一棵（独立的）子二叉树。在二叉查找树中，每个结点还包含了一个键和一个值，键之间也有顺序之分来支持高效的查找。
    {定义：二叉查找树}一棵二叉查找树（BST）是一颗二叉树，其中每个结点都含有一个Comparable的键（以及相关联的值）且每个结点的键都大于其左子树中的任意结点的键而小于右子树的任意结点的键。
    我们在画出二叉查找树时会将键写在结点上。我们使用“A是E的左子结点”的说法用键指代结点。我们用连接结点的线表示链接，并将键对应的值写在结点旁边（若值不确定则省略）。除了空结点只表示为向下的一条线段
    以外，每个结点的链接都指向它下方的结点。
    3.2.1 基本实现
        3.2.1.1 数据表示
            和链表一样，我们嵌套定义了一个私有类表示二叉查找树上的一个结点。每个结点都含有一个键、一个值、一条左链接、一条右链接和一个结点计数器。左链接指向一棵由小于该结点的所有键组成的二叉查找
            树，右链接指向一棵由大于该结点的所有键组成的二叉查找树。变量N给出了以该结点为根的子树的结点总数。你将会看到，它简化了许多有序符号表的操作的实现。实现的私有方法size()会将空链接的值当作
            0，这样我们就能保证以下公式对于二叉树中的任意结点x都成立
            size(x)=size(x.left)+size(x.right)+1
            一棵二叉查找树代表了一组键（及其相应的值）的集合，而同一个集合可以用多棵不同的二叉查找树表示。如果我们将一棵二叉查找树的所有键投影到一条直线上，保证一个结点的左子树中的键出现在它的左边，
            右子树中的键出现在它的右边，那么我们一定可以得到一条有序的键列。我们会利用二叉查找树的这种天生的灵活性，用多棵二叉查找树表示同一组有序的键来实现构建和使用二叉查找树的高效算法。
       3.2.1.2 查找
            一般来说，在符号表中查找一个键可能得到两个结果。如果含有该键的结点存在于表中，我们的查找就命中了，然后返回相应的值。否则查找未命中（返回null）。根据数据表示的递归结构我们马上就能得到，
            在二叉查找树中查找一个键的递归算法；如果树是空的，则查找未命中；如果被查找的键和根结点的键相等，查找命中，否则我们就（递归地）在适当的子树中继续查找。如果被查找的键就选择左子树，否则就
            选择右子树。get()方法完全实现了这段算法。它的第一个参数是一个结点（子树的根结点），第二个参数是被查找的键。代码会保证只有该结点所表示的子树才会含有和被查找的键相等的结点。和二分查找
            中每次迭代之后查找的区间就会减半一样，在二叉查找树中，随着我们不断向下查找，当前结点所代表的子树的大小也在减小（理想情况下是减半，但至少会有一个结点）。当找到一个含有被查找的键的结点
            （命中）或者当前子树变为空（未命中）时这个过程才会结束。从根节点开始，在每个结点中查找的进程都会递归地在它的一个子结点上展开，因此一次查找就定义了树的一条路径。对于命中的查找，路径在含有
            被查找的键的结点处结束。对于未命中的查找，路径的终点是一个空链接。
            见类【BST】
            这段代码用二叉查找树实现了有序符号表的API，树由Node对象组成，每个对象都含有一对键值、两条链接和一个结点计数器N。每个Node对象都是一棵含有N个结点的子树的根结点，它的左链接指向一棵由小于
            该结点的所有键组成的二叉查找树，右链接指向一棵由大于该结点的所有键组成的二叉查找树。root变量指向二叉树查找树的根节点Node对象（这棵树包含了符号表中的所有键值对）。
      3.2.1.3 插入
            类【BST】中的查找代码几乎和二分查找的一样简单，这种简洁性是二叉查找树的重要特性之一。而二叉查找的另一个更重要的特性是插入的实现难度和查找差不多。当查找一个不存在于树中的结点并结束于一条
            空链接时，我们需要做的就是将链接指向一个含有被查找的键的新结点。
            算法中递归地put()方法的实现逻辑和递归查找很相似：如果树是空的，就返回一个含有该键值对的新结点；如果被查找的键小于根节点的键，我们会继续在左子树中插入该键，否则在右子树中插入该键。
      3.2.1.4 递归
            可以将递归调用前的代码想象成沿着树向下走：它会将给定的键和每个结点的键相比较并根据结果向左或者向右移动到下一个结点。
            然后可以将递归调用后的代码想象成沿着树向上爬。对于get()方法，这对应着一系列的返回指令（return），但是对于put()方法，这意味着重置搜索路径上每个父结点指向子结点的链接，并增加路径上每个
            节点中的计数器的值。在一棵简单的二叉查找树中，唯一的新链接就是在最底层指向新结点的链接，重置更上层的链接可以通过比较语句来避免。同样，我们只需要将路径上每个结点中的计数器的值加1，但我们
            使用了更通用的代码，使之等于结点的所有子结点的计数器之和加1.












     */




}
