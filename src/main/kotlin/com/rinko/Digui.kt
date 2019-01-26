package com.rinko

class Digui {
}

data class ListNode(val value: Int, var next: ListNode? = null)

//加了这个后 将递归转变为迭代、可以减少Stack Overflow的出现

// 这个方法是 查找Node1里的Node2的value等于一个值,没找到就再找Node2的Node3
tailrec fun findListNode(head: ListNode?, value: Int): ListNode? {
    head ?: return null
    if (head.value == value) return head
    println(head)
    return findListNode(head.next, value)
}

//非伪递归加此关键字会警告jj
tailrec fun factorial(n: Long): Long {
    return n * factorial(n - 1) //调用完后 又乘了个 n 所以不是伪递归
}

fun main(args: Array<String>) {
    val MAX_NODE_COUNT = 10 //不加关键字、此时则会异常
    val head = ListNode(0)
    var p = head
    for (i in 1..MAX_NODE_COUNT) {
        p.next = ListNode(i)
        println(p)  //ListNode(value=0, next=ListNode(value=1, next=null))  ListNode(value=1, next=ListNode(value=2, next=null))
        p = p.next!!
        println(p)  //ListNode(value=1, next=null)  ListNode(value=2, next=null)
        println(head)   //ListNode(value=0, next=ListNode(value=1, next=null)) ListNode(value=0, next=ListNode(value=1, next=ListNode(value=2, next=null)))
        println()

    }
    println(findListNode(head, MAX_NODE_COUNT - 2)?.value)
}