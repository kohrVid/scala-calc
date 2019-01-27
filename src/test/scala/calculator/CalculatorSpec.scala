package com.kohrvid.calculator

import org.scalatest._

class CalculatorSpec extends FunSpec with Matchers {
  describe("convertToRPN") {
    it("converts infix sum to postfix sum") {
      Calculator.convertToRPN("1 + 2") shouldEqual "1 2 +"
    }
  }

  describe("calculate") {
    it("can handle powers") {
      Calculator.calculate("3 2 **") shouldEqual 9.0
    }

    it("can divide two numbers") {
      Calculator.calculate("3 2 /") shouldEqual 1.5
    }

    it("can multiply two numbers") {
      Calculator.calculate("3 2 *") shouldEqual 6.0
    }

    it("can add two numbers") {
      Calculator.calculate("3 2 +") shouldEqual 5.0
    }

    it("can subtract two numbers") {
      Calculator.calculate("3 2 -") shouldEqual 1.0
    }

    it("can calculate sum of more than two numbers") {
      Calculator.calculate("3 2 2 * +") shouldEqual 7.0
    }

    it("can handle large numers") {
      Calculator.calculate("30 20 2 * +") shouldEqual 70.0
    }
  }
}
