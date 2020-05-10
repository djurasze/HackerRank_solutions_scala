package introduction.compute_the_area_of_a_polygon

import scala.io.Source

object Solution {

  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\compute_the_area_of_a_polygon\\data.txt")

  def readInput():List[(Int, Int)] = {
    val linesItr = source.getLines()
//    val linesItr = io.Source.stdin.getLines()
    val n = linesItr.next().toInt
    LazyList.fill(n)(linesItr.next().split(" ")).map(el => (el(0).toInt, el(1).toInt)).toList
  }

//  def calculateSegmentLength(segment: ((Int, Int), (Int, Int))): Double = {
//      Math.sqrt(Math.pow(Math.abs(segment._1._1-segment._2._1),2) + Math.pow(Math.abs(segment._1._2-segment._2._2),2))
//  }
//
//  def calculateTriangleArea(points: ((Int, Int), (Int, Int), (Int, Int))): Double = {
//      val firstSegment = calculateSegmentLength((points._1,points._2))
//      val secondSegment = calculateSegmentLength((points._1,points._3))
//      val thirdSegment = calculateSegmentLength((points._2,points._3))
//      val tmp = (firstSegment+secondSegment+thirdSegment)/2d
//      Math.sqrt(tmp* (tmp - firstSegment) * (tmp - secondSegment) * (tmp - thirdSegment))
//  }
//
//
////  Only convex
//  def calculateArea(points: List[(Int, Int)]): Double = {
//    val basePoint = points.head
//    val restOfPoints = points.drop(1)
//    val shiftedPoints = restOfPoints.drop(1)
//    val pointsPairs = restOfPoints.zip(shiftedPoints)
//    pointsPairs.map(pair => calculateTriangleArea((basePoint, pair._1, pair._2))).sum
//  }


  def calculateAreaAttachedToX(segment: ((Int, Int), (Int, Int))): Double = {
    val avgHeight = Math.abs(segment._1._2 + segment._2._2)/2d
    val width = segment._1._1 - segment._2._1
    avgHeight*width
  }

    def calculateArea(points: List[(Int, Int)]): Double = {
      val shiftedPoints = points.drop(1) :+ points.head
      val segments = points.zip(shiftedPoints)
      segments.map(calculateAreaAttachedToX).sum.abs
    }

  def main(args: Array[String]): Unit = {
    val points = readInput()
    println(calculateArea(points))

  }

}


