package com.navin.filimo

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.navin.filimo.adapter.CategoryAdapter
import com.navin.filimo.adapter.VideoAdapter
import com.navin.filimo.api.IService
import com.navin.filimo.api.Webservice
import com.navin.filimo.databinding.ActivityMainBinding
import com.navin.filimo.models.BaseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val iService: IService = Webservice.retrofit.create(IService::class.java)
/*        iService.getHome().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

               val jsonObject = JSONObject(response.body()!!.string())
               val allVideo = jsonObject.get("ALL_IN_ONE_VIDEO").toString()
               val allVideoJson = JSONObject(allVideo)
               val featured_video: String = allVideoJson.get("featured_video").toString()
               val featuresArray = JSONArray(featured_video)
               val featuresList: MutableList<Video> = arrayListOf()

              for (i in 0..featuresArray.length()-1) {
                   val videoObj: JSONObject = featuresArray.getJSONObject(i)

                   val id = videoObj.get("id").toString()
                 val cat_id = videoObj.get("cat_id").toString()
                  val video_title = videoObj.get("video_title").toString()
                   val video_url = videoObj.get("video_url").toString()
                 val video_thumbnail_b = videoObj.get("video_thumbnail_b").toString()
                val video_duration = videoObj.get("video_duration").toString()
                  val video_description = videoObj.get("video_description").toString()
                    val rate_avg = videoObj.get("rate_avg").toString()
                val totel_viewer = videoObj.get("totel_viewer").toString()
                 val cid = videoObj.get("cid").toString()
                 val category_name = videoObj.get("category_name").toString()
                   val category_image = videoObj.get("category_image").toString()
                   val category_image_thumb = videoObj.get("category_image_thumb").toString()
                  val video_id = videoObj.get("video_id").toString()
                   val video_thumbnail_s = videoObj.get("video_thumbnail_s").toString()
                  val video_type = videoObj.get("video_type").toString()

                  val video = Video(cat_id,category_image,category_image_thumb,category_name,cid,
                      id,rate_avg,totel_viewer,video_description,video_duration,video_id,
                     video_thumbnail_b,video_thumbnail_s,video_title,video_type,video_url)

                  featuresList.add(video)

              }


        }
           override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
               Log.e("Failure",t.message.toString())
           })*/
        val typeFace = Typeface.createFromAsset(assets,"fonts/Far_Nazanin.ttf")
        binding.txtFeatured.setTypeface(typeFace)
        binding.txtLatestVideos.setTypeface(typeFace)
        binding.txtAllVideos .setTypeface(typeFace)


        binding.progress.visibility = View.VISIBLE
        iService.getHomeData().enqueue(object :Callback<BaseModel>{
            override fun onResponse(call: Call<BaseModel>, response: Response<BaseModel>) {
                binding.progress.visibility = View.GONE

                binding.recyclerFeatured.adapter = VideoAdapter(this@MainActivity,
                    response.body()?.baseVideoModel!!.featuredVideo)

                binding.recyclerFeatured.layoutManager = LinearLayoutManager(this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,false)

                binding.recyclerLatest.adapter = VideoAdapter(this@MainActivity
                    ,response.body()!!.baseVideoModel.latestVideo)

                binding.recyclerLatest.layoutManager = LinearLayoutManager(this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,false)

                binding.recyclerAllVideos.adapter = VideoAdapter(this@MainActivity
                    ,response.body()!!.baseVideoModel.allVideo)

                binding.recyclerAllVideos.layoutManager = LinearLayoutManager(this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,false)


                binding.recyclerCategories.adapter = CategoryAdapter(this@MainActivity,
                    response.body()!!.baseVideoModel.category)

                binding.recyclerCategories.layoutManager = LinearLayoutManager(this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,false)

            }

            override fun onFailure(call: Call<BaseModel>, t: Throwable) {
                binding.progress.visibility = View.GONE
            }

        })
    }
}