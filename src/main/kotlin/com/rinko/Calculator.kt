package com.rinko

// 计算器
fun main(args: Array<String>) {
    run {
        while (true) {
            println("请输入算式例如：3+4")
            val input = readLine()!!//00.00  + 00.00
            val regex = "\\s*(-?\\d+)\\s*([\\+|-|\\*|/|%])\\s*(-?\\d)\\s*".toRegex()
            val regex2 = """\s*(-?\d+)\s*([\+|-|\*|/|%])\s*(-?\d)\s*""".toRegex()
            val replace = input.replace(regex2, "$1 $2 $3").trim()
            val arr = replace.split(" ")
            try {
                val left: Double = arr[0].toDouble()
                val op = arr[1]
                val right: Double = arr[2].toDouble()
                val result = Operator(op)(left, right)
                println("$left $op $right = $result")
            } catch (e: NumberFormatException) {
                println("请检查格式是否正确")
            } catch (e: IndexOutOfBoundsException) {
                println("请依次输入数字、运算符、数字")
            }

            while (true) {
                print("再来一次?[Y/N]")
                val cmd = readLine()!!
                if (cmd.toLowerCase() == "y") {
                    break
                }
                if (cmd.toLowerCase() == "n") {
                    return@run
                }
            }

        }
    }
    println("感谢您的使用！")
}

class Operator(op: String) {

    private val opFun: ((l: Double, r: Double) -> Double)?

    init {
        opFun = when (op) {
            "+" -> { l, r -> l + r }
            "-" -> { l, r -> l - r }
            "*" -> { l, r -> l * r }
            "/" -> { l, r -> l / r }
            "%" -> { l, r -> l % r }
            else -> throw UnsupportedOperationException("不支持的运算")
        }
    }

    operator fun invoke(left: Double, right: Double): Double {
        return opFun!!(left, right)
    }
}