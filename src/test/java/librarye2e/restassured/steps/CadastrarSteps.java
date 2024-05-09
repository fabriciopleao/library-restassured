package librarye2e.restassured.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import librarye2e.restassured.objects.LibraryObjects;
import librarye2e.restassured.utils.RandomDataGenerator;
import librarye2e.restassured.validations.APIValidations;
import librarye2e.restassured.validations.Exceptions;

public class CadastrarSteps {

	Response response;
	
	@Given("que estou acessando a API de livros")
	public void queEstouAcessandoAAPIDeLivros() {

	}

	@When("que insira as informacoes validas do livro no body request")
	public void queInsiraAsInformacoesValidasDoLivroNoBodyRequest() {
	    response = LibraryObjects.cadastrarLivro(RandomDataGenerator.tituloLivroRandom(), 
									    		 RandomDataGenerator.autorRandom(), 
									    		 RandomDataGenerator.quantidadeEstoqueRandom(), 
									    		 RandomDataGenerator.editoraRandom(), 
									    		 RandomDataGenerator.anoPublicacaoRandom(), 
									    		 RandomDataGenerator.generoRandom());
	}

	@Then("validar o status code Created e as informacoes do livro cadastradas")
	public void validarOStatusCodeCreatedEAsInformacoesDoLivroCadastradas() {
		APIValidations.validarStatusCode(response, 201);
				
	}

	@When("que insira as informacoes validas em massa dos livros no body request")
	public void queInsiraAsInformacoesValidasEmMassaDosLivrosNoBodyRequest() {
		response = LibraryObjects.cadastrarLivroEmMassa(
				
				// Livro 1
				  RandomDataGenerator.tituloLivroRandom(), 
	    		  RandomDataGenerator.autorRandom(), 
	    		  RandomDataGenerator.quantidadeEstoqueRandom(), 
	    		  RandomDataGenerator.editoraRandom(), 
	    		  RandomDataGenerator.anoPublicacaoRandom(), 
	    		  RandomDataGenerator.generoRandom(), 
	    		// Livro 2  
	    		  RandomDataGenerator.tituloLivroRandom(), 
	    		  RandomDataGenerator.autorRandom(), 
	    		  RandomDataGenerator.quantidadeEstoqueRandom(), 
	    		  RandomDataGenerator.editoraRandom(), 
	    		  RandomDataGenerator.anoPublicacaoRandom(), 
	    		  RandomDataGenerator.generoRandom(), 
	    		// Livro 3 
	    		  RandomDataGenerator.tituloLivroRandom(), 
	    		  RandomDataGenerator.autorRandom(), 
	    		  RandomDataGenerator.quantidadeEstoqueRandom(), 
	    		  RandomDataGenerator.editoraRandom(), 
	    		  RandomDataGenerator.anoPublicacaoRandom(), 
	    		  RandomDataGenerator.generoRandom(), 
	    		// Livro 4
	    		  RandomDataGenerator.tituloLivroRandom(), 
	    		  RandomDataGenerator.autorRandom(), 
	    		  RandomDataGenerator.quantidadeEstoqueRandom(), 
	    		  RandomDataGenerator.editoraRandom(), 
	    		  RandomDataGenerator.anoPublicacaoRandom(), 
	    		  RandomDataGenerator.generoRandom());
			
	}

	@Then("validar o status code Created e as informacoes cadastradas dos livros em massa")
	public void validarOStatusCodeCreatedEAsInformacoesCadastradasDosLivrosEmMassa() {
		APIValidations.validarStatusCode(response, 201);
	}

	@When("que insira as informacoes duplicadas em massa dos livros no body request")
	public void queInsiraAsInformacoesDuplicadasEmMassaDosLivrosNoBodyRequest() {
		response = LibraryObjects.cadastrarLivroEmMassa("duplicado1", "duplicado1", 1, "duplicado1", 0, "duplicado1",
														"duplicado1", "duplicado1", 1, "duplicado1", 0, "duplicado1",
														"duplicado2", "duplicado2", 1, "duplicado2", 0, "duplicado2",
														"duplicado2", "duplicado2", 1, "duplicado2", 0, "duplicado2");
		
	}

	@Then("validar o status code Bad Request e mensagem de erro")
	public void validarOStatusCodeBadRequestEMensagemDeErro() {
		APIValidations.validarStatusCode(response, 400);
		APIValidations.validarMensagemErro(response, Exceptions.livroJaCadastradoException);
		
	}

	@When("que insira as informacoes de livro ja cadastrado no body request")
	public void queInsiraAsInformacoesDeLivroJaCadastradoNoBodyRequest() {
		response = LibraryObjects.cadastrarLivro("QA Certification", "Fabricio Leão", 20, "Amazon", 2024, "Tecnologia");
	}

	@When("que informe o body request com dados em branco")
	public void queInformeOBodyRequestComDadosEmBranco() {
		response = LibraryObjects.cadastrarLivro("", "", 1, "", 0, "");
	}

	@Then("validar o status code Bad Request e mensagem de erro em branco")
	public void validarOStatusCodeBadRequestEMensagemDeErroEmBranco() {
		APIValidations.validarStatusCode(response, 400);
		//falta exception de erro dados em branco
	}

	@When("que informe o body request com titulo e autor null")
	public void queInformeOBodyRequestComTituloEAutorNull() {
		response = LibraryObjects.cadastrarLivro(null, null, 1, "", 0, "");
	}

	@Then("validar o status code Bad Request e mensagem de erro dados invalidos")
	public void validarOStatusCodeBadRequestEMensagemDeErroDadosInvalidos() {
		APIValidations.validarStatusCode(response, 400);
		APIValidations.validarMensagemErro(response, Exceptions.camposInvalidosException);
	}

}
