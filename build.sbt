name := "string-matcher"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.scalatest" %% "scalatest" % "2.1.0" % "test"
)     

play.Project.playScalaSettings
