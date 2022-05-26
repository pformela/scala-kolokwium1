package ninetynine.problems

object P15 {

  def duplicateNTimes[A](l: List[A], n: Int): List[A] = {
    l.flatMap(x => List.fill(n)(x))
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'c', 'd')
    println(duplicateNTimes(l, 4))
  }
}
