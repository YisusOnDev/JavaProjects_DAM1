package mainapp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Student;
import java.awt.event.ActionListener;

/**
 * Esta clase implementará directamente la clase Student sin un controlador o modelo
 * de BD para simplificar el ejercicio.
 * 
 * 
 * @author adrig
 *
 */
public class MainApp extends JFrame implements ActionListener{

	private int studentController = 0;
	private boolean readyToAdd = false;
	private static ArrayList<Student> list = new ArrayList<Student>();
	private JPanel contentPane;
	private JTextField textF_studentNum;
	private JTextField textF_studentName;
	private JTextField textF_studentGroup;
	private TextPrompt textP_studentName;
	private TextPrompt textP_userGroup;
	private JLabel lbl_Welcome;
	JLabel lbl_StudentReg;
	private JLabel background;
	private JButton jbutton_New;
	private JButton jbutton_Add;
	private JButton jbutton_Previous;
	private JButton jbutton_Next;

	/**
	 * Create the frame.
	 */
	public MainApp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imges\\iconDB.png"));
		contentPane = new JPanel();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 425, 480);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// LABELS
		lbl_Welcome = new JLabel("Welcome!");
		lbl_Welcome.setBounds(150, 21, 130, 42);
		lbl_Welcome.setFont(new Font("Corbel", Font.BOLD, 24));
		lbl_Welcome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl_Welcome);
		lbl_StudentReg = new JLabel("Student Registration");
		lbl_StudentReg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_StudentReg.setFont(new Font("Corbel", Font.PLAIN, 20));
		lbl_StudentReg.setBounds(131, 83, 175, 42);
		contentPane.add(lbl_StudentReg);
		
		// TEXT FIELDS
		// NUM
		textF_studentNum = new JTextField();
		textF_studentNum.disable(); // Never editable
		textF_studentNum.setBounds(150, 136, 130, 25);
		textF_studentNum.setColumns(10);
		textF_studentNum.setForeground(new Color(150, 0, 0));
		textF_studentNum.setDisabledTextColor(new Color(150, 0, 0));
		textF_studentNum
				.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(5, 10, 5, 5)));
		contentPane.add(textF_studentNum);
		// NAME
		textF_studentName = new JTextField();
		textF_studentName.setBounds(150, 183, 130, 25);
		textF_studentName.setHorizontalAlignment(SwingConstants.LEFT);
		textF_studentName.setColumns(10);
		textF_studentName.setForeground(new Color(150, 0, 0));
		textF_studentName.setDisabledTextColor(new Color(150, 0, 0));
		textF_studentName
				.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(5, 10, 5, 5)));
		getContentPane().add(textF_studentName);
		// GROUP
		textF_studentGroup = new JTextField();
		textF_studentGroup.setBounds(150, 233, 130, 25);
		textF_studentGroup.setColumns(10);
		textF_studentGroup.setForeground(new Color(150, 0, 0));
		textF_studentGroup.setDisabledTextColor(new Color(150, 0, 0));
		textF_studentGroup
				.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(5, 10, 5, 5)));
		contentPane.add(textF_studentGroup);

		// PLACEHOLDERS - Podéis ignorar esto
		// NUM
		textP_studentName = new TextPrompt("Student ID", textF_studentNum);
		textP_studentName.setHorizontalAlignment(SwingConstants.LEADING);
		textP_studentName.changeAlpha(0.75f);
		textP_studentName.setForeground(new Color(150, 0, 0, 180));
		textP_studentName.changeStyle(Font.ITALIC);
		// NAME
		textP_studentName = new TextPrompt("Name", textF_studentName);
		textP_studentName.setHorizontalAlignment(SwingConstants.LEADING);
		textP_studentName.changeAlpha(0.75f);
		textP_studentName.setForeground(new Color(150, 0, 0, 180));
		textP_studentName.changeStyle(Font.ITALIC);
		// GROUP
		textP_userGroup = new TextPrompt("Group", textF_studentGroup);
		textP_userGroup.setHorizontalAlignment(SwingConstants.LEADING);
		textP_userGroup.changeAlpha(0.75f);
		textP_userGroup.setForeground(new Color(150, 0, 0, 180));
		textP_userGroup.changeStyle(Font.ITALIC);

		// BUTTONS
		//NEW
		jbutton_New = new JButton("New");
		jbutton_New.addActionListener(this);
		jbutton_New.setFont(new Font("Arial", Font.PLAIN, 14));
		jbutton_New.setBounds(169, 335, 80, 23);
		jbutton_New.setForeground(new Color(255, 255, 255));
		jbutton_New.setBackground(new Color(122, 214, 125));
		jbutton_New
				.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(5, 0, 5, 0)));
		contentPane.add(jbutton_New);
		// ADD
		jbutton_Add = new JButton("Add");
		jbutton_Add.addActionListener(this);
		jbutton_Add.setFont(new Font("Arial", Font.PLAIN, 14));
		jbutton_Add.setBounds(169, 291, 80, 23);
		jbutton_Add.setBackground(new Color(0.76f, 0.42f, 0.42f));
		jbutton_Add.setForeground(new Color(255, 255, 255));
		jbutton_Add
				.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(5, 0, 5, 0)));
		contentPane.add(jbutton_Add);		
		// PREVIOUS
		jbutton_Previous = new JButton("Previous");
		jbutton_Previous.addActionListener(this);
		jbutton_Previous.setForeground(Color.WHITE);
		jbutton_Previous.setFont(new Font("Arial", Font.PLAIN, 14));
		jbutton_Previous.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(5, 0, 5, 0)));
		jbutton_Previous.setBackground(new Color(194, 107, 107));
		jbutton_Previous.setBounds(79, 313, 80, 23);
		contentPane.add(jbutton_Previous);
		
		jbutton_Next = new JButton("Next");
		jbutton_Next.addActionListener(this);
		jbutton_Next.setForeground(Color.WHITE);
		jbutton_Next.setFont(new Font("Arial", Font.PLAIN, 14));
		jbutton_Next.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(5, 0, 5, 0)));
		jbutton_Next.setBackground(new Color(194, 107, 107));
		jbutton_Next.setBounds(259, 314, 80, 23);
		contentPane.add(jbutton_Next);
		
		// Get create Student form as default
		setReadyToAdd();
		
		// BACKGROUND
		background = new JLabel(new ImageIcon("imges\\background.png"));
		background.setBounds(0, 0, 419, 451);
		contentPane.add(background);
	}
	/**
	 * En este controlador de eventos ocurre lo siguiente:
	 * 
	 * 
	 * Si pulsas "New":
	 * 		Llama a la función readyToAdd. Prepara los campos para poder introducir datos.
	 * 
	 * Si pulssas "Add":
	 * 		Podría comprobar que no ponga Pollo en los campos, pero bueno, directamente crea
	 * 		un alumno con lo que halla. Hora de tener compañeros pollo en la clase pollo.
	 * 		NOTA: El campo ID desaparece mientras se añade un nuevo alumno.
	 * 
	 * Si pulsas "Next":
	 * 		Primero studentController incrementa en uno.
	 * 		Luego se llama a printStudent.
	 * 		Por último establece readyToAdd = false, esto hace que si pulsas Add no añada algo que no quieras.
	 * 
	 * Si pulsas "Previous":
	 * 		Primero studentController decrementa en uno.
	 * 		Luego se llama a printStudent.
	 * 		Por último establece readyToAdd = false, esto hace que si pulsas Add no añada algo que no quieras.
	 * 

	 * 
	 * Es decir, controla cuándo se pulsa un botón y, además, controla qué índice se pasa
	 * a la función printStudent.
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jbutton_New) {
			setReadyToAdd();
		}
		
		if(e.getSource()==jbutton_Add){
			if(readyToAdd==true)
			addStudent(list);
		}
		
		if(e.getSource()==jbutton_Next) {
			if(studentController<list.size()-1) {
				setReadyToShow();
				printStudent(list, ++studentController);
			}			
		}		
		
		if(e.getSource()==jbutton_Previous) {
			if(studentController>0) {
				setReadyToShow();
				printStudent(list, --studentController);
			}
		}
	}
	
	/**
	 * Esta función hace lo siguiente:
	 * 		Llama a eraseFields() para vaciar los campos.
	 * 
	 * 		Cambia el subtítulo para indicar que se van a introducir datos.
	 * 
	 * 		Oculta el campo de Student ID ya que no se desea que el usuario indique el número del alumno,
	 * 		este número se asgna automáticamente por orden de adición (no se pueden ver ni editar).
	 * 
	 * 		Activa los campos de nombre y grupo (hace que se pueda editar), pues por defecto, durante la visualización de alumnos,
	 * 		se encuentran desactivados (no se pueden editar).
	 * 
	 * 		Establece readyToAdd=true, esta variable se utiliza a la hora de confirmar un nuevo registro con un "if".
	 * 	
	 */
	public void setReadyToAdd() {
		eraseFields();
		lbl_StudentReg.setText("Student Registration");
		textF_studentNum.setVisible(false);
		textF_studentName.enable();
		textF_studentGroup.enable();
		readyToAdd=true;
	}
	
	/**
	 * Si has leído getReadyToAdd() deberías ser capaz de entender esta función :)
	 */
	public void setReadyToShow() {
		lbl_StudentReg.setText("Student");
		textF_studentNum.setVisible(true);
		textF_studentName.disable();
		textF_studentGroup.disable();
		readyToAdd=false;
	}
	
	/**
	 * Función que recibe una lista y un índice.
	 * Selecciona el objeto de la lista con dicho índice list.get(index), extrae sus datos y los
	 * incrusta en los campos de texto.
	 * 
	 * @param list Lista de alumnos
	 * @param index El número del alumno deseado.
	 */
	public void printStudent(ArrayList<Student> list, int index) {
		setReadyToShow();
		textF_studentNum.setText(list.get(index).getNum());
		textF_studentName.setText(list.get(index).getName());
		textF_studentGroup.setText(list.get(index).getGroup());
	}
	

	/**
	 * Añado un nuevo objeto con new Student(parámetros).
	 * 
	 * ¿Qué leches hay dentro del nuevo alumno?
	 * Al asignarle list.size()+1 al número del nuevo alumno, su número será el último de la lista.
	 * Uso ejemploTextField.getText() para extraer lo que haya en dichos campos y utilizarlo para crear el nuevo estudiante.
	 * 
	 * @param list Lista a la que añadir un nuevo objeto de tipo Student.
	 */
	public void addStudent(ArrayList<Student> list) {		
		list.add(new Student(list.size()+1,textF_studentName.getText(), textF_studentGroup.getText()));
	}
	
	public void eraseFields() {
		textF_studentNum.setText("");
		textF_studentName.setText("");
		textF_studentGroup.setText("");
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		// FRAME
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		// Aquí genero 4 estudiantes por defecto, aquí no se da la chicha, fíjate en
		// actionPerformed y las funciones a las que llama.
		list = new ArrayList<Student>();
		list.add(new Student(1, "Pepito el del Garrote", " 2 DAM"));
		list.add(new Student(2, "Carlos González", "1 DAW"));
		list.add(new Student(3, "Pipo García", "1 DAM"));
		list.add(new Student(4, "María Matarín", "2 DAM"));		
	}	
}