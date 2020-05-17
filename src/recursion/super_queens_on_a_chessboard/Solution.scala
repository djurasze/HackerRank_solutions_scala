package recursion.super_queens_on_a_chessboard

import scala.collection.mutable
import scala.io.Source
import scala.collection.mutable.Map

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\super_queens_on_a_chessboard\\data.txt")
  val moves = mutable.Map[(Int, Int), List[(Int, Int)]]()

  def initBoard(boardSize: Int): Array[Array[Int]] = Array.ofDim[Int](boardSize, boardSize)

  def setPosition(position: (Int, Int), board: Array[Array[Int]], state: Int): Unit = {
    board(position._1)(position._2) = state
  }

  def getQueenMoves(position: (Int, Int), length: Int): List[(Int, Int)] = {
    if (!moves.contains(position)) {
      val horizontal = Seq.range(0, length).map(col => (position._1, col)).filter(pos => pos._2 != position._2)
      val vertical = Seq.range(0, length).map(row => (row, position._2)).filter(pos => pos._1 != position._1)

      val diagonal = Seq.range(0, length).flatMap(row => Seq.range(0, length).map(col => (row, col))).filter(pos => pos._1 - position._1 == pos._2 - position._2 || pos._1 - position._1 == -(pos._2 - position._2))
        .filter(pos => pos._1 != position._1 && pos._2 != position._2)
      moves.addOne(position, horizontal.concat(vertical).concat(diagonal).toList)
    }
    moves(position)
  }


  def getKnightMoves(position: (Int, Int), size: Int): List[(Int, Int)] = {
    List((position._1 - 2, position._2 - 1), (position._1 - 2, position._2 + 1), (position._1 - 1, position._2 + 2),
      (position._1 + 1, position._2 + 2), (position._1 - 1, position._2 - 2), (position._1 + 1, position._2 - 2),
      (position._1 + 2, position._2 - 1), (position._1 + 2, position._2 + 1))
      .filter(pos => pos._1 >= 0 && pos._1 < size && pos._2 >= 0 && pos._2 < size)
  }

  def blockPositions(position: (Int, Int), board: Array[Array[Int]]): Unit = {
    val knightMoves = getKnightMoves(position, board.length)
    val queenMoves = getQueenMoves(position, board.length)
    knightMoves.concat(queenMoves).foreach(pos => setPosition(pos, board, 2))


  }


  def putQueenOnBoard(position: (Int, Int), board: Array[Array[Int]]): Unit = {
    setPosition(position, board, 1)
    blockPositions(position, board)
  }


  def noCollision(position: (Int, Int), board: Array[Array[Int]]): Boolean = {
    val knightMoves = getKnightMoves(position, board.length)
    val queenMoves = getQueenMoves(position, board.length)
    knightMoves.concat(queenMoves).map(collision => board(collision._1)(collision._2) == 1).forall(_ == false)
  }

  def findNextPositionOfQueen(column: Int, board: Array[Array[Int]]): List[(Int, Int)] = {
    board.view.zipWithIndex.filter(tuple => tuple._1(column) == 0 && noCollision((tuple._2, column), board)).map(tuple => (tuple._2, column)).toList
  }

  def recSolve(position: (Int, Int), board: Array[Array[Int]]): List[Array[Array[Int]]] = {
    putQueenOnBoard(position, board)
    //    board foreach { row => row foreach print; println }
    //    println()

    if (position._2 == board.length - 1) {
      return List(board)
    }

    val nextPositions = findNextPositionOfQueen(position._2 + 1, board)
    nextPositions.flatMap(next => recSolve(next, board.map(_.clone)))
  }


  def solveNSuperQueens(boardSize: Int): Int = {
    Seq.range(0, boardSize).flatMap(startRow => recSolve((startRow, 0), initBoard(boardSize))).size
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    println(solveNSuperQueens(linesItr.next().trim().toInt))
  }

}


