package recursion.fibonacci_numbers

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\fibonacci_numbers\\data.txt")


  @scala.annotation.tailrec
  def fib(pos: Int, x: Int, first: Int, second: Int): Int =
  {
    pos match {
      case _ if pos == x => first + second
      case _ => fib(pos+1, x, second, first + second)
    }
  }


  def fibonacci(x:Int):Int = {
    x match {
      case _ if x == 1 => 0
      case _ if x == 2 => 1
      case _ => fib(3, x, 0, 1)
    }
  }


  def main(args: Array[String]) {
    val linesItr = source.getLines()
    println(fibonacci(linesItr.next().trim().toInt))

  }

}


