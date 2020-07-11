package ucad.com.ecommerceSpringBoot.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import ucad.com.ecommerceSpringBoot.entities.Product;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

    @RestResource(path="/byDescription")
    public List<Product>  findByDescriptionContains(@Param("mc") String des);


    @RestResource(path="/byDescriptionPage")
    public Page<Product> findByDescriptionContains(@Param("mc") String des, Pageable pageable);

    @RestResource(path="/byName")
    public List<Product>  findByNameContains(@Param("mc") String des);


    @RestResource(path="/byNamePage")
    public Page<Product> findByNameContains(@Param("mc") String des, Pageable pageable);




    @RestResource(path = "/selectedProducts")
    public List<Product> findBySelectedIsTrue();
    //@RestResource(path = "/productsByKeyword")
   // public List<Product> findByNameContains(@Param("mc") String mc);
    @RestResource(path = "/promoProducts")
    public List<Product> findByPromotionIsTrue();
    @RestResource(path = "/dispoProducts")
    public List<Product> findByAvailableIsTrue();
}
