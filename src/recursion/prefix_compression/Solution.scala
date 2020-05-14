package recursion.prefix_compression


import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\prefix_compression\\data.txt")


  def findPrefixSize(first: List[Char], second: List[Char]): Int = {
    if(first.isEmpty || second.isEmpty)
      return 0
    if(first.head == second.head)
      1 + findPrefixSize(first.tail, second.tail)
    else
      0
  }

  def calculate(first:String, second: String): List[String] = {
    val prefixSize = findPrefixSize(first.toList, second.toList)
    val prefix = first.substring(0, prefixSize)
    val firstEnd = first.substring(prefixSize)
    val secondEnd = second.substring(prefixSize)
    List(prefix, firstEnd, secondEnd)
  }


  def main(args: Array[String]) {
    val linesItr = source.getLines()
    calculate(linesItr.next().trim(),linesItr.next().trim()).foreach(text => println(text.length + " " + text))

  }

}


