
import java.time.LocalDate;
import java.util.Scanner;
import Controllers.Biblioteca;
import Controllers.ControladorLivro;
import Controllers.ControladorUsuario;
import Models.Livro.LivroBraille;
import Models.Livro.LivroDigital;
import Models.Livro.LivroFisico;
import Models.*;
public class App {
    
    public static void main(String[] args) throws Exception {
        ControladorLivro controladorLivro = new ControladorLivro();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        Biblioteca biblioteca = new Biblioteca(controladorLivro, controladorUsuario);
        boolean sair = false;


        
        Scanner scanner = new Scanner(System.in);
        while (!sair) {
            System.out.println("BIBLIOTECA");
            System.out.println("Digite o número da opção correspondente");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Emitir Relatórios");
            System.out.println("6. Pesquisar livro");
            System.out.println("7. Sair");
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
                    controladorUsuario.adicionarUsuario(usuario);
                    System.out.println("Usuário cadastrado com sucesso");
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
                        System.out.println("Livro cadastrado com sucesso");
                    }
                    else if(tipoLivro == 2){
                        System.out.println("Digite o formato do arquivo: ");
                        String arqFormato = scannerCadastroLivro.nextLine();
                        LivroDigital livroD = new LivroDigital(nomeLivro, categoriaLivro, autorLivro, anoPub, exemDisp, arqFormato);
                        controladorLivro.adicionarLivro(livroD);
                        System.out.println("Livro cadastrado com sucesso");
                    }
                    else if(tipoLivro == 3){
                        System.out.println("Digite o material do livro: ");
                        String material = scannerCadastroLivro.nextLine();
                        LivroBraille livroB = new LivroBraille(nomeLivro, categoriaLivro, autorLivro, anoPub, exemDisp, material);
                        controladorLivro.adicionarLivro(livroB);
                        System.out.println("Livro cadastrado com sucesso");
                    }
                    break;
                case 3:
                    Scanner scannerEmprestimo = new Scanner(System.in);
                    System.out.println("Digite o título do livro: ");
                    String tituloLivroEmprestimo = scannerEmprestimo.nextLine();
                    System.out.println("Digite o nome do usuário: ");
                    String nomeUEmprestimo = scannerEmprestimo.nextLine();
                    Usuario uEmprestimo = controladorUsuario.buscarUsuarioAdd(nomeUEmprestimo);
                    System.out.println("Digite a data de empréstimo (formato: AAAA-MM-DD): ");
                    String dataEmprestimoStr = scannerEmprestimo.nextLine();
                    LocalDate dataEmprestimo = LocalDate.parse(dataEmprestimoStr);
                    biblioteca.emprestarLivroParaUsuario(uEmprestimo, tituloLivroEmprestimo, dataEmprestimo);
                    System.out.println("Empréstimo realizado");
                    System.out.println(uEmprestimo);
                break;
                case 4:
                    Scanner scannerDevolucao = new Scanner(System.in);
                    System.out.println("Digite o título do livro");
                    String tituloLivroDevolucao = scannerDevolucao.nextLine();
                    System.out.println("Digite o nome do usuário que vai devolver");
                    String nomeUDevolucao = scannerDevolucao.nextLine();
                    Usuario uDevolucao= controladorUsuario.buscarUsuarioAdd(nomeUDevolucao);
                    biblioteca.devolverLivroDeUsuario(uDevolucao, tituloLivroDevolucao);
                    System.out.println("Livro devolvido com sucesso!");
                    System.out.println(uDevolucao);
                    break;
                case 5:
                    Scanner scannerRelatorio = new Scanner(System.in);
                    System.out.println("Digite o número correspondente ao tipo de relatório");
                    System.out.println("1. Consultar livros emprestados");
                    System.out.println("2. Consultar usuários com atrasos");
                    System.out.println("3. Consultar livros mais populares");
                    System.out.println("4. Consultar acervo de livros");
                    int tipoRelatorio = scannerRelatorio.nextInt();
                    scannerRelatorio.nextLine();
                    if(tipoRelatorio == 1){
                        System.out.println(biblioteca.getLivrosEmprestados());
                    }
                    else if(tipoRelatorio == 2){
                        System.out.println(controladorUsuario.listarUsuariosComAtraso());
                    }
                    else if(tipoRelatorio == 3){
                        System.out.println(controladorLivro.listarLivrosPopularidade());
                    }
                    else if(tipoRelatorio == 4){
                        System.out.println(controladorLivro.listarTodosOsLivros());
                    }
                    break;
                case 6:
                    Scanner scannerBusca = new Scanner(System.in);
                    System.out.println("Digite o número para o tipo de busca correspondente");
                    System.out.println("1.Código");
                    System.out.println("2.Título");
                    System.out.println("3.Autor");
                    System.out.println("4.Categoria");
                    int busca = scannerBusca.nextInt();
                    scannerBusca.nextLine();
                    if(busca == 1){
                        System.out.println("Digite o código: ");
                        int cod = scannerBusca.nextInt();
                        scannerBusca.nextLine();
                        System.out.println(controladorLivro.buscarLivroCod(cod)); 
                    }

                    else if(busca == 2){
                        System.out.println("Digite o título ");
                        String titulo = scannerBusca.nextLine();
                        System.out.println(controladorLivro.buscarLivroTitulo(titulo)); 
                    }
                    else if(busca == 3){
                        System.out.println("Digite o autor ");
                        String autor = scannerBusca.nextLine();
                        System.out.println(controladorLivro.buscarLivrosAutor(autor)); 
                    }
                    else if(busca == 4){
                        System.out.println("Digite a categoria ");
                        String categoria = scannerBusca.nextLine();
                        System.out.println(controladorLivro.buscarLivrosCategoria(categoria)); 
                    }
                    break;
                case 7:
                    sair = true;
                    break;
                default:
                    System.out.println("Digite um valor válido");
            }
        }

        scanner.close();
    }
 } 

