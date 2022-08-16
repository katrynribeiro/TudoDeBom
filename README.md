
# Farmácia Tudo de Bom 

Uma API para gerenciar transações na nova plataforma da Farmácia Tudo de Bom (loja fictícia).

<div style="position: relative; width: 100%; height: 0; padding-top: 75.0000%;
 padding-bottom: 48px; box-shadow: 0 2px 8px 0 rgba(63,69,81,0.16); margin-top: 1.6em; margin-bottom: 0.9em; overflow: hidden;
 border-radius: 8px; will-change: transform;">
  <iframe loading="lazy" style="position: absolute; width: 100%; height: 100%; top: 0; left: 0; border: none; padding: 0;margin: 0;"
    src="https:&#x2F;&#x2F;www.canva.com&#x2F;design&#x2F;DAFJcbkT6E0&#x2F;view?embed" allowfullscreen="allowfullscreen" allow="fullscreen">
  </iframe>
</div>
<a href="https:&#x2F;&#x2F;www.canva.com&#x2F;design&#x2F;DAFJcbkT6E0&#x2F;view?utm_content=DAFJcbkT6E0&amp;utm_campaign=designshare&amp;utm_medium=embeds&amp;utm_source=link" target="_blank" rel="noopener">Beige Colorful Minimal Flowchart Infographic Graph</a> de Tati Ramos



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

