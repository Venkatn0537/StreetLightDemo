package nyc.jsjrobotics.streetlight

enum class LightOption(val timeUntilNextLight: Int) {
    RED(5),
    YELLOW(2),
    GREEN(3);

    fun getNextLight() : LightOption {
        when (this) {
            RED -> return GREEN
            YELLOW -> return RED
            GREEN -> return YELLOW
        }
    }

}
