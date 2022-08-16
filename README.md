
# Farmácia Tudo de Bom 

Uma API para gerenciar transações na nova plataforma da Farmácia Tudo de Bom (loja fictícia).

<a href="https://ibb.co/520w8m1"><img src="https://i.ibb.co/8XCt5qm/Beige-Colorful-Minimal-Flowchart-Infographic-Graph.png" alt="Beige-Colorful-Minimal-Flowchart-Infographic-Graph" border="0"></a>

O sistema necessita das seguintes opções:
- Cadastro de cliente
- Listagem de Clientes Cadastrados
- Atualização de Cliente
- Deletar Cliente
- Histórico de transação entre contas
- Controle de estoque.

Devem especificar que os Medicamentos Genéricos possuem 20% de desconto. 

## Documentação da API

#### Retorna todos os itens

```http
  GET /api/items
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `api_key` | `string` | **Obrigatório**. A chave da sua API |

#### Retorna um item

```http
  GET /api/items/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |

#### add(num1, num2)

Recebe dois números e retorna a sua soma.


## Autores

- [@catrynribeiro](https://www.github.com/katrynribeiro) 
- [@tatiramoos](https://www.github.com/tatiramoos)
- [@eduardosilva3](https://www.github.com/eduardosilva3)



## Documentação

[Documentação](https://link-da-documentação)


## Licença

[MIT](https://choosealicense.com/licenses/mit/)


## Usado por

Esse projeto é usado pelas seguintes empresas:

- IBM
- Gama Academy

