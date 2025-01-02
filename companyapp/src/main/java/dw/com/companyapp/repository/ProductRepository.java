package dw.com.companyapp.repository;

import dw.com.companyapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
