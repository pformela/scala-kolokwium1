package ninetynine.problems

object P10 {

  def runLengthEncoding[A](l: List[A]): List[(Int, A)] = {
    l.foldLeft(List[List[A]]())((prev, next) => {
      if(prev.isEmpty) prev :+ List(next)
      else if(prev.last.last != next) prev :+ List(next)
      else prev.slice(0, prev.length - 1) :+ (prev.last :+ next)
    }).map(x => (x.length, x.head))
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    println(runLengthEncoding(l))
  }
}
