import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.github.jczuchnowski",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT",
      scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
    )),
    name := "akka-http-firebase",
    libraryDependencies ++= (mainDeps :+ scalaTest % Test)

  )

publishTo := Some("Sonatype Snapshots Nexus" at "https://oss.sonatype.org/content/repositories/snapshots")
