class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "According to KMP you are on ${platform.name}!"
    }
}