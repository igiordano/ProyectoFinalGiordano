package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.controller;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ItemRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ItemResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ESTA CAPA SE CONECTA CON POSTMAN QUIEN GUARDA LA INFORMACION EN LA BBDD VENTAS LUEGO DE LA EJECUCION DE CUALQUIER METODO APLICADO DE ACA
//  SE CONECTA CON /ItemService/ItemResponse
@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping()
    public ResponseEntity<List<ItemResponse>> obtenerItems() {
        return ResponseEntity.ok(itemService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> buscarPorId(@PathVariable Long itemId) throws ApiException {
        return ResponseEntity.ok(itemService.buscarPorIdItem(itemId));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<ItemResponse> actualizar(@RequestBody ItemRequest item) throws ApiException {
        return ResponseEntity.ok(itemService.actualizar(item));
    }

    @PostMapping("/crear")
    public ResponseEntity<ItemResponse> crear(@RequestBody ItemRequest item) throws ApiException {
        return ResponseEntity.ok(itemService.crear(item));
    }

    @PostMapping("/eliminar")
    public void eliminar(@RequestBody ItemRequest item) throws ApiException {
        itemService.eliminar(item);
    }

    @PostMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable Long  itemId) {
        itemService.eliminarPorIdItem(itemId);
    }




}
