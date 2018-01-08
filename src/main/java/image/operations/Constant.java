package image.operations;
import java.io.File;

/**
 * <h1>Constant</h1>
 * <p>
 * Constant of the project
 *</p>
 * @author alim
 * @version 1.0
 * @since 6.12.2016
 */
public class Constant {


    /**
     * {@value #IMAGE_PATH} Holds the path of the inpu image
     * {@value #IMAGE_PATH_OUTPUT} Holds the path of the output image
     */
    public static final String IMAGE_PATH = "/Pictures/016_F.jpg";
    public static final String IMAGE_PATH_OUTPUT = "/Pictures/Output/OUTPUT_016_F";



    /**
     * Determines which distance type used in computing
     * 0 for Cosine Similarity,
     * 1 for Euclidean Distance,
     * 2 for Mix Distance,
     * 3 for Mix Distance Parallel
     * 4 for Cosine Similarity 2 (with the threshold 0.6 )
     */
    public static int DISTANCE_TYPE = 2;

    /**
     * {@value #IMAGE_PATH_098} Holds the path of the images
     * CoMoFod picture number 98 - Birds
     */
    public static final String IMAGE_PATH_098 = "\\Pictures\\098_F.png";
    /**
     * {@value #IMAGE_PATH_OUTPUT_098} Holds the path of the output image
     * CoMoFod picture number 98 - Birds
     */
    public static final String IMAGE_PATH_OUTPUT_098 = "\\Pictures\\OUTPUT_098_F";
    public static final String IMAGE_PATH_OUTPUT_098_C = "\\Pictures\\OUTPUT_098_F_C";
    /**
     * {@value #IMAGE_PATH_028} Holds the path of the images
     * CoMoFod picture number 28 - Plants
     */
    public static final String IMAGE_PATH_028 = "\\Pictures\\028_F.png";
    /**
     * {@value #IMAGE_PATH_OUTPUT_028} Holds the path of the output image
     * CoMoFod picture number 28 - Plants
     */
    public static final String IMAGE_PATH_OUTPUT_028 = "\\Pictures\\OUTPUT_028_F";
    /**
     * {@value #IMAGE_PATH_018} Holds the path of the images
     * Picture number 18 - Cars
     */
    public static final String IMAGE_PATH_018 = "\\Pictures\\018_F.jpg";
    /**
     * {@value #IMAGE_PATH_OUTPUT_018} Holds the path of the output image
     * Picture number 18 - Cars
     */
    public static final String IMAGE_PATH_OUTPUT_018 = "\\Pictures\\OUTPUT_018_F";
    /**
     * {@value #IMAGE_PATH_048} Holds the path of the images
     * Picture number 48 - Guns
     */
    public static final String IMAGE_PATH_048 = "\\Pictures\\048_F.jpg";
    /**
     * {@value #IMAGE_PATH_OUTPUT_048} Holds the path of the output image
     * Picture number 48 - Guns
     */
    public static final String IMAGE_PATH_OUTPUT_048 = "\\Pictures\\OUTPUT_048_F";
    /**
     * {absolutePath} gets the absolute path of the project
     */
    public static String absolutePath = new File("").getAbsolutePath();


    /**
     * {THRESHOLD} sets the parallel computing minimum level
     */
    public static final int THRESHOLD = 200;



    /**
     * The caller references the constants using <tt>Constant.EMPTY_STRING</tt>,
     * and so on. Thus, the caller should be prevented from constructing objects of
     * this class, by declaring this private constructor.
     */
    private Constant() {
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }
}