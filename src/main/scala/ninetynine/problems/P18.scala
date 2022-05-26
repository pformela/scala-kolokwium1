package ninetynine.problems

object P18 {

  def extractSlice[A](a: Int, b: Int, l: List[A]): List[A] = {
    l.slice(a, b)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    println(extractSlice(3, 7, l))
  }
}
