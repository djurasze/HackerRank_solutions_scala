package memoization_and_dp.differnet_ways

import scala.collection.mutable
import scala.io.Source
import scala.collection.mutable.Map


object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\memoization_and_dp\\differnet_ways\\data.txt")

  def findWays(testCase: (Int, Int), mem: mutable.Map[(Int, Int), BigInt]): BigInt = {
    val n = testCase._1
    val k = testCase._2

    mem.getOrElse(testCase, k match {
      case 0 =>
        mem.put((n, k), 1)
        1
      case _ if n == k =>
        mem.put((n, k), 1)
        1
      case _ =>
        mem.put((n, k), findWays((n - 1, k - 1), mem) + findWays((n - 1, k), mem))
        mem((n, k))
    })
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    val numberOfTestCases = linesItr.next().trim().toInt
    val testCases = Seq.range(0, numberOfTestCases).map(_ => linesItr.next().split(" ")
      .map(el => el.toInt).toList).map(list => (list.head, list(1)))
    val mem: mutable.Map[(Int, Int), BigInt] = mutable.Map()

    testCases.foreach(testCase => println(findWays(testCase, mem) mod BigInt.long2bigInt((Math.pow(10, 8).toLong + 7))))

  }

}


