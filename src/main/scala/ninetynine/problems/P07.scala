package ninetynine.problems

object P07 {

  def flattenNestedList(l: List[Any]): List[Any] = l flatMap {
    case i: List[_] => flattenNestedList(i)
    case e => List(e)
  }

  def main(args: Array[String]): Unit = {
    val l = List(List(1, 1), 2, List(3, List(5, 8)))
    println(flattenNestedList(l))
  }
}
