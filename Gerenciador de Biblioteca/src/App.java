
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

import Controllers.Biblioteca;
import Controllers.ControladorLivro;
import Controllers.ControladorUsuario;
import Models.Livro.Livro;
import Models.Livro.LivroBraille;
import Models.Livro.LivroDigital;
import Models.Livro.LivroFisico;
import Models.*;

//Ver estrutura do projeto(Herança-Usuario, UsuarioComum e UsuarioPremium, Interface-ILivro, LivroComum e LivroPremium)
//Como funcionaria a interface Ilivros? sendo que todos os métodos de adicionar, remover livros ficariam na biblioteca
//Como funcionaria pra classe usuário ter uma lista de livros, seria na classe mãe ou cada classe teria uma lista?

public class App {
    
    public static void main(String[] args) throws Exception {
        ControladorLivro controladorLivro = new ControladorLivro();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        Biblioteca biblioteca = new Biblioteca(controladorLivro, controladorUsuario);
        LivroBraille livroBraille = new LivroBraille("Teste", "Teste", "Teste", 2023, 2023, "Papel");
        LivroFisico livroFisico = new LivroFisico("uhul", "Capoeira", "boitata", 2023, 7, 467);
        LivroDigital livroDigital = new LivroDigital("testando", null, null, 0, 0, null);
        Usuario user1 = new Usuario("tata", "tata", "tata", "tata");
        Usuario user2 = new Usuario("Cefwild", "123", "Something missing", "foundme");
        controladorLivro.adicionarLivro(livroBraille);
        controladorLivro.adicionarLivro(livroFisico);
        controladorLivro.adicionarLivro(livroDigital);
        controladorUsuario.adicionarUsuario(user1);
        controladorUsuario.adicionarUsuario(user2);
        biblioteca.emprestarLivroParaUsuario(user1, "Teste", LocalDate.of(2023, 4, 15));
        biblioteca.emprestarLivroParaUsuario(user2, "uhul", LocalDate.of(2023, 4, 15));
        System.out.println(biblioteca.getLivrosEmprestados());
        boolean sair = false;


        
        Scanner scanner = new Scanner(System.in);
        while (!sair) {
            System.out.println("BIBLIOTECA");
            System.out.println("Digite o número da opção correspondente");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Sair");
            System.out.println("5. Emitir Relatórios");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    Scanner scannerCadastroUsuario = new Scanner(System.in);
                    System.out.println("Digite o nome do usuário:");
                    String nomeUsuario = scannerCadastroUsuario.nextLine();
                    System.out.println("Digite o telefone do usuário:");
                    String telefoneUsuario = scannerCadastroUsuario.nextLine();
                    System.out.println("Digite o endereço do usuário:");
                    String enderecoUsuario = scannerCadastroUsuario.nextLine();
                    System.out.println("Digite o e-mail do usuário:");
                    String emailUsuario = scannerCadastroUsuario.nextLine();
                    Usuario usuario = new Usuario(nomeUsuario, telefoneUsuario, enderecoUsuario, emailUsuario);
                    System.out.println("Opção 1 selecionada: Emprestar livro");
                    controladorUsuario.adicionarUsuario(usuario);
                    System.out.println(controladorUsuario);
                    break;
                case 2:
                    Scanner scannerCadastroLivro = new Scanner(System.in);
                    System.out.println("Digite o número correspondente ao tipo de livro:");
                    System.out.println("1.Livro Físico");
                    System.out.println("2.Livro Digital");
                    System.out.println("3.Livro Braille");
                    int tipoLivro = scannerCadastroLivro.nextInt();
                    scannerCadastroLivro.nextLine();
                    System.out.println("Digite o título do livro");
                    String nomeLivro = scannerCadastroLivro.nextLine();
                    System.out.println("Digite a categoria do livro");
                    String categoriaLivro = scannerCadastroLivro.nextLine();
                    System.out.println("Digite o autor(a) do livro");
                    String autorLivro = scannerCadastroLivro.nextLine();
                    System.out.println("Digite o ano de publicação");
                    int anoPub = scannerCadastroLivro.nextInt();
                    System.out.println("Digite o número de exemplares disponíveis");
                    int exemDisp = scannerCadastroLivro.nextInt();
                    scannerCadastroLivro.nextLine();
                    if(tipoLivro == 1){
                        System.out.println("Digite o número de páginas");
                        int numPag = scannerCadastroLivro.nextInt();
                        LivroFisico livroF = new LivroFisico(nomeLivro, categoriaLivro, autorLivro, anoPub, exemDisp, numPag);
                        controladorLivro.adicionarLivro(livroF);
                        System.out.println(controladorLivro);
                    }
                    else if(tipoLivro == 2){
                        System.out.println("Digite o formato do arquivo: ");
                        String arqFormato = scannerCadastroLivro.nextLine();
                        LivroDigital livroD = new LivroDigital(nomeLivro, categoriaLivro, autorLivro, anoPub, exemDisp, arqFormato);
                        controladorLivro.adicionarLivro(livroD);
                        System.out.println(controladorLivro);
                    }
                    else if(tipoLivro == 3){
                        System.out.println("Digite o material do livro: ");
                        String material = scannerCadastroLivro.nextLine();
                        LivroBraille livroB = new LivroBraille(nomeLivro, categoriaLivro, autorLivro, anoPub, exemDisp, material);
                        controladorLivro.adicionarLivro(livroB);
                        System.out.println(controladorLivro);
                    }
                    break;
                case 3:
                System.out.println("Digite o título do livro: ");
                String tituloLivro = scanner.nextLine();

                System.out.println("Digite o nome do usuário: ");
                String nomeU = scanner.nextLine();
                Usuario u = new Usuario(nomeU, null, null, null);
                if (u== null) {
                    System.out.println("Usuário não encontrado.");
                    break;
                }

                System.out.println("Digite a data de empréstimo (formato: AAAA-MM-DD): ");
                String dataEmprestimoStr = scanner.nextLine();
                LocalDate dataEmprestimo = LocalDate.parse(dataEmprestimoStr);

                biblioteca.emprestarLivroParaUsuario(u, tituloLivro, dataEmprestimo);
                System.out.println("Livro emprestado com sucesso para o usuário: " + u.getNome());
                System.out.println(controladorUsuario);
                break;
                case 5:
                    System.out.println("Digite o número correspondente ao tipo de relatório");
                    System.out.println("1. Consultar livros emprestados");
                    System.out.println("2. Consultar usuários com atrasos");
                    System.out.println("3. Consultar livros emprestados");
                    sair = true;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }
 } 

