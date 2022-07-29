package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.impl;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.builder.ComprobanteBuilder;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.daorepository.ComprobanteRepository;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ComprobanteEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ComprobanteRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ComprobanteResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.ComprobanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//ESTA CLASE IMPLEMENTA LA INTERFACE ComprobanteService
// SOBRE ESCRIBE LOS METODOS DE LA INTERFACE

@Service
@RequiredArgsConstructor
public class ComprobanteServiceImpl implements ComprobanteService {

    private final ComprobanteRepository comprobanteRepository;

    @Override
    public ComprobanteResponse buscarPorIdComprobante(Long comprobanteId) throws ApiException {
        ComprobanteEntity comprobante = comprobanteRepository.findById(comprobanteId).orElse(null);
        if (comprobante != null) {
            return ComprobanteBuilder.entityToResponse(comprobante);
        }
        return null;
    }

    @Override
    public List<ComprobanteResponse> buscarTodos() {
        List<ComprobanteEntity> listaComprobantesEntities = comprobanteRepository.findAll();
        List<ComprobanteResponse> listaComprobanteResponse = ComprobanteBuilder.entityToResponseList(listaComprobantesEntities);
        return listaComprobanteResponse ;
    }

    @Override
    public ComprobanteResponse crear(ComprobanteRequest comprobante) throws ApiException {
        try {
            if (buscarPorIdComprobante(comprobante.getComprobanteId()) == null) {
                ComprobanteEntity comprobanteAGuardar = ComprobanteBuilder.requestToEntity(comprobante);
                ComprobanteEntity entity = comprobanteRepository.save(comprobanteAGuardar);
                ComprobanteResponse comprobanteAResponder = ComprobanteBuilder.entityToResponse(entity);
                return comprobanteAResponder;
            } else {
                throw new ApiException("Comprobante ya existe");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }


    @Override
    public ComprobanteResponse actualizar(ComprobanteRequest comprobante) throws ApiException {
        try {
            if (buscarPorIdComprobante(comprobante.getComprobanteId())!= null)  {
                ComprobanteEntity entity = comprobanteRepository.save(ComprobanteBuilder.requestToEntity(comprobante));
                return ComprobanteBuilder.entityToResponse(entity);
            } else {
                throw new ApiException("Comprobante no existe");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    @Override
    public void eliminar(ComprobanteRequest comprobante) throws ApiException {
        if (buscarPorIdComprobante(comprobante.getComprobanteId()) != null) {
            ComprobanteEntity comprobanteAEliminar = ComprobanteBuilder.requestToEntity(comprobante);
            comprobanteRepository.delete(comprobanteAEliminar);
        } else {
            throw new ApiException("Cliente no existe");
        }

    }

    @Override
    public void eliminarPorIdComprobante(Long comprobanteId) {
        comprobanteRepository.deleteById(comprobanteId);

    }
}
