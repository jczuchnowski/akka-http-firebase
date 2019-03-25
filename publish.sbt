ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/jczuchnowski/akka-http-firebase"),
    "scm:git@github.com:jczuchnowski/akka-http-firebase.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "jczuchnowski",
    name  = "Jakub Czuchnowski",
    email = "jakub.czuchnowski@gmail.com",
    url   = url("https://github.com/jczuchnowski")
  )
)

//ThisBuild / description := "Some descripiton about your project."
ThisBuild / licenses := List("CC0" -> new URL("https://github.com/jczuchnowski/akka-http-firebase/blob/master/LICENSE.md"))
ThisBuild / homepage := Some(url("https://github.com/jczuchnowski/akka-http-firebase"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
