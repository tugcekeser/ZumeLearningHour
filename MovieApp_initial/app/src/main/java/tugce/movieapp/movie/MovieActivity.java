package tugce.movieapp.movie;


import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tugce.movieapp.R;
import tugce.movieapp.models.Movie;

public class MovieActivity extends AppCompatActivity {

    private ArrayList<Movie> movies;
    private MovieArrayAdapter movieAdapter;
    private ListView lvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        //initViews();

        /*movies = new ArrayList<Movie>();
        movieAdapter = new MovieArrayAdapter(this, movies);
        lvMovies.setAdapter(movieAdapter);*/

        //fetchMovies();

    }

    /*private void initViews() {
        lvMovies = (ListView) findViewById(R.id.lvMovies);
    }*/

    /*public void fetchMovies() {

        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Get a handler that can be used to post to the main thread
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                Handler refresh = new Handler(Looper.getMainLooper());
                refresh.post(new Runnable() {
                    public void run() {

                        try {
                            JSONArray movieJsonResults = null;
                            String responseData = response.body().string();
                            JSONObject json = new JSONObject(responseData);
                            movieJsonResults = json.getJSONArray("results");

                            movies.addAll(Movie.fromJSONArray(movieJsonResults));
                            movieAdapter.setOrientation(getResources().getConfiguration().orientation);
                            movieAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }*/

}
