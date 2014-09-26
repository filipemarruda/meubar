package meubar.aspects;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import meubar.business.TokenUtils;
import meubar.cadastro.servico.ServicoCadastro;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class Authorization {

	@EJB
	ServicoCadastro servicoCadastro;

	@Pointcut("execution (@meubar.aspects.Permissoes * *(..))")
	public void authorizableCall() {
	}

	@Around("authorizableCall() && @annotation(perm)")
	public Object advice(ProceedingJoinPoint joinPoint, Permissoes perm)
			throws Throwable {
		
		Object result = null;

		String[] permissoes = perm.values();
		List<String> permArray = Arrays.asList(permissoes);
		
		Object[] args = joinPoint.getArgs();
		String token = (String) args[0];
		String grupo = TokenUtils.extractGrupo(token);
		
		if (permArray.contains(grupo)) {
			result = joinPoint.proceed();
		} else {
			result = Response.status(Status.UNAUTHORIZED).build();
		}

		return result;

	}

}
