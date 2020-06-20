package memoization_and_dp.pentagonal_numbers

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\memoization_and_dp\\pentagonal_numbers\\data.txt")


//  def findPentagonalNumbers(n: Long):Long = {
//    Seq.range(1,n+1).map(num => (num-1)*3+1).sum
//  }

//  def findPentagonalNumbers(n: Long):Long = {
//    (3 * n * n - n) / 2
//  }

//  def main(args: Array[String]) {
//    val linesItr = source.getLines()
//    val numberOfTestCases = linesItr.next().trim().toInt
//    Seq.range(0, numberOfTestCases).map(_ => findPentagonalNumbers(linesItr.next().trim().toInt)).foreach(println)
//
//  }

  def findPentagonalNumbers(maxTestCase: Int, mem: Array[Long]): Unit = {
    for(i <- 1 to maxTestCase) {
      mem(i) = mem(i-1) + (i-1)*3+1
    }

  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    val numberOfTestCases = linesItr.next().trim().toInt
    val testCases = Seq.range(0, numberOfTestCases).map(_ => linesItr.next().trim().toInt)
    val maxTestCase = testCases.max
    val mem = Array.ofDim[Long](maxTestCase+1)
    mem(1) = 1
    findPentagonalNumbers(maxTestCase, mem)
    testCases.foreach(testCase => println(mem(testCase)))

  }

}


