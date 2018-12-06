import com.pntechworld.photoapp.api.ApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtils {

    companion object {
        fun getApiService(): ApiServices {
            var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("www.pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiServices::class.java)
        }
    }
}

