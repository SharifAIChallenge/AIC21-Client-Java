package client.model.dto.state;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AttackDTO {
    @SerializedName(value = "attacker_row")
    private int attackerRow;
    @SerializedName(value = "attacker_col")
    private int attackerColumn;
    @SerializedName(value = "defender_row")
    private int defenderRow;
    @SerializedName(value = "defender_col")
    private int defenderColumn;
    @SerializedName(value = "is_attacker_enemy")
    private boolean isAttackerEnemy;

    public int getAttackerColumn() {
        return attackerColumn;
    }

    public int getAttackerRow() {
        return attackerRow;
    }

    public boolean getIsAttackerEnemy() {
        return isAttackerEnemy;
    }

    public int getDefenderColumn() {
        return defenderColumn;
    }

    public int getDefenderRow() {
        return defenderRow;
    }
}
