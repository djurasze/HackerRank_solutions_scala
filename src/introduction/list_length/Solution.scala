package introduction.list_length

import introduction.sum_of_odd_elements.Solution.f

import scala.io.Source

object Solution {

  def f(arr:List[Int]):Int = arr.foldLeft(0)((acc, _) => acc + 1)

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\list_length\\data.txt")

    println(f(source.getLines().map(_.toInt).toList))

    source.close()
  }

}


