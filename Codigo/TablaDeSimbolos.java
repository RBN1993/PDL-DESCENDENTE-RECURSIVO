import java.util.*;
import java.io.*;

public class TablaDeSimbolos{

	public static ArrayList<FormatoTS> tsg = new ArrayList<FormatoTS>();
    public static ArrayList<FormatoTS> tsl = new ArrayList<FormatoTS>();
	// public static ArrayList<FormatoTS> tablaEntera = new ArrayList<FormatoTS>();
	public static String titulo="";
	public static int contFuncion = 1;
	
	//################ GLOBAL #####################
	public static int posicion;
	
	
	//################ LOCAL #####################
	public static int posicionTsl=0;
	
    public static void crearTablaGlobal()
    {
		
    	// FormatoTS --> lexema, tipo,nParam, array tipoParams
    	tsg.add(new FormatoTS("","var", "PalRes", 0,null));
    	tsg.add(new FormatoTS("","function", "PalRes", 0,null));
    	tsg.add(new FormatoTS("","prompt", "PalRes", 0, null));
    	tsg.add(new FormatoTS("","write", "PalRes", 0,null));
    	tsg.add(new FormatoTS("","while", "PalRes", 0,null));
    	tsg.add(new FormatoTS("","if", "PalRes", 0, null));
    	tsg.add(new FormatoTS("","return", "PalRes", 0,null));
    	tsg.add(new FormatoTS("","int", "PalRes", 0,null));
    	tsg.add(new FormatoTS("","chars", "PalRes", 0,null));
    	tsg.add(new FormatoTS("","bool", "PalRes", 0,null));
		tsg.add(new FormatoTS("","true", "PalRes", 0,null));
    	tsg.add(new FormatoTS("","false", "PalRes", 0,null));
    }

 //################ GLOBAL #####################
	
	public static void insertarTsgFun(FormatoTS token){
		
		tsg.add(posicion,token);
		imprimirFun();
		posicion++;
		
	}
	public static void insertarTsgVar(FormatoTS token){
		tsg.add(posicion,token);
		imprimirVar();
		posicion++;
	}
	
	
	public static boolean buscarFunTsg(String kind, String lexema, String tipo , int param, ArrayList<String> tipoParams){
		String k;
		String lex;
		String type;
		int n;
		ArrayList<String> types = new ArrayList<String>();
		Iterator it = tsg.listIterator();
            while (it.hasNext()){
				FormatoTS s = (FormatoTS)it.next();
				k = s.kind;
                lex = s.lexema;
				type = s.tipo;
				n = s.nParam;
				types = s.tipoParams;
				if (k.equals(kind)&&lex.equals(lexema)&&tipo.equals(type)&&param==n&&tipoParams.equals(types)) {
					// System.err.println("Ya existe la variable/funcion declarada -->"+s.lexema);
                    return true;
                }
			}
		return false;
	}
	
	public static boolean busquedaFuncion(String kind,String lexema, String tipo , int param, ArrayList<String> tipoParams){//Busqueda de funcion
		if(buscarFunTsg(kind,lexema,tipo,param,tipoParams)==false){
		
			return false;
		}
		return true;
	}
	public static boolean buscarVarTsg(String kind, String lexema){//Busqueda var para diferenciar de function
		String k;
		String lex;
		Iterator it = tsg.listIterator();
            while (it.hasNext()){
				FormatoTS s = (FormatoTS)it.next();
				k = s.kind;
				lex = s.lexema;
				if (k.equals(kind)&&lex.equals(lexema)) {
					// System.err.println("Ya existe la variable/funcion declarada -->"+s.lexema);
                    return true;
                }
			}
		return false;
	}
	
	public static boolean busquedaVar(String kind,String lexema){//Busqueda var
		if(buscarVarTsg(kind,lexema)==false){//Busqueda var para diferenciar de function
			return false;
		}
		return true;
	}
	
	public static void imprimirFun(){
		try{
			FileWriter fw = new FileWriter("TablaDeSimbolos.txt",true);
			// System.out.println("ENTRE EN FUNCION");
			fw.write("TABLA PRINCIPAL #"+contFuncion+":\n");
			contFuncion++;
			String token = tsg.get(posicion).toString();
			fw.write(token);
			fw.close();
		}catch (IOException ex) {
            System.out.println(ex.getMessage() + " escribiendo el fichero");
		}	
	}
	
	public static void imprimirVar(){
		
		try{
			FileWriter fw = new FileWriter("TablaDeSimbolos.txt",true);
			// System.out.println("ENTRE EN VARIABLE");
			fw.write("TABLA PRINCIPAL CON VARIABLES #"+contFuncion+":\n");
			contFuncion++;
			String token = tsg.get(posicion).toStringVar();
			fw.write(token);
			fw.close();
		}catch (IOException ex) {
            System.out.println(ex.getMessage() + " escribiendo el fichero");
		}	
	}
	public static void imprimirPalR(){
		Iterator<FormatoTS> it = tsg.iterator();
		try{
			FileWriter fw = new FileWriter("TablaDeSimbolos.txt",true);
			fw.write("TABLA PRINCIPAL PALABRAS RESERVADAS #"+contFuncion+":\n");
			contFuncion++;
			int i=0;
			while(i<12){
					String token = it.next().toStringPalR();
					fw.write(token);
					posicion=12;
					i++;
			}	
			fw.write("---------------------------------------------------------\n");
			
			fw.close();
		}catch (IOException ex) {
            System.out.println(ex.getMessage() + " escribiendo el fichero");
		}
	}
	
	//################ LOCAL #####################
	public static void setTablesLocal(){
		tsl.clear();
		posicionTsl=0;
	}
	public static void insertarTslParam(FormatoTS token){
		tsl.add(token);
		// imprimirTslVar();
		
		posicionTsl++;
	}
	
	public static void insertarTslVar(FormatoTS token){
		tsl.add(token);
		imprimirTslVar();
		
		posicionTsl++;
	}
	public static boolean buscarParamTsl(String lexema){
		String lex;
		Iterator it = tsl.listIterator();
            while (it.hasNext()){
				FormatoTS s = (FormatoTS)it.next();
                lex = s.lexema;
				if (lex.equals(lexema)) {
					// System.err.println("Ya existe la variable/funcion declarada -->"+s.lexema);
                    return true;
                }
			}
		return false;
	}
	
	public static boolean busquedaParamTsl(String lexema){//Busqueda Param
		if(buscarParamTsl(lexema)==false){
			return false;
		}
		return true;
	}
	
	public static boolean buscarVarTsl(String lexema){
		String lex;
		String type;
		Iterator it = tsl.listIterator();
            while (it.hasNext()){
				FormatoTS s = (FormatoTS)it.next();
                lex = s.lexema;
				type = s.tipo;
				if (lex.equals(lexema)) {
					// System.err.println("Ya existe la variable/funcion declarada -->"+s.lexema);
                    return true;
                }
			}
		return false;
	}
	
	public static boolean busquedaVarTsl(String lexema){//Busqueda var
		if(buscarVarTsl(lexema)==false){
			return false;
		}
		return true;
	}
	public static void imprimirTitulo(){
		
		try{
			FileWriter fw = new FileWriter("TablaDeSimbolos.txt",true);
			// System.out.println("IMPRIMO TITULO");
			titulo=tsg.get(posicion-1).lexema;
			fw.write("CONTENIDO DE LA FUNCION "+titulo+" #"+contFuncion+":\n");
			contFuncion++;
			fw.close();
		}catch (IOException ex) {
            System.out.println(ex.getMessage() + " escribiendo el fichero");
		}	
	}
	
	public static void imprimirParam(){
		
		try{
			FileWriter fw = new FileWriter("TablaDeSimbolos.txt",true);
			// System.out.println("ENTRE EN VARIABLE TSL PARAM");
			int i=0;
			while(i<posicionTsl){
				String token = tsl.get(i).toStringParam();
				fw.write(token);
				i++;
			}
			fw.close();
		}catch (IOException ex) {
            System.out.println(ex.getMessage() + " escribiendo el fichero");
		}	
	}
	public static void imprimirTslVar(){
		
		try{
			FileWriter fw = new FileWriter("TablaDeSimbolos.txt",true);
			// System.out.println("ENTRE EN VARIABLE TSL VAR");
			String token = tsl.get(posicionTsl).toStringTslVar();
			fw.write(token);
			fw.close();
		}catch (IOException ex) {
            System.out.println(ex.getMessage() + " escribiendo el fichero");
		}	
	}

	public static void quitar(){
		
		try{
			FileWriter fw = new FileWriter("TablaDeSimbolos.txt",true);
			// System.out.println("IMPRIMO TITULO");
			titulo=tsg.get(posicion-1).lexema;
			fw.write("CONTENIDO DE LA FUNCION "+titulo+" #"+contFuncion+":\n");
			contFuncion++;
			fw.close();
		}catch (IOException ex) {
            System.out.println(ex.getMessage() + " escribiendo el fichero");
		}	
	}

	//Aquí empieza el Semántico
	public static String buscarIDTsg(String lexema){
		String lex;
		String var;
		Iterator it = tsg.listIterator();
            while (it.hasNext()){
				FormatoTS s = (FormatoTS)it.next();
				lex = s.lexema;
				var = s.kind;
				if (lex.equals(lexema) &&  var.equals("var")){
					
                    return s.tipo;
                }
			}
		return null;
	}

	public static String buscarLlamadaTsg(String lexema, int param, ArrayList<String> tipoParams){
		String lex;
		String function;
		int parametros;
		ArrayList<String> tipos;

		Iterator it = tsg.listIterator();
            while (it.hasNext()){
				FormatoTS s = (FormatoTS)it.next();
				lex = s.lexema;
				function = s.kind;
				parametros = s.nParam;
				tipos = s.tipoParams;

				if (lex.equals(lexema) &&  function.equals("function") && param ==parametros && tipoParams.equals(tipos)){
					
                    return s.tipo;
                }
			}
		return null;
	}
	
	public static String buscarIDTsl(String lexema){
		String lex;
		String var;
		Iterator it = tsl.listIterator();
            while (it.hasNext()){
				FormatoTS s = (FormatoTS)it.next();
				lex = s.lexema;
				var = s.kind;
				if (lex.equals(lexema) &&  var.equals("var")){
					
                    return s.tipo;
                }
			}
		return null;
	}
	
}