import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    println("Input Wizard's health, power, mana (0-1000)")
    val w = Wizard(input.nextInt(), input.nextInt(), input.nextInt())
    println("Input Robot's health, power, mana (0-1000)")
    val r = Robot(input.nextInt(), input.nextInt(), input.nextInt())
    println("Input Knight's health, power, mana (0-1000)")
    val k = Knight(input.nextInt(), input.nextInt(), input.nextInt())

    println("Input count of battles")
    val n = input.nextInt()
    val random = Random(1337)
    for (i in 0 until n) {
        val r1 = random.nextInt(0,3)
        var r2 = random.nextInt(0, 3)
        if (r1 == r2)
            r2 = (r2 + 1) % 3

        when(r1) {
            0 -> {
                val p1 = ClassInGame.Wizard

                when(r2) {
                    1 -> {
                        val p2 = ClassInGame.Robot
//                        println("$p1 attack $p2")
                        w.attack(r, p2)
                    }
                    2 -> {
                        val p2 = ClassInGame.Knight
//                        println("$p1 attack $p2")
                        w.attack(k, p2)
                    }
                }
            }
            1 -> {
                val p1 = ClassInGame.Robot
                when(r2) {
                    0 -> {
                        val p2 = ClassInGame.Wizard
//                        println("$p1 attack $p2")
                        r.attack(w, p2)
                    }
                    2 -> {
                        val p2 = ClassInGame.Knight
//                        println("$p1 attack $p2")
                        r.attack(k, p2)
                    }
                }
            }
            2 -> {
                val p1 = ClassInGame.Knight
                when(r2) {
                    0 -> {
                        val p2 = ClassInGame.Wizard
//                        println("$p1 attack $p2")
                        k.attack(w, p2)
                    }
                    1 -> {
                        val p2 = ClassInGame.Robot
//                        println("$p1 attack $p2")
                        k.attack(r, p2)
                    }
                }
            }
        }
        if (w.health < 0 || r.health < 0 || k.health < 0)
            break
        if (i % 3 == 2) {
            w.heal()
            r.heal()
            k.heal()
        }
    }
    val list = arrayOf(w, r, k)
    val customComparator = CustomComparator()

    Arrays.sort(list)

    println(list.contentToString())
    println("Wizard count of attacks ${Wizard.countAttacks}")
    println("Robot count of attacks ${Robot.countAttacks}")
    println("Knight count of attacks ${Knight.countAttacks}")
}