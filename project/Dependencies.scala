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

  val compileDeps = Seq(
    "com.typesafe"               % "config"                % typesafeConfigVersion,
    "ch.qos.logback"             % "logback-classic"       % logbackVersion,
    "com.typesafe.scala-logging" %% "scala-logging"        % scalaLoggingVersion,
    "org.typelevel"              %% "cats-core"            % catsVersion,
    "com.typesafe.akka"          %% "akka-http"            % akkaHttpVersion,
    "com.typesafe.akka"          %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka"          %% "akka-testkit"         % akkaVersion
  )

  val testDeps = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  )
}
