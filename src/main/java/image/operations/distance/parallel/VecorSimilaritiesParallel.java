package image.operations.distance.parallel;


import image.operations.distance.Distance;
import image.operations.distance.SimilarityList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * <h1>Euclidean Distance</h1>
 * <p>
 * Euclidean Distance with Parallel Programming
 *
 * @author alim
 * @version 1.0
 * @since 25.12.2017
 */

public class VecorSimilaritiesParallel implements Distance {
    static double similarityMatrix[][];
    static ArrayList<ArrayList> vectorList;

    public static void parallelsimilarityMatrix(List<ArrayList> vList, int index) {
        RecursiveAction mainTask = new SimilarityMatrix(vList, index);
        ForkJoinPool pool = new ForkJoinPool(6);
        pool.invoke(mainTask);
        pool.shutdown();
    }

    @Override
    public ArrayList getSimilarity(List<ArrayList> descriptor_list) {
        VecorSimilaritiesParallel vecorSimilaritiesParallel = new VecorSimilaritiesParallel();
        vecorSimilaritiesParallel.vectorList = new ArrayList<ArrayList>();
        vecorSimilaritiesParallel.vectorList = (ArrayList<ArrayList>) descriptor_list;
        vecorSimilaritiesParallel.similarityMatrix = new double[vecorSimilaritiesParallel.vectorList.size()][vecorSimilaritiesParallel.vectorList.size()];


        long startTime = System.currentTimeMillis();

        for (int i = 0; i < vecorSimilaritiesParallel.vectorList.size(); i++) {

            parallelsimilarityMatrix(vecorSimilaritiesParallel.vectorList, i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Euclidean Distance Computation time (Parallel):  " + (endTime - startTime)
                + " milliseconds");
        SimilarityList similarityList = new SimilarityList();
        return similarityList.getSimilarityList(similarityMatrix, descriptor_list.size());
    }

    private static class SimilarityMatrix extends RecursiveAction {
        private final int THRESHOLD = 200;
        int index;
        private List<ArrayList> list;

        SimilarityMatrix(List<ArrayList> vList, int index) {
            this.list = vList;
            this.index = index;
        }

        @Override
        protected void compute() {

            if (list.size() < THRESHOLD) {
                //  System.out.println("index = " + index  + "  -  " + list.size() );
                for (int j = 0; j < list.size(); j++) {
                    int indx2 = (Integer) list.get(j).get(0);
                    double sum = 0;
                    for (int k = 1; k < 128; k++) {
                        sum += Math.pow((Integer) vectorList.get(index).get(k) - (Integer) list.get(j).get(k), 2);
                    }

                    if (sum == 0)
                        similarityMatrix[index][indx2] = Integer.MAX_VALUE;

                    else
                        similarityMatrix[index][indx2] = Math.sqrt(sum);

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
                invokeAll(new SimilarityMatrix(firstHalf, index),
                        new SimilarityMatrix(secondHalf, index));
            }
        }
    }


}
