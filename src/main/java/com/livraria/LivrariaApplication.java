package com.livraria;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.livraria.domain.Autor;
import com.livraria.domain.Cidade;
import com.livraria.domain.Cliente;
import com.livraria.domain.Colecao;
import com.livraria.domain.Departamento;
import com.livraria.domain.DepartamentoLeitura;
import com.livraria.domain.DireitoAutoral;
import com.livraria.domain.Editora;
import com.livraria.domain.Emprestimo;
import com.livraria.domain.Endereco;
import com.livraria.domain.Estado;
import com.livraria.domain.Livro;
import com.livraria.domain.Pais;
import com.livraria.enums.EstadoLivro;
import com.livraria.repositories.AutorRepository;
import com.livraria.repositories.CidadeRepository;
import com.livraria.repositories.ClienteRepository;
import com.livraria.repositories.ColecaoRepository;
import com.livraria.repositories.DepartamentoRepository;
import com.livraria.repositories.DireitoAutoralRepository;
import com.livraria.repositories.EditoraRepository;
import com.livraria.repositories.EmprestimoRepository;
import com.livraria.repositories.EnderecoRepository;
import com.livraria.repositories.EstadoRepository;
import com.livraria.repositories.LivroRepository;
import com.livraria.repositories.PaisRepository;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository; 
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private EditoraRepository editoraRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private DireitoAutoralRepository direitoAutoralRepository;
	@Autowired
	private ColecaoRepository colecaoRepository;
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pais pais1 = new Pais(null,"Brasil");
		
		Estado estado1 = new Estado(null, "Pernambuco", pais1);
		Estado estado2 = new Estado(null, "Bahia", pais1);
		
		paisRepository.saveAll(Arrays.asList(pais1));
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		
		Cidade cidade1 = new Cidade(null, "Recife", estado1);
		Cidade cidade2 = new Cidade(null, "Salvador", estado2);
		Cidade cidade3 = new Cidade(null, "Ilhéus", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade1,cidade2));
		
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		
		String data1 = "20/05/2000";
		String data2 = "25/05/2000";
		Date dataEmprestimo = new SimpleDateFormat("dd/MM/yyyy").parse(data1);
		Date dataDevolucao = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
		
		Editora editora1 = new Editora(null, "Saraiva");
		Editora editora2 = new Editora(null, "Angel");
		
		Autor autor1 = new Autor(null, "Arthur Pontes");
		Autor autor2 = new Autor(null, "Manoel Carlos");	
		
		Departamento departamentoLeitura = new DepartamentoLeitura(null, "Livros para  Entreter", "Livre");
		
		Colecao colecao1 = new Colecao(null, "Terra", departamentoLeitura);
		Colecao colecao2 = new Colecao(null, "Planeta Terra", departamentoLeitura);
		
		departamentoLeitura.getColecoes().addAll(Arrays.asList(colecao1,colecao2));

		
		Livro livro1 = new Livro(null, "Terra", 2000, EstadoLivro.EMPRESTADO, 2.00, editora1);
		Livro livro2 = new Livro(null, "Terra características", 2000, EstadoLivro.DISPONIVEL, 3.00, editora1);
		Livro livro3 = new Livro(null, "Água", 1995, EstadoLivro.INUTILIZADO, 5.00, editora2);
		
		colecao1.getLivros().addAll(Arrays.asList(livro1,livro2));
		colecao2.getLivros().addAll(Arrays.asList(livro3));
		
		livro1.getColecoes().addAll(Arrays.asList(colecao1));
		livro2.getColecoes().addAll(Arrays.asList(colecao1));
		livro3.getColecoes().addAll(Arrays.asList(colecao2));
		
		DireitoAutoral direitoAutoral1 = new DireitoAutoral(autor1, livro3, 2.00);
		DireitoAutoral direitoAutoral2 = new DireitoAutoral(autor1, livro2, 3.00);
		DireitoAutoral direitoAutoral3 = new DireitoAutoral(autor2, livro1, 2.00);
		DireitoAutoral direitoAutoral4 = new DireitoAutoral(autor2, livro2, 4.00);
		
		autor1.getDireitoAutoral().addAll(Arrays.asList(direitoAutoral1,direitoAutoral2));
		autor2.getDireitoAutoral().addAll(Arrays.asList(direitoAutoral3,direitoAutoral4));
		
		livro1.getDireitoAutoral().addAll(Arrays.asList(direitoAutoral3));
		livro2.getDireitoAutoral().addAll(Arrays.asList(direitoAutoral2,direitoAutoral4));
		livro3.getDireitoAutoral().addAll(Arrays.asList(direitoAutoral1));
		
		editora1.getLivros().addAll(Arrays.asList(livro1,livro2));
		editora2.getLivros().addAll(Arrays.asList(livro3));
				
		Emprestimo emprestimo1 = new Emprestimo(null, dataEmprestimo, dataDevolucao, null, livro1);
				
		Cliente cliente1 = new Cliente(null, "Paulo",  emprestimo1);
		
		Endereco endereco1 = new Endereco(null, "Rua Capiba", "12", "A", "Limoeiro", "12345678", cliente1, cidade1);
		
		cliente1.setEndereco(endereco1);		
		cliente1.getTelefones().addAll(Arrays.asList("32563256"));
		cliente1.getEmprestimo().setCliente(cliente1);
		
		editoraRepository.saveAll(Arrays.asList(editora1,editora2));	
		
		departamentoRepository.saveAll(Arrays.asList(departamentoLeitura));
				
		livroRepository.saveAll(Arrays.asList(livro1,livro2,livro3));
		
		colecaoRepository.saveAll(Arrays.asList(colecao1,colecao2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		
		enderecoRepository.saveAll(Arrays.asList(endereco1));

		emprestimoRepository.saveAll(Arrays.asList(emprestimo1));
		
		autorRepository.saveAll(Arrays.asList(autor1, autor2));
		
		direitoAutoralRepository.saveAll(Arrays.asList(direitoAutoral1,direitoAutoral2,direitoAutoral3,direitoAutoral4));
		
		System.out.println("Testando");
		
	}

}
