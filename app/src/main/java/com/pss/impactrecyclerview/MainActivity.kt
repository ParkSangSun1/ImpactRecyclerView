package com.pss.impactrecyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pss.impactrv.ImpactRecyclerView
import com.pss.impactrv.ImpactRvItem
import com.pss.impactrv.ImpactRvListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<ImpactRecyclerView>(R.id.rv)
        recyclerView
            .init(testArray(), this)
            .listener(object : ImpactRvListener {
                override fun onClickEvent(item: ImpactRvItem, position: Int) {
                    Toast.makeText(
                        this@MainActivity,
                        "onClickEvent p:$position",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
            .build()
    }

    private fun testArray(): ArrayList<ImpactRvItem> {
        val aList = ArrayList<ImpactRvItem>()
        aList.add(
            ImpactRvItem(
                url = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhgXBu8PArJLjdZHLXb92aRVPB3Z7UtjN2fGqGR9S4bMGiqEBZNM_oa8F6tVk5U8tArD5ir9qUIyKTXug4QU4zj9krezxxi08gUiVlFS4zouVnu2CCXyp4bv1NMPrW3vs7R2riIXuyPO55w7Trp0NkDBZzpQtQtHlbH2VOt4rBzLBnu12eELiAzkm1-/w640-h191/Compose%20Blog%20Header.jpg",
                text = "hiiiiiiiii",
                background = Color.BLACK
            )
        )
        aList.add(
            ImpactRvItem(
                url = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhgXBu8PArJLjdZHLXb92aRVPB3Z7UtjN2fGqGR9S4bMGiqEBZNM_oa8F6tVk5U8tArD5ir9qUIyKTXug4QU4zj9krezxxi08gUiVlFS4zouVnu2CCXyp4bv1NMPrW3vs7R2riIXuyPO55w7Trp0NkDBZzpQtQtHlbH2VOt4rBzLBnu12eELiAzkm1-/w640-h191/Compose%20Blog%20Header.jpg",
                text = "hellooooooo",
                background = Color.GRAY
            )
        )
        return aList
    }
}