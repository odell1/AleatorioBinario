import java.io.*;


public class ficheroAleatorio {

	final String ficherete="aleatorio.dat";
    
  ////////////////////////////////////////////
  ////////////////////////////////////////////
  ////////////////////////////////////////////  
    public static void EscribeFichAlea(Persona nuevaPersona) throws IOException {
		
		//ObjectOutputStream salida=null;
		//byte []array=null;
		//File fichero = new File("aleatorio.dat");
		
		RandomAccessFile archivo = new RandomAccessFile("aleatorio.dat"/*fichero*/, "rw");

         // Ponemos el puntero al final del archivo
         archivo.seek(archivo.length());
				 
        // Serializamos el objeto Persona
        // Lo convertimos en una secuencia de bytees.
        //ByteArrayOutputStream escribir = new ByteArrayOutputStream();
        //salida = new ObjectOutputStream(escribir);
        //salida.writeObject(nuevaPersona.getTodo());
		
		// //Cerramos el objeto
		// salida.close();
		
		// //obtenemos los bytes del libro serializado
		// array = escribir.toByteArray();
		
		// // Escribimos los bytes en el archivo.
		// archivo.write(array);
		
		//file.writeInt(p.getId());
		StringBuffer sb=new StringBuffer(nuevaPersona.getNombre());
		sb.setLength(10);
		System.out.println(nuevaPersona.getNombre());
        archivo.writeChars(sb.toString());
		StringBuffer sc=new StringBuffer(nuevaPersona.getApellido());
		sc.setLength(10);
		archivo.writeChars(sc.toString());
		archivo.writeInt(nuevaPersona.getEdad());
		archivo.writeInt(nuevaPersona.getNumeroCervezas());
		archivo.writeDouble(nuevaPersona.getSalario());
		archivo.writeBoolean(nuevaPersona.isJuegaDardos());
		archivo.writeBoolean(nuevaPersona.isTienePareja()); 

		
		System.out.println("Datos escritos");
		archivo.close();
		
	}
	
////////////////////////////////////////////
  ////////////////////////////////////////////
  ////////////////////////////////////////////  
  // Método para leer el archivo de acceso aleatorio
    public static void LeeFichAlea() throws IOException{
			
			
			RandomAccessFile archivo = new RandomAccessFile("aleatorio.dat", "r");
			byte []array=null;
            
			ByteArrayInputStream leer=null;
			ObjectInputStream entrada = null;

			Persona nuevaPersona=new Persona();
		try{
            // Nos posicionamos al principio del fichero
            archivo.seek(0);
             
            // Almacenamos los bytes del fichero en un array de bytes
            array = new byte[(int)archivo.length()];
             
            // Leemos todos los bytes del fichero
            archivo.readFully(array);
             
            // Convertimos ese array de bytes en un objeto.
            leer = new ByteArrayInputStream(array);
            entrada = new ObjectInputStream(leer);
             
            /* Hacemos una conversion de lo que lee el ObjectInputStream
            a un objeto de tipo Persona y lo almacenamos
            en la variable objeto nuevaPersona*/
            nuevaPersona=(Persona) entrada.readObject();

            System.out.println(nuevaPersona);

            // Cerramos el objeto ObjectInputStream
            entrada.close();
			archivo.close();
             
        } catch (Exception e) {
            System.out.println("No se puede leer el archivo"
            + e.getMessage());
        }


		// File fichero = new File("aleatorio.dat");
		// RandomAccessFile file = new RandomAccessFile(fichero, "r");
		
		// int id, edad = 0, numeroCerves=0, posicion=0;
		// Double salario;
		// boolean dardos, pareja;
		// char apellido[] = new char[10], aux;
		// char nombre[] = new char[10], auxN;
		
		// for(;;){
		// 	file.seek(posicion);
		// 	id = file.readInt();

		// //recorro uno a uno los caracteres del apellido
		// for (int i = 0; i < apellido.length; i++) {

		// 	aux = file.readChar();
	
		// 	apellido[i] = aux; //\os voy guardando en el array
		// }
		// for (int i = 0; i < nombre.length; i++) {

		// 	auxN = file.readChar();
	
		// 	nombre[i] = auxN; //\os voy guardando en el array
		// }
		// //convierto a String el array

		// String apellidos = new String(apellido) ;
		// String nombres = new String(nombre) ;
		// id = file.readInt(); //obtengo dep
		// salario = file.readDouble(); //obtengo salario

		// if(id >0)
		// System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",
		// id, apellidos.trim(), edad, salario);

		// //me posiciono para el sig empleado, cada empleado ocupa 36 bytes
		// posicion= posicion + 42;

		// //Si he recorrido todos los bytes salgo del for
		// if (file.getFilePointer() == file.length())break;

		// }//fin bucle for
		// file.close(); //cerrar fichero
	}


}//FicheroAleatorio
