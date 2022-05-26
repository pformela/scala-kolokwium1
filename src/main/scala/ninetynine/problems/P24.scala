package ninetynine.problems

import scala.util.Random

object P24 {

  def lotto(amount: Int, to: Int): List[Int] = {
    val random = new Random
    (for(i <- 1 to amount) yield random.nextInt(to)).toList
  }

  def main(args: Array[String]): Unit = {
    println(lotto(6, 49))
  }
}
