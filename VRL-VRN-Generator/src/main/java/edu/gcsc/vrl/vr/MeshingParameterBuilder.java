package edu.gcsc.vrl.vr;

/**
 * MeshingParameterBuilder
 * Builds parameters for meshing with the very classical builder pattern
 */
public final class MeshingParameterBuilder {
    private boolean smooth = false;
    private int segLength = 4;
    private int refinement = 0;
    private int inflation = 1;

    /**
     * Set smoothing 
     * @param smooth presmooth or not
     * @return MeshingParameterBuilder
     */
    public MeshingParameterBuilder setSmoothing(final boolean smooth) {
        this.smooth = smooth;
        return this;
    }

    /**
     * Set inflation
     * @param inflation level of inflation
     * @return MeshingParameterBuilder
     */
    public MeshingParameterBuilder setInflation(final int inflation) {
        this.inflation = inflation;
        return this;
    }

    /**
     * Set refinement
     * @param refinement number of refinements
     * @return MeshingParameterBuilder
     */
    public MeshingParameterBuilder setRefinement(final int refinement) {
        this.refinement = refinement;
        return this;
    }

    /**
     * Set segment length
     * @param segLength length of edge segments
     * @return MeshingParameterBuilder
     */
    public MeshingParameterBuilder setSegLength(final int segLength) {
        this.segLength = segLength;
        return this;
    }

    /**
     * Build the parameters
     * @return MeshingParameter
     */
    public MeshingParameter build() {
        return new MeshingParameter(smooth, segLength, refinement, inflation);
    }
}