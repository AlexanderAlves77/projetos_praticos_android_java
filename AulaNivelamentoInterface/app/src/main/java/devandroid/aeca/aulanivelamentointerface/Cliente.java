package devandroid.aeca.aulanivelamentointerface;

public class Cliente implements ICrud {

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void incluir() {
        
    }

    @Override
    public void alterar() {

    }

    @Override
    public void listar() {

    }

    @Override
    public void deletar() {

    }
}
