package com.edu.controller.template;


import com.edu.dto.CategoryDTO;
import com.edu.dto.Response.GenericResponse;
import com.edu.security.JwtRequest;
import com.edu.security.JwtResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestTemplateController {
    private final RestTemplate restTemplate;


    @GetMapping("/pokemon/{name}")
    public ResponseEntity<String> getPokemon(@PathVariable String name) {
        String pokemonUrl = "https://pokeapi.co/api/v2/pokemon/" + name;
        String response = restTemplate.getForEntity(pokemonUrl, String.class).getBody();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/test1")
    public ResponseEntity<GenericResponse<CategoryDTO>> test1() {
        String url ="http://localhost:9090/categories";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);
        var typeRef =  new ParameterizedTypeReference<GenericResponse<CategoryDTO>>() {};
        //ParameterizedTypeReference<GenericResponse<CategoryDTO>> typeRef2 = new ParameterizedTypeReference<>() {};

        return restTemplate.exchange(url, HttpMethod.GET,entity,typeRef);

    }

    @GetMapping("/test2")
    public ResponseEntity<String> test2(
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "size",defaultValue = "3") int size
    ){
        String url ="http://localhost:9090/categories/pagination2?="+page+"&s="+size;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/test3")
    public ResponseEntity<Map> test3(
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "size",defaultValue = "3") int size
    ){
        String url ="http://localhost:9090/categories/pagination2?p={page}&s={size}";

        Map<String , Integer> uriVariables =  new HashMap<>();
        uriVariables.put("page", page);
        uriVariables.put("size", size);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(url,HttpMethod.GET,requestEntity,Map.class,uriVariables);
    }

    @PostMapping("/test4")
    public ResponseEntity<CategoryDTO> test4 (@RequestBody CategoryDTO categoryDTO){
        String url ="http://localhost:9090/categories";
        HttpEntity<CategoryDTO> requestEntity = new HttpEntity<>(categoryDTO);

        CategoryDTO response = restTemplate.postForObject(url,requestEntity,CategoryDTO.class);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/test5/{id}")
    public ResponseEntity<CategoryDTO> test5 (@PathVariable("id") int id, @RequestBody CategoryDTO categoryDTO){
        String url ="http://localhost:9090/categories/" + id;
        HttpEntity<CategoryDTO> requestEntity = new HttpEntity<>(categoryDTO);

        return restTemplate.exchange(url,HttpMethod.PUT,requestEntity,CategoryDTO.class);
    }

    @DeleteMapping("/test6/{id}")
    public ResponseEntity<Void> test6 (@PathVariable("id") Integer id){
        String url ="http://localhost:9090/categories/" + id;
        restTemplate.delete(url);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/test7/{id}")
    public ResponseEntity<Void> test7 (@PathVariable("id") Integer id){
        String url ="http://localhost:9090/categories/{idCategory}";

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("idCategory", id);
        restTemplate.delete(url,uriVariables);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/test8/{id}")
    public ResponseEntity<Void> test8(
            @PathVariable("id") Integer id,
            @RequestBody JwtRequest request
    ) throws Exception {
        String token = generateToken(request.getUsername(),request.getPassword());

        //enviar el token para pedir o hacer acciones
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> jwtEntity = new HttpEntity<>(headers);

        String url ="http://localhost:9090/categories/{idCategory}";
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("idCategory", id);

        restTemplate.exchange(url,HttpMethod.DELETE,jwtEntity,String.class,uriVariables);
        return ResponseEntity.noContent().build();
    }

    private String generateToken(String username, String password) throws JsonProcessingException {
        final String AUTHENTICACION_URL = "http://localhost:9090/login";
        JwtRequest userRequest = new JwtRequest(username, password);
        String userRequestJson = new ObjectMapper().writeValueAsString(userRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type",MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> authEntity = new HttpEntity<>(userRequestJson, headers);
        ResponseEntity<JwtResponse> authResponse = restTemplate.exchange(AUTHENTICACION_URL,HttpMethod.POST,authEntity,JwtResponse.class);

        if (authResponse.getBody() != null){
            return  authResponse.getBody().jwtToken();
        }
        return "INVALID_TOKEN";
    }

    @GetMapping("/test9")
    public ResponseEntity<GenericResponse<CategoryDTO>> test9(
            @RequestBody JwtRequest request
    ) throws Exception {
        String token = generateToken(request.getUsername(),request.getPassword());

        //enviar el token para pedir o hacer acciones
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> jwtEntity = new HttpEntity<>(headers);

        //
        String url ="http://localhost:9090/categories";

        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        var typeRef =  new ParameterizedTypeReference<GenericResponse<CategoryDTO>>() {};

        return restTemplate.exchange(url, HttpMethod.GET,jwtEntity,typeRef);



    }
}
