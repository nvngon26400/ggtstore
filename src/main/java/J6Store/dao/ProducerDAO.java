package J6Store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import J6Store.entity.Producer;

public interface ProducerDAO extends JpaRepository<Producer, String> {

}
