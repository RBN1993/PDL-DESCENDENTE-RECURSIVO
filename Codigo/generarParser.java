import java.util.*;
import java.io.*;

public class generarParser{

	public static void imprimir(){		
		try{
			FileWriter fw = new FileWriter("parser.txt");
			
			fw.write(LexicoSintactico.parser);
		
			fw.close();
		}catch (IOException ex) {
            System.out.println(ex.getMessage() + " escribiendo el fichero");
		}

	}
}