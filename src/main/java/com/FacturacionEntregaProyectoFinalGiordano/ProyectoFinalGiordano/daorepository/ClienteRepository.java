package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.daorepository;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//INTERFACE/CAPA ACCESO A DATOS RECIBE DE MODEL LOS DATOS DE LA CLASE ClienteEntity POR EL CLIENTEID
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
