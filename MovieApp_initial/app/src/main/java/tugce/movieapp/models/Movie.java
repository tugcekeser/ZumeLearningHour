package tugce.movieapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tugce on 10/13/2016.
 */
public class Movie implements Serializable {
    private String posterPath;
    private String backdropPath;
    private String originalTitle;
    private String overview;
    private long id;
    private String releaseDate;
    private String originalLanguage;
    private double popularity;
    private long voteCount;
    private double voteAverage;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w1000/%s", backdropPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public long getId() {
        return id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }


    /*Network call response*/
    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.popularity = jsonObject.getDouble("popularity");
        this.voteAverage = jsonObject.getDouble("vote_average");
        this.voteCount = jsonObject.getLong("vote_count");
        this.id = jsonObject.getLong("id");
        this.originalLanguage = jsonObject.getString("original_language");
        this.releaseDate = jsonObject.getString("release_date");
        this.backdropPath = jsonObject.getString("backdrop_path");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();
        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }


}
