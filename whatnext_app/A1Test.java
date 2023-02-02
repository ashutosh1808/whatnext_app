import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class A1 extends JFrame
{
Container c;
JLabel lblName,lblChoice;
JTextField txtName;
JRadioButton rbJob,rbMba,rbMs;
JButton btnSubmit;

A1()
{
	c=getContentPane();		
	c.setLayout(null);
	c.setBackground(Color.YELLOW);
	Font f=new Font("Sans Serif",Font.BOLD,30);	
	lblName=new JLabel("Enter name: ");
	lblName.setFont(f);
	lblName.setBounds(10,30,300,40);
	txtName=new JTextField(40);
	txtName.setFont(f);
	txtName.setBounds(250,30,300,40);
	lblChoice=new JLabel("What Next? ");
	lblChoice.setFont(f);
	lblChoice.setBounds(10,90,300,40);
	rbJob=new JRadioButton("Job");
	rbJob.setFont(f);
	rbJob.setBounds(10,150,300,40);
	rbMba=new JRadioButton("MBA");
	rbMba.setFont(f);
	rbMba.setBounds(10,250,300,40);
	rbMs=new JRadioButton("MS");
	rbMs.setFont(f);
	rbMs.setBounds(10,350,300,40);
	btnSubmit=new JButton("Save");
	btnSubmit.setFont(f);
	btnSubmit.setBounds(200,400,300,40);

	ButtonGroup bg=new ButtonGroup();
	bg.add(rbJob);
	bg.add(rbMba);
	bg.add(rbMs);
	lblName.setOpaque(false);
	rbJob.setOpaque(false);
	rbMba.setOpaque(false);
	rbMs.setOpaque(false);
	c.add(lblName);
	c.add(txtName);
	c.add(lblChoice);
	c.add(rbJob);
	c.add(rbMba);
	c.add(rbMs);
	c.add(btnSubmit);

	ActionListener a1=(ae)->{
		try{
			String name=txtName.getText();
			if(!name.matches("[a-zA-Z ]+"))
				throw new Exception("inv name");
			String choice="";
			if(rbJob.isSelected())		choice="Job";
			else if(rbMba.isSelected())	choice="MBA";
			else if(rbMs.isSelected())	choice="MS";
			else		
				throw new Exception("please choose an option");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kc_2feb23","root","abc456");
			String sql="insert into student values(?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString(2,choice);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(c,"thank u!");	
		}catch(SQLException e){
			JOptionPane.showMessageDialog(c,"Issue: "+e);
			txtName.setText("");
			txtName.requestFocus();
		}catch(Exception e){
			JOptionPane.showMessageDialog(c,"Issue: "+e.getMessage());
			txtName.setText("");
			txtName.requestFocus();
		}
	};
	btnSubmit.addActionListener(a1);
	setTitle("What next?");
	setSize(750,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);
}
}

class A1Test{
public static void main(String[] args)
{
A1 a=new A1();
}
}