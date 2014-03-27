package models

import org.scalatest._

class PerformanceTest extends FlatSpec with Matchers {

  val matcher = NaiveMatcher

  "matcher" should "execute" in {
      val timer = new Timer
      val n = 100000;
      val pattern = "a" * (n / 2) + "b"
      val text = "a" * n + "b"
      timer.timeDiff()
      matcher.matchPatternToText(pattern)(text)
      println(timer.timeDiff())
    }

}
