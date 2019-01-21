package com.rinko

import com.sun.xml.internal.fastinfoset.util.StringArray


val anotherInt: Int = 0xFF  //16进制 相当于255
val moreInt: Int = 0b0000000011 //2进制 相当于3
val maxInt: Int = Int.MAX_VALUE //2147483647
val maxInt2: Double = Math.pow(2.0, 63.0) - 1  //2.147483647E9
val minInt: Int = Int.MIN_VALUE //-2147483648
val minInt2: Double = -Math.pow(2.0, 31.0)  //-2.147483648E9

val maxLong: Long = Long.MAX_VALUE  //9223372036854775807
val maxLong2: Double = Math.pow(2.0, 63.0) - 1  //9.223372036854776E18
val minLong: Long = Long.MIN_VALUE  //-9223372036854775808
val minLong2: Double = -Math.pow(2.0, 63.0) //-9.223372036854776E18

//加f的为单精度浮点型
val aFloat: Float = 2.0F //2.0
val anotherFloat: Float = 1E3f   //1000.0
val maxFloat: Float = Float.MAX_VALUE    //3.4028235E38
val minFloat: Float = Float.MIN_VALUE    //1.4E-45 这个是正数的最小值

val aNaN: Float = 0.0F / 0.0F  //NaN
val bo = aNaN == Float.NaN  //false 无法比较的数比较为false

//不加f的为双精度浮点型
val aDouble: Double = 3.0   //3.0
val anotherDouble: Double = 1E3 //1000.0
val maxDouble: Double = Double.MAX_VALUE    //1.7976931348623157E308
val minDouble: Double = Double.MIN_VALUE    //4.9E-324 这个是正数的最小值

val maxShort: Short = Short.MAX_VALUE   //32767
val maxShort2: Double = Math.pow(2.0, 15.0) - 1  //32767.0
val minShort: Short = Short.MIN_VALUE //-32768
val minShort2: Double = -Math.pow(2.0, 15.0)  //-32768.0

val maxByte:Byte = Byte.MAX_VALUE   //127
val minByte:Byte = Byte.MIN_VALUE   //-128

val fromChars:String = String(charArrayOf('H','e','l','l','o','W','o','r','l','d'))
val rowString:String = """/n/d $fromChars"""    // /n/d HelloWorld 无需转义 不过变量的$无法加/转义

val 我喜欢的妹子:String = "阿佐"

val range:IntRange = 0..1024    //闭区间   [0,1024]
val range_exclusive = 0 until 1024  //开区间   [0,1024) 即 [0,1023]
val range_empty = 0..-1

val intArray:IntArray = intArrayOf(0,1,2,3)
val stringArray:Array<String> = arrayOf("a","b","c","d")

fun main(args: Array<String>) {
    println(minByte)
    println(maxByte)
    println(minShort)
    println(我喜欢的妹子)

    println(1024 in range)     //意思同下   true
    println(range_exclusive.contains(1024)) //false
    println(range_empty.isEmpty())  //true
    for(i in range){
        print("$i,")
    }
    println()
    for(i in range_exclusive){
        print("$i,")
    }
    println()

    println(intArray.joinToString())    //0, 1, 2, 3
    println(intArray.joinToString("-")) //0-1-2-3
    println(intArray.joinToString("-","开始："))   //开始：0-1-2-3
    println(intArray.joinToString("-","开始：","结束"))   //开始：0-1-2-3结束
    println(intArray.joinToString("-","开始：","结束",0))    //开始：...结束
    println(intArray.joinToString("-","开始：","结束",2))    //开始：0-1-...结束
    println(intArray.joinToString("-","开始：","结束",2,"省略"))    //开始：0-1-省略结束
    println(intArray.joinToString("-","开始：","结束",2,"省略",{i:Int->i.toString()+"zhe"}))    //开始：0-1-...结束
    println(stringArray.joinToString("-","开始：","结束",2,"省略",{i:String->"${i}+"}))

    println(intArray.slice(0..1))   //[0,1] 数组截取
    println(Girl::class.java.simpleName)    //Girl
    println(Girl::class.java.name)  //com.rinko.Girl
}