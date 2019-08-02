val sharedSettings = Seq(
  organization := "com.raasahsan",
  version := "0.1.0",

  scalaVersion := "2.13.0",

  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding", "utf-8",
    "-explaintypes",
    "-feature",
    "-language:implicitConversions",
    "-language:higherKinds",
    "-unchecked",
    "-Xfatal-warnings",
    "-Ywarn-dead-code",
    "-Ywarn-nullary-unit",
    "-Ywarn-numeric-widen",
    "-Ywarn-unused:implicits",
    "-Ywarn-unused:imports",
    "-Ywarn-unused:locals",
    "-Ywarn-unused:params",
    "-Ywarn-unused:patvars",
    "-Ywarn-unused:privates",
    "-Ywarn-value-discard"
  )
)

val testSettings = Seq(
  scalacOptions in Test ++= Seq("-Yrangepos")
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "rex"
  )
  .settings(sharedSettings)
  .settings(testSettings)
  .dependsOn(rexAst, rexParser, rexCompiler, rexInterpreter)
  .aggregate(rexAst, rexParser, rexCompiler, rexInterpreter)

lazy val rexAst = project
  .in(file("./rex-ast"))
  .settings(
    name := "rex-ast"
  )
  .settings(sharedSettings)
  .settings(testSettings)

lazy val rexParser = project
  .in(file("./rex-parser"))
  .settings(
    name := "rex-parser"
  )
  .settings(sharedSettings)
  .settings(testSettings)

lazy val rexCompiler = project
  .in(file("./rex-compiler"))
  .settings(
    name := "rex-compiler",

    libraryDependencies ++= Seq(
      "org.ow2.asm" % "asm" % "7.1"
    )
  )
  .settings(sharedSettings)
  .settings(testSettings)
  .dependsOn(rexAst)

lazy val rexInterpreter = project
  .in(file("./rex-interpreter"))
  .settings(
    name := "rex-interpreter"
  )
  .settings(sharedSettings)
  .settings(testSettings)
