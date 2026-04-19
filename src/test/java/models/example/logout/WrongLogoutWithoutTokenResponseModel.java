package models.example.logout;


import java.util.List;

public record WrongLogoutWithoutTokenResponseModel(List<String> refresh) {}