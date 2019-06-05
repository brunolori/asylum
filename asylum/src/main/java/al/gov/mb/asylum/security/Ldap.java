package al.gov.mb.asylum.security;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author Bruno
 */
public class Ldap {
    
    
    public boolean ldapLogin(String uname,String password)
    {
        
        String ldapServer = "LDAP://192.168.150.10:389";
        String domain = "ASP.GOV.AL";
        
        try{
            
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, ldapServer);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, uname+"@"+domain);
            env.put(Context.SECURITY_CREDENTIALS, password);
            
            DirContext ctx = new InitialDirContext(env);
            
            boolean result = ctx != null;
            
            if(ctx != null)
            {
                ctx.close();
            }
            
            return result;
            
        }catch(Exception e)
        {
            System.out.println("Error LDAP: me shum mundesi wrong passw");
            return false;
        }
        
    }
    
    
}