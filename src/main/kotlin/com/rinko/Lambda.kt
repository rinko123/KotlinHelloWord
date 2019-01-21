package com.rinko

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

val sum3 = { a: Int, b: Int -> a + b }

val sum33 = { a: Int, b: Int ->
    println("可以写别的代码")
    a + b
}

val printHello = { println("Hello") }


fun main(args: Array<String>) {
    println(sum3(2, 3)) //Lambda 变量调用
    println(sum3.invoke(2, 3))  //相当于invoke
    val arr = intArrayOf(0, 1, 2, 3)
    for (i in arr) {
        print(i)
    }

    arr.forEach({ it -> print(it) })    ////如果方法最后一个参数是个Lambda表达式可以把表达式移到小括号外
    arr.forEach() { it -> print(it) }   //小括号没参数可删掉
    arr.forEach { it -> print(it) }     //传入的参数如果只有一个可以默认不写 使用it
    arr.forEach { print(it) }
    //print(message: Int): Unit{}  方法类型即  (Int) -> Unit
    //forEach接收的参数类型   action: (T) -> Unit  T是Any类型子类
    //print方法的类型和action完全一致则有以下写法
    arr.forEach(::print)

    println()
    println(funcB(::funcA)) //开始funcAfuncB结束
    println(funcB(lambdaA))   //lambdaA开始funcB结束
    println(lambdaB(::funcA)) //开始funcAlambdaB结束
    println(lambdaB(lambdaA))   //lambdaA开始lambdaB结束

    run myBreak@{
        arr.forEach myContinue@{
            if (it == 1) {
                println("continue")
                return@myContinue
            }
            if (it == 2) {
                println("break")
                return@myBreak
            }
            println(it)
        }
    }


}

fun funcA(string: String) = "开始funcA$string"
fun funcB(action: (String) -> String) = "${action("funcB")}结束"
val lambdaA = { string: String -> "lambdaA开始$string" }
val lambdaB = { action: (String) -> String -> "${action("lambdaB")}结束" }
