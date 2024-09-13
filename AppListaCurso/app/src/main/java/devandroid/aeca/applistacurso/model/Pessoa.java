package devandroid.aeca.applistacurso.model;

import androidx.annotation.NonNull;

public class Pessoa {

    private String primeiroNome;
    private String sobreNome;
    private String produtoDesejado;
    private String telefoneContato;

    public Pessoa() {}

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getProdutoDesejado() {
        return produtoDesejado;
    }

    public void setProdutoDesejado(String produtoDesejado) {
        this.produtoDesejado = produtoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", produtoDesejado='" + produtoDesejado + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                '}';
    }
}
