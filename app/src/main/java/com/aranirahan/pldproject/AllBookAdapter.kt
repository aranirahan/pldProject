package com.aranirahan.pldproject

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.*

class AllBookAdapter(private val myBook: List<AllBook>,
                     private val listener: (AllBook) -> Unit
) : RecyclerView.Adapter<AllBookViewHolder>() {
    override fun onBindViewHolder(holderViewHolder: AllBookViewHolder, position: Int) {
        holderViewHolder.bindItem(myBook[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllBookViewHolder {
        return AllBookViewHolder(AllBookUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = myBook.size

}

class AllBookUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                leftPadding = dip(8)
                rightPadding = dip(8)
                topPadding = dip(8)
                bottomPadding = dip(8)
                orientation = LinearLayout.VERTICAL

                imageView {
                    setImageResource(R.drawable.btn_books)
                    id = R.id.iv_my_book
                }.lparams {
                    height = dip(90)
                    width = dip(90)
                }

                textView {
                    id = R.id.tv_title_book
                    textSize = 16f
                }.lparams {
                    horizontalGravity = Gravity.CENTER_HORIZONTAL
                    margin = dip(15)
                }

            }
        }
    }

}

class AllBookViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val ivMyBook: ImageView = view.find(R.id.iv_my_book)
    private val titleBook: TextView = view.find(R.id.tv_title_book)

    fun bindItem(allBook: AllBook, listener: (AllBook) -> Unit) {
//        Picasso.get().load(myBook.coverBook).into(ivMyBook)
        titleBook.text = allBook.titleBook
        itemView.setOnClickListener { listener(allBook) }
    }
}