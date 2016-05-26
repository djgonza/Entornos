public class DemoPatronComposite
{
   public static void main(String[] args)
   {
      Empleado direccion = new Empleado("Juan","direccion", 30000);

        Empleado jv = new Empleado("Roberto","Jefe de ventas", 20000);

        Empleado jm = new Empleado("Miguel","Jefe de Marketing", 20000);

          Empleado mark1 = new Empleado("Laura","Marketing", 10000);
          Empleado mark2 = new Empleado("Pepe","Marketing", 10000);

          Empleado ventas1 = new Empleado("Ricardo","Ventas", 10000);
          Empleado ventas2 = new Empleado("Jose","Ventas", 10000);

      direccion.add(jv);
      direccion.add(jm);

      jv.add(ventas1);
      jv.add(ventas2);

      jm.add(mark1);
      jm.add(mark2);

      //print  Empleados de la organization

      System.out.println(direccion);

      for (Empleado jefe : direccion.getSubordinados())
      {
         System.out.println(jefe);
         for (Empleado empleado : jefe.getSubordinados()) 
            System.out.println(empleado);
      }
   }
}
