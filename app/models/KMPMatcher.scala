package models

class KMPMatcher[T] extends MatchFinder[T] {

  override def find(pattern: Seq[T])(body: Seq[T]): Seq[Int] = {
    val table: Array[Int] = constructTable(pattern)
    var startIndex, matchSize = 0;
    var found: List[Int] = Nil
    while (startIndex + matchSize < body.length) {
      if (pattern(matchSize) == body(startIndex+matchSize))
       if (matchSize + 1 == pattern.length) {
          found = startIndex :: found
          matchSize = 0
          startIndex += pattern.length
        } else matchSize += 1
      else {
        startIndex += matchSize - table(matchSize)
        matchSize = Math.max(0, table(matchSize))
      }
    }
    found reverse
  }

  private def constructTable(pattern: Seq[T]) = {
    val n = pattern.length
    val t = Array.fill(n)(0)
    t(0) = -1
    var i = 2
    var j = 0
    while (i < n)
      if (pattern(i - 1) == pattern(j)) {
        j += 1
        t(i) = j
        i += 1
      } else if (j>0) j = t(j)
      else {
        t(i) = 0
        i += 1
      }
    t
  }
}

object KMPStringMatcher extends KMPMatcher[Char] {

  def find(pattern: String)(body: String): Seq[Int] = super.find(pattern)(body)
}
