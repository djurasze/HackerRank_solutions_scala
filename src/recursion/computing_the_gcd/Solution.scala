package recursion.computing_the_gcd

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\computing_the_gcd\\data.txt")


  @scala.annotation.tailrec
  def gcd(x: Int, y: Int): Int =
  {
    val difference = x -y
    difference match {
      case 1 => 1
      case 0 => x
      case diff if diff < 0 => gcd(y-x, x)
      case diff if diff > 0 => gcd(x-y, y)
    }

  }


  def acceptInputAndComputeGCD(pair:List[Int]) = {
    println(gcd(pair.head,pair.reverse.head))
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    acceptInputAndComputeGCD(linesItr.next().trim().split(" ").map(x=>x.toInt).toList)

  }

}


