# Dicars
Projeto exemplo para explicação de injeção de dependência no Android com a biblioteca Hilt

- Projeto para entender o Hilt - [Confira esta branch][hilt-inicial]
- Projeto com Hilt na prática - [Confira esta branch][hilt-pratico]

### Melhorando o projeto ainda mais com Hilt
Podemos utilizar o Hilt para melhorar ainda mais a forma como nossas dependências são criadas.
Por exemplo, podemos fazer com que o arquivo `DatabaseModule` possua um método exclusivo para criar a instância do database e os outros métodos vão consumir esse método para prover as instâncias das DAOs que precisarem, temos a seguintes vantagens ao fazer isso:

- Delegamos a criação do banco de dados para o Hilt, podendo assim, deixar o arquivo `DicarsDatabase` mais exuto;

- Futuramente se outras DAOs precisarem ser criadas a partir do banco de dados, temos um código mais flexível;

- Como o Hilt fornecerá automaticamente instâncias de `DicarsDatabase` pelo método `provideDatabase`, sempre que necessário, podemos adicionar uma outra anotação a este método a `@Singleton` vai fazer o com que a instância retornada seja sempre a mesma de acordo com o padrão [singleton pattern][singleton-pattern].

Podemos aplicar uma abordagem similar ao arquivo `RetrofitModule`, separando a criação da instância de Retrofit das classes `service`, assim, podemos mover toda implementação de `RetrofitInit` para  dentro do módulo e apagar o arquivo original.
Você pode conferir um exemplo funcional desses exemplos que comentarmos através [deste commit][hilt-refinado]

[hilt-inicial]: https://github.com/alura-cursos/Dicars/commits/hilt-inicial
[hilt-pratico]: https://github.com/alura-cursos/Dicars/commits/hilt-pratico
[hilt-refinado]: https://github.com/alura-cursos/Dicars/commit/2fcf96378c158f10d8226af4ade7240e4ac865b5
[singleton-pattern]: https://en.wikipedia.org/wiki/Singleton_pattern
