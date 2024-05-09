#Author: fabriciopereiraleao@gmail.com

@delete @integration
Feature: Excluir livro
   Como QA
   Quero validar a funcionalidade de excluir livro 
   Para verificar a API da E2E Library

  @positive
  Scenario: Excluir livro com sucesso
 	 	Given que estou acessando a API de livros
    When que insira o id do livro desejado 
    Then validar o status code No Content
    
  @negative
  Scenario: Excluir livro inexistente
 	 	Given que estou acessando a API de livros
    When que insira o id de um livro nao cadastrado 
    Then validar o status code Bad Request
