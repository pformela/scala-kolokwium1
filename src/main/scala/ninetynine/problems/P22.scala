package ninetynine.problems

object P22 {

  def range(from: Int, to: Int): List[Int] = {
    List.range(from, to + 1)
  }

  def main(args: Array[String]): Unit = {
    println(range(4, 9))
    println(range(9, 4))
  }
}
