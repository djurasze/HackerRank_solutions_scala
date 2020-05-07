package introduction.functions_or_not

import org.graalvm.compiler.replacements.SnippetTemplate.Arguments

import scala.io.Source

object Solution {


  def readFunctionArgument(lines: Iterator[String]):Int = lines.next().split(" ").map(_.toInt).toList.head

  def readSamples(numOfSamples: Int, lines: Iterator[String]): List[Int] = LazyList.fill(numOfSamples)(readFunctionArgument(lines)).toList

  def checkIfFunction(arguments: List[Int]): Boolean = arguments.distinct.size == arguments.size

  def convertToAnswer(result: Boolean): String = if(result.equals(true)) "YES" else "NO"

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\functions_or_not\\data.txt")

    val lines = source.getLines()
    val testCases = lines.next().strip().toInt

    LazyList.fill(testCases)(lines.next().strip().toInt).map(readSamples(_, lines)).map(checkIfFunction).map(convertToAnswer).foreach(println)

    source.close()
  }

}


