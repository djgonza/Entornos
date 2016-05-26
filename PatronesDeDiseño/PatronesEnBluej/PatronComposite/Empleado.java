
import java.util.ArrayList;
import java.util.List;

public class Empleado {
   private String nombre;
   private String depto;
   private int salario;
   private List<Empleado> subordinados;

   // constructor
   public Empleado(String nombre,String depto, int sal)
   {
      this.nombre = nombre;
      this.depto = depto;
      this.salario = sal;
      subordinados = new ArrayList<Empleado>();
   }

   public void add(Empleado e) 
   {
      subordinados.add(e);
   }

   public void remove(Empleado e)
   {
      subordinados.remove(e);
   }

   public List<Empleado> getSubordinados()
   {
     return subordinados;
   }

   public String toString()
   {
      return ("Empleado :[ nombre : " + nombre + ", depto : " + depto
        + ", salario :" + salario+" ]");
   }
}
