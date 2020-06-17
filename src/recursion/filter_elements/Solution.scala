package recursion.filter_elements

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\filter_elements\\data.txt")

  @scala.annotation.tailrec
  def countRepeats(data: List[Int], position: Int, counts: Map[Int, Int]): Map[Int, Int] = {
    position match {
      case pos if data.size == pos => counts
      case _ => countRepeats(data, position + 1, counts + (data(position) -> (counts(data(position)) + 1)))
    }
  }

  def filterElements(minNumOfElements: Int, data: List[Int]): List[Int] = {
//    val repeats = data.groupBy(identity)
//    val occurrences  = repeats.view.mapValues(value => value.length)
    val occurrences = countRepeats(data, 0, Map().withDefaultValue(0))
    val result = data.distinct.filter(occurrences(_) >= minNumOfElements)
    if (result.isEmpty) List(-1) else result
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    val numberOfTestCases = linesItr.next().trim().toInt
    Seq.range(0, numberOfTestCases).map(_ => filterElements(linesItr.next().split(" ")(1).trim().toInt, linesItr.next().split(" ")
      .map(_.toInt).toList)).foreach(result => println(result.mkString(" ")))

  }

}


