class Timestamp {
	int hrs;
	int mins;
	int secs;
	
	void fillTimes() {
		java.util.Calendar now;
		now = java.util.Calendar.getInstance();
		now.setTimeZone(java.util.TimeZone.getTimeZone("Asia/Shanghai"));//important
		hrs = now.get(java.util.Calendar.HOUR_OF_DAY);
		mins = now.get(java.util.Calendar.MINUTE);
		secs = now.get(java.util.Calendar.SECOND);
	}	
}

class ClockView extends javax.swing.JFrame {
	private javax.swing.JLabel  tLabel = new javax.swing.JLabel();
	
	ClockView() {
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setSize(95, 45);
		this.getContentPane().add(tLabel);
		this.refreshTimeDisplay();
	}
	
	protected String getDigitsAsString(int i) {
		String str = Integer.toString(i);	
		if(i<10) str = "0" + str;
		return str;
	}
	
	public void refreshTimeDisplay() {
		Timestamp t = new Timestamp();
		t.fillTimes();
		String display = getDigitsAsString(t.hrs) + ":"
		           + getDigitsAsString(t.mins) + ":"
		           + getDigitsAsString(t.secs);
		tLabel.setText(" " + display);
		tLabel.repaint();
	}
}

public class clock {
	public static void main(String[] args) {
		ClockView cv = new ClockView();
		cv.setVisible(true);
		try {
			for(;;) {
				cv.refreshTimeDisplay();
				Thread.sleep(500);	
			}	
		}catch (Exception e) {System.out.println("Error:"+e);}
	}
}
