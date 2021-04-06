package edu.gcsc.vrl.vr;

/**
 * MeshingParameterBuilder
 */
public class MeshingParameterBuilder {
    private boolean smooth;
    private int segLength;
    private int refinement;
    private int inflation;

    /**
     * Set smoothing 
     * @param smooth presmooth or not
     */
    public MeshingParameterBuilder(final boolean smooth) {
        this.smooth = smooth;
    }

    /**
     * Set inflation
     * @param inflation level of inflation
     */
    public MeshingParameterBuilder setInflation(final int inflation) {
        this.inflation = inflation;
        return this;
    }

    /**
     * Set refinement
     * @param refinement number of refinements
     */
    public MeshingParameterBuilder setRefinement(final int refinement) {
        this.refinement = refinement;
        return this;
    }

    /**
     * Set segment length
     * @param segLength length of edge segments
     */
    public MeshingParameterBuilder setSegLength(final int segLength) {
        this.segLength = segLength;
        return this;
    }

    /**
     * Build
     */
    public MeshingParameter build() {
        return new MeshingParameter(smooth, segLength, refinement, inflation);
    }
}