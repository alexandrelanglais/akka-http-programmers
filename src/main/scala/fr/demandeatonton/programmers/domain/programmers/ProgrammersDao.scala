package fr.demandeatonton.programmers.domain.programmers

import fr.demandeatonton.programmers.domain.MongoFactory._
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import fr.demandeatonton.programmers.domain.Helpers._

class ProgrammersDao {

  def list() = {
    collection
  }

  def add(programmer: Programmer) = {
    val doc: Document = Document("_id" -> 0, "name" -> programmer.name,
      "favoriteLanguage" -> programmer.favoriteLanguage)
    collection.insertOne(doc)
  }

  def findByName(name: String) = {
    collection.find(equal("name", name)).first()
  }

  def findFirst() = {
    collection.find().first()
  }
}
