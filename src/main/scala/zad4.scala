import scala.collection.immutable.HashMap

/*
    Korzystając wyłącznie z mechanizmów kolekcji języka Scala znajdź kraj o najdłużej rosnącym wskaźniku LadderScore.
    Innymi słowy, korzystając z załączonych danych szukamy kraju, dla którego wskaźnik LadderScore najdłużej
    utrzymał „dobrą passę” (z roku na rok się zwiększał).

    Zwróć uwagę na to, że w danych mogą wystąpić „linie” z brakującymi danymi. Takie linie powinny zostać
    POMINIĘTE. Brakujące dane oznaczają, że w linii występują sekwencje postaci: ,,, przykładowo:

        Kosovo,2020,6.294,,0.792,,0.880,,0.910,0.726,0.201

    Linie takie, jako „niewiarygodne” należy pominąć (oczywiście nie zmieniając samego pliku danych)
    zanim program rozpocznie analizę.

    W razwiązaniu nie wolno uzywać zmiennych, ani konstrukcji imperatywnych, takich jak pętle
*/

object zad4 {

    case class CountryData(
        CountryName : String,
        Year : String,
        LadderScore : String,
        LogGDPPerCapita : String,
        SocialSupport : String,
        HealthyLifeExpectancyAtBirth : String,
        FreedomToMakeLifeChoices : String,
        Generosity : String,
        PerceptionsOfCorruption : String,
        PositiveAffect : String,
        NegativeAffect : String
    )


    def main(args: Array[String]): Unit = {
        val wyniki = io.Source
            .fromResource("world-happiness-report.csv")
            .getLines()
            .toList
            .filterNot(p => p matches "(.*,{2,}.*)|.*,$")

        val countries = wyniki.foldLeft(new HashMap[String, List[List[Double]]]())((prev, next) => {
            val country = next.split(",").toList
            if(country.head.nonEmpty){
                if (prev.contains(country.head))
                    prev + (country.head -> (prev(country.head) :+ country.tail.map(n => n.toDouble)))
                else prev + (country.head -> List(country.tail.map(n => n.toDouble)))
            } else prev
        }).map((k, v) => k -> v.sortBy(row => row(0)).transpose)

        val maxLadderScores = countries.keys.foldLeft(List[(String, Int)]())((prev, next) => {
            prev :+ (next, countries(next)(1).sliding(2, 1).toList.map(x => if(x.length >= 2) x(0) < x(1) else true).foldLeft(List[Int]())((prev2, next2) => {
                if(prev2.length == 0 && next2) prev2 :+ 1
                else if(prev2.length >= 1 && next2) prev2 :+ (prev2.last + 1)
                else prev2 :+ 1
            }).max)
        }).sortBy(x => -x._2)

        val maxScore = maxLadderScores(0)._2
        val finalResult = maxLadderScores.filter(x => x._2 == maxScore)

        println(finalResult)
    }

}
