package com.telepathy.boutique;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookingController {

    Map<String,String> roomMap;


    BookingController(){

        roomMap=new LinkedHashMap<>();

        int[] floors={1,2,3,4};
        String[] rooms={"A","B","C","D","E"};

        roomMap.put("1A","Available");
        roomMap.put("1B","Available");
        roomMap.put("1C","Available");
        roomMap.put("1D","Available");
        roomMap.put("1E","Available");
        roomMap.put("2E","Available");
        roomMap.put("2D","Available");
        roomMap.put("2C","Available");
        roomMap.put("2B","Available");
        roomMap.put("2A","Available");
        roomMap.put("3A","Available");
        roomMap.put("3B","Available");
        roomMap.put("3C","Available");
        roomMap.put("3D","Available");
        roomMap.put("3E","Available");
        roomMap.put("4E","Available");
        roomMap.put("4D","Available");
        roomMap.put("4C","Available");
        roomMap.put("4B","Available");
        roomMap.put("4A","Available");
    }

    public void getAllAvailableRooms(){
        roomMap.entrySet().stream().filter(f->f.getValue().equals("Available")).forEach(s-> System.out.println(s.getKey()+" "+s.getValue()));
    }

    public String assignRoom(){
        String assignedRoom=roomMap.entrySet().stream().filter(f->f.getValue().equals("Available")).findFirst().get().getKey();

        //change the value
        roomMap.replace(assignedRoom,"Occupied");

        if(assignedRoom!=null)
            return assignedRoom;
        return "No room available";
    }

    public void getAllRooms(){
        roomMap.entrySet().stream().forEach(s-> System.out.println(s.getKey()+" "+s.getValue()));
    }

    /**
     * This method id used for change the method status manually
     *
     * @param roomNo
     * @param status
     * @return previous status of the room
     */
    public String changeStatus(String roomNo, String status){
        return roomMap.replace(roomNo,status);
    }

    public String checkoutAsAvailable(String roomNo,String action){
        if(roomMap.get(roomNo).equals("Vacant") && ACTION.CLEAN.getValue().equals(action))
            return this.changeStatus(roomNo,"Available");
        return "Room is in "+roomMap.get(roomNo)+" status : Unable to make this room available. : "+roomNo;
    }

    public String checkoutAsRepair(String roomNo,String action){
        if(roomMap.get(roomNo).equals("Vacant") && ACTION.OUT_OF_SERVICE.getValue().equals(action))
            return this.changeStatus(roomNo,"Repair");
        return "Room is not in vacant status : Unable to make this room repair. : "+roomNo;
    }

    public String checkoutAsVacant(String roomNo){
        if(roomMap.get(roomNo).equals("Repair") || roomMap.get(roomNo).equals("Occupied"))
            return this.changeStatus(roomNo,"Vacant");
        return "Room is in "+roomMap.get(roomNo)+" status : Unable to make this room repair. : "+roomNo;
    }
}
