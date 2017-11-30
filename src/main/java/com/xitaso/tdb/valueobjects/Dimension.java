package com.xitaso.tdb.valueobjects;

/**
 * Immutable value object to represent a 2D integer dimension (width x height).
 */
public final class Dimension {
    public final int width;
    public final int height;

    public Dimension(int width, int height) {
        if (width < 0 || height < 0)
            throw new IllegalArgumentException("Dimensions may not be negative (w=" + width + ", h=" + height + ")");
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dimension dimension = (Dimension) o;

        if (width != dimension.width) return false;
        return height == dimension.height;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
