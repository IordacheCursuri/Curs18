package com.itFactory.repository;

import com.itFactory.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final Connection connection;

    @Autowired
    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createUser(User user){
        String sql = "INSERT INTO users (id, username, email, salary) VALUES (?, ?, ?, ?)";

        try(PreparedStatement createStmt = connection.prepareStatement(sql)) {

            createStmt.setInt(1, user.getId());
            createStmt.setString(2, user.getUsername());
            createStmt.setString(3, user.getEmail());
            createStmt.setDouble(4, user.getSalary());

            createStmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try(PreparedStatement findStmt = connection.prepareStatement(sql)) {

            findStmt.setString(1, email);
            ResultSet rs = findStmt.executeQuery();


            while (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setSalary(rs.getDouble("salary"));

                return user;

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try ( PreparedStatement deleteStmt = connection.prepareStatement(sql)){

            deleteStmt.setInt(1, id);

            return deleteStmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> getAllUsers()  {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try (PreparedStatement finaAllStmt = connection.prepareStatement(sql)){

            ResultSet rs = finaAllStmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setSalary(rs.getDouble("salary"));

                users.add(user);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public int updateEmail(String username, String newEmail){

        String sql = "UPDATE users SET email = ? WHERE username = ?";

        try (PreparedStatement updateStmt = connection.prepareStatement(sql)){

            updateStmt.setString(1, newEmail);
            updateStmt.setString(2, username);

            int isUpdated = updateStmt.executeUpdate();
            return isUpdated;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }









}
