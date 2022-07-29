package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.daorepository;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//INTERFACE/CAPA ACCESO A DATOS RECIBE DE MODEL LOS DATOS DE LA CLASE ItemEntity POR EL ITEMID
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
