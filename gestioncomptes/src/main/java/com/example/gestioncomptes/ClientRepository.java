package com.example.gestioncomptes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client,Long>  {
    @RestResource(path = "/parNom")
    public  List<Client> findByNom(@Param("nm") String nom);

    @RestResource(path="/parDesignation")
    public List<Client> findByEmailEquals(@Param("ds") String des);

}
