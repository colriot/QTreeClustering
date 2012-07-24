package com.quadtree.clustering;

/**
 * Cluster of points representation
 * 
 * @author colriot
 * @since Jul 9, 2012
 * 
 */
public class GeoCluster extends GeoPointInternal {

    private int size;

    /**
     * @param lng
     *            cluster longitude
     * @param lat
     *            cluster latitude
     * @param size
     *            number of objects in this cluster
     */
    public GeoCluster(int lng, int lat, int size) {
        super(lng, lat);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Cl" + super.toString();
    }
}
