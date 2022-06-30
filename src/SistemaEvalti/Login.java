package SistemaEvalti;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login {

	// global las etiquetas

	JFrame panel1 = new JFrame();
	JPanel panel2 = new JPanel();
	JLabel image = new JLabel();
	JLabel text1 = new JLabel();
	JLabel text2 = new JLabel();
	JTextField text3 = new JTextField();
	JPasswordField text4 = new JPasswordField();
	JButton boton1 = new JButton();
	JButton boton2 = new JButton();
	int intentos;

	private  void paneles() {
		// login
		panel1.setTitle("Login");
		panel1.setLocationRelativeTo(null);
		panel1.setBounds(600, 300, 350, 500);

		// panel
		panel2.setBackground(Color.white);
		panel2.setBounds(600, 300, 350, 500);
		panel2.setLayout(null);
		panel1.add(panel2);
		panel1.setVisible(true);

		// imagen
		
	
		// user
		text1.setText("Usario ");
		text1.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		text1.setBounds(100, 150, 150, 60);
		text1.setVisible(true);
		panel2.add(text1);
		// password
		text2.setText("Contraseña");
		text2.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		text2.setBounds(100, 250, 80, 60);
		text2.setVisible(true);
		panel2.add(text2);

		// textfield
		text3.setBounds(100, 200, 150, 30);
		
		text4.setBounds(100, 300, 150, 30);
		panel2.add(text3);
		panel2.add(text4);

	}

	private void boton() {
		boton1.setText("Salir");
		boton1.setBounds(170, 350, 100, 40);
		panel2.add(boton1);

		ActionListener Salir = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		};
		boton1.addActionListener(Salir);

		boton2.setText("Registrar");
		boton2.setBounds(50, 350, 100, 40);
		panel2.add(boton2);

		ActionListener Registrar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String usuario = text3.getText();
				String contrania = String.valueOf(text4.getPassword());

				Principal principal = new Principal();

				Usuarios usuario2 = new Usuarios();
				usuario2.setCorreo_electronico(usuario);
				usuario2.setContrasenia(contrania);

				Usuarios usu = principal.obtenerUser(usuario2);

				if (usu != null) {
					JOptionPane.showMessageDialog(null, "Bienvenido");

					this.dispose();
					panel1.setVisible(false);
					Menu menu = new Menu();

					menu.ejecutar();

				} else if (intentos == 3) {
					JOptionPane.showMessageDialog(null, "HA excedido el numero de intentos.Vuele mas tarde", contrania,
							JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "Datos invalidos. \nQuedan " + (3 - intentos) + " Intentos ",
							"Error", JOptionPane.ERROR_MESSAGE);
					intentos = intentos + 1;
				}

			}
			
		

			private void dispose() {
				// TODO Auto-generated method stub

			}
		};
		boton2.addActionListener(Registrar);

	}

	public void ejecutar() {
		paneles();
		boton();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login login01 = new Login();

		login01.ejecutar();

	}

}
