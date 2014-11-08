/**
 * 	Model for a Rule.
 * 	TODO continue implementation
 * 	@author Adrien Ghosn
 */
/*TODO Abandon the context thing for the moment*/
/*TODO what would be the best way to enforce a method to apply the rule ?*/
package scala.obey.model

import scala.meta._

object Rule {
}

/*TODO def warning instead of vla */
trait Rule {
  /** Identifier to pretty print and identity the rule*/
  val name: String
}

trait Msg {
  val message: String
}

trait RuleWarning extends Rule {
  Keeper.warners :+= this
  
  def warning(t: Tree): Warning

  case class Warning(message: String) extends Msg {
    val rule = this
  }

  def apply(t: Tree): List[Warning]
}

trait RuleError extends Rule {
  /*TODO change this*/
  def error(t: Tree): Error

  case class Error(message: String) extends Msg {
    val rule = this
    /*TODO maybe exception here or something*/
  }
}

trait RuleFormat extends Rule {
  Keeper.formatters :+= this
}