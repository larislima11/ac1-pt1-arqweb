package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Produto;
import com.example.ac1.models.ProdutoCategoria;
import com.example.ac1.repository.ProdutoCategoriaRepository;
import com.example.ac1.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Ac1Application {
	@Bean
	@Transactional
	public CommandLineRunner init(
			@Autowired ProdutoCategoriaRepository produtoCategoriaRepository,
			@Autowired ProdutoRepository produtoRepository) {
		return args -> {
			System.out.println("*** CRIANDO AS CATEGORIAS ***");
			ProdutoCategoria c1 = produtoCategoriaRepository.salvar(
					new ProdutoCategoria(0, "Pratos", "Acessórios de Cozinha"));
			ProdutoCategoria c2 = produtoCategoriaRepository.salvar(
					new ProdutoCategoria(0, "Jogos","Eletronicos"));
			List<ProdutoCategoria> listaCategorias = produtoCategoriaRepository.obterTodos();
			listaCategorias.forEach(System.out::println);

			System.out.println("*** CRIANDO PRODUTOS ***");
			produtoRepository.salvar(
					new Produto(0, "Poltrona Vermelha", 2000, c1));
					produtoRepository.salvar(
					new Produto(0, "Cadeira", 2050, c2));
			List<Produto> listaCursos = produtoRepository.obterTodos();
			listaCursos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);

		
	}

}
