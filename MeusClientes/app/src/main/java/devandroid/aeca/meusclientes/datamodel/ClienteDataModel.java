package devandroid.aeca.meusclientes.datamodel;

public class ClienteDataModel {

    // Modelo Objeto Relacional
    // Toda Classe Data Model tem esta estrutura

    // 1 - Atributo nome da tabela
    public static final String TABELA = "cliente";

    // 2 - Atributos uma para um com os nomes dos campos
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String TELEFONE = "telefone";
    public static final String EMAIL = "email";
    public static final String CEP = "cep";
    public static final String LOGRADOURO = "logradouro";
    public static final String NUMERO = "numero";
    public static final String BAIRRO = "bairro";
    public static final String CIDADE = "cidade";
    public static final String ESTADO = "estado";
    public static final String TERMOS_DE_USO = "termos_de_uso";

    // 3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // 4 - Método para gerar o Script para criar a tabela
    public static String criarTabela() {

        // Concatenação de Strings
        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOME + " text, ";
        queryCriarTabela += TELEFONE + " text, ";
        queryCriarTabela += EMAIL + " text, ";
        queryCriarTabela += CEP + " integer, ";
        queryCriarTabela += LOGRADOURO + " text, ";
        queryCriarTabela += NUMERO + " text, ";
        queryCriarTabela += BAIRRO + " text ";
        queryCriarTabela += CIDADE + " text ";
        queryCriarTabela += ESTADO + " text ";
        queryCriarTabela += TERMOS_DE_USO + " integer ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }

}
