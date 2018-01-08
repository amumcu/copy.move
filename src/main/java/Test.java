import image.operations.keypoint.KeyPointDetector;
import org.opencv.core.Core;

/**
 * Created by alim on 15.11.2016.
 * Basic OpenCV operations
 */
public class Test {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        KeyPointDetector keyPointDetector = new KeyPointDetector();
        keyPointDetector.detectKeyPoint();

        long endTime = System.currentTimeMillis();
        System.out.println("Totol Time is " + (endTime - startTime)
                + " milliseconds");
    }
}
