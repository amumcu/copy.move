package image.operations.distance.normal;

import image.operations.keypoint.KeyPointDetector;
import image.operations.model.Angles;
import org.opencv.calib3d.Calib3d;
import org.opencv.core.*;
import org.opencv.features2d.KeyPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ali on 2/2/2017.
 */
public class CosineSimilarity2 {
    List list_points_angles_list;//  128 bit desriptors list

    public int getSimilarityList(List<ArrayList> descriptor_list, KeyPoint[] keypoints) {

        double oneAngle;
        list_points_angles_list = new ArrayList();
        List<Angles> points_angles_list = new ArrayList<Angles>();

        for (int i = 0; i < descriptor_list.size(); i++) {

            points_angles_list = new ArrayList<Angles>();

            for (int j = i + 1; j < descriptor_list.size(); j++) {

                int num = 0;
                double dense_1 = 0;
                double dense_2 = 0;
                for (int z = 0; z < 128; z++) {

                    num += (Integer) descriptor_list.get(i).get(z) * (Integer) descriptor_list.get(j).get(z);
                    dense_1 += Math.pow((Integer) descriptor_list.get(i).get(z), 2);
                    dense_2 += Math.pow((Integer) descriptor_list.get(j).get(z), 2);
                }
                double dense = Math.sqrt(dense_1 * dense_2);
                double cos = num / dense;
                oneAngle = Math.acos(cos);

                Angles angle = new Angles();
                angle.setAngle(oneAngle);
                angle.setPoint1(i);
                angle.setPoint2(j);

                angle.setP1(new Point(keypoints[i].pt.x, keypoints[i].pt.y));
                angle.setP2(new Point(keypoints[j].pt.x, keypoints[j].pt.y));

                points_angles_list.add(angle);

            }
            list_points_angles_list.add(points_angles_list);
        }
        return getSimilarity();


    }

    private int getSimilarity() {

        List<Point> pts1 = new ArrayList<Point>();
        List<Point> pts2 = new ArrayList<Point>();

        int counterPoint = 0;
        for (Object list_points_angles :
                list_points_angles_list) {
            Collections.sort((List<Angles>) list_points_angles, new AnglesCompare());

            for (int i = 0; i < ((List<Angles>) list_points_angles).size() - 1; i++) {
                if (((List<Angles>) list_points_angles).get(i).getAngle() / ((List<Angles>) list_points_angles).get(i + 1).getAngle() < 0.6) {
                    /*Core.line(
                            KeyPointDetector.objectImage,
                            ((List<Angles>) list_points_angles).get(i).getP1(),
                            ((List<Angles>) list_points_angles).get(i).getP2(),
                            new Scalar(255, 255, 0)
                    );*/

                    pts1.add(((List<Angles>) list_points_angles).get(i).getP1());
                    pts2.add(((List<Angles>) list_points_angles).get(i).getP2());
                    counterPoint++;
                }
            }

        }


        Mat outputMask = new Mat();
        MatOfPoint2f pts1Mat = new MatOfPoint2f();
        pts1Mat.fromList(pts1);
        MatOfPoint2f pts2Mat = new MatOfPoint2f();
        pts2Mat.fromList(pts2);

        Mat Homog = Calib3d.findHomography(pts1Mat, pts2Mat, Calib3d.RANSAC, 15, outputMask);

        /*
         * Draw lines after RANSAC elimination
         */
        System.out.println("Drawing matching lines on object image...");
        int matchPointNumber = 0;
        for (int i = 0; i < pts1.size(); i++) {
            if (outputMask.get(i, 0)[0] == 0.0) continue;
            Core.line(
                    KeyPointDetector.objectImage,
                    pts1.get(i),
                    pts2.get(i),
                    new Scalar(255, 255, 0)
            );
            //System.out.println(pts1.get(i) + "     "+ pts2.get(i));
            matchPointNumber++;

        }

        System.out.println("counterPoint = " + counterPoint);
        System.out.println("match point number RANSAC = " + matchPointNumber);
        return matchPointNumber;
    }

    /**
     * <h1>Sorting the Key Points</h1>
     */
    public class AnglesCompare implements Comparator<Angles> {

        public int compare(Angles o1, Angles o2) {

            if (o1.getAngle() < o2.getAngle()) return -1;
            if (o1.getAngle() == o2.getAngle()) return 0;
            return 1;

        }
    }
}
