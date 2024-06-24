public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, Cliente dono, double saldo, double limite){
        super(numero,dono,saldo,limite);
        this.setLimite(limite);
    }
    @Override
    public void setLimite(double limite) {
        if (limite < 100)
            limite = 100;
        if (limite > 1000)
            limite = 1000;
        this.limite = limite;
    }

    public double calculaTaxas(){
        return 0;
    }
}



