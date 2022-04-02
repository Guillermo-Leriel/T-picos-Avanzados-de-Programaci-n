import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class JFrameTablaDatos extends JFrame
{
   JTable tabla;
   JScrollPane scroll = new JScrollPane();
   JButton salir, agregar, modificar, eliminar;
   ManPersona mp = new ManPersona();
   ArrayList<Persona> datosPer = new ArrayList<Persona>();
   JPanel tdb = new JPanel();
   JPanel td = new JPanel();
   
   public JFrameTablaDatos()
   {  
      //super.setVisible(false);
      setLayout(new BorderLayout());
      initComponents();
      
      //dispose();
   }
   
   private void initComponents()
   {
      //super.setVisible(false);
      //super.dispose();
      setSize(800, 800);
      setTitle("Contactos Registrados");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      datosPer = mp.Datos();
      String titulos [] = {"Nombre" , "Fecha de cumpleaños", "Telefono", "Correo Electronico", "Tipo"};
      String info [][] = obtenerDatos();
      tdb.setLayout(new GridLayout(0,1));
      td.setLayout (new GridLayout(2,2));
      
      
      agregar = new JButton("Agregar");
      agregar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
            action(evt);
      }});
      salir = new JButton("Salir");
      salir.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
            action(evt);
      }});
      modificar = new JButton("Modificar");
      modificar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
            action(evt);
      }});
      eliminar = new JButton("Eliminar");
      eliminar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
            action(evt);
      }});
      tabla = new JTable(info, titulos);
      tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      scroll.setViewportView(tabla);
      tdb.add(scroll); 
      td.add(agregar);
      td.add(modificar);
      td.add(eliminar);
      td.add(salir);
      this.add(tdb, BorderLayout.NORTH);
      this.add(td);
      this.setLocationRelativeTo(null);

      setVisible(true);
       
   }
   
   private String[][] obtenerDatos(){
      int x=0;
      String informacion[][] = new String[datosPer.size()][5];
      Iterator<Persona> itrPersona = datosPer.iterator();
      while(itrPersona.hasNext()){
         Persona persona = itrPersona.next();
         informacion[x][0] = persona.getNombre();
         informacion[x][1] = persona.getApellidos();
         informacion[x][2] = persona.getTelefono();
         informacion[x][3] = persona.getCorreos();
         informacion[x][4] = persona.getTipo();
         x++;
      }
      return informacion;
   }
    public void action(ActionEvent e){
      /*String usuario = txtUser.getText();
      String pass = new String(passContra.getPassword());
      */
      if(e.getSource() == agregar) {
         dispose();
         JDialogMostrar mostrar = new JDialogMostrar();
      }   
      if(e.getSource() == modificar) {
         int celda = tabla.getSelectedRow();
         if(celda != -1) {
            dispose();
            JDialogModificar mod = new JDialogModificar(celda);
         }  else  {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro",
            "Error", JOptionPane.ERROR_MESSAGE);
         }
      } 
      if(e.getSource() == eliminar) {
         int celda = tabla.getSelectedRow();
         if(celda != -1) {
            int resp = JOptionPane.showConfirmDialog(null, 
		      "Realmente desea eliminar este registro?", "Eliminacion de registro", 
            JOptionPane.YES_NO_OPTION);        
            if (resp == JOptionPane.YES_OPTION) {
   	         mp.Eliminar(celda);
               dispose();
               JFrameTablaDatos td = new JFrameTablaDatos();
            }
         }  else  {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro",
            "Error", JOptionPane.ERROR_MESSAGE);
         }
      }
      if(e.getSource() == salir) {
         System.exit(0);
      }
   }   
}