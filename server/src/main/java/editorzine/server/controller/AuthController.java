package editorzine.server.controller;

import editorzine.server.dto.AuthDTO.*;
import editorzine.server.dto.EditorDTO;
import editorzine.server.service.EditorService;
import editorzine.server.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final EditorService editorService;


    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, EditorService editorService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.editorService = editorService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody EditorDTO editorDTO) {
        int id = editorService.saveEditor(editorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest request)  {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(principal.getUsername(), Map.of("roles", principal.getAuthorities()));

        long expiresInMs = Long.parseLong(System.getProperty("app.jwt.expiration-ms", "3600000"));
        return ResponseEntity.ok(new LoginResponse(token, expiresInMs));
    }
}

