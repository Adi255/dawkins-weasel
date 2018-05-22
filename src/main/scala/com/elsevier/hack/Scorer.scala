package com.elsevier.hack

object Scorer {

  def altScore(phrase: String, target: String): Int =
    phrase.toCharArray.toList.zip(target.toCharArray.toSeq).map {
      case (charA, charB) => if (charA == charB) 1 else 0
    }.sum

}
