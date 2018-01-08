package image.operations.distance;

import java.util.ArrayList;

/**
 * <h1>Similarity List</h1>
 * <p>
 *Getting most similar key points in the picture.
 * </p>
 * @author alim
 * @version 1.0
 * @since 10.01.2017
 */

public class SimilarityList {

    public ArrayList getSimilarityList(double similarityMatrix[][], int size) {

        ArrayList matchingPointList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            double min = similarityMatrix[i][0];
            int min_index_row = 0;
            for (int j = 0; j < size; j++) {
                if (min > similarityMatrix[i][j]) {
                    min = similarityMatrix[i][j];
                    min_index_row = j;
                }
            }
            int min_index_column = min_index_row;
            min = similarityMatrix[0][min_index_row];
            for (int k = 0; k < size; k++) {
                if (min > similarityMatrix[k][min_index_row]) {
                    min = similarityMatrix[k][min_index_row];
                    min_index_column = k;
                }
            }
            if (min_index_column == i) {


                matchingPointList.add(min_index_column);
                matchingPointList.add(min_index_row);
            }
        }
        return matchingPointList;
    }
}
