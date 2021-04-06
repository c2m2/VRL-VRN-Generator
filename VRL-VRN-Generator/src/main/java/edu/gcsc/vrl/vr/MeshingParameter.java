package edu.gcsc.vrl.vr;

/**
 * MeshingParameter
 */
public class MeshingParameter {
    public final boolean smooth;
    public final int inflation;
    public final int refinement;
    public final int segLength;
    
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
}