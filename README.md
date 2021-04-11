# Exemplo simples de uma API usado Spring Tool Suite 4

- Criar um projeto do tipo Spring Starter Project
- Adicionar as dependencias 
    - Spring JPA
    - Spring Security
    - Spring Validation
    - Spring Web
    - DevTool para reiniciar o server automaticamente ao salvar
    - MySQL Connector
- Configurar o arquivo src/main/resources/application.properties
    - Porta padrão
    - Dados de conexão do banco de dados

Este projeto contém uma implementação simples, com as anotações para o uso do Spring Boot, o projeto inicia com o arquivo padrão em cadastrarclientes, o restante foram criados, nos pacotes:

- Model: Contém a configuração que faz referencia a tabela no banco de dados
- Repository: Uma interface que é necessária para fazer as ações de banco de dados na classe service
- Service: Classe que implementa as ações de banco de dados
- Controller: Classe principal de tratamento das rotas e parametros, com mapeamento dos verbos HTTP e responsável pelas informações recebidas e resposta das requisições