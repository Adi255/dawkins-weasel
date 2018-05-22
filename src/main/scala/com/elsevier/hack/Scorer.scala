package com.elsevier.hack

import org.apache.commons.text.similarity.LevenshteinDistance

object Scorer {

  def calculateScore(phrase: String, target: String): Int = {
    val levenshteinDistance = LevenshteinDistance.getDefaultInstance.apply(phrase, target)
    target.length - levenshteinDistance
  }

  def altScore(phrase: String, target: String): Int =
    phrase.toCharArray.toList.zip(target.toCharArray.toSeq).map {
      case (charA, charB) => if (charA == charB) 1 else 0
    }.sum

}
