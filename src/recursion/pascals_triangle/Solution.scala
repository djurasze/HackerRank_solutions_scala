package recursion.pascals_triangle

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\pascals_triangle\\data.txt")

  def factorial(n: Int): Int = {
    n match {
      case 0 => 1
      case 1 => 1
      case n => n * factorial(n - 1)
    }
  }

  def calculatePascalTriangleRecord(row: Int, col: Int): Int = {
    factorial(row) / (factorial(col) * factorial(row - col))
  }

  def calculatePascalTriangleRow(row: Int): List[Int] = {
    Seq.range(0, row+1).map(calculatePascalTriangleRecord(row, _)).toList
  }


  def calculatePascalTriangle(x: Int): List[List[Int]] = {
    Seq.range(0, x).toList.map(n => calculatePascalTriangleRow(n))
  }


  def main(args: Array[String]) {
    val linesItr = source.getLines()
    calculatePascalTriangle(linesItr.next().trim().toInt).foreach(row => println(row.mkString(" ")))

  }

}


