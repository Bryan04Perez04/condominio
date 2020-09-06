package condominio.modulos.login.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class ManagerLogin {
	@PersistenceContext
	private EntityManager em;
}
