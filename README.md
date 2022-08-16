<div align="center">
<img src="https://user-images.githubusercontent.com/106891550/184989414-eb297f24-50da-4584-817c-5bf29741c1ab.png" width="700px"/>
</div>


Uma API para gerenciar transações na nova plataforma da <b>Farmácia Tudo de Bom</b> (loja fictícia).

O sistema  precisa ter as seguintes opções:
- Cadastro de Clientes
- Listagem de Clientes
- Atualizar Clientes
- Deletar Clientes
- Histórico de Transações
- Os Medicamentos Genéricos têm 20% de desconto

Esse projeto faz parte do Desafio - Parte 1 do treinamento <b>If Black, Then Code</b> das empresas <b>IBM</b> e <b>Gama Academy</b>.



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

