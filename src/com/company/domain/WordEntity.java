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

    @Override
    public String toString() {
        return "WordEntity{" +
                "keywordName='" + keywordName + '\'' +
                ", keywordValue='" + keywordValue + '\'' +
                '}';
    }

    private String keywordValue;

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

    public WordEntity(String keywordName, String keywordValue) {

        this.keywordName = keywordName;
        this.keywordValue = keywordValue;
    }
}
