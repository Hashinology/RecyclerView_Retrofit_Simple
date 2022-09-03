package com.hashinology.recyclerviewkotlinwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.InputQueue
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hashinology.recyclerviewkotlinwithretrofit.adapter.MyAdapter
import com.hashinology.recyclerviewkotlinwithretrofit.models.ModelList
import com.hashinology.recyclerviewkotlinwithretrofit.ui.AdapterInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), AdapterInterface {
    lateinit var myList: ArrayList<ModelList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()

    }

    private fun getData() {
        val call = RetrofitClient().getInstanceValue().retrofitAPI!!.getRetrofitInterfaceMethod()
        call.enqueue(object: Callback<ModelList>{
            override fun onResponse(
                call: Call<ModelList>,
                response: Response<ModelList>
            ) {
                myList = ArrayList<ModelList>()
                for(x in 1..5){
                    myList.add(response.body()!!)
                }
                val adapter =  MyAdapter(myList, this@MainActivity, this@MainActivity)
                rvOnline.adapter = adapter
                rvOnline.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)


            }

            override fun onFailure(call: Call<ModelList>, t: Throwable) {
                Toast.makeText(this@MainActivity, ""+t.message, Toast.LENGTH_LONG).show()
            }

        })

    }

    override fun getAdapterInterface(view: View, position: Int) {

    }
}