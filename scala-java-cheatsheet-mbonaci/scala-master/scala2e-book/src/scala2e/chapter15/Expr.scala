package scala2e.chapter15

import scala2e.chapter15.expressions.ExprFormatter

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Chapter15 extends App {
  implicit def intToNumber(x: Int) = new Number(x)
  
  val formatter = new ExprFormatter
  formatter.format(
    BinOp("*",
      BinOp("/",
        BinOp("-", 
          BinOp("*", 2, 4),
          8),
        3),
    11))
    
    
  val f = new ExprFormatter

  val e1 = BinOp("*", BinOp("/", 1, 2),
                      BinOp("+", Var("x"), 1))

  val e2 = BinOp("+", BinOp("/", Var("x"), 2),
                      BinOp("/", Number(1.5), Var("x")))
                                                  

  val e3 = BinOp("/", e1, e2)

  def show(e: Expr) = println(f.format(e)+ "\n\n")
    for (e <- Array(e1, e2, e3)) show(e)
  
}