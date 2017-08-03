package fr.demandeatonton.programmers.domain

import org.mongodb.scala._
import org.mongodb.scala.model.Aggregates._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._
import org.mongodb.scala.model.Updates._
import org.mongodb.scala.model._

object MongoFactory {
  val DATABASE_NAME = "programmers"

  val mongoClient: MongoClient = MongoClient()

  val database = mongoClient.getDatabase(DATABASE_NAME)
  val collection:MongoCollection[Document] = database.getCollection("programmers")

}
