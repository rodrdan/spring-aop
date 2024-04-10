package cz.rodr.springAopDemo;

import cz.rodr.springAopDemo.dao.AccountDAO;
import cz.rodr.springAopDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopDemoApplication.class, args);
	}
    @Bean
    public CommandLineRunner commandLineRunner(Account theAccount, AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
            demoTheBeforeAdvice(theAccount, theAccountDAO, theMembershipDAO);
        };
    }

    private void demoTheBeforeAdvice(Account theAccount, AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        System.out.println("Calling the Account method:");
        theAccountDAO.addAccount(theAccount, true);

        System.out.println("Calling a Membership method:");

        theMembershipDAO.addAccount();
    }

}
