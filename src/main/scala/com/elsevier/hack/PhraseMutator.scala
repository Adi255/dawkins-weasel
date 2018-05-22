package com.elsevier.hack

import scala.annotation.tailrec
import scala.util.Random

object PhraseMutator {

  def mutatePhrase(phrase: String, vocab: List[Char]): String = {

    def mutate() = vocab(Random.nextInt(vocab.length))

    def doMutate() = Random.nextInt() % 20 == 0

    @tailrec
    def helper(remainingChars: List[Char], buildingPhrase: Seq[Char]): Seq[Char] = {
      remainingChars match {
        case Nil => buildingPhrase
        case chars =>
          if(doMutate())
            helper(chars.tail, buildingPhrase :+ mutate)
          else
            helper(chars.tail, buildingPhrase :+ chars.head)
      }
    }

    helper(phrase.toCharArray.toList, Nil).mkString

  }

}
