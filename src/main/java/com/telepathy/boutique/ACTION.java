package com.telepathy.boutique;

public enum ACTION {
    CLEAN,
    OUT_OF_SERVICE,
    REPAIRED,
    CHIECK_IN;


   public String getValue(){

       switch (this){
           case CLEAN:
               return "clean";
           case OUT_OF_SERVICE:
               return "out of service";
           default:
               return null;
       }
   }
}
