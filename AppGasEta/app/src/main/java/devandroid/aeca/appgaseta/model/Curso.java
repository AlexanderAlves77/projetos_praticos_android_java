package devandroid.aeca.appgaseta.model;

public class Curso {

    private String nomeDoCursoDesejado;

    public Curso(String nomeDoCurso) {
        this.nomeDoCursoDesejado = nomeDoCurso;
    }

    public String getNomeDoCursoDesejado() {
        return nomeDoCursoDesejado;
    }

    public void setNomeDoCursoDesejado(String nomeDoCursoDesejado) {
        this.nomeDoCursoDesejado = nomeDoCursoDesejado;
    }
}
