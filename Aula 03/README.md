# Trabalhando com RestControllers no Spring Boot
Na aula anterior, exploramos como criar repositories e services para interagir com entidades no Spring Boot. Nesta aula, iremos abordar o uso de RestControllers para expor endpoints REST em nossa aplicação. Falaremos sobre anotações importantes, como @RestController, @RequestMapping, @GetMapping, e @PostMapping, além de discutir como o controle do Spring gerencia as requisições.

## Introdução aos RestControllers
No contexto do Spring Boot, um RestController é uma classe responsável por gerenciar requisições HTTP e fornecer respostas em formato JSON. Vamos criar um VeiculoController para exemplificar o uso dessas anotações.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Métodos do controlador podem ser adicionados aqui
}
```
* **@RestController:** Anotação que combina a funcionalidade de @Controller e @ResponseBody. Indica que a classe é um controlador REST e que os métodos retornarão dados serializados automaticamente.
* **@RequestMapping("/livro"):** Anotação que mapeia a URL base para todas as operações neste controlador.

### Mapeando Endpoints com @GetMapping
```java
@GetMapping("/{id}")
public ResponseEntity<Livro> buscarPorId(@PathVariable Integer id) {
    return livroService.buscarPorId(id);
}

@GetMapping("/autor")
public ResponseEntity<Livro> buscarPorAutor(@RequestParam String autor) {
    return livroService.buscarPorAutor(autor);
}
```
* **@GetMapping("/{id}"):** Anotação que mapeia a URL para operações HTTP GET. O valor entre chaves indica um parâmetro de caminho (id) que será extraído da URL.
* **@PathVariable:** Anotação que indica que o parâmetro do método (id) é extraído do caminho da URL.
* **@RequestParam:** Anotação que indica que o parâmetro do método (autor) é extraído dos parâmetros da requisição.

### @RequestBody para Receber Dados do Corpo da Requisição
Ao lidar com operações que requerem dados do corpo da requisição, como a criação de recursos (POST), a anotação @RequestBody é usada para indicar que o corpo da requisição deve ser convertido para o tipo de objeto desejado no parâmetro do método.

Vamos modificar nosso LivroController para incluir um método que recebe um novo livro no corpo da requisição:
```java
@PostMapping("/salvar")
public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
    return livroService.salvarLivro(livro);
}
```

### Como funciona o @RequestBody
Quando uma requisição POST é feita para "/livro/salvar" com um corpo JSON representando um livro, o Spring Boot utiliza automaticamente um conversor de mensagem (message converter), como o Jackson, para converter o corpo da requisição no objeto Livro. Isso permite que o método salvarLivro do LivroController receba um objeto Livro diretamente.

# Exercicio
Seguindo o exericio das outras aulas..
1. Crie o Controller da sua entidade Veiculo.
2. Crie um método para salvar um Veículo no seu Service e crie um endpoint para esse método no seu Controller
3. Crie um endpoint que retorna um veículo por id, utilizando @PathVariable
4. Crie um endpoint **/busca** que receba no parametro da URL 3 parametros: modelo, marca e placa. Dependendo de qual parametro você receber, retorne o resultado.