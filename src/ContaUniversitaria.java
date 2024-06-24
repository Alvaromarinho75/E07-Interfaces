public class ContaUniversitaria extends Conta {
    public ContaUniversitaria(int numero, Cliente dono, double saldo, double limite){
        super(numero,dono,saldo,limite);
        this.setLimite(limite);
    }
    @Override
    public void setLimite(double limite) {
        if (limite < 0)
            limite = 0;
        if (limite > 500)
            limite = 500;
        this.limite = limite;
    }

    public double calculaTaxas(){
        return 0;
    }
}



