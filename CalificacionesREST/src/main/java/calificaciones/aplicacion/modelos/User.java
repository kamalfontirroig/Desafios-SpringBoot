package calificaciones.aplicacion.modelos;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String username;
	private String email;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Role> roles;
}
