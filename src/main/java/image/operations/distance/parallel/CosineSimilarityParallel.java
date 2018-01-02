package image.operations.distance.parallel;

import image.operations.distance.Distance;
import image.operations.distance.SimilarityList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * <h1>Cosine Similarity</h1>
 * <p>
 * Cosine Similarity with Parallel Programming
 *
 * @author alim
 * @version 1.0
 * @since 26.12.2017
 */

public class CosineSimilarityParallel implements Distance {
    static double[][] angles;
    static ArrayList<ArrayList> vectorList;

    public static void parallelsimilarityMatrixCosine(List<ArrayList> vList, int index) {
        RecursiveAction mainTask = new SimilarityMatrixCosine(vList, index);
        ForkJoinPool pool = new ForkJoinPool(6);
        pool.invoke(mainTask);
        pool.shutdown();
    }

    @Override
    public ArrayList getSimilarity(List<ArrayList> descriptor_list) {
        long startTime = System.currentTimeMillis();

        CosineSimilarityParallel cosineSimilarityParallel = new CosineSimilarityParallel();
        cosineSimilarityParallel.vectorList = new ArrayList<ArrayList>();
        cosineSimilarityParallel.vectorList = (ArrayList<ArrayList>) descriptor_list;
        angles = new double[descriptor_list.size()][descriptor_list.size()];

        for (int i = 0; i < descriptor_list.size(); i++) {

            parallelsimilarityMatrixCosine(cosineSimilarityParallel.vectorList, i);

        }

        long endTime = System.currentTimeMillis();
        System.out.println("Cosine Similarity Computation time (Parallel):  " + (endTime - startTime)
                + " milliseconds");
        SimilarityList similarityList = new SimilarityList();
        return similarityList.getSimilarityList(angles, descriptor_list.size());
    }

    private static class SimilarityMatrixCosine extends RecursiveAction {
        private final int THRESHOLD = 200;
        int index;
        private List<ArrayList> list;

        SimilarityMatrixCosine(List<ArrayList> vList, int index) {
            this.list = vList;
            this.index = index;
        }

        @Override
        protected void compute() {

            if (list.size() < THRESHOLD) {

                //  System.out.println("index = " + index  + "  -  " + list.size() );
                for (int j = 0; j < list.size(); j++) {
                    int indx2 = (Integer) list.get(j).get(0);
                    int num = 0;
                    double dense_1 = 0;
                    double dense_2 = 0;

                    for (int z = 1; z < 128; z++) {

                        num += (Integer) vectorList.get(index).get(z) * (Integer) list.get(j).get(z);
                        dense_1 += Math.pow((Integer) vectorList.get(index).get(z), 2);
                        dense_2 += Math.pow((Integer) list.get(j).get(z), 2);
                    }
                    double dense = Math.sqrt(dense_1 * dense_2);
                    double cos = num / dense;
                    angles[index][indx2] = Math.acos(cos);
                    if (angles[index][indx2] == 0) angles[index][indx2] = Double.MAX_VALUE;

                }
            } else {

                // Obtain the first half
                List<ArrayList> firstHalf = new ArrayList<>(list.size() / 2);
                firstHalf = list.subList(0, list.size() / 2);

                // Obtain the second half
                int secondHalfLength = list.size() - list.size() / 2;
                List<ArrayList> secondHalf = new ArrayList<>(secondHalfLength);
                secondHalf = list.subList(list.size() / 2, list.size());

                // Recursively sort the two halves
                invokeAll(new SimilarityMatrixCosine(firstHalf, index),
                        new SimilarityMatrixCosine(secondHalf, index));
            }
        }
    }
}


