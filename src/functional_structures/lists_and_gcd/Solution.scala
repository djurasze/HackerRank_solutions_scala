package functional_structures.lists_and_gcd

import scala.io.Source
import scala.math.max

object Solution {


  def gcd(number1: Array[(Int, Int)], number2: Array[(Int, Int)]): Array[(Int, Int)] = {
    number1.filter(num => number2.map(_._1).contains(num._1))
      .map(num => (num._1, Math.min(num._2, number2.filter(el => el._1 == num._1).map(_._2).head)))
  }

  def gcd(numbers: List[Array[(Int, Int)]]): Array[(Int, Int)] = {
    numbers.length match {
      case 2 => gcd(numbers.head, numbers(1))
      case _ => gcd(numbers.head, gcd(numbers.tail))
    }
  }

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\functional_structures\\lists_and_gcd\\data.txt")
    val lines = source.getLines()
    val n = lines.next().toInt
    val numbers = Seq.range(0, n).map(_ => lines.next().split(" ")).map(list => {
      val even = list.zipWithIndex.filter(_._2 % 2 == 0).map(_._1.toInt)
      val odd = list.zipWithIndex.filter(_._2 % 2 == 1).map(_._1.toInt)
      even.zip(odd)
    }).toList

    println(gcd(numbers).flatMap(el => Array(el._1, el._2)).mkString(" "))

    source.close()
  }

}


