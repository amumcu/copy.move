package image.operations.distance.normal;

import image.operations.distance.Distance;
import image.operations.distance.SimilarityList;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Euclidean Distance</h1>
 * <p>
 * Euclidean Distance Computing
 *
 * @author alim
 * @version 1.0
 * @since 10.01.2017
 */

public class VecorSimilarities implements Distance {

    @Override
    public ArrayList getSimilarity(List<ArrayList> descriptor_list) {
        double similarityMatrix[][] = new double[descriptor_list.size()][descriptor_list.size()];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < descriptor_list.size(); i++) {
            for (int j = 0; j < descriptor_list.size(); j++) {

                double sum = 0;
                for (int k = 1; k < 128; k++) {
                    sum += Math.pow((Integer) descriptor_list.get(i).get(k) - (Integer) descriptor_list.get(j).get(k), 2);
                }

                if (sum == 0)
                    similarityMatrix[i][j] = Integer.MAX_VALUE;

                else
                    similarityMatrix[i][j] = Math.sqrt(sum);

            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Euclidean Distance Computation time (Normal):  " + (endTime - startTime)
                + " milliseconds");

        SimilarityList similarityList = new SimilarityList();
        return similarityList.getSimilarityList(similarityMatrix, descriptor_list.size());
    }
}
