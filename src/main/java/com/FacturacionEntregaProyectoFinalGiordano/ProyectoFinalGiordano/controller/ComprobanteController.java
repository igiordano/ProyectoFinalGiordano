package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.controller;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ComprobanteRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ComprobanteResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.ComprobanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ESTA CAPA SE CONECTA CON POSTMAN QUIEN GUARDA LA INFORMACION EN LA BBDD VENTAS LUEGO DE LA EJECUCION DE CUALQUIER METODO APLICADO DE ACA
//  SE CONECTA CON /ComprobanteService/ComprobanteResponse
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/comprobante")
public class ComprobanteController {

    private final ComprobanteService comprobanteService;

    @GetMapping()
    public ResponseEntity<List<ComprobanteResponse>> ObtenerComprobante(){
        return ResponseEntity.ok(comprobanteService.buscarTodos());
    }

    @GetMapping(value = "/{comprobanteId}")
    public ResponseEntity<ComprobanteResponse> buscarPorId(@PathVariable Long comprobanteId) throws ApiException {
        return ResponseEntity.ok(comprobanteService.buscarPorIdComprobante(comprobanteId));
    }

    @PostMapping(value = "/actualizar")
    public ResponseEntity<ComprobanteResponse> actualizar(@RequestBody ComprobanteRequest comprobante) throws ApiException {
        return ResponseEntity.ok(comprobanteService.actualizar(comprobante));
    }

    @PostMapping( "/crear")
    public ResponseEntity<ComprobanteResponse> crear(@RequestBody ComprobanteRequest comprobante) throws ApiException {
        return ResponseEntity.ok(comprobanteService.crear(comprobante));
    }

    @PostMapping(value = "/eliminar")
    public void eliminar(@RequestBody ComprobanteRequest comprobante) throws ApiException {
        comprobanteService.eliminar(comprobante);
    }

    @PostMapping(value = "/eliminar/{comprobanteId}")
    public void eliminarPorId(@PathVariable Long comprobanteId) {
        comprobanteService.eliminarPorIdComprobante(comprobanteId);
    }

}








