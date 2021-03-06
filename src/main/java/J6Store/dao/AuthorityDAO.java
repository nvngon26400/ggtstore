package J6Store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import J6Store.entity.Account;
import J6Store.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {

	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);
	
	@Query(nativeQuery = true, value = "select count(RoleId) from Authorities where RoleId='DIRE'")
	long authorityDirector();
	
	@Query(nativeQuery = true, value = "select count(RoleId) from Authorities where RoleId='STAF'")
	long authorityStaff();
}
