package ninetynine.problems

object P04 {

  def findLength[A](l: List[A]): Int =
    l.length

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    println(findLength(l))
  }
}
