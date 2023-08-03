import java.util.Arrays;

class Movie1{
    private String movieName;
    private String company;
    private String genre;
    private int budget;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    public Movie1(String movieName,String company,String genre,int budget){
        this.movieName  = movieName;
        this.budget = budget;
        this.company  = company;
        this.genre = genre;
    }
}


class SolutionMovieGet{
    public static Movie1[] getMovieByGenre(Movie1[] moiveobj,String searchGenre){
        Movie1[] movieResArr = new Movie1[0];
        for(Movie1 x: moiveobj){
            if(searchGenre.equalsIgnoreCase(x.getGenre())) {
                movieResArr = Arrays.copyOf(movieResArr, movieResArr.length + 1);
                movieResArr[movieResArr.length - 1] = x;
            }
        }
        return movieResArr;
    }
}
public class MovieGetProb {
    public static void main(String[] args){

    }
}