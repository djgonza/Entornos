
/**
 * Representa un triangulo, con sus lados
 * ordenados de menor a mayor.
 * 
 * @author Mikel
 * @version abr 16
 */
public class Triangulo
{
    double a,b,c; // lados de menor a mayor;
    
    /**
     * Constructor de Triangulo por defecto.
     */
    public Triangulo()
    {
        a = 3;
        b = 4;
        c = 5;
    }
    
    /**
     * Constructor de Triangulo equilatero.
     */
    public Triangulo(double lado)
    {
        a = lado;
        b = lado;
        c = lado;
    }
    
    /**
     * Constructor de Triangulo isosceles.
     */
    public Triangulo(double distinto, double repetido)
    {
        b = repetido;
        if (distinto > repetido)
                    { a = repetido;     c = distinto;    }
             else   { a = distinto;     c = repetido;    }
    }

    /**
     * Constructor de Triangulo escaleno.
     */
    public Triangulo(double x, double y, double z)
    {
        double mayor, menor;
        if (x > y)
                  { mayor = x; menor = y; }
           else   { mayor = y; menor = x; } 
        if (x < menor)
            { a = z;     b = menor;     c = mayor; }
            else
            { a = menor;
              if (z < mayor)
                        { b = z;        c = mayor;  }
                 else   { b = mayor;    c = z;      }
            }
    }
    
    public boolean esValido()
    {
        return a > 0 && a + b > c; // lados positivos y se pueden unir.
    }
    
    public boolean esEquilatero()
    {
        return a == c;
    }

    public boolean esIsosceles()
    {
        return (a == b || b == c) && ! esEquilatero();
    }
    
    public boolean esRectangulo()
    {
        return a*a + b*b - c*c < 0.000000001; // con mucha aproximacion
    }
    
    public boolean tieneSoloAngulosAgudos()
    {
        return c*c < a*a + b*b;
    }
    
    public boolean tieneAnguloObtuso()
    {
        return c*c > a*a + b*b && esValido();
    }
    
    public double getAlturaMinima()
    {
        double x = (a*a + c*c - b*b) / (2 * c);
        return Math.sqrt(a*a - x*x);
    }
    
    public double getAlturaMediana()
    {
        double x = (a*a + b*b - c*c) / (2 * b);
        return Math.sqrt(a*a - x*x);
    }
    
    public double getAlturaMaxima()
    {
        double x = (a*a + b*b - c*c) / (2 * a);
        return Math.sqrt(b*b - x*x);
    }
    
    public double getMenor()    { return a; }
    public double getMediano()  { return b; }
    public double getMayor()    { return c; }
    
    public double getPerimetro(){ return a + b + c; }
    public double getArea()     { return c * getAlturaMinima() / 2; }
}
