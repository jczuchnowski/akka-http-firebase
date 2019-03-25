import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.github.jczuchnowski",
      scalaVersion := "2.12.8",
      version      := "0.1.1-SNAPSHOT",
      scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
    )),
    name := "akka-http-firebase",
    libraryDependencies ++= (mainDeps :+ scalaTest % Test)

  )
