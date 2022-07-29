package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.daorepository;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ComprobanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//INTERFACE/CAPA ACCESO A DATOS RECIBE DE MODEL LOS DATOS DE LA CLASE ComprobanteEntity POR EL COMPROBANTEID
@Repository
public interface ComprobanteRepository extends JpaRepository<ComprobanteEntity, Long> {
}
