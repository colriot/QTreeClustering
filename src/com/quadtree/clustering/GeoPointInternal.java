package com.quadtree.clustering;

/**
 * {@link IGeoPoint} realization for internal purpose
 * 
 * @author colriot
 * @since Jul 9, 2012
 * 
 */
public class GeoPointInternal implements IGeoPoint {
    protected int x, y;

    public GeoPointInternal(int lng, int lat) {
        this.x = lng;
        this.y = lat;
    }

    @Override
    public int getLng() {
        return x;
    }

    @Override
    public int getLat() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
