package com.company.performance_evaluation;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.IRAMDictionary;
import edu.mit.jwi.RAMDictionary;
import edu.mit.jwi.data.ILoadPolicy;
import edu.mit.jwi.item.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Shihab on 2/28/14.
 */
public class GettingSynonyms
{
    public static ArrayList<String> getSynonyms(String wordToFindSynonym) throws IOException {

        System.setProperty("wordnet.database.dir", "C:\\Program Files\\WordNet\\2.1\\dict");
        ArrayList<String> synonyms = new ArrayList<String>();
        String env = System.getProperty("wordnet.database.dir");
        URL url = new URL("file", null, env);
        IRAMDictionary dict = new RAMDictionary(url , ILoadPolicy. NO_LOAD );
        dict.load();
      //  IDictionary dict = new Dictionary( url);
        dict.open();
        IIndexWord idxWord = dict.getIndexWord(wordToFindSynonym, POS.NOUN);
      //  System.out.println("TO find Synonym "+idxWord);
        if (idxWord==null)
        {
            dict.close();
            return null;
        }
        IWordID wordID;
        wordID = idxWord . getWordIDs ().get(0) ; // 1st meaning

        IWord word = dict . getWord ( wordID );
        ISynset synset = word . getSynset ();

        // iterate over words associated with the synset
        for( IWord w : synset . getWords ()){
            synonyms.add(w.getLemma());
          //  System.out.println (w.getLemma());
        }


        // get the hypernyms
        List< ISynsetID > hypernyms =
                synset . getRelatedSynsets ( Pointer . HYPERNYM );

        // print out each h y p e r n y m s id and synonyms

        List <IWord > words ;
        for( ISynsetID sid : hypernyms ){
            words = dict . getSynset (sid). getWords ();

            for( Iterator<IWord > i = words . iterator (); i. hasNext () ;){
                synonyms.add(i.next().getLemma());
                //System .out . println(i.next().getLemma());
            }
        }
        dict.close();
        return synonyms;
    }
}
