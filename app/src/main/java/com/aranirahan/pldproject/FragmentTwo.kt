package com.aranirahan.pldproject

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.ctx

class FragmentTwo : Fragment(), AnkoComponent<Context> {
    private lateinit var listMyBook: RecyclerView
    private lateinit var adapter: MyBookAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val myBooks = ArrayList<MyBook>()
        myBooks.add(MyBook("Koding Malam", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Belajar Menulis", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Title Book", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Title Book", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Title Book", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Koding Malam", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Belajar Menulis", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Title Book", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Title Book", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Title Book", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))
        myBooks.add(MyBook("Title Book", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"))

        adapter = MyBookAdapter(myBooks) {}
        listMyBook.adapter = adapter

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(AnkoContext.create(ctx))
    }

    companion object {
        fun newInstance(): FragmentTwo = FragmentTwo()
    }

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        linearLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            horizontalGravity = Gravity.CENTER_HORIZONTAL
            lparams(width = wrapContent, height = wrapContent)
            horizontalGravity = Gravity.CENTER_HORIZONTAL
            orientation = LinearLayout.VERTICAL
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)

            listMyBook = recyclerView {
                lparams(width = matchParent, height = wrapContent) {
                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }
                layoutManager = GridLayoutManager(ctx, 2)
            }
        }
    }
}
