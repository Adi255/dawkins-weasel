package com.elsevier.hack

import org.scalatest.{FlatSpec, Matchers}

class PhraseMutatorSpec extends FlatSpec with Matchers {

  "Phrase Mutator" should "update some characters in a String" in {
    val phrase = "MUTATE THIS"
    val vocab = List('X', 'Y', 'Z')
    val mutated = PhraseMutator.mutatePhrase(phrase, vocab)
    println(mutated)
  }

}
