package com.demojpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demojpa.models.Categoria;
import com.demojpa.repository.IcategoriaRepository;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {

	@Autowired
	private IcategoriaRepository repoCategoria;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}
	
@Override
public void run (String... args) throws Exception {
	//llamar a otros metodos
	guardar();
	
	testConexion();
}


private void buscarPorId () {
	Optional<Categoria> optional = repoCategoria.findById(1);
	if (optional.isPresent())
	System.out.println (optional.get().getNombre ());
else
System.out.println("Categoria no econtrada");
	
}


private void guardar () {
	Categoria categoria = new Categoria();
	categoria.setNombre("Trips en la yapla");
	categoria.setDescripcion("Todo tipo de paseos en la yapla");
	repoCategoria.save(categoria);
	
}
	
private void testConexion() {
	
	if (repoCategoria != null)
		System.out.println("Conexion exitosa: " + repoCategoria);
	else
	System.out.println("Error en conexion");


}

}