package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.controller;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ClienteRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ClienteResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ESTA CAPA SE CONECTA CON POSTMAN QUIEN GUARDA LA INFORMACION EN LA BBDD VENTAS LUEGO DE LA EJECUCION DE CUALQUIER METODO APLICADO DE ACA
//  SE CONECTA CON /ClienteService/ClienteResponse
@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<ClienteResponse>> obtenerClientes() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/buscarPorDni/{dni}")
    public ResponseEntity<ClienteResponse> buscarClientePorDni(@PathVariable Long dni) throws ApiException {
        return ResponseEntity.ok(clienteService.buscarPorDni(dni));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<ClienteResponse> actualizarCliente( @RequestBody ClienteRequest cliente) throws ApiException {
        return ResponseEntity.ok(clienteService.actualizar(cliente));
    }

    @PostMapping("/crear")
    public ResponseEntity<ClienteResponse> crearCliente(@RequestBody ClienteRequest cliente) throws ApiException {
        return ResponseEntity.ok(clienteService.crear(cliente));
    }

    @PostMapping("/eliminar")
    public void eliminar(@RequestBody ClienteRequest cliente) throws ApiException {
        clienteService.eliminar(cliente);
    }

    @PostMapping("/eliminar/{dni}")
    public void eliminar(@PathVariable Long dni) {
        clienteService.eliminarPorDni(dni);
    }
}
