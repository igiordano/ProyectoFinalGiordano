package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.controller;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ProductoRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ProductoResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ESTA CAPA SE CONECTA CON POSTMAN QUIEN GUARDA LA INFORMACION EN LA BBDD VENTAS LUEGO DE LA EJECUCION DE CUALQUIER METODO APLICADO DE ACA
//  SE CONECTA CON /ProductoService/ProductoResponse

@RestController
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;
    @GetMapping()
    public ResponseEntity<List<ProductoResponse>> obtenerProductos() {
        return ResponseEntity.ok(productoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> buscarPorId(@PathVariable Long ProductoId) {
        return ResponseEntity.ok(productoService.buscarPorId(ProductoId));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<ProductoResponse> actualizar(@RequestBody ProductoRequest producto) throws ApiException {
        return ResponseEntity.ok(productoService.actualizar(producto));
    }

    @PostMapping("/crear")
    public ResponseEntity<ProductoResponse> crear(@RequestBody ProductoRequest producto) throws ApiException {
        return ResponseEntity.ok(productoService.crear(producto));
    }

    @PostMapping("/eliminar")
    public void eliminar(@RequestBody ProductoRequest producto) throws ApiException {
        productoService.eliminar(producto);
    }

    @PostMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable Long ProductoId) {
        productoService.eliminarPorId(ProductoId);
    }

}
