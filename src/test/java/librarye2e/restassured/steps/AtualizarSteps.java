package librarye2e.restassured.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import librarye2e.restassured.objects.LibraryObjects;
import librarye2e.restassured.utils.RandomDataGenerator;
import librarye2e.restassured.validations.APIValidations;

public class AtualizarSteps {

	Response response;

	@When("que insira o id desejado e as informacoes validas para atualizacao do livro no body request")
	public void queInsiraOIdDesejadoEAsInformacoesValidasParaAtualizacaoDoLivroNoBodyRequest() {
	    response = LibraryObjects.atualizarLivro("1", 
	    		 RandomDataGenerator.tituloLivroRandom(), 
	    		 RandomDataGenerator.autorRandom(), 
	    		 RandomDataGenerator.quantidadeEstoqueRandom(), 
	    		 RandomDataGenerator.editoraRandom(), 
	    		 RandomDataGenerator.anoPublicacaoRandom(), 
	    		 RandomDataGenerator.generoRandom());
	}
	@Then("validar o status code OK e as informacoes do livro atualizadas")
	public void validarOStatusCodeOKEAsInformacoesDoLivroAtualizadas() {
	    APIValidations.validarStatusCode(response, 200);
	}

	@When("que insira o id desejado e as informacoes invalidas para atualizacao do livro no body request")
	public void queInsiraOIdDesejadoEAsInformacoesInvalidasParaAtualizacaoDoLivroNoBodyRequest() {
	    response = LibraryObjects.atualizarLivro("10", null, null, 0, "", 0, "");
	}
	@Then("validar o status code Bad Request")
	public void validarOStatusCodeBadRequest() {
	    APIValidations.validarStatusCode(response, 400);
	}

	@When("que insira o id desejado e mande os dados em branco no body request")
	public void queInsiraOIdDesejadoEMandeOsDadosEmBrancoNoBodyRequest() {
	    response = LibraryObjects.atualizarLivro("20", "", "", 0, "", 0, "");
	}

	@When("que insira o id desejado e mande dados de livro ja cadastrado no body request")
	public void queInsiraOIdDesejadoEMandeDadosDeLivroJaCadastradoNoBodyRequest() {
	    response = LibraryObjects.atualizarLivro("30", "A Time to Kil", "Rogelio Kihn", 2270, "Black Sparrow Books", 1901, "Fiction in verse");
	}
	







	
}
