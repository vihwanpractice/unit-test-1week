import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Item {

    private String name;
    private String Type;
    private int Cost;

    @Data
    public static class stats {
        private int abilityPower; //AP
        private int attackDamage; //AD
        private int attackSpeed;
        private int cooldownReduction;
        private int armor;
        private int magicResistance;
        private int health;
        private int baseManaRegeneration;
    }
}
