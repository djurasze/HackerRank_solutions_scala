package ad_hoc.huge_gcd

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\ad_hoc\\huge_gcd\\data.txt")


  def product(nFactors: Array[Int]): BigInt = {
    nFactors.map(BigInt.apply).product
  }

  @scala.annotation.tailrec
  def gcd(n: BigInt, m: BigInt): BigInt = {
    if (m == 0) {
      return n
    }
    gcd(m, n mod m)
  }

  def findGCD(nFactors: Array[Int], mFactors: Array[Int]): BigInt = {
    val n = product(nFactors)
    val m = product(mFactors)
    gcd(n, m)
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    val (_, nFactors, _, mFactors) = (linesItr.next(), linesItr.next().trim().split(" ").map(_.toInt), linesItr.next(), linesItr.next().trim().split(" ").map(_.toInt))
    println(findGCD(nFactors, mFactors) mod 1000000007)
  }

}


