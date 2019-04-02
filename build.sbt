lazy val root =
  project
    .in(file("."))
    .settings(name := "transport", description := "transport", organization := "com.marmoush", version := "0.0.1")
    .settings(MySettings.scalaSettings)
    .settings(clippyColorsEnabled := true)
    .settings(scalacOptions ++= MySettings.scalacOptions)
    .settings(libraryDependencies ++= Dependencies.compileDeps ++ Dependencies.testDeps)
