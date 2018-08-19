import java.awt.*;

class WarningWindow extends Window {
	WarningWindow(Frame anyFrame) {
		super(anyFrame);
		setBackground(Color.red);
	}	
}

public class window1 {
	public static void main(String[] args) {
		Frame f = new Frame(); // Window must belong to a Frame
		Window w = new Window(f);
		//w.setBackground(Color.white);
		w.setSize(200, 100);
		w.setVisible(true);
		w.setLocation(300, 300);
		
		WarningWindow ww = new WarningWindow(f);
		ww.setSize(200, 100);
		ww.setVisible(true);
		ww.setLocation(370, 370);
	}
}