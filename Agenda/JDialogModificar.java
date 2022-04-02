import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDialogModificar extends JDialog
{
   private JButton btnGuardar, btnCancelar;
   private JTextField txtNombre, txtApellidos, txtTel, txtCorreo;
   private JRadioButton tec, trabajo;
  
   private ManPersona mpa = new ManPersona();
   private Persona p;
   
   private JPanel mod = new JPanel();
   
   private int numCelda;
   
    public JDialogModificar(int celda)
   {  
      //super.setVisible(false);
     //super.dispose();
     numCelda = celda;
      initComponents();
   }
   
   private void initComponents()
   {
      //super.setVisible(false);
      //super.dispose();
      setSize(300, 200);
      setTitle("AGENDA");
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      setResizable(false);
      
      p = mpa.MandarPersona(numCelda);
      mod.setLayout(new GridLayout(7,2));
      JLabel lblNombre = new JLabel("Nombre: ", JLabel.RIGHT);
      txtNombre = new JTextField(15);
      String nombre = p.getNombre();
      txtNombre.setText(nombre);
      mod.add(lblNombre);
      mod.add(txtNombre);
       
      JLabel lblApellidos = new JLabel("Fecha de cumpleaños (dd/mm/aaaa): ", JLabel.RIGHT);
      txtApellidos = new JTextField(20);
      txtApellidos.setText(p.getApellidos());
      mod.add(lblApellidos);
      mod.add(txtApellidos);
       
      JLabel lblTel = new JLabel("Numero de Celular: ", JLabel.RIGHT);
      txtTel = new JTextField(15);
      txtTel.setText(p.getTelefono());
      mod.add(lblTel);
      mod.add(txtTel);
   
      JLabel lblCorreo = new JLabel("Correo Electronico: ", JLabel.RIGHT);
      txtCorreo = new JTextField(20);
      txtCorreo.setText(p.getCorreos());
      mod.add(lblCorreo);
      mod.add(txtCorreo);
   
      JLabel lblTipo = new JLabel("CONOCIDO DE...", JLabel.CENTER);
      JLabel lblTipo2 = new JLabel(" ", JLabel.CENTER);
      mod.add(lblTipo);
      mod.add(lblTipo2);
       
      ButtonGroup gpoBotones = new ButtonGroup();
      if(p.getTipo() == "Tecnologico") {
         tec = new JRadioButton("Tecnologico", true);
         trabajo = new JRadioButton("Trabajo");
      } else  {
         tec = new JRadioButton("Tecnologico");
         trabajo = new JRadioButton("Trabajo", true);
      }
      gpoBotones.add(tec);
      gpoBotones.add(trabajo);
       
      mod.add(tec);
      mod.add(trabajo);
       
      btnGuardar = new JButton("Guardar");
      btnGuardar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
            action(evt);
      }});
      
      btnCancelar = new JButton("Cancelar");
      btnCancelar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
            action(evt);
      }});
       
      mod.add(btnGuardar);
      mod.add(btnCancelar);

      
      setContentPane(mod);
      this.setLocationRelativeTo(null);

      setVisible(true);
       
   }   
   
   public void action(ActionEvent e)
  {
     String tipo = "Tecnologico";
     if(trabajo.isSelected())
         tipo = "Trabajo";
     if(e.getSource() == btnGuardar){
         boolean validacionNombre = false;         
         boolean validacionNum = false;
         boolean validacionCum = false;
          
         for(int x = 0; x < txtNombre.getText().length(); x++){   
            int num = (int) txtNombre.getText().charAt(x);           
            if((num < 97 || num > 122) && (num < 65 || num > 90) ){
               validacionNombre = true;              
            }  
         }    
         
         for(int x = 0; x < txtTel.getText().length(); x++){              
            if((txtTel.getText().charAt(x) < '0' || txtTel.getText().charAt(x) > '9') ){
               validacionNum = true;              
            }  
         } 
         
         for(int x = 0; x < txtApellidos.getText().length(); x++){              
            if(txtApellidos.getText().charAt(x) < '0' || txtApellidos.getText().charAt(x) > '9'  ){
               validacionCum = true;              
            }  
            if(txtApellidos.getText().charAt(x) == '/' ) {
               validacionCum = false;    
            }
         }      
         
         if(validacionNombre) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un nombre valido",
            "Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtNombre.requestFocus();
         }
         else
         if(validacionCum) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un cumpleaños valido",
            "Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtApellidos.requestFocus();
         }
         else

         if(validacionNum) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un telefono valido",
            "Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtTel.requestFocus();
         }
         else

        if(txtNombre.getText() == null || txtNombre.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(null, "Debes colocar al menos el nombre",
          "Aviso", JOptionPane.INFORMATION_MESSAGE);
          txtNombre.requestFocus();
        }
        else
        if(txtTel.getText() == null || txtTel.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(null, "Debes capturar el telefono celular",
          "Aviso", JOptionPane.INFORMATION_MESSAGE);
          txtTel.requestFocus();
        }
       else
       {
         mpa.Modificar(txtNombre.getText(), txtApellidos.getText(), txtTel.getText(),
         txtCorreo.getText(), tipo);
         
         JOptionPane.showMessageDialog(null, "Se guardaran los datos",
         "Aviso", JOptionPane.INFORMATION_MESSAGE);
         dispose();
         JFrameTablaDatos jft = new JFrameTablaDatos();
       
       }
    }
    
    if(e.getSource()==btnCancelar){
       dispose();
       JFrameTablaDatos jft = new JFrameTablaDatos();
       //mpa.mostrar();
       //System.exit(0);
    }    
       
  }
}