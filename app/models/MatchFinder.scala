package models

trait MatchFinder[T] {

  def find(pattern: Seq[T])(body: Seq[T]): Seq[Int]
}
