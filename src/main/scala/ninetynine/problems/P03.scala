package ninetynine.problems

object P03 {

  def findKth[A](index: Int, l: List[A]): A =
    l(index)

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    println(findKth(2, l))
  }
}
