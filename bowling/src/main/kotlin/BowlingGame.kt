enum class Frame {
    STRIKE,
    SPARE,
    OPEN
}

class BowlingGame {
    private var res = mutableListOf<Int>()

    fun roll(pins: Int) {
        if (pins < 0 || pins > 10) throw IllegalStateException()

        res.add(pins)
    }

    fun score(): Int {
        if (res.isEmpty()) throw IllegalStateException()

        var idx = 0
        var score = 0
        var round = 0
        try {
            while (round < 10) {
                when {
                    round == 9 -> {
                        if (res[idx] == 10 || res[idx] + res[idx + 1] == 10) {
                            score += res.subList(idx, idx + 3).sum()
                            idx += 3
                        } else {
                            score += res.subList(idx, idx + 2).sum()
                            idx += 2
                        }
                        round += 1
                    }
                    res[idx] == 10 -> { score += 10 + res[idx + 1] + res[idx + 2]; idx += 1; round += 1 }
                    res[idx] < 10 && res[idx] + res[idx + 1] == 10 -> {score += res[idx] + res[idx + 1] + res[idx + 2]; idx += 2; round += 1}
                    res[idx] < 10 && res[idx] + res[idx + 1] < 10 -> {score += res[idx] + res[idx + 1]; idx += 2; round += 1}
                    else -> throw IllegalStateException()
                }
            }
        } catch (_: IndexOutOfBoundsException) {
            throw IllegalStateException()
        }

        if (idx != res.size) throw IllegalStateException()

        return score
    }
}
