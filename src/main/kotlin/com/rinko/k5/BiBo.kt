package com.rinko.k5


//闭包

fun myFun(): () -> Unit {
    var count = 0
    return fun() {
        println(++count)
    }
}
fun main(args: Array<String>) {
    val x = myFun()
    x()
    x()
    x()
    x()
    x()
    // 打印 1 2 3 4 5
    val y = myFun3()
    println(y(1))
    println(y(1))
    println(y(1))
    println(y(1))
    println(y(1))
    // 打印 1=1 1=2 1=3 1=4 1=5

    val z = myFun()
    z()
    x()// 1 6
}

fun myFun2(): () -> Unit {
    var count = 0
    val a = fun() { println(++count) }
    val b = { println(++count) }
    val c = { -> println(++count) } //() -> Unit
    return c
}

fun myFun3(): (Int) -> String {
    var count = 0
    val a = fun(int: Int): String { return "$int=${++count}" }
    val b = { int: Int -> "$int....${++count} " }
    val c = { _: Int -> "=${++count} " }    //(Int) -> String
    return b
}