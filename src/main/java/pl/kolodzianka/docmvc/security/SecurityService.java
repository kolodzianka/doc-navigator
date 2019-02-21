package pl.kolodzianka.docmvc.security;


import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

    String findLoggedInUsername();

    void login(String username, String password);
}
