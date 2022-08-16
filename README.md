<a data-flickr-embed="true" href="" title="FARMÁCIA"><img src="https://live.staticflickr.com/65535/52290521824_bdf74fd6d3.jpg" width="500" height="250" alt="FARMÁCIA"></a>

Uma API para gerenciar transações na nova plataforma da Farmácia Tudo de Bom (loja fictícia).


## Documentação

[Documentação](https://link-da-documentação)


## Licença

[MIT](https://choosealicense.com/licenses/mit/)


## Autores

- [@katrynribeiro](https://www.github.com/katrynribeiro)
- [@tatiramoos](https://www.github.com/tatiramoos)
- [@eduardosilva3](https://www.github.com/eduardosilva3)
- [@luiz-lab](https://www.github.com/luiz-lab)


## Documentação da API

#### Retorna todos os itens

```http
  GET /api/produtos
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `PESQUISAR` | `string` | **Obrigatório**. A chave da sua API |


#### Retorna um item

```http
  GET /api/produtos
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `ATUALIZAR` | `string` | **Obrigatório**. A chave da sua API |


#### Retorna um item

```http
  PUT /api/produtos
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ATUALIZAR`      | `string` | **Obrigatório**. O ID do item que você quer |


#### Retorna um item

```http
  POST /api/produtos
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `CADASTRAR` | `string` | **Obrigatório**. A chave da sua API |

```http
  DELETE /api/produtos
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `EXCLUIR` | `string` | **Obrigatório**. A chave da sua API |





## Usado por

Esse projeto é usado pelas seguintes empresas:

- IBM
- Gama Academy

