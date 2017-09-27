import java.util.ArrayList;

public class FormatoTS{

	///ESTA ESTRUCTURA ES DE LA TABLA DE SIMBOLOS 
	String lexema;
	String tipo;
	int nParam;
	String kind;
	ArrayList<String> tipoParams=new ArrayList<String>();
	
	public FormatoTS(String kind, String lexema, String tipo, int nParam, ArrayList<String> tipoParams)
    {
		this.kind=kind;
        this.lexema=lexema;
        this.tipo=tipo;
        this.nParam=nParam;
		this.tipoParams=tipoParams;
		
    }
	
	 @Override
    public String toString()
    {
		String numtipoParam="";
		int i=0;
		int j=1;
		while(i<nParam){
			while(j<=i+1){
				numtipoParam+=" ";
				j++;
			}
			numtipoParam+="  +tipoParam"+(i+1)+":'"+this.tipoParams.get(i)+"'\n";
			i++;
			j=1;
		}
		String tipoRetorno="";
		if(this.tipo!=""){
			tipoRetorno="\n +tipo:'"+this.tipo+"'";
		}
        return "* (Esto es una funcion) LEXEMA: '"+this.lexema+"'\n ATRIBUTOS:"+tipoRetorno+"\n  +parametros:"+this.nParam+"\n"+
		numtipoParam;
    }
	public String toStringPalR()
    {
		return "* LEXEMA: '"+this.lexema+"'\n";
		// +" +tipo:'"+this.tipo+"'\n"
	}
	public String toStringVar()
    {
		return "* LEXEMA: '"+this.lexema+"'\n +tipo:'"+this.tipo+"'\n";
		// +" +tipo:'"+this.tipo+"'\n"
	}
	
	public String toStringParam()
    {
		return "* LEXEMA:'"+this.lexema+"' (tipo de entrada 'parametro') \n +tipo:'"+this.tipo+"'\n";
		// +" +tipo:'"+this.tipo+"'\n"
	}
	
	public String toStringTslVar()
    {
		return "* LEXEMA: '"+this.lexema+"' (tipo de entrada 'variable')\n +tipo:'"+this.tipo+"'\n";
		// +" +tipo:'"+this.tipo+"'\n"
	}
}