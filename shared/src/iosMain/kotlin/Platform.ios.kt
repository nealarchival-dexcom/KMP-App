import platform.UIKit.UIDevice
import platform.CoreBluetooth.CBCentralManager
import platform.CoreBluetooth.CBCentralManagerStatePoweredOff
import platform.CoreBluetooth.CBCentralManagerStatePoweredOn
import platform.CoreBluetooth.CBCentralManagerStateResetting
import platform.CoreBluetooth.CBCentralManagerStateUnauthorized
import platform.CoreBluetooth.CBCentralManagerStateUnsupported

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

    override fun getBluetoothState(): BluetoothState {
        val centralManagerState = CBCentralManager().state

        return when (centralManagerState) {
            CBCentralManagerStatePoweredOn -> BluetoothState.ON
            CBCentralManagerStatePoweredOff -> BluetoothState.OFF
            CBCentralManagerStateUnauthorized -> BluetoothState.UNAUTHORIZED
            CBCentralManagerStateResetting -> BluetoothState.OFF
            CBCentralManagerStateUnsupported -> BluetoothState.UNSUPPORTED
            else -> BluetoothState.UNKNOWN
        }
    }
}

actual fun getPlatform(): Platform = IOSPlatform()