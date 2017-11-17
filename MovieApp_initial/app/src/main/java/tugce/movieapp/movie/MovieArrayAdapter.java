package tugce.movieapp.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import tugce.movieapp.R;
import tugce.movieapp.models.Movie;

/**
 * Created by Tugce on 10/13/2016.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {
    private int orientation;

    /*private static class ViewHolderMovie {
        ImageView ivImage;
        TextView tvTitle;
        TextView tvOverview;
    }*/

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_expandable_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Movie movie = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.item_movie, parent, false);

        /*ViewHolderMovie holder = new ViewHolderMovie();
        holder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        holder.ivImage.setImageResource(0);

        holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        holder.tvTitle.setText(movie.getOriginalTitle());

        holder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        if (movie.getOverview().length() > 100) {
            holder.tvOverview.setText(movie.getOverview().substring(0, 100) + "...");
        } else {
            holder.tvOverview.setText(movie.getOverview());
        }

        /*https://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library*/
        /*Picasso.with(holder.ivImage.getContext())
                .load(orientation == Configuration.ORIENTATION_PORTRAIT ? movie.getPosterPath() : movie.getBackdropPath())
                .transform(new RoundedCornersTransformation(10, 10))
                .placeholder(R.mipmap.popcorn)
                .into(holder.ivImage);*/

       /* convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MovieDetailActivity.class).putExtra(MovieAppConstants.MOVIE, movie);
                getContext().startActivity(intent);
            }
        });*/

        return convertView;
    }

}
