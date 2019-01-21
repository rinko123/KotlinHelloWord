package com.rinko

//高阶函数

class Hello {
    fun somebody(name: String): String {
        return "Hello $name !"
    }
}

class MyPrinter {
    fun println(message: Any?) {
        kotlin.io.println(message)
    }
}


fun main(args: Array<String>) {
    val hello = Hello()
    (Hello::somebody)(hello, "阿佐")
    hello.somebody("阿佐")

    println("".isNotEmpty())
    println((String::isNotEmpty)(""))

    val arr = arrayOf("", "阿佐1", "", "阿佐2", "", "阿佐3")

    arr.map(hello::somebody) // 实例对象::方法
            .filter(String::b)   // 类名::方法
            .forEach(::c)        // 包级函数

    //fun String.b():Boolean
    // filter 需要 predicate: (T) -> Boolean 的方法
    //fun b2(string: String):Boolean
    arr.map(hello::somebody).filter(::b2).forEach(::c)

}
//
//operator fun String.times(string: String):String{
//    return "$this * $string"
//}
//
//fun String.a(string: String):String{
//    return "$this * $string"
//}

fun String.b(): Boolean {
    return this.isNotEmpty()
}

fun b2(string: String): Boolean {
    return string.isNotEmpty()
}

fun c(string: String) {
    println("$string c")
}