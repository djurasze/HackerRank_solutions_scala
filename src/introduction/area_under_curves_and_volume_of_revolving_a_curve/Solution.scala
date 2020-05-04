package introduction.area_under_curves_and_volume_of_revolving_a_curve

import introduction.list_length.Solution.f

import scala.io.Source

object Solution {

  def f(coefficients:List[Int],powers:List[Int], x:Double):Double =
    coefficients.zip(powers)
      .foldLeft(0.0){case (acc,(c,p))=> acc + c * math.pow(x,p)}

  def area(coefficients:List[Int],powers:List[Int],x:Double):Double =
    math.Pi * math.pow(f(coefficients,powers,x),2)

  def summation(func:(List[Int],List[Int],Double)=>Double,
                upperLimit:Int,
                lowerLimit:Int,
                coefficients:List[Int],
                powers:List[Int]):Double =
  {
    val step = 0.001
    val subIntervals = (BigDecimal(upperLimit) to BigDecimal(lowerLimit) by BigDecimal(step)).map(_.toDouble)

    subIntervals
      .foldLeft(0.0){case (acc,x)=> acc + func(coefficients,powers,x)*step}
  }

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\introduction\\area_under_curves_and_volume_of_revolving_a_curve\\data.txt")
    val lines = source.getLines()
    val coefficients = lines.next().split(" ").map(_.toInt).toList
    val powers = lines.next().split(" ").map(_.toInt).toList
    val limits = lines.next().split(" ").map(_.toInt).toList

    println(summation(f, limits.head, limits(1), coefficients, powers))
    println(summation(area, limits.head, limits(1), coefficients, powers))

    source.close()
  }

}


