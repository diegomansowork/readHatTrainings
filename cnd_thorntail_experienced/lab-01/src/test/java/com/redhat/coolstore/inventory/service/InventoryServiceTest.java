package com.redhat.coolstore.inventory.service;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import javax.inject.Inject;
import org.junit.Test;
import com.redhat.coolstore.inventory.model.Inventory;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Arquillian.class)
public class InventoryServiceTest {

    @Inject
    private InventoryService inventoryService;
    
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackages(true, InventoryServiceTest.class.getPackage())
                .addPackages(true, Inventory.class.getPackage())
                .addAsResource("project-local.yml", "project-defaults.yml")
                .addAsResource("META-INF/test-persistence.xml",  "META-INF/persistence.xml")
                .addAsResource("META-INF/test-load.sql",  "META-INF/test-load.sql");
    }

    @Test
    public void getInventory() throws Exception {
        assertThat(inventoryService, notNullValue());
        Inventory inventory = inventoryService.getInventory("123456");
        assertThat(inventory, notNullValue());
        assertThat(inventory.getQuantity(), is(99));
    }
    
        @Test
        public void getNonExistingInventory() throws Exception {

            // TODO:
            //
            // - assert that the inventory service is not null
            // - get an inventory object using a non-existant id: "99999"
            // - assert that the inventory object retrieved is a null value
        	 assertThat(inventoryService, notNullValue());
        	 Inventory inventory = inventoryService.getInventory("5445645");
        	 assertThat(inventory, nullValue());
        	
        }
    
    
}
