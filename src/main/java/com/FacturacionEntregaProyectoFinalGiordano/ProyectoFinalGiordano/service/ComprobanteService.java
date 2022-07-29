package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ComprobanteRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ComprobanteResponse;

import java.util.List;
// INTERFACE ComprobanteService con los metodos, se usan en la clases ComprobanteServiceImpl y ComprobanteController//
public interface ComprobanteService {
    ComprobanteResponse buscarPorIdComprobante(Long comprobanteId) throws ApiException;
    List<ComprobanteResponse> buscarTodos();
    ComprobanteResponse crear(ComprobanteRequest comprobante) throws ApiException;
    ComprobanteResponse actualizar(ComprobanteRequest comprobante) throws ApiException;
    void eliminar(ComprobanteRequest comprobante) throws ApiException;
    void eliminarPorIdComprobante(Long comprobanteId);


}
