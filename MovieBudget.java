import java.util.Scanner;

class Movie{
    private int movieId;
    private String director;
    private int rating;
    private int budget;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    public Movie(int movieId,String director,int rating,int budget){
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }
}

class SolutionMovie{
    public static int findAvgBudgetByDirector(Movie[] movieobj,String director){
        int budget = 0;
        int count = 0;
        for(Movie x:movieobj){
            if(director.equals(x.getDirector())){
                budget += x.getBudget();
                count++;
            }
        }
     return budget/count;
    }
    public static Movie getMovieByRatingBudget(Movie[] movieobj,int rating,int budget){
        for(Movie x:movieobj){
            if((rating ==x.getRating()&&budget ==x.getBudget())&&(budget%rating==0)){
                return  x;
            }
        }
        return null;
    }
}

public class MovieBudget{
    public static void main(String[] args){
        Movie[] movieobj = new Movie[4];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<4;i++){
            System.out.println("Enter Details");

            int movieId = sc.nextInt();
            String director = sc.nextLine();
            sc.nextLine();
            int rating = sc.nextInt();
            int budget = sc.nextInt();

            Movie obj = new Movie(movieId,director,rating,budget);
            movieobj[i] = obj;
        }
        String searchDirector = sc.nextLine();
        sc.nextLine();
        int seachRating = sc.nextInt();
        int searchBudget = sc.nextInt();
        int resAverage = SolutionMovie.findAvgBudgetByDirector(movieobj,searchDirector);
        if(resAverage>0){
            System.out.println(resAverage);
        }else {
            System.out.println("Sorry - The given director not yet created any movie");
        }
        Movie resMovie = SolutionMovie.getMovieByRatingBudget(movieobj,seachRating,searchBudget);
        if(resMovie!=null){
            System.out.println(resMovie.getMovieId());
        }else {
            System.out.println("Sorry - No movie is available in specific given rating and budget req");
        }
    }
}