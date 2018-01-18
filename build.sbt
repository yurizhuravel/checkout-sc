import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.yuri",
      scalaVersion := "2.12.3",
      version      := "0.1.0"
    )),
    name := "Checkout",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
    ),
    connectInput in run := true
  )