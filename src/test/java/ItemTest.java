import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

public class ItemTest {

    private List<Item> itemList = new ArrayList<>();

    @Before
    public void setUp() {


        Item TheBloodthirster = new Item("피바라기", "Finished Item", 3500);
        Item BladeOfTheRuinedKing = new Item("몰락한 왕의 검", "Finished Item", 3300);
        Item RunaansHurricane = new Item("루난의 허리케인","Finished Item", 2600);
        itemList.add(TheBloodthirster);
        itemList.add(BladeOfTheRuinedKing);
        itemList.add(RunaansHurricane);

    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        int optItemCost = itemList.get(2).getCost();
        assertThat(itemList.get(2), anything());
        assertThat(itemList.get(2).getCost(), is(optItemCost));
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldItemCountThree() {
        assertTrue(itemList.size() == 3);
        assertThat(itemList.size(), is(3));
        assertThat(itemList, hasSize(3)); //hasSize는 아얘 List자체를 던져주면 알아서 사이즈를 계산

    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldItemNameIsRavenousHydra() {
       Item RavenousHydra = new Item("굶주린 히드라","Finished Item", 3500);
        assertThat("굶주린 히드라", is(RavenousHydra.getName()));
        assertThat("Finished Item", is(equalTo(RavenousHydra.getType())));
        assertThat(itemList.get(1).getName(), equalTo(RavenousHydra.getName()));
    }
}