package image.operations.distance;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Distance Interfaca</h1>
 *
 * @author alim
 * @version 1.0
 * @since 10.01.2017
 */

public interface Distance {

    // Similarity Matrix is a square matrix with a size equals to descriptor list length
    public ArrayList getSimilarity(List<ArrayList> descriptor_list);

}
