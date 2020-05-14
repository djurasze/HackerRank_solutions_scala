package recursion.string_mingling

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\string_mingling\\data.txt")


  def mergeStrings(first:String, second: String): String = {
    first.toList.zip(second.toList).map(tuple => tuple._1.toString+tuple._2.toString).foldLeft("")((sum, next) => sum+next)
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    println(mergeStrings(linesItr.next().trim(),linesItr.next().trim()))
  }

}


