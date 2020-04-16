package introduction.hello_world

object Solution {

  def f(): Unit = println("Hello World")

//  def f(n: Int) {
//    for(i <- 1 to n) {
//      println("Hello World")
//    }
//  }

  def f(n: Int): Unit = LazyList.fill(n)("Hello World").foreach(println)

  def sum(numbers: Iterator[String]): Int = numbers.map(_.toInt).sum

  def main (args: Array[String] ): Unit = {
    f(10)
    println(sum(io.Source.stdin.getLines().take(2)))
  }

}


