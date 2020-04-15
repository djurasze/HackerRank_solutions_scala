package introduction.hello_world

object Solution extends App {

  def f(): Unit = println("Hello World")

//  def f(n: Int) {
//    for(i <- 1 to n) {
//      println("Hello World")
//    }
//  }

  def f(n: Int): Unit = LazyList.fill(n)("Hello World") foreach {println}

  f()
  f(10)
}



