package image.operations.keypoint;

import org.opencv.features2d.KeyPoint;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by PC on 22.02.2017.
 *
 */
public class DesriptorFile {
    void writeFile(KeyPoint[] keypoints, List<ArrayList> descriptor_list){
        BufferedWriter writer = null;
        try {

            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File logFile = new File(timeLog+".sift");

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(keypoints.length + " 128\n");
            for (int i = 0; i < keypoints.length; i++) {
                writer.write(keypoints[i].pt.y + " " +
                keypoints[i].pt.x+ " " +
                keypoints[i].size+ " " +
                keypoints[i].angle+ "\n");
                for (int j = 0; j < 128; j++) {
                    writer.write(" " + descriptor_list.get(i).get(j));
                    if (j % 19 == 0 && j!=0) writer.write("\n");
                }
                writer.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }

    }
}
