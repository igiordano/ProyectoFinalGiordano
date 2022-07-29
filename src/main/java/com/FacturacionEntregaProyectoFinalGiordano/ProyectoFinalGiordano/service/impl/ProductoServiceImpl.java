package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.impl;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.builder.ProductoBuilder;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.daorepository.ProductoRepository;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ProductoEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ProductoRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ProductoResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//ESTA CLASE IMPLEMENTA LA INTERFACE ProductoService
// SOBRE ESCRIBE LOS METODOS DE LA INTERFACE

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public ProductoResponse buscarPorId(Long ProductoId) {
        ProductoEntity producto = productoRepository.findById(ProductoId).orElse(null);
        return ProductoBuilder.entityToResponse(producto);
    }

    @Override
    public ProductoResponse buscarPorCodigo(Integer codigo) {
        ProductoEntity producto = productoRepository.findByCodigo(codigo);
        if (producto != null) {
            return ProductoBuilder.entityToResponse(producto);
        }
        return null;
    }

    @Override
    public List<ProductoResponse> buscarTodos() {
        List<ProductoEntity> listaProductosEntities = productoRepository.findAll();
        List<ProductoResponse> listaProductoResponse = ProductoBuilder.entityToResponseList(listaProductosEntities);
        return listaProductoResponse;
    }

    @Override
    public ProductoResponse crear(ProductoRequest producto) throws ApiException {
        try {
            if (buscarPorCodigo(producto.getCodigo()) == null) {
                ProductoEntity productoAGuardar = ProductoBuilder.requestToEntity(producto);
                ProductoEntity entity = productoRepository.save(productoAGuardar);
                ProductoResponse productoAResponder = ProductoBuilder.entityToResponse(entity);
                return productoAResponder;
            } else {
                throw new ApiException("Producto ya existe");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    @Override
    public ProductoResponse actualizar(ProductoRequest producto) throws ApiException {
        try {
            if (buscarPorCodigo(producto.getCodigo()) == null) {
                ProductoEntity entity = productoRepository.save(ProductoBuilder.requestToEntity(producto));
                return ProductoBuilder.entityToResponse(entity);
            } else {
                throw new ApiException("Producto no existe");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    @Override
    public void eliminar(ProductoRequest producto) throws ApiException {
        if (buscarPorCodigo(producto.getCodigo()) != null) {
            ProductoEntity productoAEliminar = ProductoBuilder.requestToEntity(producto);
            productoRepository.delete(productoAEliminar);
        } else {
            throw new ApiException("Producto no existe");
        }
    }

    @Override
    public void eliminarPorId(Long ProductoId) { productoRepository.deleteById(ProductoId);}
}
