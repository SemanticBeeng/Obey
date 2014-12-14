import org.scalatest.FunSuite

import scala.obey.tools._

class LoaderTest extends FunSuite {

  test("Load a simple Rule from the model.rules folder") {
    val loader = new Loader("./tests/target/scala-2.11/classes")
    loader.rules.foreach(r => println("a rule: "+r))
    assert(loader.rules.size == 2)
  }

  test("From other project") {
    val loader = new Loader("/home/aghosn/Documents/Programs/Scala/IObey/rules/target/scala-2.11/classes")
    loader.rules.foreach(r => println("a rule "+r))
  }

}