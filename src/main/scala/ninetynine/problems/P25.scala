package ninetynine.problems

import scala.util.Random

object P25 {

  def generatePermutation[A](l: List[A]): List[A] = {
    val random = new Random
    val perm = l.permutations.toList
    perm(random.nextInt(perm.length))
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f')
    println(l)
    println(generatePermutation(l))
  }
}
