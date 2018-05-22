package com.elsevier.hack

import scala.annotation.tailrec
import scala.util.Random

object DawkinsWeasel {

  private val vocab = List(
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
    ' '
  )

  def generateSeedPhrase(): String =
    (0 to 27).map(_ => vocab(Random.nextInt(vocab.length))).mkString

  private val targetPhrase = "METHINKS IT IS LIKE A WEASEL"

  def main(args: Array[String]): Unit = {

    @tailrec
    def findSolution(words: List[String], iterations: Int): Unit = {
//      if (iterations % 10 == 0)
//        println(s"iteration $iterations, word ${words.head}")
      val mutatedWords =
        words.map(phrase => PhraseMutator.mutatePhrase(phrase, vocab))
      val mutatedWithScore =
        mutatedWords.map(phrase => {
          (phrase, Scorer.altScore(phrase, targetPhrase))
        })
      mutatedWithScore.find(_._2 == 28) match {
        case Some(winner) => println(s"Complete after $iterations iterations, winner ${winner._1}")
        case None =>
          val best = mutatedWithScore.maxBy(_._2)._1
          findSolution(Array.fill(100)(best).toList, iterations + 1)
      }
    }

    val startTime = System.currentTimeMillis()
    val seedPhrase = generateSeedPhrase()
    val initialPhrases = Array.fill(100)(seedPhrase)
    println(s"Starting with phrase $seedPhrase")
    findSolution(initialPhrases.toList, 0)
    println(s"Took ${System.currentTimeMillis() - startTime} ms")
  }


}
