package br.com.reunioes.gerenciadorgalareunioes.model.repository;

import br.com.reunioes.gerenciadorgalareunioes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
}
