package ninetynine.problems

object P16 {

  def dropEveryNth[A](n : Int, l: List[A]): List[A] = {
    l.zipWithIndex.filterNot(x => x._2 % n == n - 1).map(x => x._1)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    println(dropEveryNth(3, l))
  }
}
