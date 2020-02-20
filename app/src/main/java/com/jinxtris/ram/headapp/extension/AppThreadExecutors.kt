package com.jinxtris.ram.headapp.extension

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors


private val IO_THREAD_EXECUTOR = Executors.newSingleThreadExecutor()

private val NETWORK_THREAD_EXECUTOR = Executors.newFixedThreadPool(500)

private val MAIN_THREAD_EXECUTOR = MainThreadExecutor()

private class MainThreadExecutor : Executor {
    private val mainThreadHandler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mainThreadHandler.post(command)
    }
}


fun ioThread(f: () -> Unit) {
    IO_THREAD_EXECUTOR.execute(f)
}

fun networkThread(f: () -> Unit) {
    NETWORK_THREAD_EXECUTOR.execute(f)
}

fun mainThread(f: () -> Unit) {
    MAIN_THREAD_EXECUTOR.execute(f)
}