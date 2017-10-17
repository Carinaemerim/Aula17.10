package br.edu.ifrs.canoas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IfTeste.class, SeleniumTeste.class, testAlerta.class })
public class AllTests {

}
