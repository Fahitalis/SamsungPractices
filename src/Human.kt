abstract class Human(
    var health:Int,
    var power:Int
): IHeal, Comparable<Human> {
    abstract fun attack(enemy:Human, type:ClassInGame)
    override fun compareTo(other: Human): Int {
        val x1 = when(this) {
            is Wizard -> this.mana
            is Robot -> this.battery
            is Knight -> this.defence
            else -> 0
        }
        val x2 = when(other) {
            is Wizard -> other.mana
            is Robot -> other.battery
            is Knight -> other.defence
            else -> 0
        }
        if (this.health  == other.health) {
            if (this.power == other.power) {
                if (x1 == x2)
                    return 0
                return if (x1 > x2) -1 else 1
            }
            return if (this.power > other.power) -1 else 1
        }
        return if (this.health > other.health) -1 else 1
    }

}