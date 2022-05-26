package ninetynine.problems

object P12 {

  def decodeRunLengthEncodedList[A](l: List[(Int, A)]): List[A] = {
    l.foldLeft(List[List[A]]())((prev, next) => {
      prev :+ List.fill(next._1)(next._2)
    }).flatten
  }


  def main(args: Array[String]): Unit = {
    val l = List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e'))
    println(decodeRunLengthEncodedList(l))
  }
}
