package br.com.reunioes.gerenciadorgalareunioes;

import br.com.reunioes.gerenciadorgalareunioes.mappers.SalaMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class GerenciadorSalaReunioesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public SalaMapper salaMapper() { return new SalaMapper(); }

	@Bean(name="formatHora")
	public SimpleDateFormat formHora() { return new SimpleDateFormat("HH:mm:ss"); };

	@Bean(name="formatData")
	public SimpleDateFormat formData() { return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); };

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorSalaReunioesApplication.class, args);
	}

}
