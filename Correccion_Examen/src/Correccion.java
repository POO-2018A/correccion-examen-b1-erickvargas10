import java.util.Scanner;
public class Correccion {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        int contadorLibros = 0;
        Autor[] autores = new Autor[3];

        autores[0] = new Autor("A1", "P1");
        autores[1] = new Autor("A2", "P2");
        autores[2] = new Autor("A3", "P3");
        Libro[] libros = new Libro[10];

        do {
            System.out.println("Menu de opciones");
            System.out.println("1._Ingresar nuevo libro a la biblioteca");
            System.out.println("2._Visualizar Lista de libros favoritos");
            System.out.println("3._Libros ingresados");
            System.out.println("4._Salir");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    String titulo;
                    int anio;
                    String favoritoString;
                    boolean favorito;
                    String nombre;
                    String pais;

                    System.out.println("Ingrese el título del libro:");
                    scan.nextLine();
                    titulo = scan.nextLine();

                    System.out.println("Ingrese el año que fue publicado:");
                    anio = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Este libro es favorito? (Si o No)");
                    favoritoString = scan.nextLine();
                    favorito = favoritoString.equals("Si");

                    System.out.println("Seleccione  a que autor pertenece");
                    System.out.println("1. " + autores[0].getNombre());
                    System.out.println("2. " + autores[1].getNombre());
                    System.out.println("3. " + autores[2].getNombre());

                    int opcionAutor = scan.nextInt();
                    scan.nextLine();

                    Autor autorLibro = autores[(opcionAutor - 1)];

                    Libro nuevoLibro = new Libro(titulo, anio, favorito, autorLibro);
                    libros[contadorLibros] = nuevoLibro;
                    contadorLibros++;

                    break;

                case 2:
                    if (contadorLibros== 0) {
                        System.out.println("no existen libros ingresados");
                        break;
                    } else {
                        for (Libro libro : libros) {
                            if (libro != null && libro.isFavorito()) {
                                System.out.println(libro);
                            }
                        }
                    }
                    break;
                case 3:
                    if (contadorLibros == 0) {
                        System.out.println("no existen libros ingresados");
                        break;
                    } else {

                        System.out.println("Seleccione el autor  al que pertenece");
                        System.out.println("1. " + autores[0].getNombre());
                        System.out.println("2. " + autores[1].getNombre());
                        System.out.println("3. " + autores[2].getNombre());

                        int opcionAutor1 = scan.nextInt();
                        scan.nextLine();

                        Autor autorSeleccionado = autores[(opcionAutor1 - 1)];

                        int contadorLibrosAutor = 0;

                        for (Libro libro : libros) {
                            if (libro != null && libro.getAutor().equals(autorSeleccionado)) {
                                contadorLibrosAutor++;
                            }
                        }

                        System.out.println("Este autor posee los siguientes libros " + libros );
                    }
                    break;


                case 4:
                    System.out.println("Gracias!");
                    break;

                default:
                    System.out.println("Ingrese opcion correcta");
                    break;

            }
        } while (opcion != 4) ;

        }
    }
