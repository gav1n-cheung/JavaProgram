package com.demo.demo3;

/**
 * @author Cheung
 * @date 2021/3/25 8:56
 * 背包、队列和栈
 */
public class Note1_3 {
    /*
                许多基础数据类型都和对象的集合有关。具体来说，数据类型的值就是一组对象的集合，所有操作都是关于添加、删除或是访问集合中的对象。
                （1）三种这样的数据类型：背包（bag），队列（Queue）和栈（Stack）。三者的不同之处在于删除或者访问对象的顺序不同。
                背包、队列和栈类型都非常基础并且应用广泛。
                （2）泛型和迭代。他们都是简单的Java概念，但能极大地简化用例代码。它们是高级编程语言机制，使用这些机制能够写出更清晰、简介和优美的用例代码。
                （3）介绍并说明链式数据结构的重要性，特别是典型数据结构链表。有了它我们才能高效的实现背包、队列和栈。

        1.3.1 API
            每份API都含有一个无参数的构造函数、一个向集合中添加单个元素的方法、一个测试集合是否为空的方法和一个返回集合大小的方法。
            Stack和Queue都含有一个能够删除集合中的特定元素的方法。这几份API反映出两种Java特性：泛型和迭代。
        1.3.1.1 泛型
            集合类的抽象数据类型的一个关键特性是我们应该可以用它们存储任意类型的数据。一种特别的Java机制能够做到这一点，被称为泛型，也可以叫做参数化类型。
            在每份API中，类名后的<Item>记号将Item定义为一个类型参数，一个象征性的占位符，表示的是用例将会使用的某种具体数据类型。
            可以将Stack<Item>理解为某种元素的栈。在实现Stack时，我们并不知道Item的具体类型，但用例可以用我们的栈处理任意类型的数据，甚至是在我们的实现之后才出现的数据类型。
            在创建栈时，用例会提供一种具体的数据类型：我们可以将Item替换为任意引用数据类型（Item出现的每个地方都是如此）。这种能力正是我们所要的。
            例如，可以用一下代码来用栈处理String对象。见类【StackTest】
            再例如：用队列来处理Date对象。见类【QueueTest】
            如果尝试向stack变量中添加一个非String变量，或是向queue变量添加一个非Date变量，会得到一个编译错误。
            如果没有泛型，我们就必须为需要收集的每种数据类型定义不同的API，而有了泛型后，我们只需要一份API就能够处理所有类型的数据，
            甚至是未来定义的数据类型。
       1.3.1.2 自动装箱
            类型参数必须被实例化为引用类型，因此Java有一种特殊的机制来使泛型代码能够处理原始数据类型。
            在处理赋值语句、方法的参数和算术或逻辑表达式时，Java会自动在引用类型和对应的原始数据类型之间进行转换。
            见类【StackTest】automaticBoxing方法
       1.3.1.3 可迭代的集合类型
            对于许多用例，用例的要求只是用某种方式处理集合中的每个元素，或者叫做迭代访问集合中的所有元素，这种模式非常重要，在Java和其他许多语言中他都是一级语言特性
            （不只是库，编程语言中本身就含有特殊的机制来支持他）。
            见类【QueueTest】中transactionCollection方法
            Stack和Queue的API的唯一不同之处只有他们的名称和方法名。这使我们认识到无法简单地通过一列方法的签名说明一个数据类型的所有特点
       1.3.1.4 背包
            背包是一种不支持从中删除元素的集合数据类型--它的目的就是帮助用例收集元素并迭代遍历所有收集到的元素（用例也可以检查背包是否为空或者获取背包中元素的数量）
            迭代的顺序不确定并且与用例无关。
            用例也可以使用stack或是queue，但如果使用bag则说明数据顺序并不重要。
            见类【Stats】我们所做的操作不要求数据的顺序，这时候我们使用bag存储数据，再使用foreach来计算每个和（不计算每个数据也可以计算数据，这样可以节省空间，用于不需要存储数据的情况）
            用bag对象保存所有数字是更复杂的统计计算所必需的。
       1.3.1.5 先进先出
            先进先出队列（或简称为队列）是一种基于先进先出（FIFO）策略的集合类型。
            队列是许多日常现象的自然模型，也是无数应用程序的核心。
            当用例使用foreach语言迭代访问队列中的元素时，元素的处理顺序就是它们被添加到队列中的顺序。在应用程序中使用队列的主要原因是在用集合保存元素的同时保存他们的相对顺序：
            使他们入列和出列的顺序相同。
            readInts的实现见类【Input】readInts方法
            我们先将输入放入queue中，再利用queue的size方法来获取输入长度，创建相同长度的数组，再将queue内的数据按照顺序放入数组中，需要注意的是，进入数组的顺序和输入的顺序是相同的，
            这是queue的性质决定的，如果我们不在意数据的顺序，那也可以使用bag来处理数据。
       1.3.1.6 下压栈
            下压栈（简称栈）是一种基于后进先出（LIFO）策略的集合类型。
            当用例使用foreach语句迭代遍历栈中的元素时，元素的处理顺序和它们被压入的顺序正好相反。
            在应用程序中使用栈迭代器的一个典型原因是在用集合保存元素的同时颠倒它们的相对顺序。
            见类【Reverse】
       1.3.1.7 算术表达式求值
            我们要学习的另一个栈用例同时也是展示泛型的应用的一个经典例子。
            Java系统是如何进行运算的？
            他接受一个输入字符串（表达式）并输出表达式的值。为了简化问题，首先看一下这份明确的递归定义：
            算数表达式可能是一个数，或者是由一个左括号、一个算数表达式、一个运算符、另一个算法表达式和一个右括号组成的表达式。
            简单起见：这里定义的是未省略括号的算术表达式，他明确地说明了所有运算符的操作数--例如1+2*3的表达式，省略了括号，采用了优先级规则

            在这里，我们也会学习简单的机制来处理优先级规则，但在这里我们不想把问题复杂化。为了突出重点，我们支持最常见的二元运算符*、+、-和/，以及只接受一个参数的平方根运算符sqrt。
            当然也可以轻易支持更多数量和种类的运算符来计算多种大家熟悉的数学表达式，包括三角函数、指数/对数函数。
            但是我们的重点在于如何解析由括号、运算符和数字组成的字符串，并按照正确的顺序完成各种初级算术运算操作。
            我们使用两个栈--一个用于保存运算符，一个用于保存操作数来完成这个任务

            表达式由括号、运算符和操作数（数字）组成。我们根据以下四种情况从左到右逐个将这些实体送入栈处理：
                （1）将操作数压入操作数栈
                （2）将运算符压入运算符栈
                （3）忽略左括号
                （4）在遇到右括号时，弹出一个运算符，弹出所需要的操作数，并将运算符和操作数的运算结果压入操作数栈。
             在处理完最后一个右括号后，操作数栈上只会有一个值。它就是表达式的值。
                每当算法遇到一个被括号包围并由一个运算符和两个操作数组成的子表达式，他都将运算符和操作数的计算结果压入操作数栈。这样的结果就好像在输入中用这个值代替了该子表达式，
                因此用这个值代替子表达式得到的结果和原表达式相同。我们可以重复应用这个规律并且最终得到一个最终值，

         1.3.2 集合类数据类型的实现
            1.3.2.1 定容栈
                一种表示容量固定的字符串栈的抽象数据类型FixedCapacityStackString:他只能处理String值，要求用例指定一个容量并且不支持迭代。
                实现一份API的第一步就是选择数据的表示方式。对于FixedCapacityStackString，显然可以选择String数组。
                见类【FixedCapacityStackString】
                这样的操作方法确保了：
                （1）数组的顺序和它们被插入的顺序相同
                （2）当N==0时，栈为空
                （3）栈顶位于a[N-1](如果栈非空)
                测试用例【FixedCapacityStackStringTest】会从标准输入读取多个字符串并将它们压入一个栈，当遇到-时，它会将最近的一个输入弹出并且打印到结果。
                这种实现主要的性能特点是push和pop操作所需要的时间独立于栈的长度。
                许多应用会因为简洁性会选择这种实现。但他也存在一些确定，我们通过一些语言的机制来改进它，就能给出一个适用性更为广泛的实现。
            1.3.2.2 泛型
                {缺点}FixedCapacityStackString的一个确定是只能处理String对象。如果需要一个double的栈，你就需要用类似的代码实现另一个类，
                也就是将所有的String替换为double，这样似乎还容易解决，但如果我们需要Transaction类型的栈或Data类型的队列等，情况就很棘手了。
                Java的参数类型（泛型）就是专门来解决变量类型的，
                见类【FixedCapacityStack】
                该实现和前面的String实现相比，主要的区别就死item的使用，并且用了 public class FixedCapacityStack<Item> 声明了类
                Item是一个类型参数，用于表示用例会将使用的某种具体类型的象征性的占位符，可以将 FixedCapacityStack<Item> 理解为某种元素的栈，这也正是我们想要的
                在实现 FixedCapacityStack<Item> 时，我们并不知道Item的实际类型，但用例只要能在创建栈时提供具体的数据类型，
                他就能用栈处理任意数据类型。实际的类型必须是引用类型，但用例可以依靠自动装箱将原始数据类型转换为相应的封装类型。
                Java会使用类型参数Item来检查类型不匹配的错误--尽管具体的数据类型还不知道，赋予了Item类型变量的值也必须是Item类型的，等等。
                这里有一个细节非常重要：我们希望用以下的代码在FixedCapacityStack的构造函数的实现中创建一个泛型的数组：
                a=new Item[cap]；
                创建泛型数组在Java中是不被允许的。我们需要使用类型转换：
                a=(Item[]) new Object[cap];
                这段代码才能实现我们所期望的效果,我们在本书中会一直使用这种方式
            1.3.2.3 调整数组大小
                选择用数组表示栈内容就意味着用例必须预先估计栈的最大容量。在Java中，数组一旦被创建，长度就无法被改变，因此栈使用的空间只能是这个最大容量的一部分。
                选择大容量的用例在栈为空或几乎为空时会浪费大量的内存，也有可能集合比数组大使得用例溢出。
                为此，push()方法需要在代码中检测栈是否已经过满，我们的API中也应该含有一个isFull()方法来允许用例判断栈是否已满。
                但我们想要用例从处理栈已满的问题中解脱出来，转而修改数组的实现，动态的调整数组a[]的大小，使得它既足以保存所有元素，又不至于浪费过多的空间
                实际上，完成这个目标非常简单，
                    （1）实现一个方法将栈移动到另一个大小不同的数组中，见类【FixedCapacityStack】的resize方法
                    （2）然后在push()中，检查数组是否过小。具体来说，我们会检查栈的大小N和数组的大小a.length是否相等来检查数组是否能够容纳新的元素。
                        如果没有多余的空间，我们就将数组的长度加倍，然后就可以通过a[N++]来插入新元素了
                    （3）类似的，我们需要在pop方法中，首先删除栈顶的元素，然后如果数组太大我们就将它的长度减半。
                        而实际上，正确的检测条件应该是栈大小是否小于数组长度的四分之一，如果是数组长度的四分之一，那我们将数组长度减半，这样在操作过的数组上，、
                        我们也可以做push的操作，而不需再增减数组长度。在这个实现中，栈永远不会溢出，使用率也永远不会低于四分之一
                        （除非栈为空，这种情况下数组长度为1）
            1.3.2.4 对象游离
                Java的垃圾收集策略是回收所有无法被访问的对象的内存。在我们对pop()的实现中，被弹出的元素的引用仍然存在于数组中。
                这个元素实际上已经是一个孤儿了--他永远不会被访问了（pop操作使得栈顶-1，其实原栈顶的索引还在，但除了push操作，没有别的操作能够接触原栈顶了
                但只要执行了push操作，那原栈顶的引用就被改写了，指向了别的元素了，那原栈顶指向的元素就再也无法接触到了）,但Java的垃圾收集器没法知道这一点，
                除非该引用被覆盖。即使用例已经不再需要这个元素了，数组中的引用仍然可以让它继续存在。
                这种情况（保存一个不需要的对象的引用）称为游离，在这里，只需将弹出的元素的值设为null即可，这将覆盖无用的引用并使系统可以在用例使用完被弹出的元素
                后回收它的内存。
           1.3.2.5 迭代
                集合类数据的基本操作之一就是，能够使用Java的foreach语句通过迭代遍历并处理集合中的每个元素。这种方式的代码既清晰又简洁，并且不依赖于集合数据类型的具体实现。
                见类【Iteration】
                在Java中，我们使用接口机制来指定一个类所必须实现的方法。对于可选的数据类型，java已经为我们定义了所必需的接口。
                要是一个类可迭代，
                (1)就是在它的声明中加入implements Interable<Item>
                (2)在类中添加一个方法iterator()并返回一个迭代器Iterator<Item>.迭代器都是泛型的，因此我们可以使用参数类型Item来帮助用例遍历他们指定的任意类型的对象。
                    对于一直使用的数组表示法，我们需要逆序迭代遍历这个数组。
                见类【FixedCapacityStack】----{算法1.1 下压（LIFO）栈，能够动态调整数组大小，实现迭代输出}
                这份泛型的可迭代的Stack API的实现是所有集合类抽象数据类型实现的模板。它将所有元素保存在数组中，并且动态调整数组的大小以确保数组大小和栈大小之比小于一个常数

        1.3.3 链表
                链表是一种基础数据结构的使用，他是在集合类的抽象数据类型实现中表示数据的合适选择。这也是我们构造非Java直接支持的数据结构的第一个例子。
                我们的实现将成为本书中其他更加复杂的数据结构的构造代码的模板。
                【定义】链表是一种递归的数据结构，它或者为空（null），或是指向一个结点（node）的引用，该结点含有一个泛型的元素和一个指向另一条链表的引用。
                在这个定义中，结点是一个可能含有任意类型数据的抽象实体，它所包含的指向结点的应用显示了他在构造链表之中的作用。
            1.3.3.1 结点记录
                在面向对象的编程中，要实现链表并不困难。
                我们首先用一个嵌套类来定义结点的抽象数据类型：见类【LinkedList】内嵌类Node
                一个Node对象含有两个实例变量，类型分别为Item（参数类型）和Node。我们会在需要使用Node类的类中定义它并将其标记为private，因为他并不是为了用例准备的。
                和任意数据类型一样，我们通过new Node()触发（无参数的）构造函数来创建一个Node类型的对象。调用的结果是一个指向Node对象的引用，它的实例变量均被初始化为null。
                Item是一个占位符，表示我们希望用链表处理的任意类型数据（我们将会使用Java泛型使之表示任意引用类型）；
                Node类型的实例变量显示了这种数据结构的链式本质。为了强调我们在组织数据时只使用了Node类，我们没有定义任何方法且会在代码中直接引用实例变量：
                    如果first是一指向某个node对象的变量，我们可以使用first.item和first.next来访问它的实例变量。这种类型的类有时也被称为记录。它们实现的不是抽象数据类型，
                    因为我们会直接使用其实例变量。但是在我们的实现中，Node和它的用例代码都会被封装在相同的类中且无法被该类的用例访问，所以我们仍然能够享受数据抽象的好处。
            1.3.3.2 构造链表
                根据递归定义，我们只需要一个Node类型的变量就能表示一条链表，只要保证它的值是null或者指向另一个Node对象并且该对象的next域指向了另一条链表即可。
                这种构造见类【LinkedList】
                （1）我们首先为每个元素创造一个结点：10-12；
                （2）然后再将每个结点的item域设为所需的值17-19
                （3）然后设置next域来构造链表21-21
                需要注意的是：third.next仍然为null（third被创建时的它被初始化的值），结果是.third是一条链表（是一个结点的引用，该结点指向null，即一个空链表）
                            second也是一条链表（是一个结点的引用，并且有一个指向third的引用，而third是一条链表）,first也是一条链表（他是一个结点的引用，
                            并且该结点含有一个指向second的引用，而second是一条链表）
                链表表示的是一列元素。在我们刚刚考察过的例子中，first表示的序列是to,be,or。我们也可以用一个数组来表示一列元素，例如我们可以用
                 String[] s={"to","be","or"};
                 不同之处在于，在链表中向序列插入元素或是从序列中删除元素都更为方便。下面我们来学习完成以下任务的代码
                 为追踪使用链表和其他链式结构的代码时，我们会使用可视化表示方法：
                    @用长方形表示对象
                    @将实例变量的值写在长方形中
                    @用指向被引用对象的箭头表示引用关系
                 这种表示方法抓住了链表的关键特性。方便起见，我们用术语链接表示对结点的隐痛。简单起见，当元素的值为字符串时（如我们的例子所示），我们会将字符串写在长方形内，
                 而非使用更准确的方式表示字符串对象和字符数组。这种可视化的表示方式使我们能够将注意力集中在链表上。
           1.3.3.3 在表头插入结点
                如果我们希望在一条链表中插入一个新的结点，最容易做到的这一点的地方就是链表的开头。
                见类【LinkedList】
                我们先将first保存在oldfirst中，然后将一个新的结点赋予first，并且将它的item域设为not，next域设为oldfirst。
                这段在链表开头插入一个结点的代码只需要几行赋值语句，因此它所需的时间和链表长度无关
           1.3.3.4 从表头删除结点
                如果想要删除一条链表的首结点。只需将first指向first.next即可。一般来说你可能会希望在赋值之前得到该元素的值，因为一旦改变了first的值，
                就再也无法访问他曾经指向的结点了。这样的结点就变成了一个孤儿.Java的内存管理系统最终将回收它所占用的内存。
                这个操作只需要一条语句，与链表的长度也无关。
           1.3.3.5 从表尾插入结点
                要完成这个任务，我们需要一个指向链表的最后一个结点的链接，因为该结点的链接必须被修改并指向一个一个含有新元素的新结点。
                我们不能在链表的代码中草率地决定维护一个额外的链接，因为每个修改链表的操作都需要添加检查是否要修改该变量（以及做出相应的修改）的代码。
                例如。我们刚刚讨论过的删除链表首结点的代码就可能改变指向链表的尾结点的引用，因为当链表中只有一个结点时，它既是首结点又是尾结点。
                另外，这段代码也无法处理链表为空的情况（他会使用空链接）。类似这样的情况的细节使得链表代码特别难以调试。
           1.3.3.6 其他位置的插入和删除操作
                通过上面的实现，我们能够通过first链接来访问链表的首结点和last链接来访问链表的尾结点：
                    （1）在表头插入结点
                    （2）在表头删除结点
                    （3）在表尾插入结点
                其他操作，例如
                    （1）删除指定的结点
                    （2）在指定结点前插入一个新结点
                实现任意插入和删除操作的标准解决方案时使用双向链表，其中每个结点都含所有两个链接，分别指向不同的方向。我们的所有实现不需要双向链表。
           1.3.3.7 遍历
                要访问一个数组中的所有元素，我们会使用for来循环处理a[]中的所有元素
                访问链表中的所有元素也有一个对应的方法：将循环的索引变量x初始化为链表的首结点，然后通过x.item访问和x相关联的元素，
                并将x设为x.next来访问链表中的下一个结点。如此反复直到x为null为止（此时我们已经到达了链表的结尾）。这个过程被称为链表的遍历，可以用以下循环处理
                链表中的每个结点的代码简洁表达，其中first指向链表的首结点。
                for(Node x=fist;x!=null;x=x.next){
                }
                这种方式和迭代遍历一个数组的所有元素的标准方式一样自然。在我们的实现中，它是迭代器使用的基本方式，它使用例能够迭代访问列表中的所有元素
                并且无需知道链表的实现细节。
           1.3.3.8 栈的实现
                见类【LinkedListQueue】
           1.3.3.9 队列的实现
                见类【LinkedListStack】
                在结构化存储数据集时，链表是数组的一种重要的替代方式。在现代编程语言中，安全指针、自动垃圾回收和抽象数据类型的使用
                使得我们能够是我们能将链表处理的代码封装在若干个类中。
           1.3.3.10 背包的实现
                用链表数据结构实现我们的Bag API只需要将Stack中的push()改为add()，去掉pop()操作的实现即可。
                见类【LinkedListBag】

      1.3.4 综述
        在本节中，我们所学习的支持泛型和迭代的背包、队列和栈的实现所提供的抽象使我们能够编写简洁的用例程序来操作对象的集合。
        这是我们研究算法数据结构的开始：
            （1）我们将以这些数据类型为基石构造本书中的其他更高级的数据结构
            （2）他们展示了数据结构和算法的关系以及同时满足多个有可能相互抽个图的性能目标时所要面对的挑战
            （3）我们将要学习的若干算法的实现重点就是需要其中的抽象数据类型能够支持对象集合的强大操作，这正是我们的起点。
        数据结构
            我们现在拥有两种表示对象集合的方式，即数组和链表。Java内置了数组，链表也很容易使用Java的标准方法实现。
            两者都非常基础，常被称为顺序存储和链式存储。在本书的后面部分，我们会在各种抽象数据类型的实现中将多种方式归结并扩展这些基本的数据结构。
            其中一种重要的拓展就是各种含有多个链接的数据结构。
            另一个重要的拓展是复合型的数据结构：我们可以用背包存储栈，用队列存储数组等等。
                                                       基础数据结构
                            数组                  优点：通过索引可以直接访问任意元素       缺点：在初始化就需要知道元素的数量
                            链表                  使用的空间大小和元素数量成正比               需要通过引用访问任意元素
            我们在本节中研究的背包、队列和栈时描述数据结构和算法的方式时全书的原型。、
            在查找一个新的应用领域时，我们将会按照以下步骤识别目标并使用数据抽象解决问题：
            （1）定义API
            （2）根据特定的应用场景开发用例代码
            （3）描述一种数据解构（一组值的表示），并在API所对应的抽象数据类型的实现中根据他定义类的实例变量
            （4）描述算法（实现一组操作的方式），并根据它实现类中的实例方法
            （5）分析算法的性能特点

      答疑：为什么不实现一个类能够实现我们想要的所有操作呢/
            我们坚持窄接口的实现：（1）设计只含有几个操作的接口显然比设计含有许多操作的接口更为简单
                             （2）窄接口能够限制用例的行为，这样使得用例代码更为简洁

     */
}
