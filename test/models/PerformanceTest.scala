package models

import org.scalatest._

class PerformanceTest extends FlatSpec with Matchers {

  val matcher = KMPStringMatcher

  "matcher" should "execute" in {
      val timer = new Timer
      val n = 100000;
      val pattern = "a" + "b"
//    val pattern = "a" * (n / 2) + "b"
      val text = "a" * n + "b"
      timer.timeDiff()
      for (i <- 1 to 10) {
        matcher.find(pattern)(text)
        println(timer.timeDiff())
      }
    }

}
