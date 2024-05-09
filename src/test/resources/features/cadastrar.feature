#Author: fabriciopereiraleao@gmail.com

@post @integration
Feature: Cadastrar um novo livro
   Como QA
   Quero validar a funcionalidade de cadastro de livro 
   Para verificar a API da E2E Library

  @positive
  Scenario: Cadastro de livro com sucesso
 	 	Given que estou acessando a API de livros
    When que insira as informacoes validas do livro no body request
    Then validar o status code Created e as informacoes do livro cadastradas
    
  @positive
  Scenario: Cadastro de livro em massa
    Given que estou acessando a API de livros 
    When que insira as informacoes validas em massa dos livros no body request
    Then validar o status code Created e as informacoes cadastradas dos livros em massa
    
  @negative
  Scenario: Cadastro de livro em massa duplicado
  	Given que estou acessando a API de livros 
  	When que insira as informacoes duplicadas em massa dos livros no body request
    Then validar o status code Bad Request e mensagem de erro
  	
  @negative
  Scenario: Cadastro de livro ja cadastrado
  	Given que estou acessando a API de livros 
  	When que insira as informacoes de livro ja cadastrado no body request
    Then validar o status code Bad Request e mensagem de erro
      
  @negative
  Scenario: Cadastro de livro com dados em branco
  	Given que estou acessando a API de livros    
  	When que informe o body request com dados em branco
    Then validar o status code Bad Request e mensagem de erro em branco
  	
  @negative
  Scenario: Cadastro de livro com dados invalidos
  	Given que estou acessando a API de livros   
  	When que informe o body request com titulo e autor null
    Then validar o status code Bad Request e mensagem de erro dados invalidos
      
