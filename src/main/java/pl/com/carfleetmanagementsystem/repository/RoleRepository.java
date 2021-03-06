package pl.com.carfleetmanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.com.carfleetmanagementsystem.models.ERole;
import pl.com.carfleetmanagementsystem.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    //Lets try string

    @Override
    List<Role> findAll();

}
