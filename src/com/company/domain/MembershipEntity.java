package com.company.domain;

/**
 * Created by Shihab on 1/30/14.
 */
public class MembershipEntity
{
    public int pageNumber;
    public int clusterNumber;
    public double membershipValue;

    public MembershipEntity(int pageNumber, int clusterNumber, double membershipValue) {
        this.pageNumber = pageNumber;
        this.clusterNumber = clusterNumber;
        this.membershipValue = membershipValue;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getClusterNumber() {
        return clusterNumber;
    }

    public void setClusterNumber(int clusterNumber) {
        this.clusterNumber = clusterNumber;
    }

    public double getMembershipValue() {
        return membershipValue;
    }

    public void setMembershipValue(double membershipValue) {
        this.membershipValue = membershipValue;
    }
}
