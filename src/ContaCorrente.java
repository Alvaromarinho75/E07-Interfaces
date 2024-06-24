public class ContaCorrente extends Conta{
    public ContaCorrente(int numero, Cliente dono, double saldo, double limite){
        super(numero,dono,saldo,limite);
        this.setLimite(limite);
    }
    @Override
    public void setLimite(double limite) {
        if (limite < -100)
            limite = -100;
        this.limite = limite;
    }

    public double calculaTaxas(){
        if(this.getDono().getClass() == PessoaFisica.class) return 10.0;
        else return 20.0;
    }
}



