package calificaciones.aplicacion.servicios;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import calificaciones.aplicacion.dao.UserRepository;
import calificaciones.aplicacion.exception.RestServiceException;
import calificaciones.aplicacion.modelos.Role;
import calificaciones.aplicacion.modelos.User;
import calificaciones.aplicacion.security.JwtTokenProvider;

@Service
public class UserServiceImp implements UserService, UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Value("${admin.username}")
	private String adminUsername;
	
	@Value("${admin.password}")
	private String adminPassword;
	
	public String signin(User user) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			if (user.getUsername().contentEquals(adminUsername)) {
				return jwtTokenProvider.createToken(user.getUsername(), new ArrayList<Role>( Arrays.asList(Role.ROLE_ADMIN)) );
			} else {
			return jwtTokenProvider.createToken(user.getUsername(),userRepository.findByUsername(user.getUsername()).getRoles());
			}
		} catch (AuthenticationException e) {
			throw new RestServiceException("username o password invalido", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public String signup(User user) {
		if (!userRepository.existsByUsername(user.getUsername())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
		} else {
			throw new RestServiceException("Username ya está en uso", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		final User user = userRepository.findByUsername(username);
		
		
		if (user== null) {
			throw new UsernameNotFoundException("Usuario '" + username + "' no encontrado");
		}
		return org.springframework.security.core.userdetails.User.withUsername(username).password(user.getPassword())
				.authorities(user.getRoles()).accountExpired(false).accountLocked(false).credentialsExpired(false)
				.disabled(false).build();
	}
}