package com.redhat.coolstore.inventory.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.coolstore.inventory.model.Inventory;
import com.redhat.coolstore.inventory.service.InventoryService;

@Path("/inventory")
@ApplicationScoped
public class InventoryResource {

	@Inject
	private InventoryService inventoryService;

	@GET
	@Path("/{itemId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Inventory getInventory(@PathParam("itemId") String itemId) {

		Inventory inventorio = inventoryService.getInventory(itemId);
		if(inventorio != null) {
			return inventorio;
		}else {
			throw new NotFoundException("No se ha encontrado el inventorio para el item: " + itemId);
		}
	}
}