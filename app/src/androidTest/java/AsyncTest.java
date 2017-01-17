import android.app.Application;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.JokeResponse;
import com.udacity.gradle.builditbigger.MyApplication;

import org.junit.Test;

/**
 * Created by albertlardizabal on 1/15/17.
 */

public class AsyncTest extends ApplicationTestCase<Application> implements JokeResponse {

    public AsyncTest() { super(Application.class); }

    @Test
    public void testAsyncTask() {
        try {
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
            endpointsAsyncTask.delegate = this;
            endpointsAsyncTask.execute(new Pair<Context, String>(MyApplication.getAppContext(), "joke"));
        } catch (Exception e) {
            System.out.println("Exception");
            fail();
        }
    }

    // Joke Async callback
    @Override
    public void retrievedJoke(String output) {
        String joke = output;
        assertNotNull("Joke is null", joke);
        assertFalse("Joke is blank", joke.isEmpty());
    }
}
