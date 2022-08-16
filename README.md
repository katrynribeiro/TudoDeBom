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


## Lista dos Endpoints

- GET  /usuarios -> Retorna uma lista de usuários

		// Método responsável pela listagem dos clientes
		JButton btnAlterar = new JButton("PESQUISAR");
		btnAlterar.setBounds(153, 356, 102, 23);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}

- GET  /usuarios/carmem -> Retorna o usuário com username carmem

        // Módulo responsável pela listagem dos clientes
        JButton btnNewButton_2 = new JButton("ATUALIZAR");
		btnNewButton_2.setBounds(265, 356, 102, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
- POST  /usuarios -> Cria um usuário

        // Módulo responsável pelo cadastro dos clientes
        JButton btnAdicionar = new JButton("CADASTRAR");
		btnAdicionar.setBounds(41, 356, 102, 23);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
- PUT  /usuario/carmem -> Atualiza o usuário carmem

        // Módulo responsável pela atualização do cliente
        JButton btnNewButton_2 = new JButton("ATUALIZAR");
		btnNewButton_2.setBounds(265, 356, 102, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
- DELETE  /usuarios/carmem -> Remove o usuário carmem

        // Módulo responsável por deletar os clientes
        JButton btnRemover = new JButton("EXCLUIR");
		btnRemover.setBounds(377, 356, 89, 23);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}


## Usado por

Esse projeto é usado pelas seguintes empresas:

- IBM
- Gama Academy

