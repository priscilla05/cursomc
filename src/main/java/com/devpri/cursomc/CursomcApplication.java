package com.devpri.cursomc;

import com.devpri.cursomc.domain.Categoria;
import com.devpri.cursomc.domain.Cidade;
import com.devpri.cursomc.domain.Estado;
import com.devpri.cursomc.domain.Produto;
import com.devpri.cursomc.repositories.CategoriaRepository;
import com.devpri.cursomc.repositories.CidadeRepository;
import com.devpri.cursomc.repositories.EstadoRepository;
import com.devpri.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria(null,"Informatica");
		Categoria categoria2 = new Categoria(null,"Escritorio");

		Produto produto1 = new Produto(null, "Computador",2000.00);
		Produto produto2 = new Produto(null, "Impressora",800.00);
		Produto produto3 = new Produto(null, "Mouse",80.00);

		categoria1.getProdutos().addAll(Arrays.asList(produto1,produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1,categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		Estado estado1 = new Estado(null,"Minas Gerais");
		Estado estado2 = new Estado(null,"Paraiba");

		Cidade cidade1 = new Cidade(null,"Uberlandia", estado1);
		Cidade cidade2 = new Cidade(null,"Joao Pessoa", estado2);
		Cidade cidade3 = new Cidade(null,"Campina Grande", estado2);

		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2,cidade3));


		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2)); //categorias sendo salvas
		produtoRepository.saveAll(Arrays.asList(produto1,produto2, produto3)); // produtos sendo salvos
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2,cidade3));

	}
}
