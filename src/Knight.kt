import kotlin.random.Random

class Knight(
    health: Int,
    power: Int,
    var defence:Int
):Human(health, power) {
    companion object {
        var countAttacks: Int = 0
        fun increaseCountAttacks() {
            countAttacks++
        }
    }
    override fun attack(enemy: Human, type: ClassInGame) {
        increaseCountAttacks()
        val rand = Random(defence)
        val k:Double
        if (defence > 50)
            k = 0.8
        else
            k = 1.5
        val prevHealth = enemy.health
        enemy.health -= (power * k + rand.nextInt(0,31)).toInt()
        println("Knight attacked $type, health $prevHealth ${enemy.health - prevHealth} -> ${enemy.health}")
    }

    override fun heal() {
        val rand = Random(defence)
        val k:Double
        if (defence > 70)
            k = 1.5
        else
            k = 0.8
        val prevHealth = this.health
        this.health += (power * k + rand.nextInt(0,31)).toInt()
        println("Knight healed, health $prevHealth ${this.health - prevHealth} -> ${this.health}")
    }

    override fun toString(): String {
        return "Knight(health=$health, power=$power, defence=$defence)"
    }

}