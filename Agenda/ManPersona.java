import java.util.*;

public class ManPersona
{
   static ArrayList<Persona> ArrPersona = new ArrayList<Persona>();
   private Persona objPersona;
   public int numCelda;
  
   public ManPersona()
   {}
  
   public void Agregar(String nom, String ape, String tel, String correo, String tipo)
   {
      objPersona = new Persona();
      objPersona.setNombre(nom);
      objPersona.setApellidos(ape);
      objPersona.setTelefono(tel);
      objPersona.setCorreos(correo);
      objPersona.setTipo(tipo);
    
      ArrPersona.add(objPersona); //Agregando el objeto al arraylist
   }
   

   
   public Persona MandarPersona(int x){
      objPersona = ArrPersona.get(x);
      return objPersona;
   }
   
   
  
   public void Modificar(String nom, String ape, String tel, String correo, String tipo) {
      objPersona = new Persona();
      objPersona.setNombre(nom);
      objPersona.setApellidos(ape);
      objPersona.setTelefono(tel);
      objPersona.setCorreos(correo);
      objPersona.setTipo(tipo);

      ArrPersona.set(numCelda, objPersona);
   }
   
   public void Eliminar(int x) {
      ArrPersona.remove(x);
   }
  
   public ArrayList Datos() {
      return ArrPersona;
   }
}