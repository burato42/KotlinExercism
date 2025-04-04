import kotlin.math.floor
import kotlin.random.Random

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {

        fun ability(): Int {
            val random = Random

            val els = (0..3).map { random.nextInt(1, 7) }

            return els.sum() - (els.minOrNull()?.toInt() ?: 0)
        }

        fun modifier(score: Int): Int {
            return floor((score - 10).toFloat() / 2).toInt()
        }
    }

}
