package com.example.AD2_Vehiculos;

import com.example.AD2_Vehiculos.entity.Moto;
import com.example.AD2_Vehiculos.entity.Propietario;
import com.example.AD2_Vehiculos.entity.Vehiculo;
import com.example.AD2_Vehiculos.repository.PropietarioRepository;
import com.example.AD2_Vehiculos.repository.VehiculoRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.example.AD2_Vehiculos")
public class Ad2VehiculosApplication implements ApplicationRunner {
	// Declaramos la dependencia como "final" para garantizar que no se modifique después de la inicialización.
	private final VehiculoRepository vehiculoRepository;
	private final PropietarioRepository propietarioRepository;

	/**
	 * Inyección de dependencias mediante constructor.
	 *
	 * Spring Boot automáticamente detecta y proporciona una instancia de VehiculoRepository
	 * cuando inicia la aplicación, gracias a la anotación @SpringBootApplication.
	 *
	 * Usar inyección por constructor es la mejor práctica porque:
	 *  - Asegura que la dependencia siempre se inyecte antes de ser usada.
	 *  - Facilita la prueba unitaria al permitir inyectar mocks fácilmente.
	 *  - Evita la necesidad de usar @Autowired en campos, que puede causar inicialización tardía.
	 */
	public Ad2VehiculosApplication(VehiculoRepository vehiculoRepository, PropietarioRepository propietarioRepository) {
		this.vehiculoRepository = vehiculoRepository;
		this.propietarioRepository = propietarioRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(Ad2VehiculosApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// Creamos os obxectos Moto
		Moto moto1 = new Moto("Yamaha", "FZ", (short) 2015, 5000, 500, "Deportiva");
		Moto moto2 = new Moto("Honda", "CBR", (short) 2018, 7000, 600, "Deportiva");
		Moto moto3 = new Moto("Kawasaki", "Ninja", (short) 2019, 8000, 1000, "Deportiva");

		// Creamos e gardamos o propietario, é importante que o propietario se garde na BD antes de asignalo ás motos,
		// pois hasta que non se garde non se lle vai xerar un ID
		Propietario propietario = new Propietario("Gabriel", "Hernández");
		propietarioRepository.save(propietario);

		// Asignamos o propietario a cada moto
		moto1.setPropietario(propietario);
		moto2.setPropietario(propietario);
		moto3.setPropietario(propietario);

		// Asignar vehiculos ao propietario
		propietario.setVehiculos(List.of(moto1, moto2, moto3));


		// Gardamos todo
		/*
		vehiculoRepository.save(moto1);
		vehiculoRepository.save(moto2);
		vehiculoRepository.save(moto3);*/
		vehiculoRepository.saveAll(List.of(moto1, moto2, moto3));

		Pageable pageable = PageRequest.of(0, 5);
		Page<Vehiculo> page = vehiculoRepository.findAll(pageable);  // Obtenemos la primera página con 5 motos

		// Mostrar los resultados de la página (por ejemplo, en consola)
		System.out.println("Página 1 de Vehículos:");
		page.getContent().forEach(moto -> System.out.println(moto.getMarca() + " " + moto.getModelo()));

		// Puedes hacer más acciones aquí, como mostrar la cantidad total de páginas, elementos, etc.
		System.out.println("Total de páginas: " + page.getTotalPages());
		System.out.println("Total de elementos: " + page.getTotalElements());

	}
}
