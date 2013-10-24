package com.company.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 10/22/13
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class UniqueKeyWordEntity
{
    private String keywordName;
    private String tagName;
    private String tagWeight;
    private String keywordFrequency;
    private String keywordWeight;

    @Override
    public String toString() {
        return "UniqueKeyWordEntity{" +
                "keywordName='" + keywordName + '\'' +
                ", tagName='" + tagName + '\'' +
                ", tagWeight='" + tagWeight + '\'' +
                ", keywordFrequency='" + keywordFrequency + '\'' +
                ", keywordWeight='" + keywordWeight + '\'' +
                '}';
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagWeight() {
        return tagWeight;
    }

    public void setTagWeight(String tagWeight) {
        this.tagWeight = tagWeight;
    }

    public String getKeywordFrequency() {
        return keywordFrequency;
    }

    public void setKeywordFrequency(String keywordFrequency) {
        this.keywordFrequency = keywordFrequency;
    }

    public String getKeywordWeight() {
        return keywordWeight;
    }

    public void setKeywordWeight(String keywordWeight) {
        this.keywordWeight = keywordWeight;
    }

    public UniqueKeyWordEntity(String keywordName, String tagName, String tagWeight, String keywordFrequency, String keywordWeight) {

        this.keywordName = keywordName;
        this.tagName = tagName;
        this.tagWeight = tagWeight;
        this.keywordFrequency = keywordFrequency;
        this.keywordWeight = keywordWeight;
    }
}
