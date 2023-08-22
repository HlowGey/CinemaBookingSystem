package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    private String movie_id;
    private String title;
    @Column(length = 8000)
    private String overview;
    private String posterImg;
    private String backdropImg;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Genre> genres=new ArrayList<>();
    protected Movie(){}
    private Movie(Builder builder){
        this.movie_id = builder.movie_id;
        this.title = builder.title;
        this.overview = builder.overview;
        this.posterImg = builder.posterImg;
        this.backdropImg = builder.backdropImg;
        this.genres = builder.genres;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterImg() {
        return posterImg;
    }

    public String getBackdropImg() {
        return backdropImg;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id='" + movie_id + '\'' +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", posterImg='" + posterImg + '\'' +
                ", backdropImg='" + backdropImg + '\'' +
                ", genres=" + genres +
                '}';
    }

    public static class Builder {
        private String movie_id;
        private String title;
        private String overview;
        private String posterImg;
        private String backdropImg;
        private List<Genre> genres=new ArrayList<>();

        public Builder setMovie_id(String movie_id) {
            this.movie_id = movie_id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setOverview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder setPosterImg(String posterImg) {
            this.posterImg = posterImg;
            return this;
        }

        public Builder setBackdropImg(String backdropImg) {
            this.backdropImg = backdropImg;
            return this;
        }

        public Builder setGenres(List<Genre> genres) {
            this.genres = genres;
            return this;
        }

        public Builder copy(Movie movie) {
            this.movie_id = movie.movie_id;
            this.title = movie.title;
            this.overview = movie.overview;
            this.posterImg = movie.posterImg;
            this.backdropImg = movie.backdropImg;
            this.genres = movie.genres;
            return this;
        }
        public Movie build(){
            return new Movie(this);
        }
    }

}
