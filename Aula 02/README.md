# Trabalhando com Repositories e Services no Spring Boot
Na aula anterior, criamos uma entidade Livro usando anotações do Hibernate. Nesta aula, exploraremos como criar os repositories e services para interagir com essa entidade no Spring Boot. Abordaremos algumas anotações cruciais, como @Repository, @Service, e @Autowired. Também veremos como criar métodos customizados no nosso repository, além de discutir diferentes formas de realizar a injeção de dependência.

##  Repositories
Um Repository no contexto do Spring Data JPA é uma interface que fornece métodos para realizar operações de persistência em uma entidade. No nosso caso, criaremos um LivroRepository para realizar operações relacionadas aos livros.

### Criando o LivroRepository
```java
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    // Métodos personalizados podem ser adicionados aqui
}
```
* **JpaRepository<Livro, Integer>: JpaRepository** é uma interface do Spring Data JPA que fornece métodos convenientes para operações CRUD (Create, Read, Update, Delete) em uma entidade. Livro é a entidade que estamos gerenciando, e Integer é o tipo da chave primária da entidade.

### Métodos Personalizados em Repositories Spring Data JPA
Em algumas situações, pode ser necessário criar métodos personalizados nos repositories para realizar consultas específicas. No nosso caso, criaremos um método para buscar livros por autor, aproveitando o campo autor presente na entidade Livro.

1. **Buscando utilizando a anotação @Query**:
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l WHERE l.autor = ?1")
    List<Livro> findByAutor(String autor);
}
```
* **@Query:** Anotação que permite a definição de consultas personalizadas em JPQL (Java Persistence Query Language).
* **?1:** É um placeholder que será substituído pelo primeiro parâmetro do método (neste caso, o autor).

2. **Buscando sem utilizar @Query**
```java
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByAutor(String autor);
}
```
O Spring Data JPA é capaz de inferir a consulta automaticamente com base no nome do método.

### Como Funciona o Gerenciamento do Spring ao Buscar por Campos
O Spring Data JPA simplifica a criação de consultas através de métodos de repositories. Ao criar um método no LivroRepository que segue as convenções de nomenclatura, o Spring Data JPA consegue gerar automaticamente a consulta SQL correspondente. No caso do método findByAutor, o Spring Data JPA entende que deve buscar todos os registros da entidade Livro onde o campo autor seja igual ao parâmetro fornecido.

Por outro lado, o uso da anotação @Query permite maior flexibilidade, possibilitando a criação de consultas personalizadas em JPQL. Essa abordagem é útil quando a consulta não pode ser representada por métodos de nomenclatura padrão.

Escolher entre essas abordagens depende das necessidades específicas do projeto e da preferência do desenvolvedor. O Spring Data JPA oferece opções poderosas para tornar as consultas eficientes e flexíveis.

##  Services
Um Service é uma classe que contém a lógica de negócios da aplicação. No nosso caso, criaremos um LivroService para encapsular a lógica relacionada aos livros.
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    // Métodos de serviço podem ser adicionados aqui
}
```
* **@Service:** Anotação que indica que a classe é um componente de serviço no Spring.

### Injeção de Dependência
Existem algumas formas de realizar a injeção de dependência no Spring.

* **Injeção pelo construtor**
```java
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // Métodos de serviço podem ser adicionados aqui
}
```

* **Injeção por Campo** 
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // Métodos de serviço podem ser adicionados aqui
}
```

* **Injeção por Método**
```java
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    @Autowired
    public void setLivroRepository(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // Métodos de serviço podem ser adicionados aqui
}
```

### Crie um método que retorne uma lista de livros por autor
```java
@Service
public class LivroService {

    private LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> buscarPorAutor(String autor) {
        return livroRepository.findByAutor(autor);
    }
}
```

# Exercicio
Seguindo o projeto que você construiu na aula passada
1. Crie o Repository e o Service da sua entidade Veiculo.
2. No repository crie métodos que busque pela placa. Outro que busque pela marca e outro que busque pelo modelo.
3. No seu service crie métodos: **buscaPelaPlaca(String placa)**, **buscaPorMarca(String marca)** e **buscaPeloModelo(String modelo)**.