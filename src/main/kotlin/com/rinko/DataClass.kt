package com.rinko

data class DataClass(val id:Int,val name: String)

class DClass(val id:Int,val name: String)

fun main(args: Array<String>) {
    val china = DataClass(0, "China")
    val japan = DClass(1, "Japan")
    println(china)
    println(japan)
    println(china.component1())
    println(china.component2())
    val (id,name) = china
    println(id)
    println(name)
}