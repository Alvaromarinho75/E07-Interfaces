public class OperacaoDeposito extends Operacao {

    public OperacaoDeposito(double valor) {
        super('d', valor);
    }

    @Override
    public String toString(){
        return this.getTipo()+"\n"+this.getData()+"\n"+this.getValor();
    }

    public double calculaTaxas(){
        return 0;
    }
}
