package com.company.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 10/19/13
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class TagEntity
{
       private String tagName;
       private String tagWeight;

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

    public TagEntity(String tagName, String tagWeight) {

        this.tagName = tagName;
        this.tagWeight = tagWeight;
    }

    @Override
    public String toString() {
        return "TagEntity{" +
                "tagName='" + tagName + '\'' +
                ", tagWeight='" + tagWeight + '\'' +
                '}';
    }
}
