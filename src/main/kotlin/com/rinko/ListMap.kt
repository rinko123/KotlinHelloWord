package com.rinko

class ListMap {

}

fun main(args: Array<String>) {
    val intRangeArr = listOf(1..5, 2..6, 3..7)
    val list1 = listOf("1", "2", "3")
    val list2 = listOf("2", "3", "4")
    val list3 = listOf("3", "4", "5")
    val list = listOf(list1, list2, list3)
    val lists = listOf(list, list)

//    val flatMap = intRangeArr.flatMap { it } // 其实就是这个
    val flatMap = intRangeArr.flatten()
    val flatMap2 = lists.flatten()
    val flatMap3 = flatMap2.flatten()
    println(flatMap.size)   //15
    println(flatMap2.size)  //6
    println(flatMap3.size)  //18

    val flatMap4 = intRangeArr.flatMap {
        it.map {
            "No. $it"
        }
    }
    flatMap4.forEach(::println)

    // 求和
    val ints = (1..10).toList() //可转可不转
    val reduce = ints.reduce { acc, int -> acc + int } // 累加和 迭代值
    println(reduce) // 55

    //阶乘 n!=1×2×3×...×n
    println(factorial(4))   // 24
    println(factorial2(4))   // 120

    //对象列表过滤 返回对象列表
    println((1..10).filter { it % 2 == 0 }) //[2, 4, 6, 8, 10]

    //表达式成立则一直取数据
    println((1..10).takeWhile { it != 5 })  //[1, 2, 3, 4]

    getPerson()?.let {
        println(it.id)
        println(it.name)
        it.work()
    }
    val name = "Rinko"
    getPerson()?.apply {
        id = 2
        this.name = "Rinko"
        println(id)
        println(name)
        work()
    }


}

fun factorial(n: Int): Int {
    if (n == 0) return 1
    return (1..n).reduce { acc, i -> acc * i }  //累乘积 迭代值
}

fun factorial2(n: Int): Int {
    if (n == 0) return 1
    return (1..n).fold(5) { acc, i -> acc * i }  //初始值5开始 累乘积 迭代值
}

class Person(var id: Int, var name: String){
    fun work(){
        println("$name is working!!!")
    }
}

fun getPerson(): Person? {
    return Person(1,"rinko")
}