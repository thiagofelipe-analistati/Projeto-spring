package com.tfanalista.Projetospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tfanalista.Projetospring.entidades.Categoria;
import com.tfanalista.Projetospring.entidades.ItensPedido;
import com.tfanalista.Projetospring.entidades.Pedido;
import com.tfanalista.Projetospring.entidades.Produto;
import com.tfanalista.Projetospring.entidades.Usuario;
import com.tfanalista.Projetospring.entidades.enuns.StatusPedidos;
import com.tfanalista.Projetospring.repositories.CategoriaRepository;
import com.tfanalista.Projetospring.repositories.ItensPedidoRepository;
import com.tfanalista.Projetospring.repositories.PedidoRepository;
import com.tfanalista.Projetospring.repositories.ProdutoRepository;
import com.tfanalista.Projetospring.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	// injeção de dependênica do spring
	@Autowired
	private UsuarioRepository userrepository;
	@Autowired
	private PedidoRepository pedidorepository;
	@Autowired
	private CategoriaRepository categoriaRepostiry;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItensPedidoRepository itensPedidoRepository;
	
	
	// metodo para instanciar os objetos.
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		
		Produto p1 = new Produto(null, "Notebook asus", "8g ram, processador i7, tela 15,6", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		

		categoriaRepostiry.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategorias().add(cat3);
		p2.getCategorias().add(cat3);
		p2.getCategorias().add(cat1);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, StatusPedidos.AGUARDANDO_PAGAMENTO);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, StatusPedidos.ENVIADO);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, StatusPedidos.PAGO);
		userrepository.saveAll(Arrays.asList(u1,u2));
		pedidorepository.saveAll(Arrays.asList(o1,o2,o3));
		
			
			ItensPedido oi1 = new ItensPedido(o1, p1, 2, p1.getPreco());
			ItensPedido oi2 = new ItensPedido(o1, p3, 1, p3.getPreco());
			ItensPedido oi3 = new ItensPedido(o2, p3, 2, p3.getPreco());
			ItensPedido oi4 = new ItensPedido(o3, p5, 2, p5.getPreco());
			
			itensPedidoRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
			
	}
	
	

}
