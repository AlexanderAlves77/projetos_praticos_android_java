package devandroid.aeca.meusclientes.datamodel;

public class ProdutoDataModel {

    // Modelo Objeto Relacional
    // Toda Classe Data Model tem esta estrutura

    // 1 - Atributo nome da tabela
    public static final String TABELA = "produto";

    // 2 - Atributos uma para um com os nomes dos campos
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String FORNECEDOR = "fornecedor";

    // 3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // 4 - Método para gerar o Script para criar a tabela
    public static String criarTabela() {

        // Concatenação de Strings
        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOME + " text, ";
        queryCriarTabela += FORNECEDOR + " text ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }

    // 5 - Queries de consulta gerais
}
