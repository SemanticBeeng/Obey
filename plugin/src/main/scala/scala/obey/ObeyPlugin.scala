/**
 * 	Main component of the compiler plugin.
 *
 * 	@author Adrien Ghosn
 */
package scala.obey

import scala.tools.nsc.{ Global, Phase, SubComponent }
import scala.tools.nsc.plugins.{ Plugin => NscPlugin, PluginComponent => NscPluginComponent }
import scala.obey.utils._

class ObeyPlugin(val global: Global) extends NscPlugin with ObeyPhase {
  import global._

  val name = "obey"
  val description = """Compiler plugin that checks defined rules against scalameta trees.
  http://github.com/aghosn/Obey for more informations."""
  val components: List[NscPluginComponent] = List[NscPluginComponent](ObeyComponent)

  override def processOptions(options: List[String], error: String => Unit) {
    options.foreach {
      o =>
    
    }
  }
}