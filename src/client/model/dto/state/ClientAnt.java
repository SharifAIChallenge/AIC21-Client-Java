package client.model.dto.state;

import client.model.enums.AntTeam;
import client.model.enums.AntType;
import com.google.gson.annotations.SerializedName;

public class ClientAnt {
    @SerializedName(value = "ant_team")
    private int antTeam;
    @SerializedName(value = "ant_type")
    private int antType;

    public AntTeam getAntTeam() {
        return AntTeam.values()[antTeam];
    }

    public AntType getAntType() {
        return AntType.values()[antType];
    }
}
