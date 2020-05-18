package recursion.the_sums_of_powers

import scala.collection.mutable
import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\the_sums_of_powers\\data.txt")
  val mem = mutable.Map[(Int, List[Int]), Set[List[Int]]]()

  def findNumberOfWays(X:Int, options: List[Int], current: List[Int]): Set[List[Int]] = {
    if (mem.contains((X, options))) {
      return mem((X, options))
    }
//    println(X)
//    println(options)
//    println(current)
    if(options.isEmpty) {
      return Set(List())
    }
    val diffs = options.map(option => option -> (X - option)).filter(rec => rec._2 >= 0).toMap
//    println(X)
//    println(options)

    diffs.flatMap(diff => {
      diff._2 match {
        case 0 => Set(current :+ diff._1)
        case newVal => {
          val newOptions = options.filterNot(opt => opt == diff._1)
          val result = findNumberOfWays(newVal, newOptions, current :+ diff._1)
          mem.put((newVal, newOptions), result)
          result
        }
      }
    }).toSet

  }


  def numberOfWays(X:Int,N:Int):Int = {
    val options = Seq.range(1, Math.floor(Math.pow(X, 1.0/N)+1).toInt).map(i => Math.pow(i, N).toInt).toList
//    println(findNumberOfWays(X, options, List()).map(result => result.sorted).filter(result => result.nonEmpty))
    findNumberOfWays(X, options, List()).map(result => result.sorted).count(result => result.nonEmpty)
  }


  def main(args: Array[String]) {
    val linesItr = source.getLines()
    println(numberOfWays(linesItr.next().trim().toInt, linesItr.next().trim().toInt))
  }

}


