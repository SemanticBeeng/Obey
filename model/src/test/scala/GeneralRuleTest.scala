import org.scalatest.FunSuite
import scala.meta._
import syntactic._
import scala.obey.Rules.VarInsteadOfVal
import scala.obey.model._

class GeneralRuleTest extends FunSuite {

  def showTree(x: Tree) = show.ShowOps(x).show[syntactic.show.Raw]

  val x: Tree =
    q"""
    			var a = 5
          var c = 3
          c = 5
					if (1 == 1) a = 1
					else a = 2
					
				"""
  test("Simply printing a tree") {
    println(showTree(x));
  }

  val v = VarInsteadOfVal

  /*This fails for the moment*/
  test("Testing the var i val rule ") {
    val l = v(x)
    println("The list of warnings: "+l)
    assert(l.size == 1)
  }

  test("Keeper tracks the Rules") {
    assert(Keeper.warners.size == 1, "Fail in number of warners")
    assert(Keeper.formatters == Nil, "Fail in number of formatters")
    assert(Keeper.errs == Nil, "Fail in number of errs")
  }

  test("Print the tree with overrides") {
    val y: Tree = 
      q"""
        abstract class bla extends Blo {

        }
      """
      println(showTree(y))
  }
}