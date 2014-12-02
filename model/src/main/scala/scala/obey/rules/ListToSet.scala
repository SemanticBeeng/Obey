package scala.obey.rules

import scala.meta.syntactic.ast._
import tqlscalameta.ScalaMetaTraverser._
import scala.obey.model._
import scala.obey.tools.Utils._

@Tag("List", "Set") object ListToSet extends Rule {
  val name = "ListToSet: defining List.toSet is defining a Set"

  def message(t: Defn.Val): Message = Message(s"The assignment $t creates a useless List") 

  def apply = {
    (collect {
      case t @ Defn.Val(mod, n, None, Term.Select(Term.Apply(Term.Name("List"), l), Term.Name("toSet"))) =>
        message(t)
    } <~
      update {
      case Defn.Val(mod, n, None, Term.Select(Term.Apply(Term.Name("List"), l), Term.Name("toSet"))) =>
        Defn.Val(mod, n, None, Term.Apply(Term.Name("Set"), l))
      }).down 
  }
}