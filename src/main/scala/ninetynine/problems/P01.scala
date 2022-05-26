package ninetynine.problems

object P01 {

  def last[A](l: List[A]): A =
    l.last

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    println(last(l))
  }
}
