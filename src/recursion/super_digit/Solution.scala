package recursion.super_digit

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\super_digit\\data.txt")


  @scala.annotation.tailrec
  def findSuperDigit(num: Long):Int = {
    if (num <= 9) {
      num.toInt
    } else {
      findSuperDigit(num.toString.toCharArray.map(_.asDigit).sum)
    }
  }

  def sumDigits(n: String, k: Int):Long = {
    n.toCharArray.map(letter => letter.asDigit*k).map(_.toLong).sum
  }

  def calculateSuperDigit(n: String, k: Int): Long = {
    val num = sumDigits(n, k)
    findSuperDigit(num)
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    val input = linesItr.next().split(" ").toList
    println(calculateSuperDigit(input.head, input(1).toInt))
  }

}


