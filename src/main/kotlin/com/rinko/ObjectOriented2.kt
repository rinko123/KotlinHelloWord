package com.rinko

class SeniorManager(private val driver: Driver, private val writer: Writer) : Driver by driver, Writer by writer {
    override fun eat(): String {
        return super<Driver>.eat() + super<Writer>.eat()
    }
}

//这两种写法是一样的 以及调用某个父类的方法

class SeniorManager2(private val driver: Driver, private val writer: Writer) : Driver, Writer {
    override fun eat(): String {
        return super<Driver>.eat() + super<Writer>.eat()
    }

    override fun drive() {
        driver.drive()
    }

    override fun write() {
        writer.write()
    }

}


class CarDriver : Driver {
    override fun drive() {
        println("代理司机开车中")
    }
}

class PPTWriter : Writer {
    override fun write() {
        println("代理写手写作中")
    }

}

interface Driver {
    fun drive()

    fun eat() = "driver eat"
}


interface Writer {
    fun write()

    fun eat() = "writer eat"
}


object Abc{

    val sum = 2
}

class Static{
    companion object {
        @JvmField
        val a= 2
        @JvmStatic
        fun b()= 2
        val c = {2}
    }
}

fun main(args: Array<String>) {
    val driver = CarDriver()
    val writer = PPTWriter()
    val seniorManager = SeniorManager(driver, writer)
    seniorManager.drive()
    seniorManager.write()
    println(minOf(1, 2))

    println(Static.Companion.a)
    println(Static.b())
    println(Static.c())
}
