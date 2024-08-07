package io.github.dovecoteescapee.byedpi.services

import io.github.dovecoteescapee.byedpi.data.AppStatus
import io.github.dovecoteescapee.byedpi.data.Mode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

var appStatus = AppStatus.Halted to Mode.VPN
    private set

// TODO: REFACTOR THIS
private var _appStatusFlow = MutableStateFlow(AppStatus.Halted to Mode.VPN)
var appStatusFlow = _appStatusFlow.asStateFlow()

fun setStatus(status: AppStatus, mode: Mode, scope: CoroutineScope) {
    scope.launch { _appStatusFlow.emit(status to mode) }
}
fun setStatus(status: AppStatus, mode: Mode) {
    appStatus = status to mode
}
