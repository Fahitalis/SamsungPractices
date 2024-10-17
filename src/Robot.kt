import kotlin.random.Random

class Robot(
    health: Int,
    power: Int,
    var battery:Int
):Human(health, power) {
    companion object {
        var countAttacks: Int = 0
        fun increaseCountAttacks() {
            countAttacks++
        }
    }
    override fun attack(enemy: Human, type: ClassInGame) {
        increaseCountAttacks()
        val rand = Random(battery)
        val k:Double
        if (battery > 70)
            k = 1.2
        else
            k = 0.8
        battery -= 10
        val prevHealth = enemy.health
        enemy.health -= (power * k + rand.nextInt(0,31)).toInt()
        println("Robot attacked $type, health $prevHealth ${enemy.health - prevHealth} -> ${enemy.health}")
        if (enemy is Knight) enemy.defence -= 10
    }

    override fun heal() {
        val rand = Random(battery)
        val k:Double
        if (battery > 70)
            k = 1.2
        else
            k = 0.8
        battery -= 10
        val prevHealth = this.health
        this.health += (power * k + rand.nextInt(0,31)).toInt()
        println("Robot healed, health $prevHealth ${this.health - prevHealth} -> ${this.health}")
    }

    override fun toString(): String {
        return "Robot(health=$health, power=$power, battery=$battery)"
    }

}