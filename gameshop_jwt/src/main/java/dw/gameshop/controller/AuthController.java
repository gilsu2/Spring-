package dw.gameshop.controller;

import dw.gameshop.dto.TokenDTO;
import dw.gameshop.dto.UserDTO;
import dw.gameshop.jwt.JwtFilter;
import dw.gameshop.jwt.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    // 생성자 함수를 사용하면 @Autowired 가 필요 없음 (스프링이 권장하는 방법)
    public AuthController(TokenProvider tokenProvider,
                          AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDTO> authenticate(@RequestBody UserDTO userDTO) {

        // 1. 유저 정보와 DB의 정보를 비교하기 위해 시큐리티 인증 객체 형태로 만듬
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(),
                        userDTO.getPassword());

        // 2. 인증정보와 DB의 저장되어있는 정보를 인증하는 코드
        Authentication authentication = authenticationManagerBuilder.getObject()
                .authenticate(authenticationToken);
        
        // 3. SecurityContextHolder에 인증이 성공한 유저 정보를 저장
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 4. JWT 생성
        String jwt = tokenProvider.createToken(authentication);

        // 5. 응답헤더에 Bearer 형태로 추가
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(
                new TokenDTO(jwt),
                httpHeaders,
                HttpStatus.OK);
    }
}
