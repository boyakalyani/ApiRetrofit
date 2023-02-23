package com.example.apiretrofit

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var btn:Button
    lateinit var title:TextView
    lateinit var author:TextView
    lateinit var img:ImageView
    //https://meme-api.herokuapp.com//mimme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn=findViewById(R.id.btnNewMemuId)
        title=findViewById(R.id.memuTitleId)
        author=findViewById(R.id.memeAuthorId)
        img=findViewById(R.id.memeImageId)

        getData()

        btn.setOnClickListener(){
            getData()
        }
    }

    private fun getData() {

        val progressDialog=ProgressDialog(this)
        progressDialog.setMessage("Please wait while data is fetch")
        progressDialog.show()

        RetrofitInstanceObject.apiInterface.getData().enqueue(object : retrofit2.Callback<responseDataClass?> {
            override fun onResponse(
                call: Call<responseDataClass?>,
                response: Response<responseDataClass?>
            ) {

                title.text=response.body()?.title
                author.text=response.body()?.author
                Glide.with(this@MainActivity).load(response.body()?.url).into(img)

                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<responseDataClass?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        })

    }
}