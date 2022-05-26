package ninetynine.problems

object P14 {

  def duplicateListElements[A](l: List[A]): List[A] = {
    l.flatMap(x => List(x, x))
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'c', 'd')
    println(duplicateListElements(l))
  }
}
