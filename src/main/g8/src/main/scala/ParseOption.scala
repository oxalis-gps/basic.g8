package $organization$

import java.io.File

import net.bmjames.opts._

import scalaz.NonEmptyList
import scalaz.syntax.applicativePlus._


object ParseOption {
  case class Opts(inputs: NonEmptyList[File], enc: String)

  val parseOpts: Parser[Opts] =
    ^(
      some(strArgument(metavar("FILEPATH"), help("Files to read")).map(new File(_))),
      strOption(long("encode"), metavar("UTF8"), help("file encode"), value("utf8"))
    )(Opts.apply)

  // 1引数のみを受け付ける版
  // val parseOpts: Parser[Opts] = some(strArgument(metavar("CSVFILE"), help("Files to read")).map(new File(_))).map(Opts)

  val opts: ParserInfo[Opts] = info(parseOpts <*> helper)

  def parse(args: Array[String]) = execParser(args, "$name;format="norm"$", opts)
}
