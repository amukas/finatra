name := "twitter-clone"
organization := "com.twitter.finatra.example"
version := "2.1.2-SNAPSHOT"
scalaVersion := "2.11.7"
parallelExecution in ThisBuild := false

lazy val versions = new {
  val finatra = "2.1.2-SNAPSHOT"
  val logback = "1.0.13"
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com"
)

assemblyMergeStrategy in assembly := {
  case "BUILD" => MergeStrategy.discard
  case other => MergeStrategy.defaultMergeStrategy(other)
}

libraryDependencies ++= Seq(
  "com.twitter.finatra" %% "finatra-http" % versions.finatra,
  "com.twitter.finatra" %% "finatra-httpclient" % versions.finatra,
  "com.twitter.finatra" %% "finatra-slf4j" % versions.finatra,
  "com.twitter.inject" %% "inject-core" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % versions.logback,

  "com.twitter.finatra" %% "finatra-http" % versions.finatra % "test->test",
  "com.twitter.finatra" %% "finatra-jackson" % versions.finatra % "test->test",
  "com.twitter.inject" %% "inject-app" % versions.finatra % "test->test",
  "com.twitter.inject" %% "inject-core" % versions.finatra % "test->test",
  "com.twitter.inject" %% "inject-modules" % versions.finatra % "test->test",
  "com.twitter.inject" %% "inject-server" % versions.finatra % "test->test",

  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.scalatest" %% "scalatest" % "2.2.3" % "test",
  "org.specs2" %% "specs2" % "2.3.12" % "test")
