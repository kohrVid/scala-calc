package com.kohrvid.calculator

import scala.math.pow

class Calculator {}

/*
 * Usage: sbt 'run "10 ** 2"'
 */

object Calculator {
  val Operands = """(\d+)"""
  val Operators = """(\D+)"""

  def main(args: Array[String]) {
    val arg = args(0)

    println(s"${arg} in reverse Polish notation is ${convertToRPN(arg)}.\nThe answer is....")
    println(calculate(convertToRPN(arg)))
  }

  def convertToRPN(str: String): String = {
    val operands = str.split(Operators)
    val operators = str.split(Operands)

    (
      operands.foldLeft("")(_+_+" ") + operators.foldLeft("")(_+_+" ").reverse
    ).replaceAll("""\s+""", " ").trim
  }

  def calculate(str: String) = {
//https://eddmann.com/posts/reverse-polish-notation-rpn-in-scala/
    str.split(' ').toList.foldLeft(List[Double]())(
      (list, token) => (list, token) match {
        case (x :: y :: zs, "**") => pow(y, x) :: zs
        case (x :: y :: zs, "/") => (y / x) :: zs
        case (x :: y :: zs, "*") => (y * x) :: zs
        case (x :: y :: zs, "+") => (y + x) :: zs
        case (x :: y :: zs, "-") => (y - x) :: zs
        case (_, _) => parse(token) :: list
      }
    ).head
  }

  private def parse = java.lang.Double.parseDouble _
}
