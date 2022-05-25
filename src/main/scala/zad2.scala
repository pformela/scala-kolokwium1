import scala.annotation.tailrec

/*
  Używając rekurencji ogonowej zdefiniuj funkcję:

    def pairwiseTest[A](l: List[A])(pred: (A, A) => Boolean)

  która sprawdzi, czy predykat „pred" jest spełniony dla wszystkich par
  elementów listy „l” o indeksach (i, długość(l) - i), dla i = 0.. długość(l)/2.

  Przykładowo, dla listy List(1,2,3,4,3,2,1) oraz predykatu równości, sprowadzi
  się to do następującej serii weryfikacji równości:

    l(0) == l(6)
    l(1) == l(5)
    l(2) == l(4)
    l(3) == l(3)

  Ogólnie, seria taka będzie miała postać:

    pred(l(0), l(l.length-1)) == true
    pred(l(1), l(l.length-2)) == true
    pred(l(2), l(l.length-3)) == true
    ...
    pred(l(l.length/2), l(l.length - l.length/2 - 1)) == true

  W przypadku pustej listy funkcja powinna zwrócić true

  Uwaga: w rozwiązaniu nie używaj zmiennych, ani mechanizmów imperatywnych jak pętle.
  Nie używaj też kolekcji języka Scala.
*/

//(1,2,3,4,3,2,1)
//(1,2,3,3,2,1)

object zad2 {
    def pairwiseTest[A](l: List[A])(pred: (A, A) => Boolean):Boolean = {
        @tailrec
        def pairwiseTestHelper(index: Int, last: Int, result: Boolean): Boolean = {
            if(index >= last && l.length % 2 == 1) pred(l(index), l(index)) && result
            else if(index >= last && l.length % 2 == 0) pred(l(index), l(l.length - index - 1)) && result
            else pairwiseTestHelper(index + 1, last, pred(l(index), l(l.length - index - 1)) && result)
        }

        pairwiseTestHelper(0, if(l.length % 2 == 0) l.length / 2  else l.length / 2 + 1, true)
    }

    def main(args: Array[String]): Unit = {
        val l1 = List(1,2,3,4,3,2,1)
        val l2 = List(1,2,3,3,2,1)
        val l3 = List(1,2,3,4,5,3,2,1)
        val l4 = List(1,2,3,4,4,2,1)
        println(pairwiseTest(l1)(_ == _))
        println(pairwiseTest(l2)(_ == _))
        println(pairwiseTest(l3)(_ == _))
        println(pairwiseTest(l4)(_ == _))
    }
}
