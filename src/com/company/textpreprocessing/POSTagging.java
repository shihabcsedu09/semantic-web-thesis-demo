package com.company.textpreprocessing;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 10/21/13
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class POSTagging {
    public static ArrayList<String> tagPos(String sentenceToTag) {
        MaxentTagger tagger = new MaxentTagger("./lib/stanford-postagger-2013-06-20/models/english-left3words-distsim.tagger");
        String[] words = tagger.tagString(sentenceToTag.toLowerCase().replaceAll("[^A-Za-z]", " ").replaceAll(" +", " ")).split(" ");
        ArrayList<String> nounWords = new ArrayList<String>();

        for (String word : words) {

            if (word.contains("NN") || word.contains("NNS") || word.contains("NNP") || word.contains("NNPS") || word.contains("VBG")) {

                nounWords.add(word.replaceFirst("_.*", ""));
            }

        }

        return nounWords;
    }
}
