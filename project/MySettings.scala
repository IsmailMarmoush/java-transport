import sbt._
import Keys._

object MySettings {

  val scalaSettings: Seq[Def.Setting[String]] = Seq(
    scalaVersion in ThisBuild := "2.12.8"
  )

  val scalaSbtVersion: Seq[Def.Setting[String]] = Seq(
    sbtVersion in Global := "1.2.8"
  )

  // Reference for this flags. https://tpolecat.github.io/2014/04/11/scalac-flags.html
  // https://www.cakesolutions.net/teamblogs/error-handling-pitfalls-in-scala
  val scalacOptions: Seq[String] = Seq(
    "-deprecation", //Emit warning and location for usages of deprecated APIs.
    "-encoding",
    "UTF-8", // yes, this is 2 args
    "-feature", //Emit warning and location for usages of features that should be imported explicitly.
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions", //you might want to cancel it.
    "-unchecked", //Enable additional warnings where generated code depends on assumptions.
    "-Xlint", //Enables Linter
    "-Yno-adapted-args", //Must be something important
    "-Ywarn-dead-code", //Linter Warning for Dead Code
    "-Ywarn-unused:locals",
    "-Ywarn-value-discard",
    "-Ywarn-numeric-widen", //warns if a numeric widening happens
    "-Ywarn-value-discard", //warns if we discarded a value. This is helpful for newcomers
    "-Xfuture", // we enable futures
    "-Ywarn-unused-import", // Warns for unused imports
    "-Ypartial-unification"
    //"-Xfatal-warnings",
  )
}
