import scala.annotation.tailrec
import scala.collection.immutable.HashMap

/*
    Wykorzystując rekurencję (wyłącznie ogonową) zdefiniuj funkcję:

        def countResults[A,B,C](l1: List[A], l2: List[B])(f: (A, B) => C): Set[(C, Int)]

    która zaaplikuje funkcję „f” do elementów l1(i), l2(i), gdzie 0 <= i < min(l1.length, l2.length)
    oraz zwróci zbiór składający się z par:

        (wynik funkcji f, liczba par dla których f zwróciła dany wynik).

    Przykładowo dla:

        countResults(List(1,2,3), List(4,5,4,6))(_+_) == Set((5,1), (7,2))

    ponieważ: 1+4 = 5, 2+5 = 7, 4+3 = 7, 6 pomijamy bo to „nadmiarowy” element w drugiej z list.

    W rozwiązaniu należy skorzystać z mechanizmu dopasowania do wzorca (pattern matching).
    Nie używaj zmiennych ani „pętli” (while, for bez yield, foreach).
*/
object zad1 {
    def countResults[A,B,C](l1: List[A], l2: List[B])(f: (A, B) => C): Set[(C, Int)] = {
        @tailrec
        def countResultsHelper(l1tail: List[A], l2tail: List[B], result: HashMap[C, Int]): HashMap[C, Int] = l1tail match {
            case head1 :: tail1 if l2tail.nonEmpty => {
                countResultsHelper(tail1, l2tail.tail,{
                    val res = f(head1, l2tail.head)
                    if(result.contains(res)) result + (res -> (result(res) + 1))
                    else result + (res -> 1)
                })
            }
            case _ => result
        }

        val result = countResultsHelper(l1, l2, new HashMap[C, Int]())
        result.keys.foldLeft(Set[(C, Int)]())((prev, next) => {
            prev + ((next, result(next)))
        })
    }

    def main(args: Array[String]): Unit = {
        println(countResults(List(4,5,4,6), List(1,2,3))(_+_))
    }
}
