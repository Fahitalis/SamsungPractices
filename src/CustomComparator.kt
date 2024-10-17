class CustomComparator: Comparator<Human> {
    override fun compare(o1: Human?, o2: Human?): Int {
        val x1 = when(o1) {
            is Wizard -> o1.mana
            is Robot -> o1.battery
            is Knight -> o1.defence
            else -> 0
        }
        val x2 = when(o2) {
            is Wizard -> o2.mana
            is Robot -> o2.battery
            is Knight -> o2.defence
            else -> 0
        }
        if (o1?.health  == o2?.health) {
            if (o1?.power == o2?.power) {
                if (x1 == x2)
                    return 0
                return if (x1 > x2) 1 else -1
            }
            return if (o1!!.power > o2!!.power) 1 else -1
        }
        return if (o1!!.health > o2!!.health) 1 else -1
    }
}