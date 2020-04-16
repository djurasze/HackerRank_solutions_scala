package introduction.list_replication

import scala.io.Source

object Solution {

  def f(num: Int, arr: List[Int]): List[Int] = arr.flatMap(LazyList.fill(num)(_))

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\list_replication\\data.txt")

    println(f(source.getLines().next().toInt, source.getLines().map(_.toInt).toList))

    source.close()
  }

}


