import com.example.a2340a_team10.model.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NameUpdateTest{
    private Player hero;

    @Before
    public void setUp(){
        hero = Player.getPlayer();
        hero.setName("OldName");
    }

    @Test
    public void nameIsUpdatedCorrectly(){
        String newName = "NewName";
        hero.setName(newName);
        assertEquals(newName, hero.getName());
    }
}