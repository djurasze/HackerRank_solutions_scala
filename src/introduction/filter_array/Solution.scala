package introduction.filter_array

import scala.io.Source

object Solution {

//  def f(delim:Int,arr:List[Int]):List[Int] = arr.filter(_ < delim)
  def f(delim:Int,arr:List[Int]):List[Int] = for (i <- arr if i < delim) yield i

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\filter_array\\data.txt")

    println(f(source.getLines().next().toInt, source.getLines().map(_.toInt).toList))

    source.close()
  }

}


