package ninetynine.problems

import scala.collection.immutable.HashMap

object P13 {

  def runLengthEncodingDirect[A](l: List[A]): List[(Int, A)] = {
    l.foldLeft(new HashMap[A, Int]())((prev, next) => {
      if(prev.contains(next)) prev + (next -> (prev(next) + 1))
      else prev + (next -> 1)
    }).map((k, v) => (v, k)).toList
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    println(runLengthEncodingDirect(l))
  }
}
