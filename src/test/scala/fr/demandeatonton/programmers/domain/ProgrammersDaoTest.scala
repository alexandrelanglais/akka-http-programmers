package fr.demandeatonton.programmers.domain

import com.mongodb.async.client.Observable
import com.mongodb.diagnostics.logging.Logger
import fr.demandeatonton.programmers.domain.MongoFactory._
import fr.demandeatonton.programmers.domain.programmers.{Programmer, ProgrammersDao}
import org.mongodb.scala.{Completed, Document, Observer}
import org.scalatest.{FlatSpec, Matchers}
import fr.demandeatonton.programmers.domain.Helpers._

class ProgrammersDaoTest extends FlatSpec with Matchers {
  val dao = new ProgrammersDao

  "A programmers DAO" should "be able to add a Programmer" in {
    val programmer = new Programmer("linus torvalds", "C")
    val inserted = dao.add(programmer)
    inserted.printResults()

    inserted.subscribe(new Observer[Completed] {
      override def onError(e: Throwable): Unit = e.printStackTrace()

      override def onComplete(): Unit = {
        val byname = dao.findByName(programmer.name)
        byname.printResults()
        byname.subscribe(new Observer[Document] {
          override def onError(e: Throwable): Unit = e.printStackTrace()

          override def onComplete(): Unit = println("find completed")

          override def onNext(result: Document): Unit = {
            println(result)
            assert(result.contains(programmer.name))
          }
        })
      }

      override def onNext(result: Completed): Unit = {
        println("on next")
      }
    })

  }
}
