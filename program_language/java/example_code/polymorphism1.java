import java.awt.*;

class WarningWindow extends Window {
	WarningWindow(Frame apple) {
		super(apple);
		setBackground(Color.red);
	}
	
	public void setSize(int x, int y) { // overriding
		int bigx = (int)(x*1.5);
		int bigy = (int)(y*1.5);
		super.setSize(bigx, bigy);
	}
	
	public String toString() { // overriding
		return new String("WarningWindow");	
	}
}

class polymorphism1 {
	public static void main(String args[]) {
		Frame f = new Frame();
		Window w = new Window(f);
		w.setSize(200, 100);
		w.setVisible(true);
		w.setLocation(300, 300);
		
		Window w2 = new WarningWindow(f);
		w2.setSize(200, 100);
		w2.setVisible(true);
		w2.setLocation(370, 370);
		System.out.println(w2);
	}	
}