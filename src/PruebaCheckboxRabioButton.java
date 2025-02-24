//Si se crean eventos, es mejor hacer la declaracion en tipo instacia

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
									//para los eventos
class VentanaInicio extends JFrame implements ActionListener, KeyListener{
	//las declaramos de instancia, por si se ocupan
	JCheckBox chbx1;
	JTextField caja1;
	JRadioButton radioMillas;
	JRadioButton radioPies;
	JRadioButton radioPulgadas;
	JTextField cajaMillas;
	JTextField cajaPies;
	JTextField cajaPulgadas;
	JButton chbx2;
	
	public VentanaInicio () {
		getContentPane().setLayout(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setTitle("Ejemplo Eventos");
		setSize(300, 400);
		setLocationRelativeTo(null); 
		setVisible(true);
		
		JLabel txt1 = new JLabel ("Ingresa Kilometros: ");
		txt1.setBounds(80, 10, 200, 50);
		add(txt1);
		
		caja1 = new JTextField (5);
		caja1.setBounds(80, 50, 130, 30);
		add(caja1);
		caja1.addKeyListener(this); //limpiar el "campo" y que no salga un resultado anterior hasta que apachurre otra vez el convertir
		
		chbx1 = new JCheckBox ("< < TODOS > >");
		chbx1.setBounds(70, 90, 130, 30);
		add(chbx1);
		
		radioMillas = new JRadioButton("Millas");
		radioMillas.setBounds(70, 130, 70, 30);
		add(radioMillas);
		radioMillas.addActionListener(this);
		
		cajaMillas = new JTextField (5);
		cajaMillas.setBounds(140, 130, 130, 30);
		add(cajaMillas);
		cajaMillas.addActionListener(this);
		cajaMillas.addKeyListener(this);
		
		radioPies = new JRadioButton("Pies");
		radioPies.setBounds(70, 170, 70, 30);
		add(radioPies);
		radioPies.addActionListener(this);
		
		cajaPies = new JTextField (5);
		cajaPies.setBounds(140, 170, 130, 30);
		add(cajaPies);
		cajaPies.addActionListener(this);
		cajaPies.addKeyListener(this);
		
		radioPulgadas = new JRadioButton("Pulgadas");
		radioPulgadas.setBounds(70, 210, 80, 30);
		add(radioPulgadas);
		radioPulgadas.addActionListener(this);
		
		cajaPulgadas = new JTextField (5);
		cajaPulgadas.setBounds(150, 210, 130, 30);
		add(cajaPulgadas);
		cajaPulgadas.addActionListener(this);
		cajaPulgadas.addKeyListener(this);
		
		chbx2 = new JButton("CONVERTIR");
		chbx2.setBounds(50, 250, 200, 50);
		add(chbx2);
		chbx2.addActionListener(this);
		
	}//public VentanaInicio

	//se usa principalmente para manejar acciones realizadas en botones, menus y otros controles que generen eventos en accion
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == chbx2) {
           
			try {
                double km = Double.parseDouble(caja1.getText());
                if (chbx1.isSelected()) { //si se selecciono "todos", convierte todo
                    double millas = ConversorDistancias.kmMillas(km);
                    double pies = ConversorDistancias.kmPies(km);
                    double pulgadas = ConversorDistancias.kmPulgadas(km);
                    
                    cajaMillas.setText(String.format("%.2f", millas));
                    cajaPies.setText(String.format("%.2f", pies));
                    cajaPulgadas.setText(String.format("%.2f", pulgadas));
                    
                } else {
                    // Convertir solo lo seleccionado
                    if (radioMillas.isSelected()) {
                        double result = ConversorDistancias.kmMillas(km);
                        cajaMillas.setText(String.format("%.2f", result)); 
                    } //if radioMillas
                    
                    if (radioPies.isSelected()) {
                        double result = ConversorDistancias.kmPies(km);
                        cajaPies.setText(String.format("%.2f", result));
                    }//if radioPies
                    
                    if (radioPulgadas.isSelected()) {
                        double result = ConversorDistancias.kmPulgadas(km);
                        cajaPulgadas.setText(String.format("%.2f", result));
                    }//if radioPulgadas
                    
                }//else
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Intenta solo ingresando numeros porfa"); //Que muestre un "mensaje" en pnatlla 
            }//try catch
			
        }//if externo
		
    }//actionPerformed

	@Override
	public void keyTyped(KeyEvent e) { }//keyTyped (evento de la tecla escrita)

	@Override
	public void keyPressed(KeyEvent e) { }//keyPressed (evento de la tecla presionada)

	@Override
	//se usa para manejar eventos relacionados con las teclas de teclado, cuando una tecla es liberada
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == caja1) {
	    //limpia las casillitas cuando quita algo del cuadro inicial
		//es lo que esta conectado con la caja1
        cajaMillas.setText("");
        cajaPies.setText("");
        cajaPulgadas.setText("");
        
		}//if
			
	}//keyReleased

}//VentanaInicio

//===================================================================================================================================================

public class PruebaCheckboxRabioButton {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaInicio();
			}
		});	
		
	}//void main

}//public class
