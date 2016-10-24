package it.lorenzorapetti.pokemaster.adapter.decoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import it.lorenzorapetti.pokemaster.R
import kotlin.properties.Delegates

class SwipeItemTouchHelperCallback(
        val context: Context,
        val viewHolderAdapter: ViewHolderSwipeAdapter) :
        ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    // we want to cache these and not allocate anything repeatedly in the onChildDraw method
    var background by Delegates.notNull<Drawable>()
    var xMark by Delegates.notNull<Drawable>()
    var xMarkMargin: Int = 0
    var initiated: Boolean = false

    private fun init() {
        background = ColorDrawable(Color.RED)
        xMark = ContextCompat.getDrawable(context, R.drawable.ic_menu_pokemon)
        xMark.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        xMarkMargin = context.resources.getDimension(R.dimen.list_item_two_lines_avatar_padding_left).toInt()
        initiated = true
    }

    override fun onMove(recyclerView: RecyclerView?,
                        viewHolder: RecyclerView.ViewHolder?,
                        target: RecyclerView.ViewHolder?) = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        val swipedPosition = viewHolder!!.adapterPosition
        viewHolderAdapter.onSwiped(swipedPosition)
    }

    override fun onChildDraw(c: Canvas?,
                             recyclerView: RecyclerView?,
                             viewHolder: RecyclerView.ViewHolder?,
                             dX: Float,
                             dY: Float,
                             actionState: Int,
                             isCurrentlyActive: Boolean) {
        val itemView = viewHolder!!.itemView

        // not sure why, but this method get's called for viewholder that are already swiped away
        if (viewHolder.getAdapterPosition() === -1) {
            // not interested in those
            return
        }

        if (!initiated) {
            init()
        }

        // draw red background
        background.setBounds((itemView.right + dX).toInt(), itemView.top, itemView.right, itemView.bottom)
        background.draw(c)

        // draw x mark
        val itemHeight = itemView.bottom - itemView.top
        val intrinsicWidth = xMark.intrinsicWidth
        val intrinsicHeight = xMark.intrinsicWidth

        val xMarkLeft = itemView.right - xMarkMargin - intrinsicWidth
        val xMarkRight = itemView.right - xMarkMargin
        val xMarkTop = itemView.top + (itemHeight - intrinsicHeight) / 2
        val xMarkBottom = xMarkTop + intrinsicHeight
        xMark.setBounds(xMarkLeft, xMarkTop, xMarkRight, xMarkBottom)

        xMark.draw(c)

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

}