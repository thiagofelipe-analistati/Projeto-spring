package com.tfanalista.Projetospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tfanalista.Projetospring.entidades.Categoria;
import com.tfanalista.Projetospring.entidades.Pedido;
import com.tfanalista.Projetospring.entidades.Usuario;
import com.tfanalista.Projetospring.entidades.enuns.StatusPedidos;
import com.tfanalista.Projetospring.repositories.CategoriaRepository;
import com.tfanalista.Projetospring.repositories.PedidoRepository;
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
	
	
	// metodo para instanciar os objetos.
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, StatusPedidos.AGUARDANDO_PAGAMENTO);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, StatusPedidos.ENVIADO);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, StatusPedidos.PAGO);
		userrepository.saveAll(Arrays.asList(u1,u2));
		pedidorepository.saveAll(Arrays.asList(o1,o2,o3));
		
			Categoria cat1 = new Categoria(null, "Electronics");
			Categoria cat2 = new Categoria(null, "Books");
			Categoria cat3 = new Categoria(null, "Computers");
			categoriaRepostiry.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
	
	

}
