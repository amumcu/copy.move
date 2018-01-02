package image.operations;

import java.io.File;

/**
 * <h1>Constants</h1>
 * <p>
 * Constants of the project
 *
 * @author alim
 * @version 1.0
 * @since 6.12.2016
 */
public class Consts {


    /**
     * {@value #IMAGE_PATH} Holds the path of the inpu image
     * {@value #IMAGE_PATH_OUTPUT} Holds the path of the output image
     */
    public static final String IMAGE_PATH = "/Pictures/058_F.jpg";
    public static final String IMAGE_PATH_OUTPUT = "/Pictures/Output/OUTPUT_021_F";
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
     * The caller references the constants using <tt>Consts.EMPTY_STRING</tt>,
     * and so on. Thus, the caller should be prevented from constructing objects of
     * this class, by declaring this private constructor.
     */
    private Consts() {
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }
}