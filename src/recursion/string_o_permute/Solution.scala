package recursion.string_o_permute

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\string_o_permute\\data.txt")


  def permute(str: String): String = {
    val splitLetters = str.zipWithIndex.foldLeft((new StringBuilder(""),new StringBuilder("")))((acc, next) => next._2 match {
      case pos if pos % 2 == 0 => (acc._1.addOne(next._1), acc._2)
      case _ => (acc._1, acc._2.addOne(next._1))
    })
    splitLetters._2.zip(splitLetters._1).foldLeft(new StringBuilder(""))((acc, el)=> acc.addOne(el._1).addOne(el._2)).toString()
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    Seq.range(0, linesItr.next().trim().toInt).map(_ => permute(linesItr.next().trim())).foreach(println)
  }

}


