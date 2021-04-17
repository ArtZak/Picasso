package com.example.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.NewsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val map = mapOf("apiKey" to "246d65a3033343ce9e1bbfe12700debd", "q" to "football")
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Task 1*/
        /*GlobalScope.launch(Dispatchers.Default) {
            var list = mutableListOf<PictureModel>()
            for (i in 1..30) {
                val picture = PostPictureModel("Title number $i", "https://picsum.photos/id/$i/150")
                val call = PictureRetrofitService.retrofit.create(PictureApiService::class.java).upload(picture)
                val response = call.execute()

                if (response.isSuccessful) {
                    Log.d("Post method test", "Successful request")
                    if(response.body() != null) {
                        list.add(response.body()!!)
                    }
                }

                withContext(Dispatchers.Main){
                    val recycler = findViewById<RecyclerView>(R.id.recycler)
                    val adapter = RecyclerAdapter(this@MainActivity, list)

                    recycler.adapter = adapter
                    recycler.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }*/

        /*Task2*/
        GlobalScope.launch (Dispatchers.Default){
            val call = NewsRetrofitService.retrofit.create(NewsApiService::class.java).getNews(map, mapOf("pageSize" to 20, "page" to 2))
            val response = call.execute()
            var list = listOf<NewsModel.Articles>()

            if(response.isSuccessful){
                list = response.body()?.articles ?: listOf()
            }

            withContext(Dispatchers.Main) {
                recyclerView = findViewById(R.id.recycler)
                val adapter = NewsAdapter(this@MainActivity, list)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}