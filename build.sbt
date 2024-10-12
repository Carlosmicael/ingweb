ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.16"

lazy val root = (project in file("."))
  .settings(
    name := "Lopez_RedSocial_Reactiva",
    libraryDependencies++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.6.17",
      "com.typesafe.akka" %% "akka-stream" % "2.6.17",
      "com.typesafe.akka" %% "akka-actor-typed" % "2.6.17",
    )
  )