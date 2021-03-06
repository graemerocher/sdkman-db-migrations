package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "003")
class ScalaMigrations {

  @ChangeSet(order = "001", id = "001-add_scala_2_12_6", author = "marc0der")
  def migration001(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.12.6",
      url = "https://downloads.lightbend.com/scala/2.12.6/scala-2.12.6.zip")
      .validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(order = "002", id = "002-add_scala_2_11_11_and_12", author = "marc0der")
  def migration002(implicit db: MongoDatabase) =
    List(
      Version(
        candidate = "scala",
        version = "2.11.11",
        url = "https://downloads.lightbend.com/scala/2.11.11/scala-2.11.11.zip"),
      Version(
        candidate = "scala",
        version = "2.11.12",
        url = "https://downloads.lightbend.com/scala/2.11.12/scala-2.11.12.zip"))
      .validate()
      .insert()
}
