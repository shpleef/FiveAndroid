package com.boiled.five;

import com.boiled.five.data.DataManager;
import com.boiled.five.data.local.PreferencesHelper;
import com.boiled.five.data.model.Character;
import com.boiled.five.data.remote.AndroidBoilerplateService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    @Mock AndroidBoilerplateService mMockAndroidBoilerplateService;
    @Mock PreferencesHelper mMockPreferencesHelper;
    DataManager mDataManager;

    @Before
    public void setUp() {
        mDataManager = new DataManager(mMockAndroidBoilerplateService, mMockPreferencesHelper);
    }

    @Test
    public void shouldLoadCharacters() throws Exception {
        int[] ids = new int[]{10034, 14050, 10435, 35093};
        List<Character> characters = MockModelFabric.makeListOfMockCharacters(4);
        for (int i = 0; i < ids.length; i++) {
            when(mMockAndroidBoilerplateService.getCharacter(ids[i]))
                    .thenReturn(Observable.just(characters.get(i)));
        }

        TestSubscriber<List<Character>> result = new TestSubscriber<>();
        mDataManager.getCharacters(ids).subscribe(result);
        result.assertNoErrors();
        result.assertValue(characters);
    }

}
