package models

import org.specs2.mutable.Specification

class MatcherSpecification extends Specification {

  "String matcher" should {
    "match 3 occurrences" in {
      NaiveMatcher.matchPatternToText("ab")("abc bca cab cab") must equalTo(List(0, 9, 13))
    }

    "not match any occurrences" in {
      NaiveMatcher.matchPatternToText("cba")("abc cab bca bac") must beEmpty
    }
  }
}
