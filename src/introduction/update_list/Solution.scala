package introduction.update_list

import scala.io.Source

object Solution {

  def f(arr:List[Int]):List[Int] = arr.map(num => Math.abs(num))

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\update_list\\data.txt")

    println(f(source.getLines().map(_.toInt).toList))

    source.close()
  }

}


