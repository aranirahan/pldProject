package com.aranirahan.pldproject

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.*

class MyBookAdapter(private val myBook: List<MyBook>,
                    private val listener: (MyBook) -> Unit
)
    : RecyclerView.Adapter<MyBookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBookViewHolder {
        return MyBookViewHolder(BookUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: MyBookViewHolder, position: Int) {
        holder.bindItem(myBook[position], listener)
    }

    override fun getItemCount(): Int = myBook.size

}

class BookUI : AnkoComponent<ViewGroup> {
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

class MyBookViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val ivMyBook: ImageView = view.find(R.id.iv_my_book)
    private val titleBook: TextView = view.find(R.id.tv_title_book)

    fun bindItem(myBook: MyBook, listener: (MyBook) -> Unit) {
//        Picasso.get().load(myBook.coverBook).into(ivMyBook)
        titleBook.text = myBook.titleBook
        itemView.setOnClickListener { listener(myBook) }
    }
}