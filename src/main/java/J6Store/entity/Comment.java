package J6Store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Comments")
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String com;
	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	Date createDate = new Date();
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Product> products;
	@ManyToOne
	@JoinColumn(name = "Username")
	Account account;
	@ManyToOne
	@JoinColumn(name = "Productid")
	Product product;
}
