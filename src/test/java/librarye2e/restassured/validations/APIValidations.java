package librarye2e.restassured.validations;

import io.restassured.response.Response;

public class APIValidations {

	public static void validarStatusCode(Response response, int statusCodeEsperado) {
		int statusCodeRecebido = response.getStatusCode();
		if(statusCodeRecebido != statusCodeEsperado) {
			throw new AssertionError("Status code diferente do esperado. Recebido: " + statusCodeRecebido + ". Esperado: " + statusCodeEsperado + ".");
		}System.out.println(response.asPrettyString());
	}
	
	public static void validarMensagemErro(Response response, String errorMessageEsperado) {
        String errorMessageRecebido = response.jsonPath().getString("error.message");
        if (!errorMessageRecebido.contains(errorMessageEsperado)) {
            throw new AssertionError("A mensagem de erro na resposta não é a esperada. Esperado: " + errorMessageEsperado + ", Atual: " + errorMessageRecebido);
        }
    }
	
	public static void validarLivroCadastrado(Response response, String titulo, String autor, int qtdEstoque, String editora, int anoPublicacao, String genero) {
      
		String responseTitulo = response.jsonPath().getString("titulo");
        String responseAutor = response.jsonPath().getString("autor");
        int responseQtdEstoque = response.jsonPath().getInt("quantidadeEmEstoque");
        String responseEditora = response.jsonPath().getString("editora");
        int responseAnoPublicacao = response.jsonPath().getInt("anoPublicacao");
        String responseGenero = response.jsonPath().getString("genero");

        if (!responseTitulo.equals(titulo) ||
            !responseAutor.equals(autor) ||
            responseQtdEstoque != qtdEstoque ||
            !responseEditora.equals(editora) ||
            responseAnoPublicacao != anoPublicacao ||
            !responseGenero.equals(genero)) {
            throw new AssertionError("Os dados do livro cadastrado não correspondem aos dados esperados.");
        }
    }
	
	
}
