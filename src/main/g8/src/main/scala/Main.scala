package $organization$

import com.typesafe.config._
import com.typesafe.scalalogging.LazyLogging
import scala.io.Source

object Main extends LazyLogging {
  def main(args: Array[String]): Unit = {
    // コンフィグファイルのロードと使用
    val config = ConfigFactory.load()
    logger.info(config.getString("hello.message"))

    // コマンド引数のパース処理
    val parsedOpt = ParseOption.parse(args)

    // ファイルの読込
    val source = Source.fromFile(parsedOpt.inputs.head, parsedOpt.enc)
    source.getLines.foreach( x => logger.info(x) )

    (new GuiApp).main(args)
  }
}