package image.operations.distance.normal;

import image.operations.distance.Distance;
import image.operations.distance.SimilarityList;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Cosine Similarity</h1>
 * <p>
 * Cosine Similarity Computing
 * </p>
 *
 * @author alim
 * @version 1.0
 * @since 17.01.2017
 */

public class CosineSimilarity implements Distance {

    @Override
    public ArrayList getSimilarity(List<ArrayList> descriptor_list) {
        long startTime = System.currentTimeMillis();

        double[][] angles = new double[descriptor_list.size()][descriptor_list.size()];

        for (int i = 0; i < descriptor_list.size(); i++) {

            for (int j = 0; j < descriptor_list.size(); j++) {

                int num = 0;
                double dense_1 = 0;
                double dense_2 = 0;
                for (int z = 1; z < 128; z++) {

                    num += (Integer) descriptor_list.get(i).get(z) * (Integer) descriptor_list.get(j).get(z);
                    dense_1 += Math.pow((Integer) descriptor_list.get(i).get(z), 2);
                    dense_2 += Math.pow((Integer) descriptor_list.get(j).get(z), 2);
                }
                double dense = Math.sqrt(dense_1 * dense_2);
                double cos = num / dense;
                angles[i][j] = Math.acos(cos);
                if (angles[i][j] == 0) angles[i][j] = Double.MAX_VALUE;

            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Cosine Similarity Computation time (Normal):  " + (endTime - startTime)
                + " milliseconds");
        SimilarityList similarityList = new SimilarityList();
        return similarityList.getSimilarityList(angles, descriptor_list.size());
    }
}


