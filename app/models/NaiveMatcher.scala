package models

import scala.annotation.tailrec

object NaiveMatcher extends StringMatcher {

  override def matchPatternToText(pattern: String)(text: String) = {

    @tailrec
    def matchFrom(result: List[Int])(from: Int): List[Int] = {
      if (from > text.length - pattern.length) result
      else if (text.substring(from, pattern.length + from) == pattern) matchFrom(from :: result)(pattern.length + from)
      else matchFrom(result)(1 + from)
    }

    matchFrom(Nil)(0) reverse
  }
}
