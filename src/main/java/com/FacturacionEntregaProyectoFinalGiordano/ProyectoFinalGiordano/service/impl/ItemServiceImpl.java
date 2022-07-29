package com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.impl;

import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.builder.ItemBuilder;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.daorepository.ItemRepository;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.handle.ApiException;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.entity.ItemEntity;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.request.ItemRequest;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.model.response.ItemResponse;
import com.FacturacionEntregaProyectoFinalGiordano.ProyectoFinalGiordano.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//ESTA CLASE IMPLEMENTA LA INTERFACE ItemService
// SOBRE ESCRIBE LOS METODOS DE LA INTERFACE

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    @Override
    public ItemResponse buscarPorIdItem(Long ItemId) throws ApiException {
        ItemEntity item = itemRepository.findById(ItemId).orElse(null);
        return ItemBuilder.entityToResponse(item);
    }

    @Override
    public List<ItemResponse> buscarTodos() {
        List<ItemEntity> listaItemEntities = itemRepository.findAll();
        List<ItemResponse> listaItemResponse = ItemBuilder.entityToResponseList(listaItemEntities);
        return listaItemResponse;
    }

    @Override
    public ItemResponse crear(ItemRequest item) throws ApiException {
        try {
            if (buscarPorIdItem(item.getItemId()) == null) {
                ItemEntity itemAGuardar = ItemBuilder.requestToEntity(item);
                ItemEntity entity = itemRepository.save(itemAGuardar);
                ItemResponse itemAResponder = ItemBuilder.entityToResponse(entity);
                return itemAResponder;
            } else {
                throw new ApiException("El Item ya existe");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    @Override
    public ItemResponse actualizar(ItemRequest item) throws ApiException {
        try {
            if (buscarPorIdItem(item.getItemId()) == null) {
                ItemEntity entity = itemRepository.save(ItemBuilder.requestToEntity(item));
                return ItemBuilder.entityToResponse(entity);
            } else {
                throw new ApiException("El Item no existe");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    @Override
    public void eliminar(ItemRequest item) throws ApiException {
        if (buscarPorIdItem(item.getItemId()) != null) {
            ItemEntity itemAEliminar = ItemBuilder.requestToEntity(item);
           itemRepository.delete(itemAEliminar);
        } else {
            throw new ApiException("Cliente no existe");
        }

    }

    @Override
    public void eliminarPorIdItem(Long ItemId) {
        itemRepository.deleteById(ItemId);

    }
}
