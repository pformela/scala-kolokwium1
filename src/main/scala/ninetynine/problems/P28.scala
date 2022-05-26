package ninetynine.problems

object P28 {

  def lsort[A](l: List[List[A]]): List[List[A]] = {
    l.sortBy(x => - x.length)
  }

  def main(args: Array[String]): Unit = {
    val l = List(List('a', 'b', 'c'), List('d', 'e'), List('f', 'g', 'h'), List('d', 'e'), List('i', 'j', 'k', 'l'), List('m', 'n'), List('o'))
    println(lsort(l))
  }
}
