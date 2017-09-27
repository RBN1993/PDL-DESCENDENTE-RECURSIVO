public class MiToken {
    
    String clave;
    String valor;
    
    public MiToken(String clave, String valor)
    {
        this.clave=clave;
        this.valor=valor;
    }
    
    public String getClave()
    {
        return this.clave;
    }
    
    public void setClave(String clave)
    {
        this.clave=clave;
    }
    
    public String getValor()
    {
        return this.valor;
    }
    
    public void setValor(String valor)
    {
        this.valor=valor;
    }
    @Override
    public String toString()
    {
        return "<"+this.clave+","+this.valor+">"+"\n";
    }
}
