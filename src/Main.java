import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Cliente joao = new PessoaFisica("João", "Av. Antonio Carlos, 6627",
                                        new Date(), "111.111.111-11", 36, 'm');
        Cliente lojinha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000",
                                        new Date(), "000.00000.0000/0001", 25, "Comércio");


        Conta conta1 = new ContaCorrente(1234, joao, 0, 990);
        Conta conta2 = new ContaCorrente(12345, lojinha, 0, 1000);
        conta1.depositar(1000);
        conta1.sacar(10);
        conta1.sacar(10);
        conta1.transferir(conta2, 700);
        conta2.sacar(100);
        conta1.imprimirExtratoTaxas();
        conta1.imprimirExtrato();
        conta2.imprimirExtratoTaxas();
        conta2.imprimirExtrato();
    }
}