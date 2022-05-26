package ninetynine.problems

import scala.util.Random

object P23 {

  def randomSelect[A](items: Int, l: List[A]): List[A] = {
    val random = new Random
    (for {
      i <- 1 to items
    } yield l(random.nextInt(l.length))).toList
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
    println(randomSelect(3, l))
    println(randomSelect(4, l))
    println(randomSelect(5, l))
    println(randomSelect(6, l))
  }
}
