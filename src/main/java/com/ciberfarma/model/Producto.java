package com.ciberfarma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_productos")
public class Producto {

	@Id
	private String id_prod;
	private String des_prod;
	private int stk_prod;
	private double pre_prod;
	private int idcategoria;
	private int est_prod;
	private int idproveedor;
}
