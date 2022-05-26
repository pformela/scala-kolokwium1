package ninetynine.problems

object P05 {

  def reverseList[A](l: List[A]): List[A] =
    l.reverse

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    println(reverseList(l))
  }
}
