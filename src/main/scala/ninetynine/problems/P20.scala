package ninetynine.problems

object P20 {

  def removeKthElement[A](k: Int, l: List[A]): (List[A], A) = {
    (l.zipWithIndex.filterNot(x => x._2 == k).map(x => x._1) ,l(k))
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd')
    println(removeKthElement(3, l))
  }
}
