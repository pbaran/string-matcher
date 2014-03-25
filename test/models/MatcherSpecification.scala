package models

import org.specs2.mutable.Specification

class MatcherSpecification extends Specification {

  val matcher = NaiveMatcher

  "String matcher" should {
    "match 3 occurrences" in {
      matcher.matchPatternToText("ab")("abc bca cab cab") must equalTo(List(0, 9, 13))
    }

    "not match any occurrences" in {
      matcher.matchPatternToText("cba")("abc cab bca bac") must beEmpty
    }
  }
}
