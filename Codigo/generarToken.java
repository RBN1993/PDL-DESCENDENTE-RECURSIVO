import java.util.*;
import java.io.*;

public class generarToken{
	private static ArrayList<MiToken> misTokens=new ArrayList<MiToken>();
		
		public static void insertar(String nombre,String name){
					MiToken s = new MiToken(nombre, "" + name);
					misTokens.add(s);	
		
		}
		public static void imprimir(){
			Iterator<MiToken> it = misTokens.iterator();
			try{
				FileWriter fw = new FileWriter("tokens.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				while(it.hasNext()){
					String token = it.next().toString();
					 fw.write(token);
				}
				bw.close();
				fw.close();
			}catch (IOException ex) {
            System.out.println(ex.getMessage() + " escribiendo el fichero");
			}

		}
}