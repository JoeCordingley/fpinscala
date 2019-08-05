trait Parsers[ParseError, Parser[_]] { self =>

  def run[A](p: Parser[A], input: String): Either[ParseError, A]

  def char(c: Char): Parser[Char]

  def or[A](s1: Parser[A], s2: Parser[A]):Parser[A]

  def listOfN[A](n: Int, parser: Parser[A]):Parser[List[A]]

  def many[A](p: Parser[A]): Parser[List[A]]

  def map[A, B](a: Parser[A], f: A => B): Parser[B]

  implicit def string(s: String): Parser[String]

  implicit class ParserOps[A](p:Parser[A]){
    def or(p2: => Parser[A]): Parser[A] = self.or(p,p2)
    def |(p2: => Parser[A]): Parser[A] = self.or(p,p2)
  }

}
