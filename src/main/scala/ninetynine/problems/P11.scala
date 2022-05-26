package ninetynine.problems

object P11 {

  def modifiedRunLengthEncoding[A](l: List[A]): List[Any] = {
    l.foldLeft(List[List[A]]())((prev, next) => {
      if(prev.isEmpty) prev :+ List(next)
      else if(prev.last.last != next) prev :+ List(next)
      else prev.slice(0, prev.length - 1) :+ (prev.last :+ next)
    }).map(x => if(x.length > 1) (x.length, x.head) else x.head)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    println(modifiedRunLengthEncoding(l))
  }
}
