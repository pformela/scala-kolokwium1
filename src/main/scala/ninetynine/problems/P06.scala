package ninetynine.problems

import scala.annotation.tailrec

object P06 {

  def isPalindrome[A](l: List[A]): Boolean = {
    @tailrec
    def isPalindromeHelper(i: Int, result: Boolean): Boolean = {
      if(l.length % 2 == 0 && i >= l.length / 2) result
      else if(l.length % 2 == 1 && i >= l.length / 2 + 1) result
      else isPalindromeHelper(i+1, result && (l(i) == l(l.length - i - 1)))
    }
    isPalindromeHelper(0, true)
  }


  def main(args: Array[String]): Unit = {
    val l = List(1, 2, 3, 2, 1)
    val l2 = List(1, 2, 3, 4, 2, 1)

    println(isPalindrome(l))
    println(isPalindrome(l2))
  }
}
