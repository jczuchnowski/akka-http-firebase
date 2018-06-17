import sbt._

object Dependencies {
  lazy val mainDeps = Seq(
    "com.typesafe.akka" %% "akka-http" % "10.0.11",
    "com.google.firebase" % "firebase-admin" % "6.2.0"
  )
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
}
