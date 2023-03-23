package jose.nunez.myfeelings.utilities

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.RectF
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import jose.nunez.myfeelings.R

class CustomBarDrawable : Drawable {


    var coordenadas: RectF? = null

    var context: Context? = null
    var emcion: Emociones? = null

    constructor(context: Context?, emcion: Emociones?) : super() {
        this.context = context
        this.emcion = emcion
    }


    override fun draw(p0: Canvas) {
        val fondo: Paint = Paint()
        fondo.style = Paint.Style.FILL
        fondo.isAntiAlias = true
        fondo.color = context?.resources?.getColor(R.color.gray) ?: R.color.gray

        val ancho: Float = (p0.width - 10).toFloat()
        val alto: Float = (p0.height).toFloat()
        coordenadas = RectF(0.0F, 0.0F, ancho, alto)

        p0.drawRect(coordenadas!!, fondo)


        if (this.emcion != null) {
            val porcentaje: Float = this.emcion!!.porcentaje * (p0.width - 10) / 100
            var coordenadas2 = RectF(0.0F, 0.0F, porcentaje, alto)
            var seccion: Paint = Paint()

            seccion.style = Paint.Style.FILL
            seccion.isAntiAlias = true
            seccion.color = ContextCompat.getColor(this.context!!, emcion!!.color)

            p0.drawRect(coordenadas2!!, seccion)


        }

    }

    override fun setAlpha(alpha: Int) {
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }


}