package algorithms.strings.strong_password

import scala.io.Source
import scala.math.max
object Solution {

  val numbers: String = "0123456789"
  val lowerCase = "abcdefghijklmnopqrstuvwxyz"
  val upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val specialCharacters = "!@#$%^&*()-+"

  def numbersValidator(text: String):Boolean = {
    numbers.toCharArray.exists(letter => text.contains(letter))
  }

  def lowerCaseValidator(text: String):Boolean = {
    lowerCase.toCharArray.exists(letter => text.contains(letter))
  }

  def upperCaseValidator(text: String):Boolean = {
    upperCase.toCharArray.exists(letter => text.contains(letter))
  }

  def specialValidator(text: String):Boolean = {
    specialCharacters.toCharArray.exists(letter => text.contains(letter))
  }


  def minimumNumber(n: Int, password: String): Int = {
    val validators = List[(String)=>Boolean](numbersValidator, lowerCaseValidator, upperCaseValidator, specialValidator)
    val missingLetters = validators.map(validator => validator(password)).count(_ == false)
    val missingLettersToExpectedSize = if (password.length >= 6) 0 else 6 - password.length
    max(missingLetters, missingLettersToExpectedSize)
  }



  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\algorithms\\strings\\strong_password\\data.txt")

    println(minimumNumber(source.getLines().next().toInt, source.getLines().next()))

    source.close()
  }

}


