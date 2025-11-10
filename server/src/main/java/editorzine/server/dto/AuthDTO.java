package editorzine.server.dto;

public record AuthDTO() {
    public record LoginRequest(String username, String password) { }
    public record LoginResponse(String token, long expiresInMs) {}
}
