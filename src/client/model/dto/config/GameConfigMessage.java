package client.model.dto.config;

import client.model.enums.AntType;
import com.google.gson.annotations.SerializedName;

/**
 * first configuration of the game will save in this class (the data that sent from the server via Json)
 * clients must NOT change or use this class
 */
public class GameConfigMessage {
    @SerializedName(value = "map_width")
    private int mapWidth;
    @SerializedName(value = "map_height")
    private int mapHeight;
    @SerializedName(value = "ant_type")
    private int antType;
    @SerializedName(value = "bases")
    private BaseDTO[] bases;
    @SerializedName(value = "base_x")
    private int baseX;
    @SerializedName(value = "base_y")
    private int baseY;
    @SerializedName(value = "health_kargar")
    private int healthKargar;
    @SerializedName(value = "health_sarbaaz")
    private int healthSarbaaz;
    @SerializedName(value = "attack_distance")
    private int attackDistance;
    @SerializedName(value = "view_distance")
    private int viewDistance;
    @SerializedName(value = "generate_kargar")
    private int generateKargar;
    @SerializedName(value = "generate_sarbaaz")
    private int generateSarbaaz;
    @SerializedName(value = "rate_death_resource")
    private int rateDeathResource;

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public AntType getAntType() {
        return AntType.values()[antType];
    }

    public int getBaseX() {
        return baseX;
    }

    public int getBaseY() {
        return baseY;
    }

    public int getHealthKargar() {
        return healthKargar;
    }

    public int getHealthSarbaaz() {
        return healthSarbaaz;
    }

    public int getAttackDistance() {
        return attackDistance;
    }

    public int getGenerateKargar() {
        return generateKargar;
    }

    public int getGenerateSarbaaz() {
        return generateSarbaaz;
    }

    public int getRateDeathResource() {
        return rateDeathResource;
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public static class BaseDTO {
        @SerializedName(value = "x")
        public int x;
        @SerializedName(value = "y")
        public int y;

        public BaseDTO(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
