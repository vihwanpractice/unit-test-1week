import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertTrue;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());
    }


    //문자열 관련 테스트 anyOf, containsString, endWith

    /**
     * anyOf - 조건에사용된 matcher 중하나만이라도통과되는지에대한테스트
     * containsString
     * endsWith*/

    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";
        assertThat(sampleString1, anyOf(startsWith("Player"), containsString("Focus"))); //성공
        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString))); //성공
      //  assertThat(sampleString1, allOf(startsWith(startString), containsString(endString))); //실패
        assertThat(sampleString2, allOf(startsWith(startString), containsString(endString))); //성공
        assertThat(sampleString2, is(endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
//        assertThat(3.14, closeTo(3, 0.2));
        assertThat(3.14, closeTo(3,0.2)); //(실제값, (기준,오차범위))
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        Champion whoareyou = championList.get(2);
//        assertThat(championList.get(2), anything());
        assertThat(championList.get(2), anything());
        assertThat(championList.get(2), is(whoareyou));
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
//        assertTrue(championList.size() == 5);
//        assertThat(championList.size(), is(5));
//        assertThat(championList, hasSize(5));

        assertTrue(championList.size() == 5);
        assertThat(championList.size(), is(5));
        assertThat(championList, hasSize(5)); //hasSize는 아얘 List자체를 던져주면 알아서 사이즈를 계산

    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
//        assertThat("타릭", is(supportChamp.getName()));
//        assertThat("타릭", is(equalTo(supportChamp.getName())));
//        assertThat("타릭", equalTo(supportChamp.getName()));
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));

    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
//        assertThat(championList.get(0), hasProperty("position"));
//        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
        // position에 대한 프로퍼티가 있는지, 있다면 그
        assertThat(championList.get(0), hasProperty("name"));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
//        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
//        assertThat(champListNames.get(0), hasToString("루시안"));
        List<String> FavoriteChampListNames = Arrays.asList("조이", "티모", "아이번", "징크스", "카밀");
        assertThat(FavoriteChampListNames.get(0), hasToString("조이"));

    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미");
//        assertThat(championNames1, samePropertyValuesAs(championNames2));
        assertThat(championNames1,samePropertyValuesAs(championNames2)); // 두 객체의 프로퍼티값이 같은지
    }



    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
//        Optional<Champion> filterdChampion = championList.stream()
//                .filter(c -> c.getPosition().equals("탑"))
//                .findFirst();
//        String champName = filterdChampion.get().getName();
//        assertTrue(champName.equals("다리우스"));
//        assertThat("다리우스", is(champName));

        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst(); //원하는 값만 필터링해서 값을 뽑아낼 수 있다.
        System.out.println("result" + filterdChampion);
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));
    }

}