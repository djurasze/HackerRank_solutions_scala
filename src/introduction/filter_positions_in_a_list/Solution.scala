package introduction.filter_positions_in_a_list

import scala.io.Source

object Solution {

//  def f(arr:List[Int]):List[Int] = arr.zipWithIndex
//    .filter{ case (_, index) => index % 2 == 1 }
//    .map(_._1)

  def f(arr:List[Int]):List[Int] = arr.zipWithIndex
    .filter(tup => tup._2 % 2 == 1 )
    .map(_._1)



  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\filter_positions_in_a_list\\data.txt")

    println(f(source.getLines().map(_.toInt).toList))

    source.close()
  }

}


