package ninetynine.problems

object P21 {

  def insertAt[A](item: A, pos: Int, l: List[A]): List[A] = {
    (List(l.slice(0, pos)) :+ List(item) :+ l.slice(pos, l.length)).flatten
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd')
    println(insertAt("new", 0, l))
    println(insertAt("new", 2, l))
  }
}
