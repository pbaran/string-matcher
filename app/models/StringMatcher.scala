package models

trait StringMatcher {

  def matchPatternToText(pattern: String)(text: String): List[Int]
}
