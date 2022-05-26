package ninetynine.problems

object P17 {

  def splitIntoTwo[A](n: Int, l: List[A]): (List[A], List[A]) = {
    (l.slice(0, n), l.slice(n, l.length))
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    println(splitIntoTwo(3, l))
  }
}
