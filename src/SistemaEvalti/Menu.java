package SistemaEvalti;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Sistema.BranchOfi;
import Sistema.Login;

public class Menu {

	JFrame panel1 = new JFrame();
	JPanel panel2 = new JPanel();
	JLabel image = new JLabel();
	JLabel text1 = new JLabel();
	JLabel text2 = new JLabel();
	JButton boton1 = new JButton();
	JButton boton2 = new JButton();
	JButton boton3 = new JButton();
	JButton boton4 = new JButton();
	Object[] headers = { "id","Nombre", "Apellido", "Rol", "Correo", "Telefono" };

	DefaultTableModel model = new DefaultTableModel(headers, 0);
	JTable table = new JTable();
	

	JScrollPane scroll;
	// Object[][] user = new Usuarios[100][5];

	private void paneles() {
		panel1.setTitle("Hoteles-GT Usuarios");
		panel1.setLocationRelativeTo(null);
		panel1.setBounds(600, 200, 700, 600);

		// panel
		panel2.setBackground(Color.white);
		panel2.setBounds(600, 200, 700, 600);
		panel2.setLayout(null);
		panel1.add(panel2);
		panel1.setVisible(true);

		// imagen

		// user
		text1.setText("Usario: ");
		text1.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		text1.setBounds(500, 10, 100, 100);
		text1.setVisible(true);
		panel2.add(text1);
	}

	public void table() {
	
		TableColumnModel columnModel = new DefaultTableColumnModel();

		TableColumn firstColumn = new TableColumn(1);
		firstColumn.setHeaderValue(headers[0]);
		columnModel.addColumn(firstColumn);

		TableColumn setColum = new TableColumn(2);
		setColum.setHeaderValue(headers[1]);
		columnModel.addColumn(setColum);

		TableColumn setColum1 = new TableColumn(3);
		setColum1.setHeaderValue(headers[2]);
		columnModel.addColumn(setColum1);

		TableColumn setColum2 = new TableColumn(4);
		setColum2.setHeaderValue(headers[3]);
		columnModel.addColumn(setColum2);

		TableColumn setColum3 = new TableColumn(5);
		setColum3.setHeaderValue(headers[4]);
		columnModel.addColumn(setColum3);
		
		TableColumn setColum4 = new TableColumn(6);
		setColum4.setHeaderValue(headers[5]);
		columnModel.addColumn(setColum4);

		table.setColumnModel(columnModel);
		table.setModel(model);

		ArrayList<Usuarios> datos = Principal.listarUsuarios();
	

		Object[] fila = new Object[6];
		for (int i = 0; i < datos.size(); i++) {
			
			fila[0] = datos.get(i).getUsuario_id();
			fila[1] = datos.get(i).getNombre();
			fila[2] = datos.get(i).getApellido();
			fila[3] = datos.get(i).getRol();
			fila[4] = datos.get(i).getCorreo_electronico();
			fila[5] = datos.get(i).getTelefono();
			
			model.addRow(fila);
		}

		scroll = new JScrollPane(table);
		table.setVisible(true);
		scroll.setBounds(60, 70, 400, 350);

		panel2.add(scroll);

	}

	private void botones() {
		// salir
		boton1.setText("Salir");
		boton1.setBackground(Color.red);
		boton1.setBounds(600, 10, 60, 30);
		panel2.add(boton1);

		ActionListener Salir = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.ejecutar();

				panel1.setVisible(false);
			}
		};
		boton1.addActionListener(Salir);

		// agregar

		boton2.setText("Agregar Usuario");
		boton2.setBounds(10, 20, 130, 30);
		panel2.add(boton2);

		ActionListener create_1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				agregar();
			}
		};

		boton2.addActionListener(create_1);
	
		// eliminar
		boton3.setText("Eliminar Usuario");
		boton3.setBounds(150, 500, 150, 30);
		panel2.add(boton3);
		
		ActionListener eliminar_1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Eliminar();
			}
		};

		boton3.addActionListener(eliminar_1);

		// actualizar
		boton4.setText("Modificar usuario");
		boton4.setBounds(400, 500, 150, 30);
		panel2.add(boton4);

	}

	private void agregar() {
		JFrame FrameCre = new JFrame();
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);

		JLabel tex1 = new JLabel();
		JLabel tex2 = new JLabel();
		JLabel tex3 = new JLabel();
		JLabel tex4 = new JLabel();
		JLabel tex5 = new JLabel();
		JLabel tex6 = new JLabel();
		JLabel tex7 = new JLabel();

		JTextField fiel1 = new JTextField();
		JTextField fiel2 = new JTextField();
		JTextField fiel3 = new JTextField();
		JTextField fiel4 = new JTextField();
		JTextField fiel5 = new JTextField();
		JTextField fiel6 = new JTextField();
		JTextField fiel7 = new JTextField();

		JButton button = new JButton();
		JButton button1 = new JButton();
		// lable

		tex6.setText("Nombre:");
		tex6.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		tex6.setBounds(150, 50, 80, 60);
		tex6.setVisible(true);
		panel4.add(tex6);

		tex1.setText("Apellido:");
		tex1.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		tex1.setBounds(150, 100, 80, 60);
		tex1.setVisible(true);
		panel4.add(tex1);

		tex2.setText("Telefono:");
		tex2.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		tex2.setBounds(150, 150, 80, 60);
		tex2.setVisible(true);
		panel4.add(tex2);

		tex3.setText("correo:");
		tex3.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		tex3.setBounds(150, 200, 80, 60);
		tex3.setVisible(true);
		panel4.add(tex3);

		tex4.setText("Fecha Nacimiento ");
		tex4.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		tex4.setBounds(150, 250, 150, 60);
		tex4.setVisible(true);
		panel4.add(tex4);

		tex5.setText("Contraña");
		tex5.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		tex5.setBounds(150, 355, 80, 60);
		tex5.setVisible(true);
		panel4.add(tex5);
		
		
		tex7.setText("Direccion");
		tex7.setFont(new Font("Serig", Font.ROMAN_BASELINE, 14));
		tex7.setBounds(150, 300, 80, 60);
		tex7.setVisible(true);
		panel4.add(tex7);

		JRadioButton radioBoton1 = new JRadioButton("Activo", false);
		radioBoton1.setBackground(Color.white);
		radioBoton1.setBounds(150, 400, 80, 60);
		panel4.add(radioBoton1);

		JRadioButton radioBoton2 = new JRadioButton("Inactiva", false);
		radioBoton2.setBackground(Color.white);
		radioBoton2.setBounds(300, 400, 80, 60);
		panel4.add(radioBoton2);

		ButtonGroup grupoRadioBotones = new ButtonGroup();
		grupoRadioBotones.add(radioBoton1);
		grupoRadioBotones.add(radioBoton2);
		

		// textField
		fiel1.setBounds(250, 60, 150, 30);
		fiel2.setBounds(250, 115, 150, 30);
		fiel3.setBounds(250, 160, 150, 30);
		fiel4.setBounds(250, 210, 150, 30);
		fiel6.setBounds(280, 260, 150, 30);
		fiel5.setBounds(250, 310, 150, 30);
		fiel7.setBounds(250, 360, 150, 30);

		panel4.add(fiel1);
		panel4.add(fiel2);
		panel4.add(fiel3);
		panel4.add(fiel4);
		panel4.add(fiel5);
		panel4.add(fiel6);
		panel4.add(fiel7);

		button.setText("Guardar");
		button.setBounds(200, 500, 100, 30);
		panel4.add(button);
		
		
		
		ActionListener save = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
				
		boolean isActivo = true;
		System.out.println(radioBoton1.isSelected());
		if(radioBoton1.isSelected()) {
			isActivo = true;
		}else if(radioBoton2.isSelected()) {
			isActivo = false;
		}
		
		Usuarios usuarios = new Usuarios();
		usuarios.setNombre(fiel1.getText());
		usuarios.setApellido(fiel2.getText());
		usuarios.setTelefono(Integer.parseInt(fiel3.getText()));
		usuarios.setDireccion(fiel4.getText());
		usuarios.setFecha(fiel6.getText());
		usuarios.setContrasenia(fiel5.getText());
		usuarios.setisActivo(isActivo);
		usuarios.setCorreo_electronico(fiel7.getText());
		Principal.agregar(usuarios);
		
		model.setRowCount(0);
		ArrayList<Usuarios> datos = Principal.listarUsuarios();
		

		Object[] fila = new Object[6];
		for (int i = 0; i < datos.size(); i++) {
			
			fila[0] = datos.get(i).getUsuario_id();
			fila[1] = datos.get(i).getNombre();
			fila[2] = datos.get(i).getApellido();
			fila[3] = datos.get(i).getRol();
			fila[4] = datos.get(i).getCorreo_electronico();
			fila[5] = datos.get(i).getTelefono();
			model.addRow(fila);
		}
		JOptionPane.showMessageDialog(null, "usuario agregado",null, JOptionPane.WARNING_MESSAGE);
		fila.clone();
			}

		};
		button.addActionListener(save);

		button1.setText("Cancelar");
		button1.setBounds(400, 500, 100, 30);
		panel4.add(button1);
		
		ActionListener f_close = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
             Menu mun = new Menu();
             mun.ejecutar();
             panel2.setVisible(false);

			}
		};
		button1.addActionListener(f_close);
		

		FrameCre.setTitle("Hoteles GT- Administrador");
		FrameCre.setBackground(Color.white);
		FrameCre.setBounds(600, 200, 700, 600);
		FrameCre.setVisible(true);

		panel4.setBackground(Color.white);
		FrameCre.add(panel4);

	}
	
	

	private void Eliminar() {
		if (table.getSelectedRow() != -1) {
            int codigo = (int) model.getValueAt(table.getSelectedRow(), 5);

            // Lo imprimimos en pantalla
            System.out.println(codigo);
            Principal.eliminar(codigo);
            model.setRowCount(0);
    		ArrayList<Usuarios> datos = Principal.listarUsuarios();
    		

    		Object[] fila = new Object[6];
    		for (int i = 0; i < datos.size(); i++) {
    			
    			fila[0] = datos.get(i).getUsuario_id();
    			fila[1] = datos.get(i).getNombre();
    			fila[2] = datos.get(i).getApellido();
    			fila[3] = datos.get(i).getRol();
    			fila[4] = datos.get(i).getCorreo_electronico();
    			fila[5] = datos.get(i).getTelefono();
    			model.addRow(fila);
    		}
        } else {
        	JOptionPane.showMessageDialog(null, "Selecione un dato primero",null, JOptionPane.WARNING_MESSAGE);
        }
		

	}

	// Principal p = new Principal();

	public void ejecutar() {
		paneles();
		botones();
		table();
		// p.listarUsuarios();
		Principal.listarUsuarios();

	}

	public static void main(String[] args) {
		Menu menu1 = new Menu();
		menu1.ejecutar();
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
