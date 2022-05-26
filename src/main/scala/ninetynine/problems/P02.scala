package ninetynine.problems

import scala.runtime.Nothing$

object P02 {
  def nextToLast[A](l: List[A]): A =
    if(l.length >= 2) l(l.length - 2)
    else l.head

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    println(nextToLast(l))
  }
}
