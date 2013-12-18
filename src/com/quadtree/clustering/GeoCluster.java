package com.quadtree.clustering;

import java.util.Collection;

/**
 * Cluster of points representation
 * 
 * @author colriot
 * @since Jul 9, 2012
 * 
 */
public class GeoCluster extends GeoPointInternal {

    private Collection<IGeoPoint> points;

    /**
     * @param lng
     *            cluster longitude
     * @param lat
     *            cluster latitude
     * @param points
     *            objects in this cluster
     */
    public GeoCluster(int lng, int lat, Collection<IGeoPoint> points) {
        super(lng, lat);
        this.points = points;
    }

    public int getSize() {
        return points.size();
    }

    public Collection<IGeoPoint> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Cl" + super.toString();
    }
}
