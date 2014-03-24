package models

import scala.annotation.tailrec

object NaiveMatcher extends StringMatcher {

  override def matchPatternToText(pattern: String)(text: String) = {
    @tailrec
    def matchTextBeginningFrom(i: Int)(result: List[Int]): List[Int] = {
      if (i == text.length) result
      else matchTextBeginningFrom(i+1){
        if (text.substring(i).startsWith(pattern)) i :: result
        else result
      }
    }

    matchTextBeginningFrom(0)(Nil) reverse
  }
}
