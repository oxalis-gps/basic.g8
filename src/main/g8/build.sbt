val Version = "0.1-SNAPSHOT"

lazy val commonSettings = Seq(
  organization := "$package$",
  version := Version,
  scalaVersion := "2.11.8",
  test in assembly := {}
)

lazy val scalismoSettings = Seq(
  resolvers ++= Seq(
    "shapemodelling unibas" at "http://shapemodelling.cs.unibas.ch/repository/public"
  ),
  libraryDependencies ++= Seq(
    "ch.unibas.cs.gravis" %% "scalismo" % "0.13.+",
    "ch.unibas.cs.gravis" % "scalismo-native-all" % "3.0.+",
    "ch.unibas.cs.gravis" %% "scalismo-ui" % "0.9.+",
    "ch.unibas.cs.gravis" %% "scalismo-sampling" % "0.3.+"
  )
)

lazy val dispatchSettings = Seq(
  libraryDependencies ++= Seq(
    "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
    "net.databinder.dispatch" %% "dispatch-json4s-native" % "0.11.2"
  )
)

lazy val kuromojiSettings = Seq(
  libraryDependencies ++= Seq(
    "com.atilika.kuromoji" % "kuromoji-core" % "0.9.0",
    "com.atilika.kuromoji" % "kuromoji-unidic" % "0.9.0",
    "com.atilika.kuromoji" % "kuromoji-ipadic" % "0.9.0"
  )
)

lazy val awsLambdaSettings = Seq(
  libraryDependencies ++= Seq(
    "com.amazonaws" % "aws-lambda-java-core" % "1.1.0",
    "com.amazonaws" % "aws-lambda-java-events" % "1.3.0",
    "com.amazonaws" % "aws-lambda-java-log4j" % "1.0.0"
  )
)

lazy val scalaFxSettings = Seq(
  libraryDependencies ++= Seq(
    "org.scalafx" %% "scalafx" % "8.0.102-R11"
  )
)

lazy val twitter4jSettings = Seq(
  libraryDependencies ++= Seq(
    "org.twitter4j" % "twitter4j-core" % "4.0.4"
  )
)

lazy val typesafeConfigSettings = Seq(
  libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.3.0"
  )
)

lazy val akkaConfigSettings = Seq(
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.4.10"
  )
)

lazy val skinnyORMSettings = Seq(
  libraryDependencies ++= Seq(
    "org.skinny-framework" %% "skinny-orm"      % "2.1.0",
    "com.h2database"       %  "h2"              % "1.4.191",
    "ch.qos.logback"       %  "logback-classic" % "1.1.+"
  )
)

lazy val scalaCsvSettings = Seq(
  libraryDependencies ++= Seq(
    "com.github.tototoshi" % "scala-csv_2.11" % "1.3.3"
  )
)

lazy val root = (project in file(".")).
  enablePlugins(JavaAppPackaging).
  settings(commonSettings: _*).
  settings(scalaFxSettings: _*).
  settings(scalismoSettings: _*).
  settings(
    name := "$application_name$",

    libraryDependencies ++= Seq(
      "org.seleniumhq.selenium" % "selenium-htmlunit-driver" % "2.52.0",
    ),

    mainClass in assembly := Some("$package$.Main"),
    assemblyJarName in assembly := "$application_name$-%s.jar" format(Version),

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
