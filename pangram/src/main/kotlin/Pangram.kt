object Pangram {

    fun isPangram(input: String): Boolean {
//        val normalized = input.lowercase().replace(Regex("[^a-z]"), "").toSortedSet()
//        return normalized == "abcdefghijklmnopqrstuvwxyz".toSortedSet()
        return ('a'..'z').all {input.contains(it, ignoreCase = true)}
    }
}
