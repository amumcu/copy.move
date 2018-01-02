package image.operations.distance;

import java.util.ArrayList;
import java.util.List;

public interface Distance {

    // Similarity Matrix is a square matrix with a size equals to descriptor list length
    public ArrayList getSimilarity(List<ArrayList> descriptor_list);

}
