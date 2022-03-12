import javax.swing.*;
import java.awt.event.*;//paquete para controlar los eventos
import java.awt.*;

public class CalculadoraF1 extends JFrame{
   JLabel Letrero;//Reserva el espacio en memoria
   JButton btnBorrar, btnPunto, btnCero, btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve, btnMas, btnMenos, btnMul, btnDiv, btnRes, btnSalir;
   JTextField txtCal;
   JPanel panel1, panel2;
   private Object objTextField;
  
   public CalculadoraF1()
   {
      this.setLayout(new BorderLayout());
      initComponents();
      panel1.setLayout(new GridLayout(2, 1));
      panel2.setLayout(new GridLayout(5, 4));
   }
  
   private void initComponents()
   {
      setSize(400, 250);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Font fuente = new Font("Dialog", Font.BOLD, 26);
      txtCal = new JTextField(10);//instanciación del objeto
      txtCal.setFont(fuente);
      
      Letrero = new JLabel("Calculadora");
       
      btnBorrar = new JButton("AC");
      btnCero = new JButton("0");
      btnCero.setMnemonic('0');
      btnPunto = new JButton(".");
      btnPunto.setMnemonic('.');
      btnUno = new JButton("1");
      btnUno.setMnemonic('1');
      btnDos = new JButton("2");
      btnDos.setMnemonic('2'); 
      btnTres = new JButton("3");
      btnTres.setMnemonic('3'); 
      btnCuatro = new JButton("4");
      btnCuatro.setMnemonic('4'); 
      btnCinco = new JButton("5");
      btnCinco.setMnemonic('5'); 
      btnSeis = new JButton("6");
      btnSeis.setMnemonic('6'); 
      btnSiete = new JButton("7");
      btnSiete.setMnemonic('7'); 
      btnOcho = new JButton("8");
      btnOcho.setMnemonic('8'); 
      btnNueve = new JButton("9");
      btnNueve.setMnemonic('9'); 
      btnMas = new JButton("+");
      btnMas.setMnemonic('+'); 
      btnMenos = new JButton("-");
      btnMenos.setMnemonic('-'); 
      btnMul = new JButton("*");
      btnMul.setMnemonic('*'); 
      btnDiv = new JButton("/");
      btnDiv.setMnemonic('/'); 
      btnRes = new JButton("=");
      btnRes.setMnemonic('='); 
      btnSalir = new JButton("Salir");
      btnSalir.setMnemonic('S');

      btnBorrar.addMouseListener(new MyListenerBorrar());
      btnPunto.addMouseListener(new MyListenerPoint());
      btnSalir.addMouseListener(new MyListenerExit());
      btnCero.addMouseListener(new MyListenerZero());
      btnUno.addMouseListener(new MyListenerOne());
      btnDos.addMouseListener(new MyListenerTwo());
      btnTres.addMouseListener(new MyListenerThree());
      btnCuatro.addMouseListener(new MyListenerFour());
      btnCinco.addMouseListener(new MyListenerFive());
      btnSeis.addMouseListener(new MyListenerSix());
      btnSiete.addMouseListener(new MyListenerSeven());
      btnOcho.addMouseListener(new MyListenerEight());
      btnNueve.addMouseListener(new MyListenerNine());
      btnMas.addMouseListener(new MyListenerPlus());
      btnMenos.addMouseListener(new MyListenerMinus());
      btnMul.addMouseListener(new MyListenerMultiplied());
      btnDiv.addMouseListener(new MyListenerDivided());
      btnRes.addMouseListener(new MyListenerResult());
      
      panel1 = new JPanel();
      panel1.add(Letrero);
      panel1.add(txtCal);
      txtCal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      txtCal.setBounds(132, 28, 144, 20);
      txtCal.setEditable(false);
      panel2 = new JPanel();
      panel2.add(btnUno);
      panel2.add(btnDos);
      panel2.add(btnTres);
      panel2.add(btnCuatro);
      panel2.add(btnCinco);
      panel2.add(btnSeis);
      panel2.add(btnSiete);
      panel2.add(btnOcho);
      panel2.add(btnNueve);
      panel2.add(btnCero);
      panel2.add(btnPunto);
      panel2.add(btnMas);
      panel2.add(btnMenos);
      panel2.add(btnMul);
      panel2.add(btnDiv);
      panel2.add(btnRes);
      panel2.add(btnSalir);
      panel2.add(btnBorrar);
      btnMas.setEnabled(false);
      btnMul.setEnabled(false);
      btnDiv.setEnabled(false);
      btnMenos.setEnabled(false);
      btnRes.setEnabled(false);
      btnPunto.setEnabled(false);
      btnCero.setEnabled(false);
      
      setTitle("Calculadora De Guillermo Leriel Ordóñez Pérezt");
      this.add(panel1, BorderLayout.NORTH);
      this.add(panel2, BorderLayout.SOUTH);
      
      setVisible(true);
   }
   static boolean operador = false, punto = false, error = false;
   
   private class MyListenerPoint extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         String texto = txtCal.getText() + ".";
         txtCal.setText(texto);
         botonesOper();
         btnCero.setEnabled(true);
         btnRes.setEnabled(false);
         punto = true;
      }
   }
   private class MyListenerZero extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "0";
         txtCal.setText(texto);
      }
   }
   private class MyListenerOne extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "1";
         txtCal.setText(texto);
      }
   }
   private class MyListenerTwo extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "2";
         txtCal.setText(texto);
      }
   }
   private class MyListenerThree extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "3";
         txtCal.setText(texto);
      }
   }
   private class MyListenerFour extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "4";
         txtCal.setText(texto);
      }
   }
   private class MyListenerFive extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "5";
         txtCal.setText(texto);
      }
   }
   private class MyListenerSix extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "6";
         txtCal.setText(texto);
      }
   }
   private class MyListenerSeven extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "7";
         txtCal.setText(texto);
      }
   }
   private class MyListenerEight extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "8";
         txtCal.setText(texto);
      }
   }
   private class MyListenerNine extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesNum();
         String texto = txtCal.getText() + "9";
         txtCal.setText(texto);
      }
   }
   
   private class MyListenerPlus extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         String texto = txtCal.getText() + "+";
         txtCal.setText(texto);
         botonesOper();
         operador = true;
      }
   }
   private class MyListenerMinus extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         String texto = txtCal.getText() + "-";
         txtCal.setText(texto);
         botonesOper();
         operador = true;
      }
   }
   private class MyListenerMultiplied extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         String texto = txtCal.getText() + "*";
         txtCal.setText(texto);
         botonesOper();
         operador = true;
      }
   }
   private class MyListenerDivided extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         String texto = txtCal.getText() + "/";
         txtCal.setText(texto);
         botonesOper();
         operador = true;
      }
   }
   
   private class MyListenerResult extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         calcular();
         operador = false;
         btnPunto.setEnabled(false);
         btnRes.setEnabled(false);
      }
   }
   
   private class MyListenerBorrar extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         botonesOper();
         txtCal.setText("");
      }
   }
   
   private class MyListenerExit extends MouseAdapter {
      public void mouseClicked(MouseEvent event) {
         System.exit(0);
      }
   }
   
   public void botonesNum () {
      btnMas.setEnabled(true);
      btnMenos.setEnabled(true);
      btnMul.setEnabled(true);
      btnDiv.setEnabled(true);
      btnPunto.setEnabled(true);
      btnCero.setEnabled(true);
      if (error == true) {
         txtCal.setText("");
         error = false;
      }
      if (operador == true) {
         btnRes.setEnabled(true);
      }
      if(punto == true) {
         btnPunto.setEnabled(false);
      }
   }
   
   public void botonesOper() {
      btnMas.setEnabled(false);
      btnMul.setEnabled(false);
      btnDiv.setEnabled(false);
      btnRes.setEnabled(false);
      btnMenos.setEnabled(false);
      btnCero.setEnabled(false);
      btnPunto.setEnabled(false);
      punto = false;
   }
   
   public void calcular() {
      boolean finalizar = true, negativo = false;
      int contNeg = 1;
      String opeIni = txtCal.getText(), opeAct = "", opePrimera = txtCal.getText(), subCadenaOpeIni, resFinal = "";  
      char valorAct, operMedio = '+'; 
      double num1 = 0.0f, num2 = 0.0f, numRes = 0.0f, auxRes = 0.0f, valorActNum;
      boolean operMedioExist = false, point = false;  
      
      for(int x = 0; x < opeIni.length(); x++) {
         valorAct = opeIni.charAt(x);
         if(valorAct >= '0' && valorAct <= '9') {
            if (operMedioExist == false) {
               if (point) {
                  valorActNum = Double.parseDouble("" + valorAct) / (Math.pow(10,contNeg));
                  contNeg++;
                  num1 = num1 + valorActNum;
               } else {
                  valorActNum = Double.parseDouble("" + valorAct);
                  num1 = (num1 * 10) + valorActNum;
               }
               if (negativo && num1 != 0) {
                  num1 = num1 * -1;
                  negativo = false;
               }
            } else {
               if (point) {
                  valorActNum = Double.parseDouble("" + valorAct) / (Math.pow(10,contNeg));
                  contNeg++;
                  num2 = num2 + valorActNum;
               } else {
                  valorActNum = Double.parseDouble("" + valorAct);
                  num2 = (num2 * 10) + valorActNum;
               }
            }
         } else if (valorAct == '.') {
            point = true;
         } else if (operMedioExist == false){   
            if(valorAct == '+') {
               opeAct += num1 + "+";
               num1 = 0.0f;
               point = false;
               contNeg = 1;
            } else if (valorAct == '-') {
               if (num1 == 0) {
                  negativo = true;  
               } else {
                  opeAct += num1 + "-";
                  num1 = 0.0f;
                  point = false;
                  contNeg = 1;
               }
            } else if (valorAct == '*') {
               operMedioExist = true;
               operMedio = '*';
               point = false;
            } else if (valorAct == '/') {
               operMedioExist = true;
               operMedio = '/';
               point = false;
            }
         } else {
            if (operMedio == '*') {
               auxRes = (double) Math.round((num1 * num2) * 1000000.0) / 1000000.0;
               subCadenaOpeIni = opeIni.substring(x, opeIni.length());
               opePrimera = opeAct + auxRes + subCadenaOpeIni; 
               num1 = auxRes;
               num2 = 0.0;
               operMedioExist = false;
               point = false;
               contNeg = 1;
            } else {
               if (num2 == 0.0 || num2 == 0) {
                  txtCal.setText("ERROR");
                  error = true;
                  return;
               }
               auxRes = (double) Math.round((num1 / num2) * 1000000.0) / 1000000.0;
               subCadenaOpeIni = opeIni.substring(x, opeIni.length());
               opePrimera = opeAct + auxRes + subCadenaOpeIni; 
               num1 = auxRes;
               num2 = 0.0;
               operMedioExist = false;
               point = false;
               contNeg = 1;
            }
         }
         if (valorAct == '*') {
            operMedioExist = true;
            operMedio = '*';
         } else if (valorAct == '/') {
            operMedioExist = true;
            operMedio = '/';
         } 
      }
      if(operMedioExist == true) { 
         if (operMedio == '*') {
            auxRes = (double) Math.round((num1 * num2) * 1000000.0) / 1000000.0;
            opePrimera = opeAct + auxRes;
         } else {
            if (num2 == 0.0 || num2 == 0) {
              txtCal.setText("ERROR");
              error = true;
              return;
            }
            auxRes = (double) Math.round((num1 / num2) * 1000000.0) / 1000000.0;
            opePrimera = opeAct + auxRes; 
         }   
      }
      
      auxRes = 0.0;
      num1 = auxRes;
      num2 = 0.0;
      opeAct = "";
      opeIni = opePrimera;
      point = false;
      operMedioExist = false;
      contNeg = 1;
      
      for(int x = 0; x < opeIni.length(); x++) {
         valorAct = opeIni.charAt(x);
         if(valorAct >= '0' && valorAct <= '9') {
            if (operMedioExist == false) {
               if (point) {
                  valorActNum = Double.parseDouble("" + valorAct) / (Math.pow(10,contNeg));
                  contNeg++;
                  num1 = num1 + valorActNum;
               } else {
                  valorActNum = Double.parseDouble("" + valorAct);
                  num1 = (num1 * 10) + valorActNum;
               }
               if (negativo && num1 != 0) {
                  num1 = num1 * -1;
                  negativo = false;
               }
            } else {
               if (point) {
                  valorActNum = Double.parseDouble("" + valorAct) / (Math.pow(10,contNeg));
                  contNeg++;
                  num2 = num2 + valorActNum;
               } else {
                  valorActNum = Double.parseDouble("" + valorAct);
                  num2 = (num2 * 10) + valorActNum;
               }
            }
         } else if (valorAct == '.') {
            point = true;
         } else if (operMedioExist == false){   
            if(valorAct == '+') {
               operMedioExist = true;
               operMedio = '+';
               point = false;
               contNeg = 1;
            } else if (valorAct == '-') {
               if (num1 == 0) {
                  negativo = true;  
               } else {
                  operMedioExist = true;
                  operMedio = '-';
                  point = false;
                  contNeg = 1;
               }
            }
         } else {
            if (operMedio == '+') {
               auxRes = (double) Math.round((num1 + num2) * 1000000.0) / 1000000.0;
               subCadenaOpeIni = opeIni.substring(x, opeIni.length());
               opePrimera = opeAct + auxRes + subCadenaOpeIni; 
               num1 = auxRes;
               num2 = 0.0;
               point = false;
               operMedioExist = false;
            } else {
               auxRes = (double) Math.round((num1 - num2) * 1000000.0) / 1000000.0;
               subCadenaOpeIni = opeIni.substring(x, opeIni.length());
               opePrimera = opeAct + auxRes + subCadenaOpeIni; 
               num1 = auxRes;
               num2 = 0.0;
               point = false;
               operMedioExist = false;
            }
         }
      }
      if (operMedio == '+') {
         auxRes = (double) Math.round((num1 + num2) * 1000000.0) / 1000000.0;
         opePrimera = opeAct + auxRes;
      } else {
         auxRes = (double) Math.round((num1 - num2) * 1000000.0) / 1000000.0;
         opePrimera = opeAct + auxRes; 
      } 
      resFinal = opePrimera;
      txtCal.setText(resFinal);  
   }
}