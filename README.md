# Itaú Unibanco - Desafio de Programação

Este é um desafio bacana tanto de desenvolvimento de software quanto de engenharia de software. Queremos testar sua capacidade de construir um software com várias partes diferentes funcionando em conjunto!

## 1. Introdução

Sua missão, caso você aceite, é criar uma API REST que recebe Transações e retorna Estatísticas sob essas transações. Para este desafio, a API deve ser criada utilizando-se de Java ou Kotlin e Spring Boot.

Um bom lugar para se começar é o [Spring Starter](https://start.spring.io/).

**Dica:** Não existe uma forma certa ou errada de resolver o desafio! Vamos avaliar coisas como a qualidade do seu código, o quão fácil é de compreender o código, organização do projeto, quantidade e qualidade dos testes, preocupação com segurança e vários outros fatores. :)

---

## 2. Definição do desafio

Neste desafio você deve criar uma API REST no GitHub ou GitLab. Leia com atenção todas as instruções a seguir!

### 2.1. Restrições Técnicas

Seu projeto deve seguir as seguintes restrições:

* **DEVE** estar no GitHub ou GitLab.
* **NÃO DEVE** fazer fork de nenhum outro projeto.
* **DEVE** ter pelo menos 1 commit por cada endpoint (mínimo de 3 commits).

    * Queremos ver a evolução do seu projeto com o tempo. ;)
* Todos os commits **DEVEM** ser feitos pelo mesmo usuário que criou o projeto.

    * Atenção caso você tenha contas diferentes para pessoal e profissional.
* **DEVE** seguir exatamente os endpoints descritos a seguir.

    * Por exemplo, `/transacao` não é a mesma coisa que `/transacoes`.
* **DEVE** aceitar e responder com objetos exatamente como descritos a seguir.

    * Por exemplo, `dataHora` não é o mesmo que `data-hora` ou `dtTransacao`.
* **NÃO DEVE** utilizar sistemas de banco de dados (H2, MySQL, PostgreSQL, etc.) ou cache (Redis, Memcached, etc.).
* **DEVE** armazenar todos os dados em memória.
* **DEVE** aceitar e responder apenas com JSON.

**Atenção:** Você **DEVE** disponibilizar seu projeto publicamente no GitHub ou GitLab. Após receber nossa avaliação, você pode tornar seu projeto privado.

---

### 2.2. Endpoints da API

Os endpoints da API e suas funcionalidades estão descritos a seguir:

#### 2.2.1. Receber Transações: POST `/transacao`

Este endpoint irá receber as Transações. Cada transação consiste de um **valor** e uma **dataHora**:

```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

**Campos:**

| Campo      | Significado                                             | Obrigatório? |
| ---------- | ------------------------------------------------------- | ------------ |
| `valor`    | Valor decimal da transação                              | Sim          |
| `dataHora` | Data/hora no padrão ISO 8601 em que a transação ocorreu | Sim          |

#### Critérios de Validação

* Campos **valor** e **dataHora** devem estar preenchidos.
* **dataHora** não pode ser no futuro.
* **dataHora** deve ser no passado.
* **valor** não pode ser negativo.
* **valor** deve ser igual ou maior que 0.

#### Respostas Esperadas

* `201 Created`: Transação aceita e registrada.
* `422 Unprocessable Entity`: Transação rejeitada (não atende os critérios).
* `400 Bad Request`: JSON inválido.

#### 2.2.2. Limpar Transações: DELETE `/transacao`

Este endpoint apaga todos os dados de transações armazenados.

#### Resposta Esperada

* `200 OK`: Informações apagadas com sucesso.

#### 2.2.3. Calcular Estatísticas: GET `/estatistica`

Este endpoint retorna estatísticas das transações nos últimos 60 segundos.

```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

**Campos:**

| Campo | Significado                                      | Obrigatório? |
| ----- | ------------------------------------------------ | ------------ |
| count | Quantidade de transações nos últimos 60 segundos | Sim          |
| sum   | Soma total dos valores                           | Sim          |
| avg   | Média dos valores                                | Sim          |
| min   | Menor valor                                      | Sim          |
| max   | Maior valor                                      | Sim          |

#### Resposta Esperada

* `200 OK`: Retorna os valores de count, sum, avg, min e max.
* Quando não houver transações nos últimos 60 segundos, considere todos os valores como 0 (zero).

---

## 4. Extras

Desafios adicionais:

* **Testes automatizados**: Testes unitários e/ou funcionais.
* **Containerização**: Disponibilizar sua aplicação como um container.
* **Logs**: Informar o que está acontecendo durante a execução.
* **Observabilidade**: Endpoint de healthcheck.
* **Performance**: Medir o tempo de cálculo das estatísticas.
* **Tratamento de Erros**: Personalizar os erros padrão do Spring Boot.
* **Documentação**: Documentar a API e as instruções de execução.
* **Configurações**: Tornar a quantidade de segundos para cálculo de estatísticas configurável (ex.: 60 ou 120 segundos).

---
