import java.util.*;

public class Principal {
  //Arreglo dinámico
  static ArrayList<Poligono> poligono = new ArrayList<Poligono>();
  static Scanner entrada = new Scanner(System.in);

  public static void main(String[] args) {
    //Llenar un polígono
    llenarPoligono();

    //Mostrar los datos y el área de cada polígono
    mostrarResultados();
  }

  public static void llenarPoligono() {
    char resp;
    int op;

    do {
      do {
        System.out.println("\nElija el poligono deseado");
        System.out.println("1. Triangulo");
        System.out.println("2. Rectangulo");
        System.out.print("Opcion: ");
        op = entrada.nextInt();
      } while(op < 1 || op > 2);

      switch(op) {
        case 1: llenarTriangulo(); //Llenar un triángulo
          break;
        case 2: llenarRectangulo(); //Llenar un rectángulo
          break;
      }

      System.out.print("\nDesea introducir otro poligono? (s/n): ");
      resp = entrada.next().charAt(0);
      System.out.println("");
    } while(resp == 's' || resp == 'S');
  }

  public static void llenarTriangulo() {
    double lado1, lado2, lado3;

    System.out.print("\nDigite el primer lado del triangulo: ");
    lado1 = entrada.nextDouble();
    System.out.print("Digite el segundo lado del triangulo: ");
    lado2 = entrada.nextDouble();
    System.out.print("Digite el tercer lado del triangulo: ");
    lado3 = entrada.nextDouble();

    Triangulo triangulo = new Triangulo(lado1, lado2, lado3);

    //Guardamos un triángulo dentro de nuestro arreglo dinámico de polígonos
    poligono.add(triangulo);
  }

  public static void llenarRectangulo() {
    double lado1, lado2;

    System.out.print("\nDigite el primer lado del rectangulo: ");
    lado1 = entrada.nextDouble();
    System.out.print("Digite el segundo lado del rectangulo: ");
    lado2 = entrada.nextDouble();

    Rectangulo rectangulo = new Rectangulo(lado1, lado2);

    //Guardamos un rectángulo dentro de nuestro arreglo dinámico de polígonos
    poligono.add(rectangulo);
  }

  public static void mostrarResultados() {
    //Recorremos el arreglo dinámico de polígonos
    for(Poligono poli : poligono) {
      System.out.println(poli.toString());
      System.out.println("El area es igual a " + poli.area());
      System.out.println("");
    }
  }
}