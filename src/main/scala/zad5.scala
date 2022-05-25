/*
    Korzystając wyłącznie z operacji na kolekcjach (w szczególności nie możesz uzyć rekurencji
    ani mechanizmów imperatywnych, takich jak zmienne i pętle) zdefiniuj funkcję:

        def findPairs(n: Int): Set[(Int,Int)]

    taką, że dowolnej liczby całkowitej N > 1

        findPairs(N)

    zawiera wszystkie pary postaci (p1, p2), gdzie p1 i p2 są liczbami
    pierwszymi takimi, że p1 + p2 = 2 * N oraz p1 <= p2.

*/
object zad5 {

    def isPrime(n: Int): Boolean =
        (n > 1) && !(2 to scala.math.sqrt(n).toInt).exists(x => n % x == 0)

    def findPairs(n: Int): Set[(Int,Int)] = {
        (for {
            p1 <- 2 to n
            if isPrime(p1) && isPrime(2 * n - p1)
        } yield (p1, 2 * n - p1)).toSet
    }

    def main(args: Array[String]): Unit = {
        println(findPairs(4))
        println(findPairs(3))
        println(findPairs(20))
        println(findPairs(15))
    }
}
