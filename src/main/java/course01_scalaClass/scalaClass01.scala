package course01_scalaClass

// 定义一个简单的类
// 回顾：类的三大要素：封装，继承，多态

// 1 简单的类的定义
class HelloWorld{
  // 类中定义的变量称为field
  // 类中定义的函数称为方法
  private var name = "xuan"
  def sayHello() {println(name)}
  def getName:String  = name

}
//
//object scalaClass01 {
//  def main(args :Array[String]) :Unit = {
//    var hello = new HelloWorld
//    println(hello.getName)
//}
//
//}



// 1.1 类中field 的getter / setter 方法尝试
//
class testGetter{
  // public 对象自带 getter setter 方法
  // private 对象的gettter ， setter 只能在类内部进行
  var publicVar = "hello"
  private var privateVar = "world"
  private[this] var veryprivateVar = "!"
  def changePrivateVar(word :String): Unit = {
    this.privateVar = word
  }
  def getPrivateVar :String = this.privateVar

}

//object scalaClass01 {
//  def main(args :Array[String]) :Unit = {
//    var testgetter = new testGetter
//    // 这是可以的：
//    println(testgetter.publicVar)
//    testgetter.publicVar = "HELLO"
//    println(testgetter.publicVar)
//    // 这样子会报错:
////    println(testgetter.privateVar)
//    // 但是可以通过内部方法
//    println(testgetter.getPrivateVar)
//    testgetter.changePrivateVar("WORLD")
//    println(testgetter.getPrivateVar)
//
//  }
//}

// 1.2 自定义getter 和 setter 方法
//
class userdefineGetterSetter{
  private var x = 1000
  def getx = x
  // 注意 get_= 是一个整体
  // 注意：get 和 set方法必须是同一个开头，下述方法定义为setx_则
  // 不能使用 a.setx = 100
  def getx_=(y :Int) {
      x = y
  }
}

//object scalaClass01{
//  def main(args:Array[String]):Unit = {
//    var gettersetter = new userdefineGetterSetter
//    println(gettersetter.getx)
//    gettersetter.getx = 100
//    println(gettersetter.getx)
//  }
//
//}

// 1.3  关于private[this] 声明
// 1） private 的私有程度 : 在类定义中可以访问该类某个对象的私有成员
// 2） private this 的私有程度：private this ：只能被当前对象访问
// 注意：下述操作对于private[this]类对象不是很需要
class privateClass{
  private var myage:Int = 0
  def age :Int = myage
  def age_=(newAge:Int): Unit ={
    if (newAge>0) myage = newAge
    else println("your input age is not right")
  }
  def compareAge(s:privateClass) :Boolean ={
    // 注意：对于private 级别的私有程度，这是允许的
    myage > s.myage
  }
}

//object scalaClass01{
//  def main(args:Array[String]):Unit = {
//    var s1 = new privateClass
//    var s2 = new privateClass
//    s1.age = 100;s2.age = 89
//    println(s1.compareAge(s2))
//  }
//}



// 2 关于构造器的使用
// 2.1 辅助构造函数
// 注意：最开始定的时候必须调用this()
class constructor01{
  private var name = ""
  private var age  = 0
  def this(name:String){
    this()
    this.name = name
  }
  def this(name:String , age :Int){
    this(name)
    this.age = age
  }
}

// 2.2 主构造函数
// 主构造器中：
// var 声明的：name，是一个private[this]
// 没有var的：age,调用了则有用，没有利用到则之后不存在了
class contructor02(var name:String , age:Int){
  def tryMainContructor02(): Unit ={
    println("my name is "+ name ,"my age is "+ age)
  }
}

// 2.3 可以指定默认值
class contructor03(var name:String = "xuan" , age:Int = 100){
  def tryMainContructor02(): Unit ={
    println("my name is "+ name ,"my age is "+ age)
  }
}


//
//object scalaClass01{
//  def main(args:Array[String]):Unit = {
//    var cons = new contructor02("xuan",20)
//    cons.tryMainContructor02()
//  }
//}



// 3 内部类
// 注意：不同的对象的 “内部类的对象”是属于不同的类
class Class{
  class student(var name :String)

}

object scalaClass01{
  def main(args:Array[String]):Unit = {
    var cons = new contructor02("xuan",20)
    cons.tryMainContructor02()
  }
}