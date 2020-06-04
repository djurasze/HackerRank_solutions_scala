package recursion.sequence_full_of_colors

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\sequence_full_of_colors\\data.txt")


  private def checkDifferenceConditions(numberOfRed: Int, numberOfGreen: Int, numberOfYellow: Int, numberOfBlue: Int): Boolean = {
    if (Math.abs(numberOfRed - numberOfGreen) > 1 || Math.abs(numberOfYellow - numberOfBlue) > 1)
      return false
    true
  }

  private def checkEqualConditions( numberOfRed: Int, numberOfGreen: Int, numberOfYellow: Int, numberOfBlue: Int): Boolean = {
    if ((numberOfRed.equals(numberOfGreen) && numberOfYellow.equals(numberOfBlue)))
      return true
    false
  }

  @scala.annotation.tailrec
  def isFullOfColors(sequence: Array[Char], position: Int, numberOfRed: Int, numberOfGreen: Int, numberOfYellow: Int, numberOfBlue: Int): Boolean = {
    if (!checkDifferenceConditions(numberOfRed, numberOfGreen, numberOfYellow, numberOfBlue))
      return false

    if (sequence.length.equals(position)) {
      if (!checkEqualConditions(numberOfRed, numberOfGreen, numberOfYellow, numberOfBlue))
        return false
      return true
    }

    sequence(position) match {
      case 'R' => isFullOfColors(sequence, position + 1, numberOfRed + 1, numberOfGreen, numberOfYellow, numberOfBlue)
      case 'G' => isFullOfColors(sequence, position + 1, numberOfRed, numberOfGreen + 1, numberOfYellow, numberOfBlue)
      case 'Y' => isFullOfColors(sequence, position + 1, numberOfRed, numberOfGreen, numberOfYellow + 1, numberOfBlue)
      case 'B' => isFullOfColors(sequence, position + 1, numberOfRed, numberOfGreen, numberOfYellow, numberOfBlue + 1)
    }

  }

  def isFullOfColors(sequence: String): Boolean = {
    isFullOfColors(sequence.toCharArray, 0, 0, 0, 0, 0)
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    val cases = Seq.range(0, linesItr.next().trim().toInt).map(_ => linesItr.next()).toList
    cases.map(sequence => isFullOfColors(sequence)).foreach(result => println(result.toString.capitalize))


  }

}


