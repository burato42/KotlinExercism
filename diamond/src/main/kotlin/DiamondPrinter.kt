class DiamondPrinter {

    fun printToList(letter: Char): List<String> {
        val padCnt = letter.code - 'A'.code
        var res = mutableListOf<String>()
        for (indexedLetter in ('A'..letter).withIndex()) {
            if (indexedLetter.value == 'A') {
                res.add(" ".repeat(padCnt - indexedLetter.index) + "A" + " ".repeat(padCnt - indexedLetter.index))
            } else {
                res.add(
                    " ".repeat(padCnt - indexedLetter.index) + indexedLetter.value.toString() + " ".repeat(indexedLetter.index * 2 - 1) + indexedLetter.value.toString() + " ".repeat(padCnt - indexedLetter.index)
                )
            }
        }

        if (res.size >= 1) {
            res = (res + res.reversed().drop(1)).toMutableList()
        }

        return res
    }

}
