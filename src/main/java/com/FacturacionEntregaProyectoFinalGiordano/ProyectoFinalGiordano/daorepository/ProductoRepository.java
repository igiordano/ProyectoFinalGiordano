package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.daorepository;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//INTERFACE/CAPA ACCESO A DATOS RECIBE DE MODEL LOS DATOS DE LA CLASE ProductoEntity POR EL PRODUCTOID
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    ProductoEntity findByCodigo(Integer codigo);
}
