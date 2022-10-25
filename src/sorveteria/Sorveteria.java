package sorveteria;

import java.util.ArrayList;
import java.util.Scanner;

public class Sorveteria {

    public ArrayList<Produto> produtosEstoque = new ArrayList<Produto>();
    public ArrayList<Produto> produtosVendidos = new ArrayList<Produto>();
    public ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

    public void adicionarFornecedor(String nome, String cnpj, String endereco, String telefone) {
        Fornecedor fornecedor = new Fornecedor(nome, cnpj, endereco, telefone);
        if (fornecedores.contains(fornecedor)) {
            System.out.println("\n ------ Fornecedor já existe! ------ \n");
        } else {
            fornecedores.add(fornecedor);
            System.out.println("\n ------ Fornecedor adicionado com sucesso! ------ \n");
        }
    }

    public void adicionarAoEstoque(double valor, double preco, String nome) {
        Produto produto = new Produto(valor, preco, nome);
        if (produtosEstoque.contains(produto)) {
            System.out.println("\n ------ Produto já existe no estoque ------ \n");
        } else {
            produtosEstoque.add(produto);
            System.out.println("\n ------ Produto adicionado ao estoque com sucesso! ------ \n");
        }
    }

    public void listarEstoque() {
        System.out.println("\n ------ Produtos no estoque ------ \n");
        if(produtosEstoque.isEmpty()) {
            System.out.println(" ----- Nenhum produto no estoque! -----\n");
        } else
        for (Produto produto : produtosEstoque) {
            System.out.println(" ----- " + produto.getNome() + " - " + produto.getValor() + " - " + produto.getPreco()
                    + " ----- ");
        }
    }

    public void listarFornecedores() {
        System.out.println("\n ------ Fornecedores ------ \n");
        if(fornecedores.isEmpty()) {
            System.out.println(" ----- Nenhum fornecedor cadastrado! -----\n");
        } else
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println(
                    " ----- " + fornecedor.getNome() + " - " + fornecedor.getCnpj() + " - " + fornecedor.getEndereco()
                            + " - " + fornecedor.getTelefone() + " ----- ");
        }
    }

    public void vender(double valor, double preco, String nome) {
        Produto produto = new Produto(valor, preco, nome);
        if (produtosEstoque.contains(produto)) {
            produtosEstoque.remove(produto);
            produtosVendidos.add(produto);
            System.out.println("\n ----- Produto vendido com sucesso! ----- \n");
        } else {
            System.out.println("\n ----- Produto não existe no estoque ----- \n");
        }
    }

    public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE

    public static void main(String[] args) {
        System.out.print(WHITE_BACKGROUND);
        Sorveteria sorveteria = new Sorveteria();
        int opcao = 0;
        Scanner s = new Scanner(System.in);

        
        while (opcao != 6) {
            System.out.println("1 - Adicionar Fornecedor");
            System.out.println("2 - Adicionar Produto ao Estoque");
            System.out.println("3 - Listar Estoque");
            System.out.println("4 - Listar Fornecedores");
            System.out.println("5 - Vender");
            System.out.println("6 - Sair");
            try {
                System.out.print("Informe um número: ");
                opcao = s.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome do fornecedor");
                        String nome = s.next();
                        System.out.println("Digite o CNPJ do fornecedor");
                        String cnpj = s.next();
                        System.out.println("Digite o endereço do fornecedor");
                        String endereco = s.next();
                        System.out.println("Digit1e o telefone do fornecedor");
                        String telefone = s.next();

                        sorveteria.adicionarFornecedor(nome, cnpj, endereco, telefone);
                        break;
                    case 2:
                        System.out.println("Digite o valor do produto");
                        double valor = s.nextDouble();
                        System.out.println("Digite o preço do produto");
                        double preco = s.nextDouble();
                        System.out.println("Digite o nome do produto");
                        String nomeProduto = s.next();
                        sorveteria.adicionarAoEstoque(valor, preco, nomeProduto);
                        break;
                    case 3:
                        sorveteria.listarEstoque();
                        break;
                    case 4:
                        sorveteria.listarFornecedores();
                        break;
                    case 5:
                        System.out.println("Digite o valor do produto");
                        double valorProduto = s.nextDouble();
                        System.out.println("Digite o preço do produto");
                        double precoProduto = s.nextDouble();
                        System.out.println("Digite o nome do produto");
                        String nomeProdutoVenda = s.next();
                        sorveteria.vender(valorProduto, precoProduto, nomeProdutoVenda);
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("\n ----- Opção inválida - Você é burro? ----- \n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um problema ao executar a opção");
                System.out.println(e);
                opcao = 6;
            }
        }
        s.close();
    }
}
