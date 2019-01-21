package com.rinko

//枚举
enum class LogLevel(private val id:Int) {

    VERBOSE(1),DEBUG(2),INFO(3),WARN(4),ERROR(5),ASSERT(6);

    // 打印id和名称
    fun getTag():String{
        return "id:$id name $name"
    }

    // 打印下标和名称
    override fun toString(): String {
        println("super ${super.toString()}")
        return "ordinal $ordinal name $name"
    }
}

fun main(args: Array<String>) {
    //这俩效果相同
    LogLevel.values().forEach(::println)
    LogLevel.values().map(::println)

    LogLevel.values().forEach { println(it.getTag())}

    println(LogLevel.valueOf("DEBUG"))
}