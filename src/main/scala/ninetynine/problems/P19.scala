package ninetynine.problems

object P19 {

  def rotateList[A](left: Int, l: List[A]): List[A] = {
    if(left > 0) (List(l.slice(left, l.length)) :+ l.slice(0, left)).flatten
    else (List(l.slice(l.length - math.abs(left), l.length)) :+ l.slice(0, l.length - math.abs(left))).flatten
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    println(rotateList(3, l))
    println(rotateList(-2, l))
  }
}
