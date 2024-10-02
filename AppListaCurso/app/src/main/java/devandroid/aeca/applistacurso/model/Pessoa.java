package devandroid.aeca.applistacurso.model;

import androidx.annotation.NonNull;

public class Pessoa {

    private String primeiroNome;
    private String sobreNome;
    private String cursoDesejado;
    private String telefoneContato;

    // Constructor
    public Pessoa() {}

    public String getPrimeiroNome() { return primeiroNome; }

    public void setPrimeiroNome(String nome) {
        this.primeiroNome = nome;
    }

    public String getSobreNome() { return sobreNome; }

    public void setSobreNome(String nome) {
        this.sobreNome = nome;
    }

    public String getCursoDesejado() { return cursoDesejado; }

    public void setCursoDesejado(String curso) {
        this.cursoDesejado = curso;
    }

    public String getTelefoneContato() { return telefoneContato; }

    public void setTelefoneContato(String telefone) {
        this.telefoneContato = telefone;
    }

    // To String - Para Textos - Para Strings de Caracteres
    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                '}';
    }
}
