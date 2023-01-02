package com.telepathy.boutique;

import junit.framework.TestCase;

public class BookingControllerTest extends TestCase {

    public void testAssignRoom() {
        assertEquals("1A",new BookingController().assignRoom());
    }

    public void testChangeStatus() {
        assertEquals("Available",new BookingController().changeStatus("1A","Occupied"));
    }

    public void testTestAssignRoom() {
        new BookingController().getAllAvailableRooms();
    }

    public void testGetAllRooms() {
        new BookingController().getAllRooms();
    }

    public void testCheckoutAsAvailable() {
        assertEquals("Available",new BookingController().checkoutAsAvailable("1B"));
    }

    public void testCheckoutAsRepair() {
        assertEquals("Room is not in vacant status : Unable to make this room repair. : 1C",new BookingController().checkoutAsRepair("1C"));
    }

    public void testCheckoutAsVacant() {
        assertEquals("Room is in Available status : Unable to make this room repair. : 1D",new BookingController().checkoutAsVacant("1D"));
    }
}