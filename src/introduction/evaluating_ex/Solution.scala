package introduction.evaluating_ex

import scala.io.Source

object Solution {

  def factorial(n:Int):Int = n match {
    case 0 => 1
    case 1 => 1
    case k => k * factorial(k-1)
  }
  def f(x:Double):Double = (0 to 9).foldLeft(0:Double)((sum:Double, i:Int) => sum + (Math.pow(x, i)/factorial(i)))

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\evaluating_ex\\data.txt")

    source.getLines().next().toInt

    source.getLines().map(_.toDouble).foreach(num => printf("%.4f\n", f(num)))
    source.close()
  }

}


