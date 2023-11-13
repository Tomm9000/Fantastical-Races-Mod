package com.fantasticalraces.Data;

import com.fantasticalraces.packet.RaceSelectionPacket;

public class PlayerData {
    private String selectedRace;

    public void setSelectedRace(String selectedRace){
        this.selectedRace = RaceSelectionPacket.getSelectedRace();
        System.out.println(this.selectedRace + "fsdkjvcdshbfd");
    }
}
