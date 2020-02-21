package com.example.testingexamples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordReverserAlgorithmTest {

    @Test
    void SingleWord_NoWhiteSpace_NoChange() {
        assertEquals("Hippo", WordReverserAlgorithm.reverseEveryOtherWord("Hippo"));
    }

    @Test
    void SingleWord_LeadingSpace_TrimmedWithNoReversal() {
        assertEquals("Hippo", WordReverserAlgorithm.reverseEveryOtherWord(" Hippo"));
    }

    @Test
    void SingleWord_TrailingSpace_TrimmedWithNoReversal() {
        assertEquals("Hippo", WordReverserAlgorithm.reverseEveryOtherWord("Hippo "));
    }

    @Test
    void TwoWords_SingleSpaceBetween_Word2Reversed() {
        assertEquals("Hungry oppiH", WordReverserAlgorithm.reverseEveryOtherWord("Hungry Hippo"));
    }

    @Test
    void TwoWords_DoubleSpaceBetween_Word2Reversed() {
        assertEquals("Hungry oppiH", WordReverserAlgorithm.reverseEveryOtherWord("Hungry  Hippo"));
    }

    @Test
    void ThreeWords_SingleSpacesBetween_Word2Reversed() {
        assertEquals("Hungry yrgnuH Hippo", WordReverserAlgorithm.reverseEveryOtherWord("Hungry Hungry Hippo"));
    }

    // Etc etc
}