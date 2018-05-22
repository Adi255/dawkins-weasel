package com.elsevier.hack

import org.scalatest.{FlatSpec, Matchers}

class ScorerSpec extends FlatSpec with Matchers {

  "Scorer" should "calculate correct edit distance" in {
    val stringA = "THIS IS WRONG"
    val stringB = "THIS IS RIGHT"

    val score = Scorer.altScore(stringA, stringB)
    score shouldBe 8
  }

  it should "get 28" in {
    val input = "METHINKS IT IS LIKE A WEASEL"
    val target = "METHINKS IT IS LIKE A WEASEL"

    val score = Scorer.altScore(input, target)
    score shouldBe 28
  }

}
