package introduction.compute_the_perimeter_of_a_polygon

import scala.io.Source

object Solution {

  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\compute_the_perimeter_of_a_polygon\\data.txt")

  def readInput():List[(Int, Int)] = {
    val linesItr = source.getLines()
//    val linesItr = io.Source.stdin.getLines()
    val n = linesItr.next().toInt
    LazyList.fill(n)(linesItr.next().split(" ")).map(el => (el(0).toInt, el(1).toInt)).toList
  }

  def calculateSegmentLength(segment: ((Int, Int), (Int, Int))): Double = {
      Math.sqrt(Math.pow(Math.abs(segment._1._1-segment._2._1),2) + Math.pow(Math.abs(segment._1._2-segment._2._2),2))
  }

  def calculatePerimeter(points: List[(Int, Int)]): Double = {
    val shiftedPoints = points.drop(1) :+ points.head
    val segments = points.zip(shiftedPoints)
    segments.map(calculateSegmentLength).sum
  }

  def main(args: Array[String]): Unit = {
    val points = readInput()
    println(calculatePerimeter(points))

  }

}


