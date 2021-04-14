package edu.gcsc.vrl.vr;

/**
 * MeshingParameter
 * Smoothing, number of inflations and refinements as well as segment length 
 */
public final class MeshingParameter {
    private final boolean smooth;
    private final int inflation;
    private final int refinement;
    private final int segLength;
    
    /**
     * Create Meshing Parameters
     * @param smooth desired presmoothing
     * @param inflation level of inflation
     * @param refinement number of refinements
     * @param segLength length of edge segments
     */
    public MeshingParameter(final boolean smooth, final int inflation, final int refinement, final int segLength) {
        this.smooth = smooth;
        this.inflation = inflation;
        this.refinement = refinement;
        this.segLength = segLength;
    }

    /**
     * Get smooth
     * @return smooth
     */
    public boolean getSmooth() { return smooth; }
    /**
     * Get inflation
     * @return inflation level
     */
    public int getInflation() { return inflation; }
    /**
     * Get refinement
     * @return number of refinements
     */
    public int getRefinement() { return refinement; }
    /**
     * Get segment length
     * @return segment length
     */
    public int getSegLength() { return segLength;}
}