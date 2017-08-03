package fr.demandeatonton.programmers.domain

import org.scalatest.{FlatSpec, Matchers}
import MongoFactory._

class MongoFactoryTest  extends FlatSpec with Matchers {

  "The MongoDB Factory" should "provide access to programmers database" in {
    val database = mongoClient.getDatabase("programmers")
    assert(database.name === "programmers")
  }
}
