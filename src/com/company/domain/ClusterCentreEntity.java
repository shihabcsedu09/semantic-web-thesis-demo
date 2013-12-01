package com.company.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 12/1/13
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class ClusterCentreEntity
{
    public int clusterNumher;
    public double clusterCenterValues;

    public int getClusterNumher() {
        return clusterNumher;
    }

    public void setClusterNumher(int clusterNumher) {
        this.clusterNumher = clusterNumher;
    }

    public ClusterCentreEntity(int clusterNumher, double clusterCenterValues) {

        this.clusterNumher = clusterNumher;
        this.clusterCenterValues = clusterCenterValues;
    }
}
