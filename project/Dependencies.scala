import sbt._

object Dependencies {
  // Logging Support
  val logbackVersion      = "1.2.3"
  val scalaLoggingVersion = "3.9.2"

  // Config Hocoon Support
  val typesafeConfigVersion = "1.3.2"

  lazy val catsVersion     = "1.6.0"
  lazy val akkaVersion     = "2.5.21"
  lazy val akkaHttpVersion = "10.1.8"
  lazy val http4sVersion   = "0.18.23"

  val compileDeps = Seq(
    "com.typesafe"               % "config"               % typesafeConfigVersion,
    "ch.qos.logback"             % "logback-classic"      % logbackVersion,
    "com.typesafe.scala-logging" %% "scala-logging"       % scalaLoggingVersion,
    "com.github.tototoshi"       %% "scala-csv"           % "1.3.5",
    "org.typelevel"              %% "cats-core"           % catsVersion,
    "org.http4s"                 %% "http4s-dsl"          % http4sVersion,
    "org.http4s"                 %% "http4s-blaze-server" % http4sVersion,
    "org.http4s"                 %% "http4s-blaze-client" % http4sVersion
  )

  val testDeps = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  )
}
