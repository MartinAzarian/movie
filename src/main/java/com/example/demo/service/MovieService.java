package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.persistence.MariadbConstants;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class MovieService {
    public void createMovie(Movie movie) {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(MariadbConstants.DB_URL, MariadbConstants.USER, MariadbConstants.PASS);

            if (conn != null) {

                if (conn != null) {
                    String query = "INSERT INTO movies( name, ganre ) VALUES(?,?)";

                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1, movie.getName());
                    preparedStatement.setString(2, movie.getGenre());
                    preparedStatement.execute();
                }
            }

        } catch (SQLException ex) {
            System.err.println("Conection error");
            ex.printStackTrace();
        } finally {

            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Movie findMovieById(int id) {
        Movie movie = new Movie();

        Connection conn = null;
        try {

            conn = DriverManager.getConnection(MariadbConstants.DB_URL, MariadbConstants.USER, MariadbConstants.PASS);

            if (conn != null) {

                String query = "SELECT* FROM movies WHERE id=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    movie.setName(resultSet.getString("name"));
                    movie.setGenre(resultSet.getString("genre"));
                }
            }

        } catch (SQLException ex) {
            System.err.println("Conection error");
            ex.printStackTrace();
        } finally {

            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return movie;
    }

    public ArrayList<Movie> findAllMovies() {
        ArrayList<Movie> movieList = new ArrayList<>();
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(MariadbConstants.DB_URL, MariadbConstants.USER, MariadbConstants.PASS);

            if (conn != null) {

                String query = "SELECT* FROM movies";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Movie movie = new Movie();
                    movie.setName(resultSet.getString("name"));
                    movie.setGenre(resultSet.getString("ganre"));
                    movieList.add(movie);
                }
            }

        } catch (SQLException ex) {
            System.err.println("Conection error");
            ex.printStackTrace();
        } finally {

            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return movieList;
    }

    public void deleteMovie(int id) {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(MariadbConstants.DB_URL, MariadbConstants.USER, MariadbConstants.PASS);

            if (conn != null) {

                String query = "DELETE FROM movies WHERE id=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }

        } catch (SQLException ex) {
            System.err.println("Conection error");
            ex.printStackTrace();
        } finally {

            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void updateMovie(int id, Movie movie) {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(MariadbConstants.DB_URL, MariadbConstants.USER, MariadbConstants.PASS);

            if (conn != null) {

                String query = "UPDATE movies SET name=?, ganre=? WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, movie.getName());
                preparedStatement.setString(2, movie.getGenre());
                preparedStatement.setInt(3, id);
                preparedStatement.execute();

            }

        } catch (SQLException ex) {
            System.err.println("Conection error");
            ex.printStackTrace();
        } finally {

            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


 



