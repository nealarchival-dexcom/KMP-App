open class CounterManager() {
    private var _count: Int = 0
    private var _step: Int = 1

    val count: Int
        get() = _count

    fun increment() {
        _count += _step
    }

    fun decrement() {
        _count -= _step
    }

    fun setStep(toValue: Int) {
        _step = _count
    }

    val color: CounterTextColor
        get() {
            if (_count > 0) {
                return CounterTextColor.GREEN
            } else if (_count < 0) {
                return CounterTextColor.RED
            }
            return CounterTextColor.BLACK
        }
}