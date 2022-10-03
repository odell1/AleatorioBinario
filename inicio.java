
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.instrument.Instrumentation;

public class inicio {

    public static void main(String[] args) {
        inicio.pregunta();

    }

    /**
     * 
     */
    private static void pregunta() {
        int opcion;
        boolean salida = true;

        
        Scanner sc = new Scanner(System.in);

        do {
                opcion=-1;  
            //sc.nextLine();//limpiamos búffer
                System.out.println("1. Introducir datos de una persona");
                System.out.println("2. Imprimir por pantalla todas las personas.");
                System.out.println("3. Imprimir por pantalla una persona. (buscada por su nombre y/o por un identificador)");
                System.out.println("4. Salir");
                System.out.print("Opcion: ");
                try{
                    opcion = sc.nextInt();
                }catch(InputMismatchException ime){
                    System.out.println("¡Cuidado! Solo puedes insertar números. ");
                    sc.nextLine();
                }
            
            switch (opcion) {
                case 1:
                    // Introduce datos
                    System.out.println("Introducir datos de una persona: *-*-*-*-*-*-");
                     Persona aux= new Persona();
                     aux=introduce();
                     try {
                        ficheroAleatorio.EscribeFichAlea(aux);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    break;
                case 2:
                    // Imprime datos
                     try {
                        ficheroAleatorio.LeeFichAlea();
                    } catch (IOException e) {
                        System.out.println("Problemas a la hora de leer el fichero.\n");
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    // inicio.imprimePersona();
                    break;
                case 4:
                    salida=true;
                    break;
                default:
                    salida = false;
                    break;

            } // switch
        } while (!salida);

        sc.close();
    }// pregunta

    private static Persona introduce() {
        //System.out.println(ObjectSizeFetcher.getObjectSize(new Persona("Judas","iscariote",45,500,34,false,false)));
      // System.out.println(ObjectSizeCalculator.getObjectSize(new int[100]));
        //StringBuffer nombre = new StringBuffer();
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce nombre: ");
        String nombre=teclado.nextLine();

        System.out.println("Introduce apellido: ");
        String apellido=teclado.nextLine();

        System.out.println("Introduce edad: ");
        int edad=teclado.nextInt();
        teclado.nextLine();

        System.out.println("Introduce salario: ");
        int salario=teclado.nextInt();
        teclado.nextLine();

        System.out.println("Introduce Número de cervezas: ");
        int numero=teclado.nextInt();
        teclado.nextLine();

        System.out.println("¿Juega a los dardos?");
        boolean dardos=teclado.nextBoolean();
        teclado.nextLine();

        System.out.println("¿Tiene pareja?");
        boolean pareja=teclado.nextBoolean();
        teclado.nextLine();

       Persona miPersona=new Persona(nombre,apellido, edad,salario,numero, dardos,pareja);//"Judas","iscariote",45,500,34,false,false)));
       
        return miPersona;

    }// introduce







}// Class inicio
