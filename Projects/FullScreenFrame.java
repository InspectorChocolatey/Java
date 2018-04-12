import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class FullScreenFrame extends JFrame implements KeyListener {
    public FullScreenFrame () {
        addKeyListener(this);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (gd.isFullScreenSupported()) {
		setUndecorated(true);
                gd.setFullScreenWindow(this);
        }
        else {
            System.err.println("Full screen not supported");
        }
        setVisible(true);
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        setVisible(false);
        dispose();
    }

    public static void main (String [] args) {
        new FullScreenFrame();
    }
}
