public class OperacaoSaque extends Operacao implements ITaxas{

    public OperacaoSaque(double valor) {
        super('s', valor);
    }
    @Override
    public String toString(){
        return this.getTipo()+"\n"+this.getData()+"\n"+this.getValor();
    }

    public double calculaTaxas(){
        return 0.05;
    }
}
