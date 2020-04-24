package introduction.reverse_a_list

import scala.io.Source

object Solution {

  def f(arr: List[Int]): List[Int] = arr.foldLeft(List[Int]())((acc, el) => el :: acc)

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\reverse_a_list\\data.txt")

    println(f(source.getLines().map(_.toInt).toList))

    source.close()
  }

}


