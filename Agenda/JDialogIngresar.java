import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDialogIngresar extends JDialog
{
   private JButton btnIngresar, btnCancelar;
   private JTextField txtUser;
   private JPasswordField passContra;
   private JPanel pia;
   
   
    public JDialogIngresar()
   {  
      //super.setVisible(false);
     //super.dispose();
      initComponents();
   }
   
   private void initComponents()
   {
      //super.setVisible(false);
      //super.dispose();
      setSize(300, 200);
      setTitle("Usuario y contraseña");
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      setResizable(false);
      pia = new JPanel();
      pia.setLayout(new GridLayout(3,2));
      JLabel lblUser = new JLabel("<html>Usuario: <br> (admin)</html>" , JLabel.RIGHT);
      txtUser = new JTextField(15);
      pia.add(lblUser);
      pia.add(txtUser);
      JLabel lblContra = new JLabel("<html>Contraseña: <br> (1234)</html>", JLabel.RIGHT);
      passContra = new JPasswordField(10);
      passContra.setToolTipText("Ingresa Contraseña");
      pia.add(lblContra);
      pia.add(passContra);
      btnIngresar = new JButton("Ingresar");
      btnIngresar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
            action(evt);
         }});
      btnCancelar = new JButton("Cancelar");
      btnCancelar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
            action(evt);
         }});
      pia.add(btnIngresar);
      pia.add(btnCancelar);      
      setContentPane(pia);
      this.setLocationRelativeTo(null);

      setVisible(true);
      
       
   }   
   
   public void action(ActionEvent e){
      String usuario = txtUser.getText();
      String pass = new String(passContra.getPassword());
      if(e.getSource() == btnIngresar) {
         if(usuario.isEmpty() && pass.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingrese su usuario y contraseña");
            txtUser.requestFocus();
         }  else {
            if(usuario.equals("admin") && pass.equals("1234")) {           
               JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
               dispose();

               JFrameTablaDatos tabla = new JFrameTablaDatos();  
                      
            }  else  {
               JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrecta");
               txtUser.setText(null);
               passContra.setText(null);
               txtUser.requestFocus();
            }  
         }
      }   
      if(e.getSource() == btnCancelar) {
         System.exit(0);
      }
   }
}