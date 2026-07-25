package org.jetbrains.skiko

import org.jetbrains.skia.Canvas
import org.jetbrains.skia.PixelGeometry

// Route 1a: mingwX64 actuals for the commonMain SkiaLayer / currentSystemTheme
// expects. Copied verbatim from SkiaLayer.linux.kt — skiko-native never really
// implements SkiaLayer (consumers drive their own render loop), so linux ships
// pure stubs with no platform deps; the same works for Windows.
actual open class SkiaLayer  {
    actual var renderApi: GraphicsApi
        get() = TODO("Not yet implemented")
        set(value) {}
    actual val contentScale: Float
        get() = TODO("Not yet implemented")
    actual var fullscreen: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}
    actual val component: Any?
        get() = TODO("Not yet implemented")
    actual fun needRender(throttledToVsync: Boolean) {
        TODO("unimplemented")
    }
    @Deprecated(
        message = "Use needRender() instead",
        replaceWith = ReplaceWith("needRender()")
    )
    actual fun needRedraw() = needRender()
    actual fun attachTo(container: Any) {
        TODO("unimplemented")
    }
    actual fun detach() {
        TODO("unimplemented")
    }

    internal actual fun draw(canvas: Canvas) {
        TODO("unimplemented")
    }

    actual var renderDelegate: SkikoRenderDelegate? = null
    actual val pixelGeometry: PixelGeometry
        get() = TODO("Not yet implemented")
}

actual val currentSystemTheme: SystemTheme
    get() = SystemTheme.UNKNOWN
