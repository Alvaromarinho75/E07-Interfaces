import java.util.Date;

public class PessoaFisica extends Cliente {

    private String cpf;

    private int idade;

    private char genero;

    public PessoaFisica(String nome, String endereco, Date data, String cpf, int idade, char genero) {
        super(nome, endereco, data);
        this.cpf = cpf;
        this.idade = idade;
        this.genero = genero;
    }
    @Override
    public boolean equals(Object obj){
        PessoaFisica other = (PessoaFisica) obj;
        return this.cpf.equals(other.cpf);
    }
    @Override
    public String toString(){
        return this.getNome() + "\n" + this.getEndereco() + "\n" + this.cpf + "\n" + this.genero + "\n" + this.getData().toString() + "\n" + this.idade;
    }
    @Override
    public boolean autenticar(String chave){
        return this.cpf.equals(chave);
    }

}
