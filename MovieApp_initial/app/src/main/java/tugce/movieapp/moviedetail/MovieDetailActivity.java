package tugce.movieapp.moviedetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tugce.movieapp.Constants.MovieAppConstants;
import tugce.movieapp.R;
import tugce.movieapp.helpers.MovieHelpers;
import tugce.movieapp.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    private Movie movie;
    private ImageView ivBackdropImage;
    private ImageView ivPoster;
    private TextView tvMovieTitle;
    private TextView tvScore;
    private TextView tvOverview;
    private TextView tvReleaseDate;
    private RatingBar rbPopularity;
    private TextView tvLanguage;
    private ImageButton btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        setToolbar();
        initViews();

        Intent intent = getIntent();
        movie = (Movie) intent.getSerializableExtra(MovieAppConstants.MOVIE);

        setValues();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
    }


    private void initViews() {
        ivBackdropImage = (ImageView) findViewById(R.id.ivBackdropImage);
        ivPoster = (ImageView) findViewById(R.id.ivMoviePoster);
        tvMovieTitle = (TextView) findViewById(R.id.tvMovieTitle);
        tvScore = (TextView) findViewById(R.id.tvScore);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        tvReleaseDate = (TextView) findViewById(R.id.tvReleaseDate);
        rbPopularity = (RatingBar) findViewById(R.id.rbPopularity);
        tvLanguage = (TextView) findViewById(R.id.tvLanguage);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:
            }
        });
    }

    private void setValues() {

        Picasso.with(ivBackdropImage.getContext()).load(movie.getBackdropPath())
                .placeholder(R.mipmap.popcorn).into(ivBackdropImage);
        Picasso.with(this).load(movie.getPosterPath()).placeholder(R.mipmap.popcorn).into(ivPoster);

        tvMovieTitle.setText(movie.getOriginalTitle());
        tvScore.setText("Score: " + movie.getVoteAverage() + "/10");
        tvOverview.setText(movie.getOverview());
        tvReleaseDate.setText(MovieHelpers.parseDateToMMddyyyy(movie.getReleaseDate()));
        tvLanguage.setText(MovieHelpers.getLanguage(movie.getOriginalLanguage()));
        rbPopularity.setRating((float) (movie.getVoteAverage() / 2));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
