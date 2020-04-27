package introduction.sum_of_odd_elements

import scala.io.Source

object Solution {

  def f(arr:List[Int]):Int = arr.filter(el => el%2!=0).sum

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\sum_of_odd_elements\\data.txt")

    println(f(source.getLines().map(_.toInt).toList))

    source.close()
  }

}


