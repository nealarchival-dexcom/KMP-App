import android.bluetooth.BluetoothAdapter
import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"

    override fun getBluetoothState(): BluetoothState {
        val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        val bluetoothState = bluetoothAdapter.state
        return when (bluetoothState) {
            BluetoothAdapter.STATE_ON -> BluetoothState.ON
            BluetoothAdapter.STATE_CONNECTED -> BluetoothState.ON
            BluetoothAdapter.STATE_OFF -> BluetoothState.OFF
            BluetoothAdapter.STATE_TURNING_OFF -> BluetoothState.OFF
            else -> BluetoothState.UNKNOWN
        }
    }
}

actual fun getPlatform(): Platform = AndroidPlatform()