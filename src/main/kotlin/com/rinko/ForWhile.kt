package com.rinko

fun main(args: Array<String>) {

    val arr = intArrayOf(1, 2, 3, 4)
    for ((i, v) in arr.withIndex()) {
        println("i=$i + v=$v")  //i=0 + v=1
    }
    for (iv in arr.withIndex()) {
        println(iv) //IndexedValue(index=0, value=1)
        println("i=${iv.index} + v=${iv.value}")  //i=0 + v=1
    }
    for ((i, v) in arr.withIndex()) {
        if (i == 0) continue
        if (v == 4) break
        print("i=$i + v=$v ")  //i=1 + v=2 i=2 + v=3
    }
    println()

    funVararg(*arr,string = "hello")
    funVararg(*arr)

}

fun funVararg(vararg i: Int, string: String = "default") {
    i.forEach(::println)
    println(string)
}