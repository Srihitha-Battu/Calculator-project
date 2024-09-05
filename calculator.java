// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {
	static JFrame f;
	static JTextField l;
	String s0, s1, s2,s3;
	
	calculator()
	{
		s0 = s1 = s2 =s3= "";
	}

	public static void main(String args[])
	{
		f = new JFrame("Calculator");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		calculator c = new calculator();

		l = new JTextField(20);

		l.setEditable(false);

		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, badd, bsub, bdid, bmul, bpon, bclr, beq, bbac;

		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		beq = new JButton("=");

		badd = new JButton("+");
		bsub = new JButton("-");
		bdid = new JButton("/");
		bmul = new JButton("*");
		bclr= new JButton("C");

		bpon = new JButton(".");
		bbac = new JButton("X");

		JPanel p = new JPanel();

		bmul.addActionListener(c);
		bdid.addActionListener(c);
		bsub.addActionListener(c);
		badd.addActionListener(c);
		b9.addActionListener(c);
		b8.addActionListener(c);
		b7.addActionListener(c);
		b6.addActionListener(c);
		b5.addActionListener(c);
		b4.addActionListener(c);
		b3.addActionListener(c);
		b2.addActionListener(c);
		b1.addActionListener(c);
		b0.addActionListener(c);
		bpon.addActionListener(c);
		beq.addActionListener(c);
		bclr.addActionListener(c);
		bbac.addActionListener(c);

		bbac.setForeground(Color.RED);
		p.add(l);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(b0);
		p.add(badd);
		p.add(bsub);
	    p.add(bmul);
		p.add(bdid);
		p.add(bpon);
		p.add(beq);
		p.add(bclr);
		p.add(bbac);


		f.add(p);

		f.setSize(300, 350);
		f.show();
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {	
			if (!s3.equals("") && s1.equals("")) {
				s0 = "";
				s3 = "";
			}						
			if (!s1.equals(""))
				s2 = s2 + s;
			else 
				s0 = s0 + s;

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			// clear the one letter
			s0 = s1 = s2 = "";

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if(s.charAt(0) == 'X')
		{
			if (!s1.equals(""))
			  {
				if (s2 != null && s2.length() > 0) {
					StringBuilder sb = new StringBuilder(s2);
					sb.deleteCharAt(sb.length() - 1);  // Deletes the last character
					s2 = sb.toString(); 
				}
				else
				{
					s1="";
				}
		
			  }
			else
				{
					if (s0 != null && s0.length() > 0) {
						StringBuilder sb = new StringBuilder(s0);
						sb.deleteCharAt(sb.length() - 1);  // Deletes the last character
						s0 = sb.toString();
				    }
					
			    }
			l.setText(s0 + s1 + s2);

		}
		else if (s.charAt(0) == '=') {

			double res;

			// store the value in 1st
			if (s1.equals("+"))
				res = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				res= (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				res= (Double.parseDouble(s0) / Double.parseDouble(s2));
			else
				res = (Double.parseDouble(s0) * Double.parseDouble(s2));

			// set the value of text
			l.setText(s0 + s1 + s2 + "=" + res);

			// convert it to string
			s0 = Double.toString(res);
			s3=s0;
			s1 = s2 = "";

		}
		else {
			// if there was no operand
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			// else evaluate
			else {
				double res;

				// store the value in 1st
				if (s1.equals("+"))
					res = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					res = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					res = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					res = (Double.parseDouble(s0) * Double.parseDouble(s2));

				// convert it to string
				s0 = Double.toString(res);
				s3=s0;

				// place the operator
				s1 = s;

				// make the operand blank
				s2 = "";
			}

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
	}
}
