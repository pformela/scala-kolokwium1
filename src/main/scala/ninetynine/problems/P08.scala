package ninetynine.problems

object P08 {

  def compress[A](l: List[A]): List[A] = {
    l.foldLeft(List[A]())((prev, next) => {
      if(prev.isEmpty) prev :+ next
      else if(prev.last != next) prev :+ next
      else prev
    })
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    println(compress(l))
  }
}
