package com.morten.epicPlugin.jsonStuff;

import java.lang.reflect.Array;
import java.util.List;

public class itemID {
    String nameID;

    List<itemList> itemID;
    public static class itemList {
        String nameID;
        public itemList(String nameID){
            this.nameID = nameID;
        }
    }


}
