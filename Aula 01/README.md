# Introdução ao Spring Boot
O Spring Boot é uma estrutura (framework) que simplifica o desenvolvimento de aplicativos Java, fornecendo uma configuração padrão e uma maneira eficiente de construir aplicativos robustos. Nesta aula, exploraremos o Spring Boot, destacando o Spring Initializr, Injeção de Dependência, Inversão de Controle e a estrutura de projetos criada pelo Spring Initializr.

## O que é Spring Boot?
O Spring Boot é uma extensão do Spring Framework que visa facilitar o desenvolvimento de aplicativos Java, fornecendo uma configuração padrão e facilitando a criação de aplicativos "prontos para produção" com o mínimo esforço.

### Spring Initializr
O Spring Initializr é uma ferramenta online que simplifica o processo de inicialização de projetos Spring Boot. Ele permite que os desenvolvedores personalizem suas configurações e adicionem dependências facilmente. Vamos explorar como criar um projeto usando o Spring Initializr.

1. Acesse o Spring Initializr.
2. Escolha as configurações do projeto, como linguagem (por exemplo, Java), versão do Spring Boot, e grupo e artefato do projeto.
3. Adicione as dependências necessárias (por exemplo, Spring Web, Spring Data JPA, etc.).
4. Clique em "Generate" para baixar o projeto ZIP.

### Injeção de Dependência e Inversão de Controle (IoC)
O Spring Framework é conhecido por promover dois conceitos importantes: Injeção de Dependência e Inversão de Controle.

* **Injeção de Dependência (IoC):** No Spring, os objetos não são responsáveis por criar ou buscar suas dependências. Em vez disso, as dependências são injetadas nos objetos. Isso facilita a manutenção e teste de aplicativos, além de reduzir o acoplamento entre componentes.
* **Inversão de Controle (IoC):** No IoC, o controle sobre a execução de um programa é invertido. Em vez de o programador chamar métodos diretamente, o framework controla o fluxo do programa. No caso do Spring, o contêiner de IoC é responsável por gerenciar a criação e a injeção de dependências.

### Estrutura do Projeto Spring Boot
Ao criar um projeto Spring Boot usando o Spring Initializr, a estrutura do projeto segue convenções que facilitam a organização e expansão do código. Algumas pastas e arquivos importantes incluem:

* **src/main/java:** Contém o código-fonte Java do projeto.
* **src/main/resources:** Armazena recursos não Java, como arquivos de configuração.
* **src/test:** Destinado a testes automatizados.
* **pom.xml:** O arquivo de configuração do Maven para gerenciar dependências e configurações do projeto.


## Configuração de Conexão com o Banco de Dados no Spring Boot
No desenvolvimento de aplicativos, a integração com um banco de dados é frequentemente necessária. O Spring Boot simplifica essa tarefa, permitindo a configuração da conexão com o banco de dados por meio do arquivo application.properties. Vamos explorar como realizar essa configuração.

### Configuração no application.properties
O arquivo application.properties é um arquivo de propriedades utilizado para configurar diversas características do aplicativo Spring Boot. Para configurar a conexão com o banco de dados, é possível definir propriedades específicas relacionadas ao datasource.

```xml
# Configuração do datasource para MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=usuario_do_banco
spring.datasource.password=senha_do_banco

# Configuração do Hibernate (JPA)
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

# Exercicio
1. Crie um novo projeto Spring Boot usando o Spring Initializr.
2. Adicione as dependências: Spring Web, Spring Data JPA, Lombok, MySQL connector.
3. Explore a estrutura do projeto gerado, destacando as pastas e arquivos principais.
4. Entenda como a Injeção de Dependência e a Inversão de Controle são aplicadas no Spring Boot.
5. Crie uma entidade veículo utilizando as anotações do Hibernate, vistas no módulo anterior.
Os campos para entidade: modelo, marca, placa e segmento (carro, moto ou caminhão).