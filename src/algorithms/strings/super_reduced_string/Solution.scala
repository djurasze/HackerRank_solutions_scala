package algorithms.strings.super_reduced_string

import scala.io.Source

object Solution {

  def fRecursion(letters:List[Char]):List[Char] = {
    letters match {
      case (a:Char) :: (b:Char) :: tail if a == b => fRecursion(tail)
      case (a:Char) :: (b:Char) :: tail => a :: fRecursion(b :: tail)
      case _ => letters
    }
  }

  def f(str:String):String = {
    fRecursion(str.toList).mkString("").transform(text => if (text == "") "Empty String" else text)
  }



  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\algorithms\\strings\\super_reduced_string\\data.txt")

    println(f(source.getLines().next()))

    source.close()
  }

}


