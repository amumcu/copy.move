package image.operations.show;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Oda on 16.11.2016.
 * Display the java Buffered Image
 */
public class DisplayImage {
    Image image;

    public DisplayImage(Image image) {
        this.image = image;
    }

    public void display()
    {
        //BufferedImage img=ImageIO.read(new File("/HelloOpenCV/lena.png"));
        ImageIcon icon=new ImageIcon(image);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(image.getWidth(null)+50, image.getHeight(null)+50);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
