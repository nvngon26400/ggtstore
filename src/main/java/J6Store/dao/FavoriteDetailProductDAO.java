package J6Store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import J6Store.entity.FavoriteDetailProduct;

public interface FavoriteDetailProductDAO extends JpaRepository<FavoriteDetailProduct, Long> {

}
