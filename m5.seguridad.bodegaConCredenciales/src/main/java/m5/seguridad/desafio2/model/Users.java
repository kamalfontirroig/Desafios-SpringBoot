package m5.seguridad.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5963620348495111026L;
	private String email;
    private String password;
    private Role role;

}