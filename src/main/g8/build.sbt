lazy val commonSettings = Seq(
  organization := "$package$",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.8",
  test in assembly := {}
)


lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "$application_name$",

    libraryDependencies ++= Seq(
      "org.skinny-framework" %% "skinny-orm"      % "2.1.0",
      "com.h2database"       %  "h2"              % "1.4.191",
      "ch.qos.logback"       %  "logback-classic" % "1.1.+",
      "org.seleniumhq.selenium" % "selenium-htmlunit-driver" % "2.52.0",
      "com.github.tototoshi" % "scala-csv_2.11" % "1.3.3",
      "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
      "net.databinder.dispatch" %% "dispatch-json4s-native" % "0.11.2"
    ),

    mainClass in assembly := Some("$package$.Main"),

    fork := true,
    fork in run := false,
    connectInput in run := true,

    javaOptions ++= Seq(
      "-Djava.library.path=.:./lib"
    ),

    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-language:experimental.macros",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xlint",
      "-Yinline-warnings",
      "-Ywarn-dead-code",
      "-Xfuture"
    )
  )
