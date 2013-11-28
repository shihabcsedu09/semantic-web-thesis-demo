package com.company.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 10/22/13
 * Time: 12:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class WordEntity
{
    private String keywordName;
    private String keywordValue;
    private String keywordFrequency;



    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public String getKeywordValue() {
        return keywordValue;
    }

    public void setKeywordValue(String keywordValue) {
        this.keywordValue = keywordValue;
    }

    public String getKeywordFrequency() {
        return keywordFrequency;
    }

    public void setKeywordFrequency(String keywordFrequency) {
        this.keywordFrequency = keywordFrequency;
    }

    public WordEntity(String keywordName, String keywordValue, String keywordFrequency) {

        this.keywordName = keywordName;
        this.keywordValue = keywordValue;
        this.keywordFrequency = keywordFrequency;
    }
}
