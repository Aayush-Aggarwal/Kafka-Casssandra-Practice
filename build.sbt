name := "kafka-kip-example"

version := "1.0"

scalaVersion := "2.12.3"
libraryDependencies ++= Seq(
  "com.datastax.cassandra" % "cassandra-driver-extras" % "3.0.0",
  "com.typesafe"               %  "config"           % "1.3.1",
  "org.apache.kafka" % "kafka-clients" % "0.11.0.0"

)
libraryDependencies += "org.twitter4j" % "twitter4j-core" % "4.0.6"