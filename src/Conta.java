public abstract class Conta{

    private double[] taxas;

    private int totalTaxas;

    private int numero;

    private Cliente dono;

    private double saldo;

    protected double limite;

    private Operacao[] operacoes;

    private int proximaOperacao;

    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new Operacao[1000];
        this.taxas = new double[1000];
        this.proximaOperacao = 0;
        this.totalTaxas = 0;

        Conta.totalContas++;
    }

    @Override
    public boolean equals(Object obj){
        Conta other = (Conta) obj;
        return this.numero == other.getNumero();
    }

    @Override
    public String toString(){
        String str_oprs = "";
        for (Operacao opr : this.operacoes){
            if (opr == null) continue;
            str_oprs += opr.toString()+"\n";
        }
        return this.numero+"\n"+this.dono+"\n"+this.limite+"\nOperacoes\n"+str_oprs;
    }

    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;

            this.operacoes[proximaOperacao] = new OperacaoSaque(valor);
            this.taxas[totalTaxas] = this.operacoes[proximaOperacao].calculaTaxas();
            System.out.println("Saque realizado com sucesso!" + this.totalTaxas);
            this.totalTaxas++;
            this.proximaOperacao++;
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.operacoes[proximaOperacao] = new OperacaoDeposito(valor);
        this.proximaOperacao++;
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public void imprimir() {
        System.out.println("===== Conta " + this.numero + " =====");
        this.dono.imprimir();
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);
        System.out.println("====================");
    }

    public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                atual.imprimir();
            }
        }
        System.out.println("====================");
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public abstract void setLimite(double limite);

    public abstract double calculaTaxas();

    public void imprimirExtratoTaxas(){
        double total = 0;
        double taxaConta = 0;

        System.out.println("=== Extrato de Taxas ===");
        taxaConta = this.calculaTaxas();
        if(taxaConta != 0) System.out.println("Manutencao da conta: " + taxaConta);
        if(this.totalTaxas > 0) System.out.println("Operacoes: ");
        for(int i = 0; i < this.totalTaxas; i++){
            System.out.println("Saque: " + this.taxas[i]);
            total += this.taxas[i];
        }
        total += taxaConta;

        System.out.println("Total: " + total);
    }
}
