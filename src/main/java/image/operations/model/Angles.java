package image.operations.model;

import org.opencv.core.Point;

/**
 * Created by Ali on 12/31/2016.
 */
public class Angles  {
    int point1;
    int point2;
    double angle;

    /*double point1_x;
    double point1_y;

    double point2_x;
    double point2_y;*/

    Point p1;
    Point p2;

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    /*public double getPoint1_x() {
        return point1_x;
    }

    public void setPoint1_x(double point1_x) {
        this.point1_x = point1_x;
    }

    public double getPoint1_y() {
        return point1_y;
    }

    public void setPoint1_y(double point1_y) {
        this.point1_y = point1_y;
    }

    public double getPoint2_x() {
        return point2_x;
    }

    public void setPoint2_x(double point2_x) {
        this.point2_x = point2_x;
    }

    public double getPoint2_y() {
        return point2_y;
    }

    public void setPoint2_y(double point2_y) {
        this.point2_y = point2_y;
    }

*/


    public Angles() {
    }

    public int getPoint1() {
        return point1;
    }

    public void setPoint1(int point1) {
        this.point1 = point1;
    }

    public int getPoint2() {
        return point2;
    }

    public void setPoint2(int point2) {
        this.point2 = point2;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }


}
