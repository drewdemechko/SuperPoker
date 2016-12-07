
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses(value={TestOperatorTree.class, TestDeckSearcher.class})
public class TestSuperPokerSuite {
}
