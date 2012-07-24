package com.quadtree.clustering;

/**
 * @author colriot
 * @since Jul 9, 2012
 *
 */
public class GeoRect {
    protected GeoPointInternal bL;
    protected GeoPointInternal tR;

    /**
     * @param bL
     *            bottom left corner
     * @param tR
     *            top right corner
     */
    public GeoRect(GeoPointInternal bL, GeoPointInternal tR) {
        this.bL = bL;
        this.tR = tR;
    }

    /**
     * @param bLx
     *            bottom left longitude
     * @param bLy
     *            bottom left latitude
     * @param tRx
     *            top right longitude
     * @param tRy
     *            top right latitude
     */
    public GeoRect(int bLx, int bLy, int tRx, int tRy) {
        this(new GeoPointInternal(bLx, bLy), new GeoPointInternal(tRx, tRy));
    }

    public int getLatSpan() {
        return tR.getLat() - bL.getLat();
    }

    public int getLngSpan() {
        if (bL.getLng() > tR.getLng()) {
            return 360000000 + tR.getLng() - bL.getLng();
        } else {
            return tR.getLng() - bL.getLng();
        }
    }

    public boolean contains(int lng, int lat) {
        return contains(new GeoPointInternal(lng, lat));
    }

    public boolean contains(IGeoPoint p) {
        if (p.getLat() < bL.getLat() || p.getLat() > tR.getLat()) {
            return false;
        }

        // if 180 to -180 border crosses this bounding box
        if (bL.getLng() > tR.getLng()) {
            return bL.getLng() <= p.getLng() || p.getLng() <= tR.getLng();
        } else {
            return bL.getLng() <= p.getLng() && p.getLng() <= tR.getLng();
        }
    }

    public boolean intersects(GeoRect rect) {
        if (bL.getLng() < tR.getLng() && rect.bL.getLng() < rect.tR.getLng()) {
            return!(tR.x < rect.bL.x || bL.x > rect.tR.x || tR.y < rect.bL.y || bL.y > rect.tR.y);
        } else if (bL.getLng() > tR.getLng() && rect.bL.getLng() > rect.tR.getLng()) {
            return tR.y >= rect.bL.y && bL.y <= rect.tR.y;
        } else if (bL.getLng() > tR.getLng()) {
            return (rect.bL.x < tR.x || bL.x < rect.tR.x) && tR.y >= rect.bL.y && bL.y <= rect.tR.y;
        } else /*if (rect.bL.getLng() > rect.tR.getLng())*/{
            return (bL.x < rect.tR.x || rect.bL.x < tR.x) && tR.y >= rect.bL.y && bL.y <= rect.tR.y;
        }
    }

    @Override
    public String toString() {
        return "Rect[bL=" + bL + ";tR=" + tR + "]";
    }
}
