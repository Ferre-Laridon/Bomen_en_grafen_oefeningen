package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] getPointerMatrix() {
        int[][] pointerMatrix = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] DMatrix = this.gewichtenMatrix.clone();

        for (int i=0; i<getAantalKnopen(); i++) {
            for (int j=0; j<getAantalKnopen(); j++) {
                for (int k=0; k<getAantalKnopen(); k++) {
                    double origineel = DMatrix[j][k];
                    double nieuw = DMatrix[j][i]+DMatrix[i][k];
                    if (origineel>nieuw) {
                        origineel = nieuw;
                        pointerMatrix[j][k]++;
                    }
                }
            }
        }

		return pointerMatrix;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] pointer) {
		List<Integer> res = new ArrayList<>();


		return res;

	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
	
		return som;
	}

}
