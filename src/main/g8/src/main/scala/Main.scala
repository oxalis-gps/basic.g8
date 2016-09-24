package $organization$.$name;format="lower,word"$

import com.typesafe.config._

object Main {
  def main(args: Array[String]): Unit = {

    val config = ConfigFactory.load()

    println(config.getString("hello.message"))

    (new GuiApp).main(args)
  }
}
