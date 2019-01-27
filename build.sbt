name := "calculator"

scalaVersion := "2.12.7"

scalacOptions ++= Seq("-deprecation")


val AkkaVersion = "2.5.19"
val AkkaHttpVersion = "10.1.7"
val ScalatestVersion = "3.0.4"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "com.typesafe.akka" %% "akka-stream-testkit" % AkkaVersion % Test,
  "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpVersion % Test,
  "org.mockito" % "mockito-core" % "2.13.0" % Test,
  "org.scalatest" %% "scalatest" % ScalatestVersion % Test
)

mainClass in (Compile, run) := Some("com.kohrvid.calculator.Calculator")
