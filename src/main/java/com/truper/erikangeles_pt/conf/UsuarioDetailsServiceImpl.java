package com.truper.erikangeles_pt.conf;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.truper.erikangeles_pt.model.Producto;
import com.truper.erikangeles_pt.model.Sucursal;
import com.truper.erikangeles_pt.model.Usuario;
import com.truper.erikangeles_pt.repository.ProductoRepo;
import com.truper.erikangeles_pt.repository.SucursalRepo;
import com.truper.erikangeles_pt.repository.UsuarioRepository;

@Configuration
@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProductoRepo productoRepo;

	@Autowired
	private SucursalRepo sucursalRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
	}

	@Bean
	String crearBase() {
		Usuario base = new Usuario();
		base.setUsername("admin");
		base.setPassword("$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.");
		usuarioRepository.save(base);

		Producto p1 = new Producto();
		p1.setCodigo("18156");
		p1.setDescripcion("Esmeriladora angular");
		p1.setPrecio(625.00);
		
		
		
		Producto p2 = new Producto();
		p2.setCodigo("17193");
		p1.setDescripcion("Pala redonda");
		p1.setPrecio(100.50);
		productoRepo.save(p1);
		productoRepo.save(p2);

		Sucursal suc = new Sucursal(0, "CDMX");

		sucursalRepo.save(suc);
		return "Base Creada";
	}
}
