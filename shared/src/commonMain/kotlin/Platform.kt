interface Platform {
    val name: String
    fun getBluetoothState(): BluetoothState
}

expect fun getPlatform(): Platform